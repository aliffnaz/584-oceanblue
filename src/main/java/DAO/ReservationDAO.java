package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.dbConnection;
import guest.model.ReservationBean;

public class ReservationDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int guestQuantity,durationOfStay,totalAdult,totalKids,totalRoom;
	private String guestICNumber,dateStart,dateEnd,reserveStatus,staffICNumber,reservationID;
  private Double totalPayment;

	//add reservation
	public void addReservation(ReservationBean bean) {
		
    guestICNumber = bean.getGuestICNumber();
    guestQuantity = bean.getGuestQuantity();
    durationOfStay = bean.getDurationOfStay();
    dateStart = bean.getDateStart();
    dateEnd = bean.getDateEnd();
    totalAdult = bean.getTotalAdult();
    totalKids = bean.getTotalKids();
    reserveStatus = bean.getReserveStatus();
    totalRoom = bean.getTotalRoom();
    totalPayment = bean.getTotalPayment();
    staffICNumber = bean.getStaffICNumber();
		
		try {			
			//call getConnection() method
			con = dbConnection.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("INSERT INTO reservation(guestICNumber,guestQuantity,durationOfStay,dateStart,dateEnd,totalAdult,totalKids,reserveStatus,totalRoom,totalPayment,staffICNumber)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
      ps.setString(1, guestICNumber);
      ps.setInt(2, guestQuantity);
      ps.setInt(3, durationOfStay);
      ps.setString(4, dateStart);
      ps.setString(5, dateEnd);
      ps.setInt(6, totalAdult);
      ps.setInt(7, totalKids);
      ps.setString(8, reserveStatus);
      ps.setInt(9, totalRoom);
      ps.setDouble(10, totalPayment);
      ps.setString(11, staffICNumber);
			
			//4. execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}	
	
	//get all reservations
	public static List<ReservationBean> getAllReservations(){
		List<ReservationBean> reservations = new ArrayList<ReservationBean>();
		
		try {
			//call getConnection() method
			con = dbConnection.getConnection();
			
			//3. create statement 
			stmt = con.createStatement();
			String sql = "SELECT * FROM reservation ORDER BY reservationID";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				ReservationBean rsv = new ReservationBean();
        rsv.setGuestICNumber(rs.getString("guestICNumber"));
        rsv.setGuestQuantity(rs.getInt("guestQuantity"));
        rsv.setDurationOfStay(rs.getInt("durationOfStay"));
        rsv.setDateStart(rs.getString("dateStart"));
        rsv.setDateEnd(rs.getString("dateEnd"));
        rsv.setTotalAdult(rs.getInt("totalAdult"));
        rsv.setTotalKids(rs.getInt("totalKids"));
        rsv.setReserveStatus(rs.getString("reserveStatus"));
        rsv.setTotalRoom(rs.getInt("totalRoom"));
        rsv.setTotalPayment(rs.getDouble("totalPayment"));
        rsv.setStaffICNumber(rs.getString("staffICNumber"));

				reservations.add(rsv);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		
			
		}
		
		
		return reservations;
	}
		
	//get reservation by id
	
	public static ReservationBean getReservationById(int reservationID) {
		ReservationBean rsv = new ReservationBean();
		try {
			//call getConnection() method
			con = dbConnection.getConnection();
			
			//3. create statement 
			ps = con.prepareStatement("SELECT * FROM reservation WHERE reservationID=?");
			ps.setInt(1, reservationID);
			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
      rsv.setGuestICNumber(rs.getString("guestICNumber"));
      rsv.setGuestQuantity(rs.getInt("guestQuantity"));
      rsv.setDurationOfStay(rs.getInt("durationOfStay"));
      rsv.setDateStart(rs.getString("dateStart"));
      rsv.setDateEnd(rs.getString("dateEnd"));
      rsv.setTotalAdult(rs.getInt("totalAdult"));
      rsv.setTotalKids(rs.getInt("totalKids"));
      rsv.setReserveStatus(rs.getString("reserveStatus"));
      rsv.setTotalRoom(rs.getInt("totalRoom"));
      rsv.setTotalPayment(rs.getDouble("totalPayment"));
      rsv.setStaffICNumber(rs.getString("staffICNumber"));
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();	
		}			
		return rsv;
	}
	
	//delete reservation	
	public void deleteReservation(int reservationID) {
		try {
			//call getConnection() method
			con = dbConnection.getConnection();
			
			//3. create statement 			
			ps = con.prepareStatement("DELETE FROM reservation WHERE reservationID=?");
			ps.setInt(1, reservationID);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();	
		}			
	}
	
	//update reservation
	
	public void updateReservation(ReservationBean bean) {
		
    guestICNumber = bean.getGuestICNumber();
    guestQuantity = bean.getGuestQuantity();
    durationOfStay = bean.getDurationOfStay();
    dateStart = bean.getDateStart();
    dateEnd = bean.getDateEnd();
    totalAdult = bean.getTotalAdult();
    totalKids = bean.getTotalKids();
    reserveStatus = bean.getReserveStatus();
    totalRoom = bean.getTotalRoom();
    totalPayment = bean.getTotalPayment();
    staffICNumber = bean.getStaffICNumber();
		
		try {			
			//call getConnection() method
			con = dbConnection.getConnection();
			
			//3. create statement - for MANAGER only
			ps = con.prepareStatement("UPDATE reservation SET reservestatus=? WHERE reservationID=?");
      ps.setString(1, reserveStatus);
      ps.setString(2, reservationID);
      //ps.setString(1, guestICNumber);
      //ps.setInt(2, guestQuantity);
      //ps.setInt(3, durationOfStay);
      //ps.setString(4, dateStart);
      //ps.setString(5, dateEnd);
      //ps.setInt(6, totalAdult);
      //ps.setInt(7, totalKids);
      //ps.setInt(9, totalRoom);
      //ps.setDouble(10, totalPayment);
      //ps.setString(11, staffICNumber);
			
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
