package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.dbConnection;
import service.model.*;

public class ServiceDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private String serviceID,serviceName,serviceType,serviceStatus;
	private double servicePrice;

	//add service
	public void addService(ServiceBean bean) {
		
		serviceID = bean.getServiceID();
		serviceName  = bean.getServiceName();
		serviceType = bean.getServiceType();
		servicePrice = bean.getServicePrice();
		serviceStatus = bean.getServiceStatus();
		
		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("INSERT INTO service(serviceID,serviceName,serviceType,servicePrice,serviceStatus)VALUES(?,?,?,?,?)");
      ps.setInt(1,serviceID);
      ps.setString(2,serviceName);
      ps.setString(3,serviceType);
      ps.setDouble(4,servicePrice);
      ps.setString(5,serviceStatus);
			
			//4. execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}	
	
	//get all services
	public static List<ServiceBean> getAllServices(){
		List<ServiceBean> services = new ArrayList<ServiceBean>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement 
			stmt = con.createStatement();
			String sql = "SELECT * FROM service ORDER BY serviceID";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				ServiceBean ser = new ServiceBean();
				serviceID = rs.getString("serviceID");
        serviceName = rs.getString("serviceName");
        serviceType = rs.getString("serviceType");
        servicePrice = rs.getDouble("servicePrice");
        serviceStatus = rs.getString("serviceStatus");
				services.add(ser);
			}
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		
			
		}
		
		
		return services;
	}
		
	//get service by id
	
	public static ServiceBean getServiceById(int serviceID) {
		ServiceBean ser = new ServiceBean();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement 
			ps = con.prepareStatement("SELECT * FROM service WHERE serviceID=?");
			ps.setInt(1, serviceID);
			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
      ser.setServiceID(rs.getString("serviceID"));
      ser.setServiceName(rs.getString("serviceName"));
      ser.setServiceType(rs.getString("serviceType"));
      ser.setServicePrice(rs.getDouble("servicePrice"));
      ser.setServiceStatus(rs.getString("serviceStatus"));	
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();	
		}			
		return ser;
	}
	
	//delete service	
	public void deleteService(int serviceID) {
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement 			
			ps = con.prepareStatement("DELETE FROM service WHERE serviceID=?");
			ps.setInt(1, serviceID);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();	
		}			
	}
	
	//update service
	
	public void updateService(ServiceBean bean) {
		
    serviceID = bean.getServiceID();
		serviceName  = bean.getServiceName();
		serviceType = bean.getServiceType();
		servicePrice = bean.getServicePrice();
		serviceStatus = bean.getServiceStatus();
		
		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("UPDATE service SET serviceName=?,serviceType=?,servicePrice=?,serviceStatus=? WHERE serviceID=?");
      ps.setInt(1,serviceID);
      ps.setString(2,serviceName);
      ps.setString(3,serviceType);
      ps.setDouble(4,servicePrice);
      ps.setString(5,serviceStatus);
			
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
