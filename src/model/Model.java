package model;

import java.util.ArrayList;
public class Model {
	/**
	 * Parámetros de configuracion a MySQL
	 */
	private ArrayList<String> dbParameters;
	
	/**
	 * Queries de manipulacion de datos
	 */
	private ArrayList<String> queries;
	
	/**
	 * Constructor por defecto
	 */
	public Model() {
		dbParameters = new ArrayList<String>();
		dbParameters.add("com.mysql.jdbc.Driver");					// 0: MySQL driver
		dbParameters.add("jdbc:mysql://localhost/hogwarts");		// 1: MySQL url
		dbParameters.add("root");									// 2: MySQL user
		dbParameters.add("");										// 3: MySQL password
		
		queries = new ArrayList<String>();
		queries.add("INSERT INTO users "
				+ "(first_name, last_name, email, password, age, house, user_type, create_date, last_modified) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW());");	// 0: Insertar nuevo usuario
		
		
		queries.add("SELECT first_name, last_name, email, password, age, house, user_type "
				+ "FROM users "
				+ "WHERE email = ? "
				+ "AND password = ?");								// 1: Buscar usuario por email y password
		
	}

	
	// Getters
	public ArrayList<String> getDbParameters() {
		return dbParameters;
	}

	public ArrayList<String> getQueries() {
		return queries;
	}
	
	

}