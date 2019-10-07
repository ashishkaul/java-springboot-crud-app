package com.ashishkaul.springboot.interfaces;

import java.util.List;
import java.util.Optional;

import com.ashishkaul.springboot.models.*;

public interface ISlamBook {
	
	String AddPersonInfo(String data);
	String EditPersonInfo(String data);
	void RemovePersonInfo(String data);
	String ViewPersonInfo(String data);
	List<String> ViewPersonsInfo();

}
