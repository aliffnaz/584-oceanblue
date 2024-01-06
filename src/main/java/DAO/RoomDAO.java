package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.dbConnection;
import guest.model.RoomBean.*;

public class RoomDAO {
static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private String roomNum;
	private String roomType;
	private String maxGuest;
	private String roomArea;
	private String roomSize;
	private String roomStatus;

	//add shawl
	public void addRoom(RoomBean bean) {
		
		roomNum = bean.getroomNum();
		roomType  = bean.getroomType();
		maxGuest = bean.getMaxGuest();
		roomArea = bean.getroomArea();
		roomSize = bean.getroomSize();
		roomStatus = bean.getroomStatus();
		
		try {			
			//call getConnection() method
			con = connectionManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("INSERT INTO room(roomNum,roomType,maxGuest,roomArea,roomSize,roomStatus)VALUES(?,?,?,?,?,?)");
			ps.setString(1, roomNum);
			ps.setString(2, roomType);
			ps.setString(3, maxGuest);
			ps.setString(4, roomArea);
			ps.setDouble(5, roomSize);
			ps.setInt(6, roomStatus);
			
			//4. execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}	
	
	//get all shawls
	public static List<shawlBean> getAllRooms(){
		List<shawlBean> rooms = new ArrayList<RoomBean>();
		
		try {
			//call getConnection() method
			con = connectionManager.getConnection();
			
			//3. create statement 
			stmt = con.createStatement();
			String sql = "SELECT * FROM shawl ORDER BY id";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				shawlBean s = new shawlBean();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setBrand(rs.getString("brand"));
				s.setColor(rs.getString("color"));
				s.setMaterial(rs.getString("material"));
				s.setPrice(rs.getDouble("price"));
				s.setQuantity(rs.getInt("quantity"));
				shawls.add(s);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		
			
		}
		
		
		return shawls;
	}
		
	//get shawl by id
	
	public static shawlBean getShawlById(int id) {
		shawlBean s = new shawlBean();
		try {
			//call getConnection() method
			con = connectionManager.getConnection();
			
			//3. create statement 
			ps = con.prepareStatement("SELECT * FROM shawl WHERE id=?");
			ps.setInt(1, id);
			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setBrand(rs.getString("brand"));
			s.setColor(rs.getString("color"));
			s.setMaterial(rs.getString("material"));
			s.setPrice(rs.getDouble("price"));
			s.setQuantity(rs.getInt("quantity"));			
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();	
		}			
		return s;
	}
	
	//delete shawl	
	public void deleteShawl(int id) {
		try {
			//call getConnection() method
			con = connectionManager.getConnection();
			
			//3. create statement 			
			ps = con.prepareStatement("DELETE FROM shawl WHERE id=?");
			ps.setInt(1, id);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();	
		}			
	}
	
	//update shawl
	
	public void updateShawl(shawlBean bean) {
		
		id = bean.getId();
		name = bean.getName();
		brand  = bean.getBrand();
		color = bean.getColor();
		material = bean.getMaterial();
		price = bean.getPrice();
		quantity = bean.getQuantity();
		
		try {			
			//call getConnection() method
			con = connectionManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("UPDATE shawl SET name=?,brand=?,color=?,material=?,price=?,quantity=? WHERE id=?");
			ps.setString(1, name);
			ps.setString(2, brand);
			ps.setString(3, color);
			ps.setString(4, material);
			ps.setDouble(5, price);
			ps.setInt(6, quantity);
			ps.setInt(7, id);
			
			//4. execute query
			ps.executeUpdate();
			
			System.out.println("Successfully updated");
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}	
}
