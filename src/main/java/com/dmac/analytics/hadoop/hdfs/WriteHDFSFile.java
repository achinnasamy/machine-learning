package com.dmac.analytics.hadoop.hdfs;



import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public final class WriteHDFSFile extends Configured implements Tool {
	
	public static final String FS_PARAM_NAME = "fs.defaultFS";
	
	public static void main(String DMAC[]) {
		
		try {
			int returnCode = ToolRunner.run(new WriteHDFSFile(), DMAC);
			System.exit(returnCode);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public int run(String[] arg0) throws Exception {
		
		Path source = new Path("/Users/tester/input.txt");
		//Path destination = new Path("output.txt");
		Path destination = new Path("hdfs://localhost:9000/priya");
		
		//InputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/tester/input.txt"));
		
		Configuration conf = getConf();
		
		conf.addResource(new Path("/Users/tester/hadoop27/etc/hadoop/core-site.xml"));
		conf.addResource(new Path("/Users/tester/hadoop27/etc/hadoop/hdfs-site.xml"));
		
		System.out.println(conf.get(FS_PARAM_NAME));
		
		FileSystem fs =  FileSystem.get(new URI("hdfs://localhost:9000"), conf);

		fs.copyFromLocalFile(source, destination);
//		
//		fs.create(destination, new Progressable() {
//			
//			@Override
//			public void progress() {
//				System.out.println("....");
//				
//			}
//		});
		
		//IOUtils.copyBytes(in, out, conf);
		return 0;
	}
}
