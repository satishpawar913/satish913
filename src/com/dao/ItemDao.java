package com.dao;

import java.util.List;

import com.domain.Item;


public interface ItemDao {
	Item findItemById(long id);

	List<Item> findAllItems();


}
