package com.dmac.service;

import org.springframework.stereotype.Service;

@Service
public class HDFSService {

	/**
	 * 
	 * @param fileName
	 * @return success or failure
	 */
	public boolean createHDFSFile(String fileName) {
		return true;
	}

	/**
	 * 
	 * @param directoryName
	 * @return success or failure
	 */
	public boolean createHDFSDirectory(String directoryName) {
		return true;
	}
	
	/**
	 * 
	 * @param fileName
	 * @return success or failure
	 */
	public boolean copyFileFromLocalToHDFS(String fileName) {
		return true;
	}	

}
