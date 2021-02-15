package model;

import javafx.scene.image.Image;

public class UserAccount {
	
	//Attribute.
	
	private String userName;
	private String password;
	private String gender;
	private String career;
	private String birthday;
	private String browser;
	private Image profile;
	
	public UserAccount(String userName, String password, String gender, String career, String birthday, String browser,Image profile) {
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.browser = browser;
		this.profile = profile;
	}
	
	
	
	//Getters
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getCareer() {
		return career;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public String getBrowser() {
		return browser;
	}
	
	public Image getProfile() {
		return profile;
	}
	
	public void setProfile(Image newProfile) {
		profile = newProfile;
	}
	
}
