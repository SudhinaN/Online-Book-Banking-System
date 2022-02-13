/**
 * 
 */
package com.viruksham.utils;

import java.util.logging.Logger;

/**
 * Viruksham Base
 *
 * @author bala
 */
public abstract class VirukshamBase {

	protected Logger logger = Logger.getLogger(getClass().getName());
	private YamlReader yamlReader = YamlReader.getSingletonObject();

	/**
	 * Return the logger instance
	 * 
	 * @return
	 */
	public Logger getLogger() {
		return logger;
	}

	public YamlReader getYamlReader() {
		return yamlReader;
	}
}
