

/**
 * 
 */
package com.viruksham.apps.tradefinapp.resources;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.viruksham.apps.tradefinapp.data.ServiceResponse;
import com.viruksham.apps.tradefinapp.model.ParamModel;

/**
 * @author brajagopal
 *
 */
@Path("v1/Param")
public class ParamResource extends BaseResource {

	private ParamModel paramModel = null;

	@GET
	@Produces ("text/plain")
	public String greetUser() {
		return "Thanks for using TradeFinApps parameters";
	}


	@GET @Path("/List")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getParamList() {
		
		ServiceResponse response = new ServiceResponse();
		try {
			
			response.setData(getParamModel().getParamList());
			return Response.ok(response.toJsonString()).build();
		} catch (ClassNotFoundException e) {
			return Response.serverError().build();
		} catch (SQLException e) {
			return Response.serverError().build();
		} catch (FileNotFoundException e) {
			return Response.serverError().build();
		}
	}

		@GET @Path("/Get/{Param}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getUserTypeDataGet(@PathParam("Param") String GetID) {

		try {
			Object value = getParamModel().getParamGet(GetID);
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

	@GET @Path("/Insert/{Param}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response insertUserTypeDataGet(@PathParam("Param") String GetID) {

		try {
			Object value = getParamModel().insertParamGet(GetID);
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
	
		@GET @Path("/Edit/{NameParam}/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response editUserTypeDataGet(@PathParam("NameParam") String NameParam,@PathParam("id") String id) {

		try {
			Object value = getParamModel().editParamGet(NameParam,id);
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

		@GET @Path("/Insert1/{CodeParam}/{NameParam}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response insert1UserTypeDataGet(@PathParam("CodeParam") String CodeParam,@PathParam("NameParam") String NameParam) {
System.out.println("entered into param insert1 resource");
		try {
			Object value = getParamModel().insert1ParamGet(CodeParam,NameParam);
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
	
		@GET @Path("/Delete/{Param}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response deleteUserTypeDataGet(@PathParam("Param") String GetID) {

		try {
			Object value = getParamModel().deleteParamGet(GetID);
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

		@GET @Path("/Delete1/{Param}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response deleteDocType(@PathParam("Param") String GetID) {

		try {
			Object value = getParamModel().deleteDocType(GetID);
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
	
			@GET @Path("/Delete2/{Param}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response deleteDoc(@PathParam("Param") String GetID) {

		try {
			Object value = getParamModel().deleteDoc(GetID);
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

/*	@PUT @Path("/create")

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response putUserDetails(String userJson) {
		
		response = new ServiceResponse();
		
		try {
			JsonDataObject data = JsonDataObject.valueOf(userJson);
			response.setData(getParamModel().createUser(data.getValue()));
			builder.entity(response.toJsonString()).status(Status.OK);
			} catch (Exception e) {
			builder.header("X-Error-Message", e.getMessage());
		}
		return builder.build();
	}*/


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

	private ParamModel getParamModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		if (paramModel == null) {
			paramModel = new ParamModel();
		}
		return paramModel;
	}
}
