package com.dmac.analytics.storm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;


public class StormConnectionFactory {

	
	private static final StormConnectionFactory INSTANCE = new StormConnectionFactory().init();
	
	/**
	 * 
	 * @return
	 */
	public static StormConnectionFactory getInstance() {
		
		return INSTANCE;
	}
	
	private StormConnectionFactory init() 
	{
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Config retrieveStormClusterConfig() 
	{		
		Config config = new Config();
		config.setMaxTaskParallelism(10);
		return config;
	}
	
	public void runTopology(TopologyBuilder topology) {
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("Config-Topology", null, topology.createTopology());
		cluster.getState();
		cluster.shutdown();
	}
}
