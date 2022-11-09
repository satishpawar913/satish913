package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.PersonDao;
import com.domain.Person;
import com.utils.ConnectionUtil;

public class PersonDaoImpl implements PersonDao{
	
	static Connection conn = ConnectionUtil.getConnection();
    //static String sql = ""; 

	@Override
	public Person find(String username) {
		
		Person person = null;
		String query = "SELECT * FROM person WHERE USERNAME=?";

		try {
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				person = new Person(rs.getLong("ID"), rs.getString("USERNAME"),
						rs.getString("PASSWORD"));
			}

		} catch (Exception  e) {
			e.printStackTrace();
		}

		return person;
	}
	
	@Override
	public boolean register(Person person) {
		
		Person nPerson = null;
		String query = "INSERT INTO PERSON (USERNAME, PASSWORD)"
				+ "VALUES (?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, person.getUsername());
			pstmt.setString(2, person.getPassword());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Username already exist ! ");
			// printStackTrace();
			return false;
		}
		return true;

	}

}
