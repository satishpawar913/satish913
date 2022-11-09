package com.dao;

import java.util.List;

import com.domain.Item;
import com.domain.Person;


public interface PersonItemDao {
	
	List<Item> findAllItemsByPersonId(Person person);

	boolean removeItemFromCart(long itemId, Person person);

	boolean addItemtoCart(long itemId, Person person);
	
	//boolean getTotalAmount(long itemId, Person person);

	boolean buyProduct(long itemId, Person person);

}
