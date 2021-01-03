import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {


    private Connection connect() {

        String url = "jdbc:sqlite:MtgCards.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    public void selectAllCards(){
        String sql = "SELECT id, name FROM cards";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try
        {
          if(connect() != null)
            connect().close();
        }
        catch(SQLException e)
        {
          // connection close failed.
          System.err.println(e.getMessage());
        }
    }

    public void selectAllCreatureCards(){
        String sql = "SELECT name, colors FROM cards WHERE types = 'Creature'";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                System.out.println(rs.getString("name") + "\t"
                +
                                   rs.getString("colors"));
              
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try
        {
          if(connect() != null)
            connect().close();
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
    }

    public void getCardColor(String colors){
               String sql = "SELECT id, name, own, colors FROM cards WHERE colors = ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1, colors);
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getInt("own") + "\t" +
                                   rs.getString("colors"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}