package com.lucifer.service;

import com.lucifer.model.Carpool;
import com.lucifer.utils.StringHelper;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CarpoolLuceneService {

    @Value("${lucene.local}")
    String local;

    IndexWriter writer;

    IndexSearcher indexSearcher;

    SimpleDateFormat mmSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    SimpleDateFormat ddSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostConstruct
    void init() throws IOException {
        Directory dir = FSDirectory.open(Paths.get(local));
        SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
        IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
        writer=new IndexWriter(dir, iwc);
        DirectoryReader ireader = DirectoryReader.open(dir);
        indexSearcher = new IndexSearcher(ireader);
    }

    public void putOne(Carpool carpool) throws IOException {
        writer.deleteDocuments(new Term("id",String.valueOf(carpool.getId())));
        writer.commit();

        Document doc=new Document();
        doc.add(new StringField("id", String.valueOf(carpool.getId()), Field.Store.YES));

        doc.add(new StoredField("linkman",carpool.getLinkman()));
        doc.add(new StoredField("site",carpool.getSite()));
        doc.add(new StoredField("phone",carpool.getPhone()));

        Date d = carpool.getDepartureTime();
        String mm = mmSimpleDateFormat.format(d);
        String dd = ddSimpleDateFormat.format(d);

        doc.add(new StringField("departureDate",dd,Field.Store.YES));
        doc.add(new StoredField("departureTime",mm));

        doc.add(new TextField("from",carpool.getFrom(),Field.Store.YES));
        doc.add(new TextField("to", carpool.getTo(), Field.Store.YES));

        if (!StringHelper.isEmpty(carpool.getPass1())) {
            doc.add(new StoredField("pass1",carpool.getPass1()));
            String middlePass = carpool.getPass1() ;
            if (!StringHelper.isEmpty(carpool.getPass2())) {
                doc.add(new StoredField("pass2",carpool.getPass2()));
                middlePass = middlePass + ";" + carpool.getPass2();
            }
            if (!StringHelper.isEmpty(carpool.getPass3())) {
                doc.add(new StoredField("pass3",carpool.getPass3()));
                middlePass = middlePass + ";" + carpool.getPass3();
            }
            doc.add(new TextField("pass",middlePass,Field.Store.YES));
        }

        //NumericDocValuesField field = new NumericDocValuesField("departureTime",48);
        //FieldType fieldType = field.fieldType();
        writer.addDocument(doc);
        writer.commit();
    }

    public void deleteOne(Long id) throws IOException {
        writer.deleteDocuments(new Term("id", String.valueOf(id)));
        writer.commit();
    }

    public List<Carpool> pageSearch(String from,String to,String date,int offset,int limit) throws IOException, ParseException {
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
        TopDocs topDocs = indexSearcher.search(mustQuery, offset+limit);
        System.out.println("查询到的条数\t"+topDocs.totalHits);
        ArrayList list = new ArrayList();
        ScoreDoc [] hits  = topDocs.scoreDocs;
        for (int i = offset; i < hits.length; i++) {
            System.out.println("hits[i].doc： "+hits[i].doc);
            Document hitDoc = indexSearcher.doc(hits[i].doc);
            System.out.println("hitDoc: "+hitDoc.toString());
            //assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
            Carpool carpool = docToCarpool(hitDoc);
            list.add(carpool);
        }
        return list;
    }

    private Carpool docToCarpool(Document hitDoc) throws ParseException {
        Carpool carpool = new Carpool();
        Long id = Long.valueOf(hitDoc.get("id"));
        carpool.setId(id);

        String linkman = hitDoc.get("linkman");
        carpool.setLinkman(linkman);

        String site = hitDoc.get("site");
        carpool.setSite(Integer.valueOf(site));

        String phone = hitDoc.get("phone");
        carpool.setPhone(phone);

        String departureTimeString = hitDoc.get("departureTime");
        Date departureTime = mmSimpleDateFormat.parse(departureTimeString);
        carpool.setDepartureTime(departureTime);

        String from = hitDoc.get("from");
        carpool.setFrom(from);

        String to = hitDoc.get("to");
        carpool.setTo(to);

        String pass1 = hitDoc.get("pass1");
        carpool.setPass1(pass1);

        String pass2 = hitDoc.get("pass2");
        carpool.setPass2(pass2);

        String pass3 = hitDoc.get("pass3");
        carpool.setPass3(pass3);

        return carpool;
    }
}
