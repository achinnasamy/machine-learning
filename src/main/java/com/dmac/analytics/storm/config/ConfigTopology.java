package com.dmac.analytics.storm.config;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;

public class ConfigTopology {

	public static void main(String[] args) throws Exception {
		
		TopologyBuilder topologyBuilder = new TopologyBuilder();
		
		topologyBuilder.setSpout("spout", null, 5);
		
		
		
		//topologyBuilder.setBolt("", null);
		StormSubmitter.submitTopology("ConfigTopology", null, topologyBuilder.createTopology());
		
		
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("Config-Topology", null, topologyBuilder.createTopology());
		
		cluster.shutdown();
	}
}
