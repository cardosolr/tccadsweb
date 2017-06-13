/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Larissa
 */
public class DAOGenerica {
    
        private DAOGenerica instance;
	private static Connection conn;
        private static final String USER = "postgres";
	private static final String PASSW = "root";
	private static final String URL = "jdbc:postgresql://localhost:5432/sys_food";
	
	public DAOGenerica(){}

	public DAOGenerica getInstance() {	
			
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSW);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			 e.printStackTrace();
		 }
		
		return instance;
	}

	public void setInstance(DAOGenerica instance) {
		this.instance = instance;
	}

	public static Connection getConn() {
		
		if(conn == null){		
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(URL,USER,PASSW);		
				System.out.println("Conexão Estabelecida");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				 e.printStackTrace();
			 }
		}
			return conn;
	}

	public static void setConn(Connection conn) {
		DAOGenerica.conn = conn;
	}

    
}
