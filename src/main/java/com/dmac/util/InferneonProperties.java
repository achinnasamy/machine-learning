package com.dmac.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class InferneonProperties {

		private static Properties properties;
		
		//Dont instantiate a singleton class
		private InferneonProperties() {}
		
		public synchronized static Properties getInstance() {
			if(properties == null) {
				properties = new Properties();
				loadProps();
			}
			
			return properties;
		}
		
		private static void loadProps() {
			try(InputStream in = InferneonProperties.class.getClassLoader().getResourceAsStream("inferneon.properties");) {
				properties.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
