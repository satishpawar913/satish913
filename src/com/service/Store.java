package com.service;

import com.domain.Item;
import com.domain.Person;

public interface Store {
	
	void displayItemsInStore();

	void removeItemFromCart(long itemId, Person person);

	void showItemsCart(Person person);

	boolean register(Person person);

	Person authenticatePerson(String username, String password);

    void addItemToCart(long itemId, Person person);
	
	void buyProduct(long itemId,Person person);

}
