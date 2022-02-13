/**
 * 
 */
package com.viruksham.apps.tradefinapp.resources;

import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.viruksham.apps.tradefinapp.data.ServiceResponse;

/**
 * @author bala
 *
 */
public class BaseResource {

	protected Logger logger = Logger.getLogger(getClass().getSimpleName());

	protected ResponseBuilder builder = Response.serverError();

	protected ServiceResponse response;
}
