package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ItemDao;
import com.domain.Item;
import com.utils.ConnectionUtil;

public class ItemDaoImpl implements ItemDao{
	
	//private ConnectionUtil util = ConnectionUtil.getUtil();
	static Connection conn = ConnectionUtil.getConnection();
    static String sql = ""; 
    


	@Override
	public Item findItemById(long id) {
		Item item=null;
		String query = " SELECT * FROM ITEM WHERE ID = ? ";
	
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setLong(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				item = new Item (
						resultSet.getLong("ID"),
						resultSet.getString("NAME"),
						resultSet.getFloat("PRICE"),
						resultSet.getString("Description"),
				        resultSet.getLong("Quantity"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return item;
	}

	@Override
	public List<Item> findAllItems() {
		List<Item> items = new ArrayList<Item> ();
		Item item=null;
		String query = " SELECT * FROM ITEM ";
		try{
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				item = new Item (
						resultSet.getLong("ID"),
						resultSet.getString("NAME"),
						resultSet.getFloat("PRICE"),
						resultSet.getString("Description"),
				        resultSet.getLong("Quantity"));
				items.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return items;
	}

}
