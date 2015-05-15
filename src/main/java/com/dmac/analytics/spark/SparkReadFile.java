package com.dmac.analytics.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;



public class SparkReadFile {
	
	
	
	public static void main(String[] args) {

		SparkConf sparkConfig = new SparkConf().setAppName("ReadLogFile").setMaster("local[4]");
		
		JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConfig);
		
		
		JavaRDD<String> dataset = javaSparkContext.textFile("file:///Users/tester/spark/examples/server.log");
		
		dataset.foreach((z) -> System.out.println(z));
		
	}
}
