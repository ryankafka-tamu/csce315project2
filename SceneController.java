/*
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.Layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.ToolBar;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.ToolBar;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.Vbox;

import java.text.ParseException;
import java.text.SimpleDataFormat;
import java.util.Date;
import java.util.List;


package application;

public class SceneController {
private Stage stage;
private Scene Scene;
private Parent root;

public void switchToScene1(ActionEvent event) {
    Parent root = FXMLLoader.Load(getClass().getResource("Scene1.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
} 
public void switchToScene2(ActionEvent event) {
    Parent root = FXMLLoader.Load(getClass().getResource("Scene2.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
}
*/



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;

public class SceneController {

    @FXML
    private Label Scene_title;

    @FXML
    private Menu admin;

    @FXML
    private Button button_home;

    @FXML
    private Button button_next;

    @FXML
    private Button button_previous;

    @FXML
    private Button button_viewhistory;

    @FXML
    private TextField end_date;

    @FXML
    private Label movie1;

    @FXML
    private Label movie10;

    @FXML
    private Label movie2;

    @FXML
    private Label movie3;

    @FXML
    private Label movie4;

    @FXML
    private Label movie5;

    @FXML
    private Label movie6;

    @FXML
    private Label movie7;

    @FXML
    private Label movie8;

    @FXML
    private Label movie9;

    @FXML
    private TextField search_bar;

    @FXML
    private Menu sort_by;

    @FXML
    private TextField start_date;

}