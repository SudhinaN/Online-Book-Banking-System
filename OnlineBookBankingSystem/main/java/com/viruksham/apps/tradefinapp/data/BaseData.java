/**
 * 
 */
package com.viruksham.apps.tradefinapp.data;

import java.util.logging.Logger;

/**
 * @author bala
 *
 */
public abstract class BaseData {
	protected Logger logger = Logger.getLogger(getClass().getName());

	/**
	 * Return the logger instance
	 * 
	 * @return
	 */
	public Logger getLogger() {
		return logger;
	}
}
