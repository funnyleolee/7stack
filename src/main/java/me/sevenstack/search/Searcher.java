package me.sevenstack.search;

import java.io.File;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class Searcher {
    private File indexDir;

    public Searcher(String indexPath) {
        this.indexDir = new File(indexPath);
    }

    public void serach(String text) throws Exception {
        Directory directory = FSDirectory.open(indexDir);
        IndexSearcher is = new IndexSearcher(directory);
        QueryParser queryParser = new QueryParser(Version.LUCENE_30, "contents", new StandardAnalyzer(Version.LUCENE_30));
        Query query = queryParser.parse(text);
        // 执行搜索
        long start = System.currentTimeMillis();
        TopDocs hits = is.search(query, 10);
        long end = System.currentTimeMillis();

        System.out.println("搜索到 " + hits.totalHits + " 个包含“" + text + "”的文档，耗时 " + (end - start)+" 毫秒。");
        // 展示路径
        for (ScoreDoc scoreDoc : hits.scoreDocs) {
            Document doc = is.doc(scoreDoc.doc);
            System.out.println(doc.getField("fullPath"));
        }
        is.close();
    }

    public static void main(String[] args) throws Exception {
        Searcher searcher = new Searcher("D:/tmp/lucence/indexDir");
        searcher.serach("delivering xxx");

    }

}
