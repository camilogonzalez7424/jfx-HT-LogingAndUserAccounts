package ui;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ClassRoom;
import model.UserAccount;

public class ClassRoomGUI {

	 	@FXML
	    private Pane mainPane;
	 	
	 	 @FXML
	     private DatePicker date;

	     @FXML
	     private ToggleGroup genderGrup;
	     
	     @FXML
	     private RadioButton female;
	     
	     @FXML
	     private RadioButton other;

	     @FXML
	     private RadioButton male;

	     @FXML
	     private ToggleGroup careerGrup;
	     
	     @FXML
	     private RadioButton sis;
	     
	     @FXML
	     private RadioButton tel;

	     @FXML
	     private RadioButton ind;


	     @FXML
	     private TextField txtUserN;

	     @FXML
	     private PasswordField txtPassword;

	     @FXML
	     private ChoiceBox<String> browser;
	  
	    @FXML
	    private TableView<UserAccount> tvAccount;

	    @FXML
	    private TableColumn<UserAccount, String> tcUserName;

	    @FXML
	    private TableColumn<UserAccount, String> tcGender;

	    @FXML
	    private TableColumn<UserAccount, String> tcCareer;

	    @FXML
	    private TableColumn<UserAccount, String> tcBirthday;

	    @FXML
	    private TableColumn<UserAccount, String> tcBrowser;

	    private Image img;
	    
	    @FXML
	    private TextField txtImageURL;

	    @FXML
	    private ImageView IvUser;

	    @FXML
	    private Label LabGenericUser;

	    @FXML
	    private TextField txtLoginUser;

	    @FXML
	    private TextField txtLoginPass;
	    
	    private ClassRoom classroom;
	    
	 public ClassRoomGUI(ClassRoom cr) {
		 classroom = cr;
	 }
	 
	 public Pane getPane() {
		 return mainPane;
	 }
	 
	 @FXML
	    public void LogIn(ActionEvent event) throws IOException{
		 if(classroom.access(txtLoginUser.getText(),txtLoginPass.getText())){
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
	    	
	    	fxmlLoader.setController(this);
	    	Parent logInPane = fxmlLoader.load();
	    	
	    	LabGenericUser.setText(txtLoginUser.getText());
	    	mainPane.getChildren().setAll(logInPane);	    	
	    	initializeTableView();
	    	}
		 }
	    
	 
	 @FXML
	    public void SignUp(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("register.fxml"));
		fxmlLoader1.setController(this);
	    Parent signUpPane = fxmlLoader1.load();
	    	    	
	    mainPane.getChildren().setAll(signUpPane);
	
	     browser.setItems(FXCollections.observableArrayList("Chrome","Firefox","Brave","Opera","Edge"));
	     
	   }
	 
	 @FXML
	    public void LogOut(ActionEvent event) throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
			fxmlLoader.setController(this);
		    Parent logInPane = fxmlLoader.load();
		    	    	
		    mainPane.getChildren().setAll(logInPane);
		 
	    }
	 @FXML
	    public void SignIn(ActionEvent event) throws IOException{
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
			fxmlLoader.setController(this);
		    Parent logInPane = fxmlLoader.load();
		    	    	
		    mainPane.getChildren().setAll(logInPane);
	    }
	 
	 @FXML
	    public void createAccount(ActionEvent event) throws IOException  {
		 String user,pass,gender,career,bDay,newBrowser;
		 
		 user = txtUserN.getText();
		 pass = txtPassword.getText();
		 gender = "";
		 career = "";
		 
		 if(male.isSelected()) {
			 gender = "Male";
		 }else if(female.isSelected()) {
			 gender = "Female";
		 }else if(other.isSelected()) {
			 gender = "Other";
		 }
		 
		 if(sis.isSelected()) {
			 career = "Software Engineering";
		 }else if(tel.isSelected()) {
			 career = "Telematic Engineering";
		 }else if(ind.isSelected()) {
			 career = "Industrial Engineering";
		 }
		 
		 if(date.getValue()!=null){
			 bDay = date.getValue().toString();
		 }else {
			 bDay = "";
		 }
		 
		 if(browser.getValue()!=null) {
			 newBrowser = browser.getValue();
		 }else {
			 newBrowser = "";
		 }
		 
		 
		 if(user.equals("") || pass.equals("") || gender.equals("") || career.equals("") || bDay.equals("") || browser.equals("")){

	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Warning");
	            alert.setHeaderText("Look");
	            alert.setContentText("Please fill all the blanks");
	            alert.showAndWait();

	        }else {
	    		classroom.addAccount(user,pass,gender,career,bDay,newBrowser,img);
	        	//System.out.println(pass);
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setTitle("Done");
	            alert.setHeaderText("New User");
	            alert.setContentText("The new account has been created!");
	            alert.showAndWait();

	        }

		 SignUp(event);
		 
	    }
		 	 
	 public void initializeTableView() {
	 ObservableList<UserAccount> observableList;
	   	observableList = FXCollections.observableArrayList(classroom.getAccounts());
	   	
	   	tvAccount.setItems(observableList);
		tcUserName.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("userName")); //the tableview search for a method called getName
		tcGender.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender"));
		tcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("career"));
	   	tcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("birthday"));
	   	tcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("browser"));
	   	IvUser.setImage(classroom.searchImage(txtLoginUser.getText()));
	   	
	 }
	 
	 @FXML
	   public void fileBrowser(ActionEvent event) {
		 FileChooser fileChooser = new FileChooser();
	        fileChooser.setTitle("Select a image");
	        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
	        Stage primaryStage = (Stage)mainPane.getScene().getWindow();
	        File fileToSave = fileChooser.showOpenDialog(primaryStage);
	        img = new Image(fileToSave.toURI().toString());


	        if(img != null){
	            txtImageURL.setText(fileToSave.getPath().toString());

	        }else{
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("ERROR");
	            alert.setHeaderText("Error, Look");
	            alert.setContentText("Not found");
	            alert.showAndWait();
	            txtImageURL.setText("");
	        }
	    }

}
