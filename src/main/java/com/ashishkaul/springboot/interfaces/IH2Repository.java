package com.ashishkaul.springboot.interfaces;

import java.util.List;
import java.util.Optional;

import com.ashishkaul.springboot.models.Person;

public interface IH2Repository {
	String Create(String data);
	String Update(String data);
	String Delete(String data);
	String ReadOne(String data);
	List<String> ReadAll();
}
