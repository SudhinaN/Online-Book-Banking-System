/**
 * 
 */
package com.viruksham.apps.tradefinapp;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

/**
 * @author bala
 */
public class TradeFinAppServer {

	private static int getPort(int defaultPort) {
		String port = System.getProperty("jersey.test.port");
		if (null != port) {
			try {
				return Integer.parseInt(port);
			} catch (NumberFormatException e) {
			}
		}
		return defaultPort;
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost/").port(getPort(9998))
				.build();
	}

	public static final URI BASE_URI = getBaseURI();

	protected static SelectorThread startServer() throws IOException {
		final Map<String, String> initParams = new HashMap<String, String>();

		initParams.put("com.sun.jersey.config.property.packages",
				"com.viruksham.apps.tradefinapp.resources");

		System.out.println("Starting grizzly...");
		SelectorThread threadSelector = GrizzlyWebContainerFactory.create(
				BASE_URI, initParams);
		return threadSelector;
	}

	public static void main(String[] args) throws IOException {
		SelectorThread httpServer = startServer();
		System.out
				.println(String
						.format("Jersey app started with WADL available at "
								+ "%sapplication.wadl\nTry out %sv1/user\nHit enter to stop it...",
								BASE_URI, BASE_URI));
		System.in.read();
		httpServer.stopEndpoint();
	}
}
