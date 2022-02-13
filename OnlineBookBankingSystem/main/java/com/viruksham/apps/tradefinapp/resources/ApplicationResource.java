/**
 * 
 */
package com.viruksham.apps.tradefinapp.resources;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.viruksham.apps.tradefinapp.data.JsonDataObject;
import com.viruksham.apps.tradefinapp.data.ServiceResponse;
import com.viruksham.apps.tradefinapp.model.ApplicationModel;

/**
 * @author brajagopal
 *
 */
@Path("v1/Application")
public class ApplicationResource extends BaseResource {

	private ApplicationModel ApplicationModel = null;

	@GET
	@Produces ("text/plain")
	public String greetUser() {
		return "Thanks for using TradeFinApps Application";
	}

	@GET @Path("/Get/{GetID}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getUserTypeDataGet(@PathParam("GetID") String GetID) {
System.out.println("entered into Application resource");
		try {
			Object value = getApplicationModel().getUserTypeGet(GetID);
			if (value == null)
				return Response.serverError().build();
			else {
				if (((List<Object>)value).size() == 0) {
					return Response.noContent().build();
				}
				ServiceResponse response = new ServiceResponse();
				response.setData(value);
				return Response.ok(response.toJsonString()).build();
			}
		}
		catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GET @Path("/List")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getUserTypeList() {
		System.out.println("entered into customer bank master resource list");
		ServiceResponse response = new ServiceResponse();
		try {
			response.setData(getApplicationModel().getUserTypeList());
			return Response.ok(response.toJsonString()).build();
		} catch (ClassNotFoundException e) {
			return Response.serverError().build();
		} catch (SQLException e) {
			return Response.serverError().build();
		} catch (FileNotFoundException e) {
			return Response.serverError().build();
		}
	}

	@GET @Path("/Delete/{delete}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getUserTypeDelete(@PathParam("delete") String delete) {
		try {
			Object value = getApplicationModel().getUserTypeDelete(delete);
			if (value == null)
				//return Response.serverError().build();
				return Response.ok("the Application has been deleted").build();
			else {
				if (((List<Object>)value).size() == 0) {
					return Response.noContent().build();
				}
				ServiceResponse response = new ServiceResponse();
				response.setData(value);
				return Response.ok(response.toJsonString()).build();
			}
		}
		catch (Exception e) {
			return Response.serverError().build();
		}
		
	}

	@PUT @Path("/Insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response insertdata(String ApplicationJson) {
		//System.out.println(" Thanks for using TradeFinApps create ");
		//System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		//System.out.println(data);
		response = new ServiceResponse();
		System.out.println("entered into insert Application resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(ApplicationJson);
			response.setData(getApplicationModel().insertdata(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}
	
	
	@PUT @Path("/Edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response editdata(String ApplicationJson) {
		//System.out.println(" Thanks for using TradeFinApps create ");
		System.out.println(" &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& ");
		System.out.println(ApplicationJson);
		response = new ServiceResponse();
		System.out.println("entered into edit Application resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(ApplicationJson);
			response.setData(getApplicationModel().editdata(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}
	
	/**
	 * TODO Implement user authentication
	 * (See 
	 * http://weblogs.java.net/blog/2008/03/07/authentication-jersey,
	 * http://developers.sun.com/identity/reference/techart/restwebservices.html
	 * )
	 *
	 * @return
	 */
	/*@GET @Path("/{userid}/auth")
	public Response authenticateUser() {
		return null;
	}*/

	private ApplicationModel getApplicationModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		if (ApplicationModel == null) {
			ApplicationModel = new ApplicationModel();
		}
		return ApplicationModel;
	}
}
