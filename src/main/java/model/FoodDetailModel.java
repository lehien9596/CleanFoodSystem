package model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import config.ConfigProject;
import utils.Utils;

public class FoodDetailModel {
	@SerializedName("idFootDetail")
	private int idFootDetail;
	
	@SerializedName("nameFoodDetail")
	private String nameFoodDetail;
	
	@SerializedName("note")
	private String note;
	
	@SerializedName("number")
	private int number;
	
	@SerializedName("codeQR")
	private String codeQR;
	
	@SerializedName("idProvider")
	private int idProvider;
	
	@SerializedName("idManage")
	private int idManage;
	
	@SerializedName("idMarket")
	private int idMarket;
	
	@SerializedName("idFood")
	private int idFood;
	
	@SerializedName("image")
	private String image;
	
	//@SerializedName("base64String")
	//private String base64String;
	
	
	public FoodDetailModel(int idFootDetail, String nameFoodDetail, String note, int number, String codeQR,
			int idProvider, int idManage, int idMarket, int idFood, String image) {
		super();
		this.idFootDetail = idFootDetail;
		this.nameFoodDetail = nameFoodDetail;
		this.note = note;
		this.number = number;
		this.codeQR = codeQR;
		this.idProvider = idProvider;
		this.idManage = idManage;
		this.idMarket = idMarket;
		this.idFood = idFood;
		this.image = image;
		
		//String path =ConfigProject.ROOT_DIR+image;
		//this.base64String = Utils.imgToBase64String(Utils.readFileImage(path), "jpg");
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
		//String path = ConfigProject.ROOT_DIR+image;
		//this.base64String = Utils.imgToBase64String(Utils.readFileImage(path), "jpg");
	}

	public int getIdMarket() {
		return idMarket;
	}

	public void setIdMarket(int idMarket) {
		this.idMarket = idMarket;
	}

	public int getIdFood() {
		return idFood;
	}

	public void setIdFood(int idFood) {
		this.idFood = idFood;
	}

	public FoodDetailModel() {
		super();
	}

	public int getIdFootDetail() {
		return idFootDetail;
	}

	public void setIdFootDetail(int idFootDetail) {
		this.idFootDetail = idFootDetail;
	}

	public String getNameFoodDetail() {
		return nameFoodDetail;
	}

	public void setNameFoodDetail(String nameFootDetail) {
		this.nameFoodDetail = nameFootDetail;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCodeQR() {
		return codeQR;
	}

	public void setCodeQR(String codeQR) {
		this.codeQR = codeQR;
	}

	public int getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	public int getIdManage() {
		return idManage;
	}

	public void setIdManage(int idManage) {
		this.idManage = idManage;
	}

	public String getInfo() {
		return "id: " + idFootDetail + "\n" + "ten:" + nameFoodDetail + "\n ghi chú:" + note + 
				"\n So luong" + number + "\n Ma nha cung cap:"+ idProvider + "\n Ma nha quan li:" + idManage + "\n link anh: "+ image;
		//return new Gson().toJson(this);
	}
}
