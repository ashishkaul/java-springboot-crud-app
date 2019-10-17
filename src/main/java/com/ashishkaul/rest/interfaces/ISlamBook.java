package com.ashishkaul.rest.interfaces;

import java.util.List;

public interface ISlamBook {
	
	String AddPersonInfo(String data);
	String EditPersonInfo(String id, String data);
	String RemovePersonInfo(String id);
	String ViewPersonInfo(String id);
	List<String> ViewPersonsInfo();

}
