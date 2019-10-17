package com.ashishkaul.rest.interfaces;

import java.util.List;

public interface IH2Repository {
	String Create(String data);
	String Update(String id, String data);
	String Delete(String id);
	String ReadOne(String id);
	List<String> ReadAll();
}
