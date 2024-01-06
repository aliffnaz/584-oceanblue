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
	private double roomSize;
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
		List<RoomBean> rooms = new ArrayList<RoomBean>();
		
		try {
			//call getConnection() method
			con = connectionManager.getConnection();
			
			//3. create statement 
			stmt = con.createStatement();
			String sql = "SELECT * FROM room ORDER BY id";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				RoomBean room = new RoomBean();
				//roomNum,roomType,maxGuest,roomArea,roomSize,roomStatus
				room.setRoomNum(rs.getInt("roomNum"));
				room.setRoomType(rs.getString("roomType"));
				room.setMaxGuest(rs.getString("maxGuest"));
				room.setRoomArea(rs.getString("roomArea"));
				room.setRoomSize(rs.getString("roomSize"));
				room.setRoomStatus(rs.getDouble("roomStatus"));
				rooms.add(room);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		
			
		}
		
		
		return rooms;
	}
		
	//get shawl by id
	
	public static RoomBean getRoomById(int roomNum) {
		RoomBean room = new RoomBean();
		try {
			//call getConnection() method
			con = connectionManager.getConnection();
			
			//3. create statement 
			ps = con.prepareStatement("SELECT * FROM room WHERE roomNum=?");
			ps.setInt(1, roomNum);
			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
			room.setRoomNum(rs.getInt("roomNum"));
				room.setRoomType(rs.getString("roomType"));
				room.setMaxGuest(rs.getString("maxGuest"));
				room.setRoomArea(rs.getString("roomArea"));
				room.setRoomSize(rs.getString("roomSize"));
				room.setRoomStatus(rs.getDouble("roomStatus"));
				
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();	
		}			
		return room;
	}
	
	//delete shawl	
	public void deleteRoom(int roomNum) {
		try {
			//call getConnection() method
			con = connectionManager.getConnection();
			
			//3. create statement 			
			ps = con.prepareStatement("DELETE FROM room WHERE roomNum=?");
			ps.setInt(1, roomNum);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();	
		}			
	}
	
	//update shawl
	
	public void updateShawl(RoomBean bean) {

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
			ps = con.prepareStatement("UPDATE room SET roomType=?,maxGuest=?,roomArea=?,roomSize=?,roomStatus=? WHERE roomNum=?");
			//roomNum,roomType,maxGuest,roomArea,roomSize,roomStatus
			ps.setString(1, roomType);
			ps.setString(2, maxGuest);
			ps.setString(3, roomArea);
			ps.setString(4, roomSize);
			ps.setDouble(5, roomStatus);
			ps.setInt(6, roomNum);
			
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
