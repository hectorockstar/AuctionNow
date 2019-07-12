package com.auctionnow.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion {

	public static Connection getConexion(){
		Connection connection = null;
		try {
			String driverClassName = "org.postgresql.Driver";
			String driverUrl = "jdbc:postgresql://localhost:5432/auctionnowdatabase";
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(driverUrl, "postgres", "system");
		} catch (SQLException e ) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return connection;
	}
}
