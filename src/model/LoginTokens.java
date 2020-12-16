package model;

public class LoginTokens{

	private String email;
	private String password;
	private String usersessionid;
	
	
	
	public LoginTokens() {
		String text = GenerateUserSessionID();
		System.out.println(text);
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsersessionid() {
		return usersessionid;
	}
	
	public void setUsersessionid(String usersessionid) {
		this.usersessionid = usersessionid;
	}
	
	private String GenerateUserSessionID() {
		String generatedsession = "";
		//Generación de la longitud (8-64)
		int length = (int)(Math.random()*( 64 - 8 + 1)+ 8);
		//Generación de la cadena (A-Z a-z 0-9 Caracteres especiales)
		for (int i = 0; i < length; i++) {
			int character = (int)(Math.random()*( 122 - 35 + 1)+ 35);
			generatedsession = generatedsession + Character.toString((char) character);
		}
		
		return generatedsession;
		
	}
}