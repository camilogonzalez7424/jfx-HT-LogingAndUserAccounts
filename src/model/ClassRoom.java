package model;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class ClassRoom {
	
	//Attributes.
	
	 private  ArrayList<UserAccount> accounts;

	    public ClassRoom(){
	        accounts = new ArrayList<UserAccount>();
	    }

	    public void addAccount(String userName, String password, String gender, String career, String birthday, String browser,Image profile) {
	    	accounts.add(new UserAccount(userName,password,gender,career,birthday,browser,profile));

	    }
	    

	    public ArrayList<UserAccount>getAccounts(){
	        return  accounts;

	    }
	    
	    
	    public boolean access(String userName , String password){
	        boolean out = false;
	        for (int i = 0; i <accounts.size() && out !=true; i++) {
	            if ((accounts.get(i).getUserName()).equals(userName) && (accounts.get(i).getPassword()).equals(password)) {
	                out = true;

	            }
	        }
	        return out;
	    }
	    
	    public Image searchImage(String userName){
	        boolean out=false;
	        Image img = null;
	        for (int i = 0; i <accounts.size() && !out ; i++) {
	            if((accounts.get(i).getUserName()).equals(userName)){
	               img = (accounts.get(i).getProfile());
	                out=true;
	            }
	        }
	        return img;
	    }

}
