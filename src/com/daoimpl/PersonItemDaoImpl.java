package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.PersonItemDao;
import com.domain.Item;
import com.domain.Person;
import com.utils.ConnectionUtil;

public class PersonItemDaoImpl implements PersonItemDao{
	
	static Connection conn = ConnectionUtil.getConnection();

	@Override
	public List<Item> findAllItemsByPersonId(Person person) {
		
		List <Item> items = new ArrayList<Item>(); 
		Item item;
		String query = "SELECT pi.p_id, i.id,  i.name, i.price,i.description,i.quantity FROM person_item pi"
				+ " INNER JOIN item i ON pi.i_id = i.id AND pi.p_id = ?";
		
		try{
		
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, person.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				item = new Item(rs.getLong("ID"), 
						rs.getString("NAME"), 
						rs.getFloat("PRICE"),
				        rs.getString("Description"),
		                rs.getLong("Quantity"));
				
				
				items.add(item);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return items; 
	}

	@Override
	public boolean removeItemFromCart(long itemId, Person person) {
		boolean success; 
		String query = "DELETE FROM PERSON_ITEM WHERE P_ID=? AND I_ID = ?";// WHERE ROWNUM <= 1
		
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, person.getId());
			ps.setLong(2, itemId);
			
			int result = ps.executeUpdate();
			
			if(result==1)
				return true; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean addItemtoCart(long itemId, Person person) {
		
		boolean success; 
		String query = "INSERT INTO PERSON_ITEM (P_ID,I_ID) VALUES (?,?)";
		
		try{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, person.getId());
			ps.setLong(2, itemId);
			
			
			int result = ps.executeUpdate();
			
			if(result==1)
				return true; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean buyProduct(long itemId, Person person) {
		boolean success; 
		List <Item> items = new ArrayList<Item>(); 
		Item item;
		
		try {

			PreparedStatement ps = conn.prepareStatement("Select * from person_item where P_ID =? and I_ID =? ");
			ps.setLong(1, person.getId());
			ps.setLong(2, itemId);
			ps.setFloat(3, person.getPrice());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				item = new Item(rs.getLong("ID"), 
						rs.getString("NAME"), 
						rs.getFloat("PRICE"),
		                rs.getLong("Quantity"));
			
			}
			conn.close();
			rs.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	
		
}
