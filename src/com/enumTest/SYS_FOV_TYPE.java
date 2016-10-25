package com.enumTest;

import java.util.HashMap;
import java.util.Map;

public enum SYS_FOV_TYPE {

	FOV_SMALL(0,"FOV_Small"),
	FOV_MEDIUM(1,"FOV_Medium"),
	FOV_LARGE(2,"FOV_Large");
	
	private int value;
	private String view_name;
	
	private SYS_FOV_TYPE(int i, String s){
		this.value = i;
		this.view_name = s;
	}
	
	public String getViewName(int value){
		for(SYS_FOV_TYPE fov: SYS_FOV_TYPE.values())
			if(fov.getValue() == value)
				return fov.getView_name();
		return "N/A";
	}

	//get map formatted <value, view_name>
	public Map<Integer,String> getFOVMap(){
		Map<Integer, String> fovMap = new HashMap<Integer, String>();
		for(SYS_FOV_TYPE fov: SYS_FOV_TYPE.values())
			fovMap.put(fov.getValue(), fov.getView_name());
		return fovMap;
	}
	
	public int getValue() {
		return value;
	}

	public String getView_name() {
		return view_name;
	}
	
	
}
