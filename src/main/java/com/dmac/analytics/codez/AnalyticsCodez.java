/**
 * Copyright (c) 2014 iPro,Inc. and its affiliates. All rights reserved.
 */
package com.dmac.analytics.codez;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@gmail.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public enum AnalyticsCodez {

	
	HBASE_ZOOKEEPER_QUORUM_VALUE				("hbase.zookeeper.quorum"),
	HADOOP_NAME_NODE							("hadoop.namenode"),
	HADOOP_JOB_TRACKER							("hadoop.jobtracker");
	
	
	
	
	
	
	private String name;
	
	/**
	 * 
	 * @param name
	 */
	private AnalyticsCodez(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {		
		return this.name;
	}
}
