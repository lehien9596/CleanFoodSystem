package model;

import com.google.gson.annotations.SerializedName;

public class GetLinkImageResponse {
	@SerializedName("data")
	private Data data;
	
	@SerializedName("success")
	private boolean success;
	
	public boolean isSuccess() {
		return success;
	}
	
	public Data getData() {
		return data;
	}
	
	public static class Data{
		@SerializedName("link")
		private String link;
		
		public String getLink() {
			return link;
		}
	}
}
