package lucene;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IndexTest {

    private String id = "qwweweg";
    private String from[]={"青岛","南京","上海"};
    private String to[]={
            "青岛是一个漂亮的城市。",
            "南京是一个文化的城市。",
            "上海是一个繁华的城市。"
    };

    SimpleDateFormat mmSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    SimpleDateFormat ddSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Test
    public void put() throws IOException {

        Directory dir = FSDirectory.open(Paths.get("U:/logs/lucene-test"));

        SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();

        IndexWriterConfig iwc=new IndexWriterConfig(analyzer);

        IndexWriter writer=new IndexWriter(dir, iwc);



        Document doc=new Document();

        doc.add(new StringField("id", id, Field.Store.YES));
        doc.add(new TextField("from0",from[0],Field.Store.YES));
        doc.add(new TextField("to0", to[0], Field.Store.YES));

        doc.add(new TextField("from1",from[1],Field.Store.YES));
        doc.add(new TextField("to1", to[1], Field.Store.YES));

        doc.add(new TextField("from2",from[2],Field.Store.YES));
        doc.add(new TextField("to2", to[2], Field.Store.YES));
        Date d = new Date();
        String mm = mmSimpleDateFormat.format(d);
        String dd = ddSimpleDateFormat.format(d);

        doc.add(new StringField("departure",dd,Field.Store.NO));
        doc.add(new StoredField("departureTime",mm));
        NumericDocValuesField field = new NumericDocValuesField("departureTime",48);
        //FieldType fieldType = field.fieldType();
        writer.addDocument(doc);
        //NumericField field = new NumericField();


        writer.close();

    }

    @Test
    public void searchAll() throws IOException {
        Directory dir = FSDirectory.open(Paths.get("U:/logs/lucene-test"));
        DirectoryReader ireader = DirectoryReader.open(dir);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        Query query = new MatchAllDocsQuery();
        TopDocs topDocs = isearcher.search(query, 10);
        System.out.println("查询到的条数\t"+topDocs.totalHits);
        ScoreDoc [] hits  = topDocs.scoreDocs;
        for (int i = 0; i < hits.length; i++) {
            System.out.println("hits[i].doc： "+hits[i].doc);
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println("hitDoc: "+hitDoc.toString());
            System.out.println("departureTime: "+hitDoc.get("departureTime"));

            //Document hitDoc = isearcher.doc(hits[i].doc);
            //assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
        }
        //isearcher.search(query);
    }

    @Test
    public void searchFromTo() throws IOException {
        Directory dir = FSDirectory.open(Paths.get("U:/logs/lucene-test"));
        DirectoryReader ireader = DirectoryReader.open(dir);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        //BooleanQuery booleanQuery = new BooleanQuery();

        //TermQuery tq = new TermQuery(new Term("fieldName", "term"));
        Query originalQuery1 = new BooleanQuery.Builder()
                .add(new TermQuery(new Term("from0", "青岛")), BooleanClause.Occur.MUST)
                .add(new TermQuery(new Term("to0", "青岛")), BooleanClause.Occur.MUST)
                .build();

        Query originalQuery2 = new BooleanQuery.Builder()
                .add(new TermQuery(new Term("from2", "青岛")), BooleanClause.Occur.MUST)
                .add(new TermQuery(new Term("to2", "青岛")), BooleanClause.Occur.MUST)
                .build();
        Query shouldQuery = new BooleanQuery.Builder()
                .add(originalQuery1, BooleanClause.Occur.SHOULD)
                .add(originalQuery2, BooleanClause.Occur.SHOULD)
                .build();
        Query mustQuery=new BooleanQuery.Builder()
                .add(shouldQuery, BooleanClause.Occur.MUST)
                .add(new TermQuery(new Term("departure", "2020-10-28")), BooleanClause.Occur.MUST)
                .build();
        TopDocs topDocs = isearcher.search(mustQuery, 10);
        System.out.println("查询到的条数\t"+topDocs.totalHits);
        ScoreDoc [] hits  = topDocs.scoreDocs;
        for (int i = 0; i < hits.length; i++) {
            System.out.println("hits[i].doc： "+hits[i].doc);
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println("hitDoc: "+hitDoc.toString());
            //assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
        }
        //isearcher.search(query);
    }


    @Test
    public void searchTest() throws IOException {
        Directory dir = FSDirectory.open(Paths.get("U:/logs/lucene-test"));
        DirectoryReader ireader = DirectoryReader.open(dir);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        //BooleanQuery booleanQuery = new BooleanQuery();

        //TermQuery tq = new TermQuery(new Term("fieldName", "term"));
        String from = "北京";
        String to = "通辽";
        String date = "2020-11-27";
        Query originalQuery1 = new BooleanQuery.Builder()
                .add(new TermQuery(new Term("from", from)), BooleanClause.Occur.MUST)
                .add(new TermQuery(new Term("to", to)), BooleanClause.Occur.MUST)
                .build();

        Query originalQuery2 = new BooleanQuery.Builder()
                .add(new TermQuery(new Term("from", from)), BooleanClause.Occur.MUST)
                .add(new TermQuery(new Term("pass", to)), BooleanClause.Occur.MUST)
                .build();

        Query originalQuery3 = new BooleanQuery.Builder()
                .add(new TermQuery(new Term("pass", from)), BooleanClause.Occur.MUST)
                .add(new TermQuery(new Term("to", to)), BooleanClause.Occur.MUST)
                .build();
        Query originalQuery4 = new BooleanQuery.Builder()
                .add(new TermQuery(new Term("pass", from)), BooleanClause.Occur.MUST)
                .add(new TermQuery(new Term("pass", to)), BooleanClause.Occur.MUST)
                .build();
        Query shouldQuery = new BooleanQuery.Builder()
                .add(originalQuery1, BooleanClause.Occur.SHOULD)
                .add(originalQuery2, BooleanClause.Occur.SHOULD)
                .add(originalQuery3, BooleanClause.Occur.SHOULD)
                .add(originalQuery4, BooleanClause.Occur.SHOULD)
                .build();

        Query mustQuery=new BooleanQuery.Builder()
                .add(shouldQuery, BooleanClause.Occur.MUST)
                .add(new TermQuery(new Term("departureDate", date)), BooleanClause.Occur.MUST)
                .build();
        TopDocs topDocs = isearcher.search(mustQuery, 10);
        System.out.println("查询到的条数\t"+topDocs.totalHits);
        ScoreDoc [] hits  = topDocs.scoreDocs;
        for (int i = 0; i < hits.length; i++) {
            System.out.println("hits[i].doc： "+hits[i].doc);
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println("hitDoc: "+hitDoc.toString());
            //assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
        }
        //isearcher.search(query);
    }

    @Test
    public void deleteAll() throws IOException {
        Directory dir = FSDirectory.open(Paths.get("U:/logs/lucene-test"));
        SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();

        IndexWriterConfig iwc=new IndexWriterConfig(analyzer);

        IndexWriter writer=new IndexWriter(dir, iwc);
        writer.deleteAll();
        writer.close();
    }
}
