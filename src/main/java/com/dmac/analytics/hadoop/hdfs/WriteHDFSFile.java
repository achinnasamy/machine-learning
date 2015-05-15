package com.dmac.analytics.hadoop.hdfs;



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
		Path destination = new Path("/Users/tester/priya/output.txt");
		
		Configuration conf = getConf();
		
		System.out.println(conf.get(FS_PARAM_NAME));
		
		FileSystem fs =  FileSystem.get(conf);
		
		fs.copyFromLocalFile(source, destination);
		return 0;
	}
}
