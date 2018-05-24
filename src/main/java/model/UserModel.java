package model;
public class UserModel {
	private int idUser;
	private String nameUser;
	private String password;
	private String email;
	private int role;
	public UserModel(int idUser, String nameUser, String password, String email, int role) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public UserModel() {
		super();
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
