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

    @FXML Label movie1;
    @FXML Label movie2;
    @FXML Label movie3;
    @FXML Label movie4;
    @FXML Label movie5;
    @FXML Label movie6;
    @FXML Label movie7;
    @FXML Label movie8;
    @FXML Label movie9;
    @FXML Label movie10;
    List<String> movies_on_display = new Vector<String>();
    // (movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10);
    movies_on_display.add(movie1.getText());
        // movies_on_display.add(movie2);
        // movies_on_display.add(movie3);
        // movies_on_display.add(movie4);
        // movies_on_display.add(movie5);
        // movies_on_display.add(movie6);
        // movies_on_display.add(movie7);
        // movies_on_display.add(movie8);
        // movies_on_display.add(movie9);
        // movies_on_display.add(movie10);

    // @FXML
    // private TextField search_bar;

    // @FXML
    // private Menu sort_by;

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


            
        // for (int i = 0; i < movies.size(); ) {
        //     if(i+1)
        //     movie1.setText(movies.get(i));
        //     movie2.setText(movies.get(1));
        //     movie3.setText(movies.get(2));
        //     movie4.setText(movies.get(3));
        //     movie5.setText(movies.get(4));
        //     movie6.setText(movies.get(5));
        //     movie7.setText(movies.get(6));
        //     movie8.setText(movies.get(7));
        //     movie9.setText(movies.get(8));
        //     movie10.setText("");
        // }

        movie1.setText(movies.get(0));
        movie1.setText(movies.get(0));
        movie2.setText(movies.get(1));
        movie3.setText(movies.get(2));
        movie4.setText(movies.get(3));
        movie5.setText(movies.get(4));
        movie6.setText(movies.get(5));
        movie7.setText(movies.get(6));
        movie8.setText(movies.get(7));
        movie9.setText(movies.get(8));
        movie10.setText("");
        // CANT FIND LOOP THAT WORKS
        for(int i = 0; i < movies.size() && i < 10; i++) {
            movies_on_display.get(i).setText("");
        }
        // for(int i = 0; i < movies.size() && i < 10; i++) {
        //     movies_on_display[i].setText(movies.get(i));
        // }
        
        //  DEBUG Code:  prints movies returned from database
        //
        // for (int i = 0; i < movies.size(); i++) {
        //     System.out.print(movies.get(i));
        //     if(i < movies.size()-1)
        //         System.out.print(",  ");
        //     if(i % 3 == 0 && i != 0)
        //         System.out.println();
        // }
        // System.out.println();


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

