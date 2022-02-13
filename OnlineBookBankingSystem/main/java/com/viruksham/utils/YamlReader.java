/**
 * 
 */
package com.viruksham.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.logging.Logger;

import org.yaml.snakeyaml.Yaml;

/**
 * YAML Reader
 *
 * @author bala
 */
public class YamlReader {

	private static YamlReader yaml = null;
	private Yaml yml = null;
	private static Map<String, Object> map = null;

	public Logger logger = Logger.getLogger(getClass().getName());

	private YamlReader() {
		yml = new Yaml();
	}

	public static YamlReader getSingletonObject() {
		if (yaml == null) {
			yaml = new YamlReader();
		}
		return yaml;
	}

	@SuppressWarnings("unchecked")
	public void loadFile(String fileName) throws FileNotFoundException {
		Reader rdr = null;
		if (map == null) {
			try {
				rdr = new FileReader(fileName);
				map = (Map<String, Object>) yml.load(rdr);
			} catch (FileNotFoundException e) {
				logger.throwing(getClass().getName(), "loadFile", e);
			} finally {
				try {
					rdr.close();
				} catch (IOException e) {}
				rdr = null;
			}
		}
	}

	public Object getValue(String key) {
		return map.get(key);
	}
}