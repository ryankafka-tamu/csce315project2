
import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class App extends Application {
    
    public static void main(String[] args) throws Exception{
        Application.launch(args);    
    } 
    // EventHandler<ActionEvent> event = new EventHandler<ActionEvent>{}
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // jdbcpostgreSQLGUI sqlcontroller = new jdbcpostgreSQLGUI();
        // MyController ctrl = new MyController();
        Parent root = FXMLLoader.load(getClass().getResource("GUI_interface2.fxml"));
        // EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        //     public void handle(ActionEvent e) {
        //         sqlcontroller.getRecentTitles(ctrl.start_date.getText(), ctrl.end_date.getText());
        //     }
        // };
        // MyController.button_viewhistory.setOnAction(e -> jdbcpostgreSQLGUI.getRecentTitles(MyController.start_date.getText(), MyController.end_date.getText()));  
        //ctrl.button_viewhistory.setOnAction(event);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        
        primaryStage.show();
         
        //jdbcpostgreSQLGUI.getRecentTitles(MyController.start_date.getText(), MyController.end_date.getText());
        //jdbcpostgreSQLGUI.getRecentTitles(MyController.start_date.getText(), MyController.end_date.getText());

        // VBox mainVBox = (VBox) FXMLLoader.load(App.class.getResource("GUI_interface2.fxml"));
        // primaryStage.setScene(new Scene(mainVBox));
        // primaryStage.show();

        // primaryStage.setTitle("HBox Experiment 1");

        // Button button1 = new Button("Analyst");
        // Button button2 = new Button("Viewer");


        // HBox hbox = new HBox(button1, button2);
        // hbox.setAlignment(Pos.TOP_RIGHT);

        // Scene scene = new Scene(hbox, 200, 100);
        // primaryStage.setScene(scene);
        // primaryStage.show();
    }
}





