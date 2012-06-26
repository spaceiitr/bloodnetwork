package com.app.bloodnetwork.enums;

import java.util.ArrayList;
import java.util.List;

public enum Availibility {

	LOW ("Low"),
	FRIENDS("Friends Only"),
	HIGH("High");

	private final String displayName;

	private Availibility( String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public static List<String> getDisplayNames()
	{
		List<String> list = new ArrayList<String>();
		for( Availibility availibility : values())
		{
			list.add(availibility.getDisplayName());
		}
		return list;
	}
}