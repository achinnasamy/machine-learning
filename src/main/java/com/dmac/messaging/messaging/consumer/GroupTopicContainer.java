package com.dmac.messaging.messaging.consumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.iprogames.util.constraints.Conditions;

/**
* A singleton container to hold in all the GROUP TOPICS
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public final class GroupTopicContainer {
	
	private static final GroupTopicContainer INSTANCE = new GroupTopicContainer();
	
	List<String> topicContainer = Collections.synchronizedList(new ArrayList<String>());
	
	private GroupTopicContainer() {}	
	
	public static GroupTopicContainer getInstance() {
		return INSTANCE;
	}
	
	/**
	 * 
	 * @param topicName
	 */
	public void insertIntoContainer(String topicName) {		
		Conditions.checkNotNull(topicName);		
		topicContainer.add(topicName);		
	}
	
	/**
	 * 
	 * @param topicName
	 */
	public void removeFromContainer(String topicName) {		
		topicContainer.remove(topicName);		
	}
	
	/**
	 * 
	 * @param topicName
	 * @return
	 */
	public boolean doesTopicAlreadyExists(String topicName) {
		return topicContainer.contains(topicName);
	}
	
	/**
	 * 
	 * @return
	 */
	public int currentNumberOfGroupTopicsRunning() {
		return topicContainer.size();
	}
	
}
