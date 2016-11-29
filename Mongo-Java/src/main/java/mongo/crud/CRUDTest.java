package mongo.crud;

import static java.util.Arrays.asList;
import static mongo.util.MongoHelper.printJson;
import static mongo.util.MongoHelper.printListJson;
import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class CRUDTest {
	public static final Logger LOGGER =  LoggerFactory.getLogger(CRUDTest.class);

	public static void main(String[] args) {
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("test");
		MongoCollection<Document> col = db.getCollection("insertTest");

		col.drop();
		//insert(col);
		//find(col);
		filter(col);
		client.close();
	}

	private static void insert(MongoCollection<Document> col) {
		Document shravan = new Document("name","Shravan").append("age", 23).append("prefesion", "Mechanical Engineer");
		Document ganesh = new Document("name","Ganesh").append("age", 24).append("prefesion", "Production Engineer");
		Document selva = new Document("name","Selva").append("age", 24).append("prefesion", "Mechanical Engineer");
		printJson(shravan);
		col.insertOne(shravan);
		col.insertMany(asList(selva,ganesh));
		printJson(shravan);
	}

	private static void find(MongoCollection<Document> col) {
		System.out.println("findOne : ");
		Document first = col.find().first();
		printJson(first);
		System.out.println("findAll with into: ");
		List<Document> documentList = col.find().into(new ArrayList<Document>());
		printListJson(documentList);
		System.out.println("findAll with iteration: ");

		try(MongoCursor<Document> cur = col.find().iterator()){
			while(cur.hasNext()){
				Document doc = cur.next();
				printJson(doc);
			}
		}
		System.out.println("Count : ");
		long count = col.count();
		System.out.println(count);
	}
	
	private static void filter(MongoCollection<Document> col) {
		for (int i = 0; i < 10; i++) {
			col.insertOne(new Document().append("x", new Random().nextInt(2)).append("y", new Random().nextInt(100)));
		}
		//Bson bsonFilter = new Document("x",0).append("y", new Document("$gt",10).append("$lt", 90));
		Bson bsonFilter = and(eq("x",0),gt("y", 10),lt("y", 90));
		List<Document> all = col.find(bsonFilter).into(new ArrayList<Document>());
		LOGGER.info("List<Document> all.size(): "+all.size());
		for (Document document : all ) {
			printJson(document);
		}
		
		System.out.println("Count : ");
		long count = col.count();
		System.out.println(count);
	}


}
