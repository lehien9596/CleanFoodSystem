package model;
public class MarketModel {
private int idMarket;
private String nameMarket;
private String address;
private String phone;
public MarketModel(int idMarket, String nameMarket, String address, String phone) {
	super();
	this.idMarket = idMarket;
	this.nameMarket = nameMarket;
	this.address = address;
	this.phone = phone;
}
public MarketModel() {
	super();
}
public int getIdMarket() {
	return idMarket;
}
public void setIdMarket(int idMarket) {
	this.idMarket = idMarket;
}
public String getNameMarket() {
	return nameMarket;
}
public void setNameMarket(String nameMarket) {
	this.nameMarket = nameMarket;
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
