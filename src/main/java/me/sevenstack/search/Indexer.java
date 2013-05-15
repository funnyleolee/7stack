package me.sevenstack.search;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Indexer {
    private IndexWriter indexWriter;

    public Indexer(String indexDir) throws Exception {
        try {
            Directory directory = FSDirectory.open(new File(indexDir));
            indexWriter = new IndexWriter(directory, new StandardAnalyzer(Version.LUCENE_30), true, IndexWriter.MaxFieldLength.UNLIMITED);
        } catch (Exception e) {
            throw new Exception("Indexer 初始化失败！", e);
        }
    }

    /**
     * 构建索引
     * 
     * @return
     */
    public int index(String dataDir, FileFilter filter) throws Exception {
        File[] fileList = new File(dataDir).listFiles();
        for (File f : fileList) {
            if (!f.isDirectory() && !f.isHidden() && f.exists() && f.canRead() && (filter == null || filter.accept(f))) {
                Document doc = getDocument(f);
                indexWriter.addDocument(doc);
            }
        }
        return indexWriter.numDocs();
    }

    /**
     * 构建文档
     * 
     * @param f
     * @return
     * @throws Exception
     */
    public Document getDocument(File f) throws Exception {
        Document doc = new Document();
        doc.add(new Field("contents", new FileReader(f)));
        doc.add(new Field("fileName", f.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field("fullPath", f.getCanonicalPath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
        return doc;
    }

    /**
     * 关闭索引构建
     * 
     * @throws Exception
     */
    public void close() throws Exception {
        indexWriter.close();
    }

    /**
     * txt文件过滤
     * 
     * @author lijinlong
     * 
     */
    public static class TxtFileFilter implements FileFilter {
        @Override
        public boolean accept(File file) {
            return file.getName().toLowerCase().endsWith(".txt");
        }

    }

    public static void main(String[] args) throws Exception {
        String dataDir = "D:/tmp/lucence/dataDir";
        String indexDir = "D:/tmp/lucence/indexDir";

        long start = System.currentTimeMillis();
        Indexer indexer = new Indexer(indexDir);
        int docNum = 0;
        try {
            docNum = indexer.index(dataDir, new TxtFileFilter());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            indexer.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("成功构建 " + docNum + " 个文档，耗时 " + (end - start) + " 毫秒。");
    }
}
