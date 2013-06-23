package me.sevenstack.search;

import javax.print.Doc;

import junit.framework.TestCase;

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;

public class IndexingTest extends TestCase {
	protected String[] ids = { "1", "2" };
	protected String[] unindexed = { "Netherlands", "Italy" };
	protected String[] unstored = { "Amsterdam has lots of bridges",
			"Venice has lots of canals" };
	protected String[] text = { "Amsterdam", "Venice" };
	private Directory directory;

	/**
	 * 初始化
	 */
	protected void setUp() throws Exception {
		directory = new RAMDirectory();
		IndexWriter writer = getWriter();
		for (int i = 0; i < ids.length; i++) {
			Document doc = new Document();
			doc.add(new Field("id", ids[i], Field.Store.YES,
					Field.Index.NOT_ANALYZED));
			doc.add(new Field("country", unindexed[i], Field.Store.YES,
					Field.Index.NO));
			doc.add(new Field("contents", unstored[i], Field.Store.NO,
					Field.Index.NOT_ANALYZED));
			doc.add(new Field("city", text[i], Field.Store.YES,
					Field.Index.ANALYZED));
			writer.addDocument(doc);
		}
		writer.close();

	}

	/**
	 * 获取writer
	 * 
	 * @return
	 * @throws Exception
	 */
	private IndexWriter getWriter() throws Exception {
		return new IndexWriter(directory, new WhitespaceAnalyzer(),
				IndexWriter.MaxFieldLength.UNLIMITED);
	}

	protected int getHitConunt(String fieldName, String searchString)
			throws Exception {
		IndexSearcher searcher = new IndexSearcher(directory);
		Term term = new Term(fieldName, searchString);
		Query query = new TermQuery(term);
		int hitCount = TestUtil.hitCount(searcher, query);
		searcher.close();
		return hitCount;

	}

	public void testIndexWrite() throws Exception {
		IndexWriter writer = getWriter();
		assertEquals(ids.length, writer.numDocs());
		writer.close();
	}

	public void testIndexReader() throws Exception {
		IndexReader reader = IndexReader.open(directory);
		assertEquals(ids.length, reader.maxDoc());
		assertEquals(ids.length, reader.numDocs());
		reader.clone();
	}
	public static void main(String[] args)throws Exception {
		IndexingTest test = new IndexingTest();
		test.setUp();
		System.out.println(test.getHitConunt("contents", "bridges"));
	}

}
