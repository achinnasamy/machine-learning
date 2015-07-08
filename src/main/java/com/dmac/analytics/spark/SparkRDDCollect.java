package com.dmac.analytics.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;

public class SparkRDDCollect {

	public static void main(String args[]) {

		SparkConf sparkConfig = new SparkConf()
						.setAppName("ReadLogFile")
						.setMaster("local[5]");
						
		
		JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConfig);

		JavaRDD<String> rdd = javaSparkContext.textFile("file:///Users/tester/ac/entitlement_view.csv");
		
		rdd.persist(StorageLevel.MEMORY_ONLY());
		rdd.collect().forEach(z -> System.out.println(z));
		rdd.unpersist();
		
		//javaSparkContext.textFile("file:///Users/tester/input.txt").cache().collect();
		
		javaSparkContext.close();
	}
}
