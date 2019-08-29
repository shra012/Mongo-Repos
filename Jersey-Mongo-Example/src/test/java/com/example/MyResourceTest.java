package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.model.Friend;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFeature.class ) );

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());
        target = client.target("http://localhost:8080/myapp/myresource/Friends");
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    @Test
    public void testPost() throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();
        List<Friend> myObjects = mapper.readValue(new File("C:\\Shravan\\Learning\\Java\\mongooutput.json"), mapper.getTypeFactory().constructCollectionType(List.class, Friend.class));
        Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(myObjects, MediaType.APPLICATION_JSON));
       //Response response = invocationBuilder.get();
        ArrayList arrayList =  (ArrayList)response.readEntity(List.class);
        System.out.println(response.getStatus());
        if(arrayList.stream().findFirst().get() instanceof Friend) {
        	Friend insertedFriend = (Friend) arrayList.stream().findFirst().get();
        	Friend requestFriend = myObjects.stream().findFirst().get();
        	assertNull(requestFriend.getId());
        	assertNotNull(insertedFriend.getId());
        	assertEquals(requestFriend.getFirstName(), insertedFriend.getFirstName());
        }
        
    }
}
