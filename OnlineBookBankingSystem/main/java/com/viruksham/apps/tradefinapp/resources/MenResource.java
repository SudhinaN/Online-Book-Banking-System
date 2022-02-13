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
import com.viruksham.apps.tradefinapp.model.MenModel;

/**
 * @author brajagopal
 *
 */
@Path("v1/Men")
public class MenResource extends BaseResource {

	private MenModel MenModel = null;

	@GET
	@Produces ("text/plain")
	public String greetUser() {
		return "Thanks for using TradeFinApps Men";
	}
	
		@GET @Path("/MList")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getMList() {
		ServiceResponse response = new ServiceResponse();
		try {
			response.setData(getMenModel().getMenuList());
			return Response.ok(response.toJsonString()).build();
		} catch (ClassNotFoundException e) {
			return Response.serverError().build();
		} catch (SQLException e) {
			return Response.serverError().build();
		} catch (FileNotFoundException e) {
			return Response.serverError().build();
		}
	}

		@GET @Path("/List")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getUserTypeList() {
		ServiceResponse response = new ServiceResponse();
		try {
			response.setData(getMenModel().getMenList());
			return Response.ok(response.toJsonString()).build();
		} catch (ClassNotFoundException e) {
			return Response.serverError().build();
		} catch (SQLException e) {
			return Response.serverError().build();
		} catch (FileNotFoundException e) {
			return Response.serverError().build();
		}
	}

	@GET @Path("/Get/{GetID}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getMenDataGet(@PathParam("GetID") String GetID) {

		try {
			Object value = getMenModel().getMenGet(GetID);
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
	
		@GET @Path("/Insert/{MenuGroupID}/{MenuID}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response insertMenDataGet(@PathParam("MenuGroupID") String menuGroupID,@PathParam("MenuID") String menuID) {

		try {
			Object value = getMenModel().insertMenGet(menuGroupID,menuID);
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
	
			@GET @Path("/DMG/{MenuGroupID}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response deletemenugroup(@PathParam("MenuGroupID") String menuGroupID) {

		try {
			Object value = getMenModel().deletemenugroup(menuGroupID);
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

	private MenModel getMenModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		if (MenModel == null) {
			MenModel = new MenModel();
		}
		return MenModel;
	}

}
