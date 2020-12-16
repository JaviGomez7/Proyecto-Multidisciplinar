package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {
	private Model model;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement prepStmt;
	
	
	public DataManager(Model model2) {
		this.model = model2;
	}
	
	private void connect() {
		String driver = model.getDbParameters().get(0);
		String url = model.getDbParameters().get(1);
		String user = model.getDbParameters().get(2);
		String password = model.getDbParameters().get(3);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt  = conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Error de driver de MySQL");
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexión con MySQL");
		}
	}
	
	private void disconnect() {
		try {
			if(stmt != null) stmt.close();
			if(prepStmt != null) prepStmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido un error al cerrar la conexión con MySQL");
		}
	}
	
	public int insertUser(User user) {
		int rowCount = 0;
		String sql = model.getQueries().get(0);
		prepStmt = null;
		try {
			connect();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, user.getFirstName());
			prepStmt.setString(2, user.getLastName());
			prepStmt.setString(3, user.getEmail());
			prepStmt.setString(4, user.getPassword());
			prepStmt.setInt(5, user.getAge());
			prepStmt.setString(6, user.getHouse());
			if(user.isProfessor())
				prepStmt.setInt(7, 1);
			else
				prepStmt.setInt(7, 0);
			
			rowCount = prepStmt.executeUpdate();
			disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public User searchUser(String email, String password) {
		User user = null;
		String sql = model.getQueries().get(1);
		prepStmt = null;
		try {
			connect();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, email);
			prepStmt.setString(2, password);
			ResultSet rs = prepStmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setAge(rs.getInt(5));
				user.setHouse(rs.getString(6));
				if(rs.getInt(7) == 1)
					user.setProfessor(true);
				else
					user.setProfessor(false);
			}
			disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}