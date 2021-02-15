package ui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ClassRoom;

public class Main extends Application{
	
	private ClassRoomGUI classroomgui;
	private ClassRoom classroom;

	public Main() {
		classroom = new ClassRoom();
		classroomgui = new ClassRoomGUI(classroom);
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("main-pane.fxml"));
		
		fxmlLoader.setController(classroomgui);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ClassRoom");
		primaryStage.show();
		
		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader1.setController(classroomgui);
		Parent loginPane = fxmlLoader1.load();
		
		classroomgui.getPane().getChildren().setAll(loginPane);
		
	}
}
