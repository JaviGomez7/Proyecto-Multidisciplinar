package model;

public final class Message {
	
	private int code;	
	private Object payload;	
	
	//Constructor
	public Message() {
		this.code = -1;
		this.payload = null;
	}
	
	//Constructor parametrizado	
	public Message(int code, Object payload) {
		this.code = code;
		this.payload = payload;
	}

	// Getters y Setters
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
}