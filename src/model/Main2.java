package model;

import model.DataManager;
import model.Model;
import model.User;

public class Main2 {
	public static void main (String[] args) {
		Model model = new Model();
		DataManager dm = new DataManager(model);
		
		User user = new User("Juan", "Lopez", "jlopez@hogwarts.edu", "12345678", 21, "Gryffindor", false);
		
		
		int rowCount = dm.insertUser(user);		// Inserta un usuario
		if(rowCount > 0) {
			System.out.println("Registro de alumno creado exitosamente");
		} else {
			System.out.println("No se ha podido insertar el registro de alumno");
		}
		
		
		user = dm.searchUser("jlopez@hogwarts.edu", "123456"); 	// Busca un usuario
		if (user == null) {
			System.out.println("No se ha encontrado el usuario buscado");
		} else {
			System.out.println(user);
		}
		
	}

}