/**
 * Copyright (c) 2014 iPro,Inc. and its affiliates. All rights reserved.
 */
package com.dmac.analytics.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.HBaseConfiguration;

import com.dmac.analytics.codez.BIGDATA_TABLE;

/**
* 
* @author <a href="mailto:aravindh.chinnasamy@gmail.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public final class HBaseConnectionFactory {

	private Configuration config;

	private HTablePool tablePool;
	
	private static final HBaseConnectionFactory INSTANCE = new HBaseConnectionFactory().init();
	
	/**
	 * 
	 * @return
	 */
	public static HBaseConnectionFactory getInstance() {
		
		return INSTANCE;
	}
	
	/**
	 * 
	 * @param table
	 * @return
	 */
	public HTableInterface createHTable(final BIGDATA_TABLE table) 
	{
		return (HTableInterface) this.tablePool.getTable(table.name());
	}
	
	
	/**
	 * 
	 * @return
	 */
	private HBaseConnectionFactory init() 
	{
		this.config = HBaseConfiguration.create();
		this.config.set("hbase.zookeeper.quorum", "");		
		this.tablePool = new HTablePool(this.config, Integer.MAX_VALUE);

		return this;
	}
	
	/**
	 * 
	 */
	public void ping() {
		
	}
}
