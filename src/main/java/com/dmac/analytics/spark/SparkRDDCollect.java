package com.dmac.analytics.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;

public class SparkRDDCollect {

	public static void main(String args[]) {

		// local - runs the spark locally
		// local[5] - runs the spark locally with 5 threads
		SparkConf sparkConfig = new SparkConf()
						.setAppName("ReadLogFile")
						.setMaster("local[5]");
						
		
		JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConfig);

		JavaRDD<String> rdd = javaSparkContext.textFile("file:///Users/tester/ac/entitlement_view.csv");
		
		rdd.cache();
		JavaRDD<String> persistedRDD = rdd.persist(StorageLevel.MEMORY_ONLY());
		rdd.collect().forEach(z -> System.out.println(z));
		persistedRDD.unpersist();
		
		//javaSparkContext.textFile("file:///Users/tester/input.txt").cache().collect();
		
		// To 
		//javaSparkContext.stop();
		javaSparkContext.close();
	}
}
