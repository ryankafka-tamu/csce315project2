import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.util.*;

/*
CSCE 315
10-10-2021
 */
public class jdbcpostgreSQLGUI {
 //  public static void main(String args[]) {
  public jdbcpostgreSQLGUI() {}
  // potential error
  static public List<String> getRecentTitles(String startDate, String endDate) {
    String cus_lname = "";
    Connection conn = null;
    conn = connect();
    Vector<String> movie = new Vector<String>();
    try{
        Statement stmt = conn.createStatement();
        //create an SQL statement
        //String sqlStatement = "SELECT titles.originaltitle FROM custumer_ratings INNER JOIN titles ON custumer_ratings.title_id= titles.titleid WHERE custumer_ratings.date >= '" + fxml.startDate + "' AND custumer_ratings.date <= '" + fxml.endDate + "' AND custumer_ratings.custumer_id = 1227322;";
        String sqlStatement = "SELECT titles.originaltitle FROM custumer_ratings INNER JOIN titles ON custumer_ratings.title_id= titles.titleid WHERE custumer_ratings.date >= \'9/1/2005\' AND custumer_ratings.date <= \'9/6/2005\' AND custumer_ratings.custumer_id = 1227322;";
        //send statement to DBMS
        ResultSet result = stmt.executeQuery(sqlStatement);
        
        while (result.next()) {
          // System.out.println(result.getString("cus_lname"));
          cus_lname = result.getString("originaltitle");
          movie.add(cus_lname);
        }
    } catch (Exception e){
      JOptionPane.showMessageDialog(null, "Error Connecting");
    }
    try {
      conn.close();
      JOptionPane.showMessageDialog(null,"Connection Closed.");
    } catch(Exception e) {
      JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
    }//end try catch
   
    return movie;
  }

  static public List<String> getTopTen(String startDate, String endDate) {
    String cus_lname = "";
    Connection conn = null;
    conn = connect();
    Vector<String> movie = new Vector<String>();
    try{
        Statement stmt = conn.createStatement();
        //create an SQL statement
        String sqlStatement = "SELECT originaltitle, startyear FROM titles WHERE startyear >= 1999 AND startyear <= 2000 ORDER BY numvotes DESC LIMIT 10;";
        //String sqlStatement = "SELECT originaltitle FROM titles WHERE startyear >= " + fxml.startDate + " AND fxml.endDate <= " + end_year + " ORDER BY numvotes DESC LIMIT 10;";
        //send statement to DBMS
        ResultSet result = stmt.executeQuery(sqlStatement);
        
        while (result.next()) {
          // System.out.println(result.getString("cus_lname"));
          cus_lname = result.getString("originaltitle");
          movie.add(cus_lname);
        }
    } catch (Exception e){
      JOptionPane.showMessageDialog(null, "Error Connecting");
    }
    try {
      conn.close();
      JOptionPane.showMessageDialog(null,"Connection Closed.");
    } catch(Exception e) {
      JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
    }//end try catch
   
    return movie;
  }
/*
  public List<String> getTopTenTitles(String startDate, String endDate) {
    String cus_lname = "";
    Statement stmt = conn.createStatement();
    //create an SQL statement
    String sqlStatement = "SELECT titles.originaltitle, titles.startyear FROM titles ORDER BY numvotes DESC LIMIT 10;";
    //send statement to DBMS
    ResultSet result = stmt.executeQuery(sqlStatement);

    //OUTPUT
    Vector<String> movie = new Vector<String>();
    while (result.next()) {
      // System.out.println(result.getString("cus_lname"));
      cus_lname += result.getString("originaltitle")+"\n";
      movie.add(cus_lname);
    }
    return movie;
  }
*/
  static private Connection connect() {
    dbSetup my = new dbSetup();
    //Building the connection
    Connection conn = null;
    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315_909_5db", my.user, my.pswd);
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }
     return conn;
  }

  private boolean disconnect(Connection conn){
    try{
      conn.close();
      JOptionPane.showMessageDialog(null,"Connection Closed.");
      return true;
    } catch(Exception e) {
      JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
      return false;
    }
  }

/*
    dbSetup my = new dbSetup();
    //Building the connection
     //Connection conn = null;
     try {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315_909_5db",
           my.user, my.pswd);
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }//end try catch
     JOptionPane.showMessageDialog(null,"Opened database successfully");
     String cus_lname = "";
     if (true) { //fxml.userButton
      try{
        //create a statement object
          Statement stmt = conn.createStatement();
          //create an SQL statement
           //String sqlStatement = "SELECT titles.originaltitle FROM custumer_ratings INNER JOIN titles ON custumer_ratings.title_id= titles.titleid WHERE custumer_ratings.date >= '" + fxml.startDate + "' AND custumer_ratings.date <= '" + fxml.endDate + "' AND custumer_ratings.custumer_id = 1227322;";
          String sqlStatement = "SELECT titles.originaltitle FROM custumer_ratings INNER JOIN titles ON custumer_ratings.title_id= titles.titleid WHERE custumer_ratings.date >= '9/1/2005' AND custumer_ratings.date <= '9/6/2005' AND custumer_ratings.custumer_id = 1227322;";
          //send statement to DBMS
          ResultSet result = stmt.executeQuery(sqlStatement);
   
          //OUTPUT
          JOptionPane.showMessageDialog(null,"Database");
          //System.out.println("______________________________________");
          Vector<String> movie = new Vector<String>();
          while (result.next()) {
            // System.out.println(result.getString("cus_lname"));
            cus_lname += result.getString("originaltitle")+"\n";
            movie.add(cus_lname);
          }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error accessing Database.");
      }
      JOptionPane.showMessageDialog(null,cus_lname);
     }

   cus_lname = "";
   // GETTING TOP 10 MOST VIEWED MOVIES
   if (MyController.button_viewhistory) {
    try{
      //create a statement object
        Statement stmt = conn.createStatement();
        //create an SQL statement
        String sqlStatement = "SELECT titles.originaltitle, titles.startyear FROM titles ORDER BY numvotes DESC LIMIT 10;";
        //send statement to DBMS
        ResultSet result = stmt.executeQuery(sqlStatement);
  
        //OUTPUT
        JOptionPane.showMessageDialog(null,"Database");
        //System.out.println("______________________________________");
        Vector<String> movie = new Vector<String>();
        while (result.next()) {
          // System.out.println(result.getString("cus_lname"));
          cus_lname += result.getString("originaltitle")+"\n";
          movie.add(cus_lname);
        }
    } catch (Exception e){
      JOptionPane.showMessageDialog(null,"Error accessing Database.");
    }
    JOptionPane.showMessageDialog(null,cus_lname);
   }
   
    //closing the connection
    try {
      conn.close();
      JOptionPane.showMessageDialog(null,"Connection Closed.");
    } catch(Exception e) {
      JOptionPane.showMessageDialog(null,"Connection NOT Closed.");
    }//end try catch
  }//end main
  */
}//end Class
