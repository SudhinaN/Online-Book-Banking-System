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
import com.viruksham.apps.tradefinapp.model.MenuModel;

/**
 * @author brajagopal
 *
 */
@Path("v1/Menu")
public class MenuResource extends BaseResource {

	private MenuModel menuModel = null;

	@GET
	@Produces ("text/plain")
	public String greetUser() {
		return "Thanks for using TradeFinApps Menu";
	}
	
		@GET @Path("/List")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getUserTypeList() {
		ServiceResponse response = new ServiceResponse();
		try {
			response.setData(getMenuModel().getMenuList());
			return Response.ok(response.toJsonString()).build();
		} catch (ClassNotFoundException e) {
			return Response.serverError().build();
		} catch (SQLException e) {
			return Response.serverError().build();
		} catch (FileNotFoundException e) {
			return Response.serverError().build();
		}
	}
			@GET @Path("/UserMenuList")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getUserMenuList() {
		ServiceResponse response = new ServiceResponse();
		try {
			response.setData(getMenuModel().getUserMenuList());
			return Response.ok(response.toJsonString()).build();
		} catch (ClassNotFoundException e) {
			return Response.serverError().build();
		} catch (SQLException e) {
			return Response.serverError().build();
		} catch (FileNotFoundException e) {
			return Response.serverError().build();
		}
	}
	
	@GET @Path("/{userid}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getUserTypeDataGet(@PathParam("userid") String userid) {

		try {
			Object value = getMenuModel().getMenuGet(userid);
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

	private MenuModel getMenuModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		if (menuModel == null) {
			menuModel = new MenuModel();
		}
		return menuModel;
	}

}
