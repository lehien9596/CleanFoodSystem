package model;
public class FoodModel {
private int idFood;
private String nameFoot;
private String note;

public FoodModel() {
	super();
}
public FoodModel(int idFood, String nameFoot, String note) {
	super();
	this.idFood = idFood;
	this.nameFoot = nameFoot;
	this.note = note;
}
public int getIdFood() {
	return idFood;
}
public void setIdFood(int idFood) {
	this.idFood = idFood;
}
public String getNameFoot() {
	return nameFoot;
}
public void setNameFoot(String nameFoot) {
	this.nameFoot = nameFoot;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}

}
