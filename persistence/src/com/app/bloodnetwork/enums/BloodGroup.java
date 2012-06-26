package com.app.bloodnetwork.enums;

import java.util.ArrayList;
import java.util.List;

public enum BloodGroup {

	A_POSITIVE("A+"),
	A_NEGATIVE("A-"),
	B_POSITIVE("B+"),
	B_NEGATIVE("B-"),
	AB_POSITIVE("AB+"),
	AB_NEGATIVE("AB-"),
	O_POSITIVE("O+"),
	O_NEGATIVE("O-");
	
	private final String displayName;
	
	private BloodGroup( String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public static List<String> getDisplayNames()
	{
		List<String> list = new ArrayList<String>();
		for( BloodGroup bloodGroup : values())
		{
			list.add(bloodGroup.getDisplayName());
		}
		return list;
	}
	
}
