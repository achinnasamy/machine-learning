package com.dmac.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {
	private Properties multiLayerProperties;
	public static void main(String[] args) {
		ReadPropertiesFile s = new ReadPropertiesFile();

		String metricsString = s.getMultiLayerProperties().getProperty(
				"username");
		
		System.out.println(metricsString);
	}
	public Properties getMultiLayerProperties() {
		if (multiLayerProperties == null) {

			String filename = "inferneon.properties";
			InputStream input = null;
			input = ReadPropertiesFile.class.getClassLoader()
					.getResourceAsStream(filename);
			if (input == null) {
				//getLogger().error("Unable to find config file" + filename);
			}

			// load a properties file from class path
			try {
				multiLayerProperties = new Properties();
				multiLayerProperties.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return multiLayerProperties;
	}
}
