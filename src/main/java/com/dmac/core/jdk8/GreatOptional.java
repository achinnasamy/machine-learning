package com.dmac.core.jdk8;

import java.util.Optional;

public class GreatOptional {

	
	public static void main(String args[]) {
		
		SomeDataObject dObject = new SomeDataObject();
		dObject.setDataMember("MY_DATA_IS_INSIDE");
		
		
		
		
		Optional<SomeDataObject> sdo = Optional.of(dObject);
		//Optional<SomeDataObject> sdo = Optional.empty();
				
		
		sdo.ifPresent(dff->System.out.println(dff.getDataMember()));

		
		
		
		
		
		
		//System.out.println(sdo.isPresent());
		//System.out.println(sdo.get().getDataMember());
		
	}
}


class SomeDataObject {
	
	private String dataMember = "DATA_DATA_DATA";

	public String getDataMember() {
		return dataMember;
	}

	public void setDataMember(String dataMember) {
		this.dataMember = dataMember;
	}
	
	
}