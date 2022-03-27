package fr.doranco.ecommerce.enums;

public enum EnumProfile {

	Administrator("admin"),
	Storekeeper("storekeeper"),
	Customer("customer");
	
	private String profile;
	
	private EnumProfile(String profile) {
		this.profile = profile;
	}
	
	public String getProfile() {
		return profile;
	}
}
