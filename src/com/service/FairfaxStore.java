package com.service;

import java.util.List;
import java.util.ListIterator;

import com.dao.ItemDao;
import com.dao.PersonDao;
import com.dao.PersonItemDao;
import com.daoimpl.ItemDaoImpl;
import com.daoimpl.PersonDaoImpl;
import com.daoimpl.PersonItemDaoImpl;
import com.domain.Item;
import com.domain.Person;
import com.service.Store;

public class FairfaxStore implements Store{
	
	private ItemDao iDao = new ItemDaoImpl();
	private PersonDao pDao = new PersonDaoImpl();
	private PersonItemDao piDoa = new PersonItemDaoImpl();
	
	@Override
	public void displayItemsInStore() {
		
        List<Item> items = iDao.findAllItems();
		
		System.out.println("\nItems in the store : ");
		for(Item i : items){
			System.out.println(i);
		}
	}
	
	@Override
	public void addItemToCart(long itemId, Person person) {
		piDoa.addItemtoCart(itemId, person);
		System.out.println("\nItem "+ itemId +" was added !");
		
	}
	
	@Override
	public void removeItemFromCart(long itemId, Person person) {
		piDoa.removeItemFromCart(itemId, person);
		System.out.println("\nItem " +itemId+ " was removed !");	
	}
	
	@Override
	public void showItemsCart(Person person) {
		List<Item> items = piDoa.findAllItemsByPersonId(person);
		
		if(items!=null){
			System.out.println("\nYour cart "+ person.getUsername()+"c :");
			for(Item i : items){
				System.out.println(i);
			}
		}else{
			System.out.println("\nYour cart "+ person.getUsername()+"c is empty ");
		}
	}
	
	public void buyProduct(long itemId, Person person) {
	
		List<Item> items = piDoa.findAllItemsByPersonId(person);
		
		int count =0;
		int temp =0;
		String name;
		float price;
		long quantity;
	
			
			//String pname = rs.getString(4);
		    System.out.println("\nYour cart "+ person.getUsername()+"c :");
			count++;
			System.out.println("product price > " +person.getPrice());
			temp=temp;
		
	}
			
	@Override
	public boolean register(Person person) {
		boolean b= pDao.register(person);
		 if(!b){
			 System.out.println(person.getUsername() + " could not be registered");
		 }else{
			 System.out.println(person.getUsername() + " was registered");
		 }
		 return b;
	}
	
	@Override
	public Person authenticatePerson(String username, String password) {
		Person person = pDao.find(username);
		if(person==null)
			return null;
		else{
			if(person.getPassword()!=null&&person.getPassword().equals(password)){
				return person;
			}
			else{
				return null; 
			}
		}
	}

		
	
	

}
