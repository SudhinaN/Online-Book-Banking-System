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
import com.viruksham.apps.tradefinapp.model.SamplesModel;
import com.viruksham.apps.tradefinapp.model.UserModel;

/**
 * @author brajagopal
 *
 */
@Path("v1/samples")
public class SamplesResource extends BaseResource {

	private SamplesModel SamplesModel = null;
	private UserModel userModel = null;

	@GET
	@Produces ("text/plain")
	public String greetUser() {
		return "Thanks for using TradeFinApps Samples";
	}

	@GET @Path("/viewall")
	@Produces (MediaType.APPLICATION_JSON)
	public Response viewall() {
		
		ServiceResponse response = new ServiceResponse();
		//ServiceResponse response1 = new ServiceResponse();
		try {
			
			response.setData(getSamplesModel().viewall());
			//response1.setData(getUserModel().getUserTypeList());
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
System.out.println("entered into samples getid resource");
		try {
			Object value = getSamplesModel().view(GetID);
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
	public Response save(String samplesJson) {
		//System.out.println(" Thanks for using TradeFinApps create ");
		response = new ServiceResponse();
		System.out.println("entered into create Samples resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(samplesJson);
			response.setData(getSamplesModel().save(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}

	@GET @Path("/confirmdelete/{GetID}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("GetID") String GetID) {
System.out.println("entered into samples delete getid resource");
		try {
			Object value = getSamplesModel().delete(GetID);
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

	private SamplesModel getSamplesModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		if (SamplesModel == null) {
			SamplesModel = new SamplesModel();
		}
		return SamplesModel;
	}
	
	private UserModel getUserModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		if (userModel == null) {
			userModel = new UserModel();
		}
		return userModel;
	}
	
}
/*********************************OVER****************************************************/
