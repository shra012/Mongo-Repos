package mongo.util;

import static java.lang.System.out;

import java.io.StringWriter;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;
public class MongoHelper {

	public static void printJson(Document document) {
		JsonWriter writer = new JsonWriter(new StringWriter(),
				new JsonWriterSettings(JsonMode.SHELL,false));

		new DocumentCodec().encode(writer, document, 
				EncoderContext.builder().isEncodingCollectibleDocument(true).build());
		out.println(writer.getWriter());
		out.flush();
		writer.close();

	}

	public static void printListJson(List<Document> document) {
		for (Document doc : document) {
			JsonWriter writer = new JsonWriter(new StringWriter(),
					new JsonWriterSettings(JsonMode.SHELL,false));
			new DocumentCodec().encode(writer, doc, 
					EncoderContext.builder().isEncodingCollectibleDocument(true).build());
			out.println(writer.getWriter());
			out.flush();
			writer.close();
		}
	}
}
