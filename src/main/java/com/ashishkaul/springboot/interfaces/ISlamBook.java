package com.ashishkaul.springboot.interfaces;

import java.util.List;
import java.util.Optional;

import com.ashishkaul.springboot.models.*;

public interface ISlamBook {
	
	String AddPersonInfo(String data);
	String EditPersonInfo(String id, String data);
	String RemovePersonInfo(String id);
	String ViewPersonInfo(String id);
	List<String> ViewPersonsInfo();

}
