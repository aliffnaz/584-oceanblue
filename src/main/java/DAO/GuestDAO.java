package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.dbConnection;
import guest.model.GuestBean;

public class GuestDAO {

	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private String guestName, guestPhoneNumber, guestICNumber, guestGender, guestReligion, guestRace, guestAddress;

	// add guest
	public void addGuest(GuestBean bean) {

		guestName = bean.getGuestName();
		guestPhoneNumber = bean.getGuestPhoneNumber();
		guestICNumber = bean.getGuestICNumber();
		guestGender = bean.getGuestGender();
		guestReligion = bean.getGuestReligion();
		guestRace = bean.getGuestRace();
		guestAddress = bean.getGuestAddress();

		try {
			// call getConnection() method
			con = dbConnection.getConnection();

			// 3. create statement
			ps = con.prepareStatement(
					"INSERT INTO guest(guestName,guestPhoneNumber,guestICNumber,guestGender,guestReligion,guestRace,guestAddress)VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, guestName);
			ps.setString(2, guestPhoneNumber);
			ps.setString(3, guestICNumber);
			ps.setString(4, guestGender);
			ps.setString(5, guestReligion);
			ps.setString(6, guestRace);
			ps.setString(7, guestAddress);

			// 4. execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// get all guests
	public static List<GuestBean> getAllGuests() {
		List<GuestBean> guests = new ArrayList<GuestBean>();

		try {
			// call getConnection() method
			con = dbConnection.getConnection();

			// 3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM guest ORDER BY guestICNumber";

			// 4. execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) { // process result
				GuestBean gst = new GuestBean();
				gst.setGuestID(rs.getInt("guestID"));
				gst.setGuestName(rs.getString("guestName"));
				gst.setGuestPhoneNumber(rs.getString("guestPhoneNumber"));
				gst.setGuestICNumber(rs.getString("guestICNumber"));
				gst.setGuestGender(rs.getString("guestGender"));
				gst.setGuestReligion(rs.getString("guestReligion"));
				gst.setGuestRace(rs.getString("guestRace"));
				gst.setGuestAddress(rs.getString("guestAddress"));
				guests.add(gst);
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return guests;
	}

	// get guest by guestID

	public static GuestBean getGuestById(int guestID) {
		GuestBean gst = new GuestBean();
		try {
			// call getConnection() method
			con = dbConnection.getConnection();

			// 3. create statement
			ps = con.prepareStatement("SELECT * FROM guest WHERE guestICNumber=?");
			ps.setInt(1, guestID);

			// 4. execute query
			rs = ps.executeQuery();
			if (rs.next()) {
				gst.setGuestID(rs.getInt("guestID"));
				gst.setGuestName(rs.getString("guestName"));
				gst.setGuestPhoneNumber(rs.getString("guestPhoneNumber"));
				gst.setGuestICNumber(rs.getString("guestICNumber"));
				gst.setGuestGender(rs.getString("guestGender"));
				gst.setGuestReligion(rs.getString("guestReligion"));
				gst.setGuestRace(rs.getString("guestRace"));
				gst.setGuestAddress(rs.getString("guestAddress"));
			}
			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return gst;
	}

	// delete guest
	public void deleteGuest(int guestID) {
		try {
			// call getConnection() method
			con = dbConnection.getConnection();

			// 3. create statement
			ps = con.prepareStatement("DELETE FROM guest WHERE guestICNumber=?");
			ps.setInt(1, guestID);

			// 4. execute query
			ps.executeUpdate();

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update guest

	public void updateGuest(GuestBean bean) {

		guestName = bean.getGuestName();
		guestPhoneNumber = bean.getGuestPhoneNumber();
		guestICNumber = bean.getGuestICNumber();
		guestGender = bean.getGuestGender();
		guestReligion = bean.getGuestReligion();
		guestRace = bean.getGuestRace();
		guestAddress = bean.getGuestAddress();

		try {
			// call getConnection() method
			con = dbConnection.getConnection();

			// 3. create statement
			ps = con.prepareStatement(
					"UPDATE guest SET guestName=?,guestPhoneNumber=?,guestICNumber=?,guestGender=?,guestReligion=?,guestRace=?,guestAddress=? WHERE guestICNumber=?");
			ps.setString(1, guestName);
			ps.setString(2, guestPhoneNumber);
			ps.setString(3, guestICNumber);
			ps.setString(4, guestGender);
			ps.setString(5, guestReligion);
			ps.setString(6, guestRace);
			ps.setString(7, guestAddress);

			// 4. execute query
			ps.executeUpdate();

			System.out.println("Successfully updated");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
