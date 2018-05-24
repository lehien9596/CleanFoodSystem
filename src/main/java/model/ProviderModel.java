package model;
public class ProviderModel {
private int idProvider;
private String nameProvider;
private String address;
private String phone;
public ProviderModel(int providerId, String providerName, String address, String phone) {
	super();
	this.idProvider = providerId;
	this.nameProvider = providerName;
	this.address = address;
	this.phone = phone;
}
public ProviderModel() {
	super();
}

public int getIdProvider() {
	return idProvider;
}
public void setIdProvider(int idProvider) {
	this.idProvider = idProvider;
}
public String getNameProvider() {
	return nameProvider;
}
public void setNameProvider(String nameProvider) {
	this.nameProvider = nameProvider;
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
