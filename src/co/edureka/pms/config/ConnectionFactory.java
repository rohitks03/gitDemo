package co.edureka.pms.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionFactory {
 private static Connection con = null;
 
 public static Connection getConnection() throws Exception{
   if(con == null) {
	   ResourceBundle bundle = ResourceBundle.getBundle("co/edureka/pms/config/dbConfig");
	   
	   String driverClass = bundle.getString("jdbc.driver-class");
	   String url = bundle.getString("jdbc.url");
	   String userName = bundle.getString("jdbc.username");
	   String pwd = bundle.getString("jdbc.password");
	   
	   Class.forName(driverClass);
	   con = DriverManager.getConnection(url,userName, pwd);
   }
   return con;	 
 }
}
