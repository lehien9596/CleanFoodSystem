package model;
public class ManageModel {
	private int idManage;
	private String nameManage;
	private String address;
	private String phone;
	public ManageModel(int idManage, String nameManage, String address, String phone) {
		super();
		this.idManage = idManage;
		this.nameManage = nameManage;
		this.address = address;
		this.phone = phone;
	}
	public ManageModel() {
		super();
	}
	public int getIdManage() {
		return idManage;
	}
	public void setIdManage(int idManage) {
		this.idManage = idManage;
	}
	public String getNameManage() {
		return nameManage;
	}
	public void setNameManage(String nameManage) {
		this.nameManage = nameManage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
