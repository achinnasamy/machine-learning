package com.dmac.async.messaging;



import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.dmac.messaging.vo.IPROMessage;
import com.dmac.messaging.vo.IPROParticipant;
import com.google.common.base.Function;
import com.iprogames.util.constraints.Conditions;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class StringLineToIPROMessageProcessorFunction implements Function<String, IPROMessage> {
	
	
	@Override
	public IPROMessage apply(String input) {
		
		Conditions.checkNotNull(input);
		Conditions.checkNotEmptyString(input);
		
		IPROMessage iproMessage = new IPROMessage();
		
		StringTokenizer tz = new StringTokenizer(input, "|");	
		String groupID = tz.nextToken();		
		String participantIDS = tz.nextToken();		
		
		StringTokenizer tokenOfPIDS = new StringTokenizer(participantIDS, ",");
		
		List<IPROParticipant>	listOfParticipants = new ArrayList<IPROParticipant>();
		while (tokenOfPIDS.hasMoreTokens()) {
			IPROParticipant ipo = new IPROParticipant(tokenOfPIDS.nextToken());
			listOfParticipants.add(ipo);			
		}
		
		iproMessage.setGroupID(groupID);
		iproMessage.setMessage("Alan Turing Group" + groupID);
		iproMessage.setListOfParticipants(listOfParticipants);
		
		return iproMessage;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(Runtime.getRuntime().availableProcessors());
		IPROMessage iproMessage = new StringLineToIPROMessageProcessorFunction().apply("12345 | 12,14,15,20,35");
		System.out.println(iproMessage.getMessage());
		System.out.println(iproMessage.getGroupID());
		System.out.println(iproMessage.getListOfParticipants().get(3).getParticipantID());
		
		
	}
}
