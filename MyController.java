import java.util.List;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;

public class MyController {

    // @FXML
    // private Label Scene_title;

    // @FXML
    // private Menu admin;

    // @FXML
    // private Button button_home;

    // @FXML
    // private Button button_next;

    // @FXML
    // private Button button_previous;

    // @FXML
    // static public Button button_viewhistory;

    // @FXML
    // static public TextField end_date;

    // @FXML
    // private Label movie1;

    // @FXML
    // private Label movie10;

    // @FXML
    // private Label movie2;

    // @FXML
    // private Label movie3;

    // @FXML
    // private Label movie4;

    // @FXML
    // private Label movie5;

    // @FXML
    // private Label movie6;

    // @FXML
    // private Label movie7;

    // @FXML
    // private Label movie8;

    // @FXML
    // private Label movie9;

    // @FXML
    // private TextField search_bar;

    // @FXML
    // private Menu sort_by;

    // @FXML
    // static public TextField start_date;

    @FXML TextField start_date_input;
    @FXML TextField end_date_input;

    /** 
     * 
     */
    @FXML protected void viewHistory(ActionEvent event) {
        System.out.println();
        System.out.println("Fetching movie history from " + start_date_input.getText() + " to " + end_date_input.getText() + " ..."); // DEBUG
        String start_date = start_date_input.getText();
        String end_date = end_date_input.getText();

        jdbcpostgreSQLGUI sqlcontroller = new jdbcpostgreSQLGUI();
        List<String> movies = sqlcontroller.getRecentTitles(start_date, end_date);
        for (int i = 0; i < movies.size(); i++) {
            System.out.print(movies.get(i));
            if(i < movies.size()-1)
                System.out.print(",  ");
            if(i % 3 == 0 && i != 0)
                System.out.println();
        }
        System.out.println();
    }
    

    // NEED TO FIX + IMPLEMENT
    // no analyst mode atm to test this
    /**
     * 
     */
    @FXML protected void viewTopTen(ActionEvent event) {
        System.out.println();
        System.out.println("Fetching top 10 movies from " + start_date_input.getText() + " to " + end_date_input.getText() + " ..."); // DEBUG
        String start_date = start_date_input.getText();
        String end_date = end_date_input.getText();

        jdbcpostgreSQLGUI sqlcontroller = new jdbcpostgreSQLGUI();
        List<String> movies = sqlcontroller.getTopTen(start_date, end_date);
        for (int i = 0; i < movies.size(); i++) {
            System.out.print(movies.get(i));
            if(i < movies.size()-1)
                System.out.print(",  ");
            if(i % 3 == 0 && i != 0)
                System.out.println();
        }
        System.out.println();
    }
}

