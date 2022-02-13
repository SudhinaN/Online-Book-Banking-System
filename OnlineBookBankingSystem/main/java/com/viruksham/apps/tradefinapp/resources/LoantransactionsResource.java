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
import com.viruksham.apps.tradefinapp.model.LoantransactionsModel;

/**
 * @author brajagopal
 *
 */
@Path("v1/Loantransactions")
public class LoantransactionsResource extends BaseResource {

	private LoantransactionsModel LoantransactionsModel = null;

	@GET
	@Produces ("text/plain")
	public String greetUser() {
		return "Thanks for using TradeFinApps Loantransactions";
	}

	
	@GET @Path("/List")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getLoantransactionsList() {
		
		ServiceResponse response = new ServiceResponse();
		try {
			
			response.setData(getLoantransactionsModel().getLoantransactionsList());
			return Response.ok(response.toJsonString()).build();
		} catch (ClassNotFoundException e) {
			return Response.serverError().build();
		} catch (SQLException e) {
			return Response.serverError().build();
		} catch (FileNotFoundException e) {
			return Response.serverError().build();
		}
	}
	
	@PUT @Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response putLoantransactionsDetails(String LoantransactionsJson) {
		response = new ServiceResponse();
		System.out.println("entered into create Loantransactions resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(LoantransactionsJson);
			response.setData(getLoantransactionsModel().createLoantransactions(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}
	
	@PUT @Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response updateLoantransactionsDetails(String LoantransactionsJson) {
		response = new ServiceResponse();
		System.out.println("entered into update Loantransactions resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(LoantransactionsJson);
			response.setData(getLoantransactionsModel().updateLoantransactions(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}
	
	@PUT @Path("/update1")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response update1LoantransactionsDetails(String LoantransactionsJson) {
		response = new ServiceResponse();
		System.out.println("entered into update1 Loantransactions resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(LoantransactionsJson);
			response.setData(getLoantransactionsModel().update1Loantransactions(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}
	
	@PUT @Path("/statusedit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response statuseditLoantransactionsDetails(String LoantransactionsJson) {
		response = new ServiceResponse();
		System.out.println("entered into status edit Loantransactions resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(LoantransactionsJson);
			response.setData(getLoantransactionsModel().statuseditLoantransactions(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}
	
	@PUT @Path("/statusedit1")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response statusedit1LoantransactionsDetails(String LoantransactionsJson) {
		response = new ServiceResponse();
		System.out.println("entered into status edit1 Loantransactions resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(LoantransactionsJson);
			response.setData(getLoantransactionsModel().statusedit1Loantransactions(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}
	
	@PUT @Path("/statusedit2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response statusedit2LoantransactionsDetails(String LoantransactionsJson) {
		response = new ServiceResponse();
		System.out.println("entered into status edit2 Loantransactions resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(LoantransactionsJson);
			response.setData(getLoantransactionsModel().statusedit2Loantransactions(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}
	
	@PUT @Path("/overdueinterest")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response overdueinterest(String LoantransactionsJson) {
		response = new ServiceResponse();
		System.out.println("entered into overdue Loantransactions resource");
		try {
			JsonDataObject data = JsonDataObject.valueOf(LoantransactionsJson);
			response.setData(getLoantransactionsModel().overdueinterest(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}

	private LoantransactionsModel getLoantransactionsModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		if (LoantransactionsModel == null) {
			LoantransactionsModel = new LoantransactionsModel();
		}
		return LoantransactionsModel;
	}
}
/*********************************OVER****************************************************/
