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
import com.viruksham.apps.tradefinapp.model.UserssModel;

/**
 * @author brajagopal
 *
 */
@Path("v1/userss")
public class UserssResource extends BaseResource {

	private UserssModel UserssModel = null;

	@GET
	@Produces ("text/plain")
	public String greetUser() {
		return "Thanks for using TradeFinApps Userss";
	}

	@GET @Path("/viewall")
	@Produces (MediaType.APPLICATION_JSON)
	public Response viewall() {
		
		ServiceResponse response = new ServiceResponse();
		ServiceResponse response1 = new ServiceResponse();
		try {
			
			response.setData(getUserssModel().viewall());
			return Response.ok(response.toJsonString()).build();
		} catch (ClassNotFoundException e) {
			return Response.serverError().build();
		} catch (SQLException e) {
			return Response.serverError().build();
		} catch (FileNotFoundException e) {
			return Response.serverError().build();
		}
	}

	@GET @Path("/view/{GetID}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response view(@PathParam("GetID") String GetID) {
System.out.println("entered into Userss getid resource");
		try {
			Object value = getUserssModel().view(GetID);
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

	@PUT @Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response save(String UserssJson) {
		//System.out.println(" Thanks for using TradeFinApps create ");
		response = new ServiceResponse();
		System.out.println("entered into create Userss resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(UserssJson);
			response.setData(getUserssModel().save(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}

	@GET @Path("/confirmdelete/{GetID}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("GetID") String GetID) {
System.out.println("entered into Userss delete getid resource");
		try {
			Object value = getUserssModel().delete(GetID);
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

	private UserssModel getUserssModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		if (UserssModel == null) {
			UserssModel = new UserssModel();
		}
		return UserssModel;
	}
	
}
/*********************************OVER****************************************************/
