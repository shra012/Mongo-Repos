package com.example;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.model.Friend;
import com.example.model.FriendApplicationException;
import com.example.service.FreindService;
import com.example.service.FriendServiceImpl;

/**
 * Root resource (exposed at "myresource" path)
 */
/**
 * @author shravan
 *
 */
@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyResource {

	FreindService service = null;
	/**
	 * Method handling HTTP GET requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	
	public MyResource() {
		service = new FriendServiceImpl();
	}
	
	@GET
	@Path("hello")
	public String getIt() {
		return "Got it!";
	}

	/**
	 * @return
	 */
	@GET
	@Path("Friends")
	public Response getFriends() {
		List<Friend> friendList  = null;
		friendList =  service.findAll();
		if(friendList == null || friendList.isEmpty()){
			return Response.serverError().entity(new FriendApplicationException("No Content Found, Please check if the friends collection exists or the collection is empty")).build();
		}
		return Response.ok().entity(friendList).build();
	}
	
	@PUT
	@Path("Friends")
	public Response insertFriends(List<Friend> friendList) {
		
		if(friendList==null || friendList.size() <= 0) {
			return Response.serverError().entity(new FriendApplicationException("Request is null or empty")).build();
		}else {
			friendList = service.insertAll(friendList);
		}
		return Response.ok().entity(friendList).build();
	}
}
