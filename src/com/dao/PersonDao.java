package com.dao;

import com.domain.Person;

public interface PersonDao {
	//Find person by username
		Person find(String username); 
		
		//Register person
		boolean register (Person person); 

}
