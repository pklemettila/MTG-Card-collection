import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import java.util.*;

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

    public void selectAllCards() {
        String sql = "SELECT id, name FROM cards";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (connect() != null)
                connect().close();
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    public void selectAllCreatureCards() {
        String sql = "SELECT name, colors FROM cards WHERE types = 'Creature'";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("name") + "\t" + rs.getString("colors"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (connect() != null)
                connect().close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void getCardColor(String colors) {
        String sql = "SELECT id, name, own, colors FROM cards WHERE colors = ?";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, colors);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("own") + "\t"
                        + rs.getString("colors"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getArtist(String artist) {
        String sql = "SELECT id, name, own, artist FROM cards WHERE artist = ?";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, artist);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("own") + "\t"
                        + rs.getString("artist"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getPrice(int id) {
        double price = 0;
        String sql = "SELECT price FROM cards WHERE id = ?";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setDouble(1, id);
            ResultSet rs = pstmt.executeQuery();
            price = rs.getDouble("price");
            return price;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return price;
        }
    }

    public int getOwnedCards(int id) {
        int own = 0;
        String sql = "SELECT own FROM cards WHERE id = ?";


        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
                own = rs.getInt("own");
                return own;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return own;
        }
    }

    public int searchOwnedById(int id) {
        int amount = 0;
        String sql = "SELECT own FROM cards WHERE id = ?";
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            amount = rs.getInt("own");
            return amount;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return amount;
        }

    }

    public void updatePrice(double price, String rarity, String artist) {
        String sql = "UPDATE cards SET price = ? " + "WHERE rarity = ?" + "AND artist = ?";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setDouble(1, price);
            pstmt.setString(2, rarity);
            pstmt.setString(3, artist);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void substractFromOwned(int id) {
        String sql = "UPDATE cards SET own = own - 1 " + "WHERE id = ?";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addToOwned(int id) {
        String sql = "UPDATE cards SET own = own + 1 " + "WHERE id = ?";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchAll(boolean filterW, boolean filterU, boolean filterB, boolean filterR, boolean filterG,
            boolean filterC, boolean filterM, boolean filterCommon, boolean filterUncommon, boolean filterRare,
            boolean filterMythic, boolean priceLow, double priceMin, boolean priceHigh, double priceMax ) {

        String sql = "SELECT name, colors, rarity FROM cards WHERE 1=1";

        if (filterW || filterU || filterB || filterR || filterG || filterC || filterM) {
            ArrayList<String> orColorStatement = new ArrayList<String>();

            if (filterW) {
                orColorStatement.add("colors LIKE '%W%'");
            }
            if (filterU) {
                orColorStatement.add("colors LIKE '%U%'");
            }
            if (filterB) {
                orColorStatement.add("colors LIKE '%B%'");
            }
            if (filterR) {
                orColorStatement.add("colors LIKE '%R%'");
            }
            if (filterG) {
                orColorStatement.add("colors LIKE '%G%'");
            }
            if (filterC) {
                orColorStatement.add("colors IS NULL");
            }
            if (filterM) {
                orColorStatement.add("colors LIKE '%,%'");
            }

            sql += " AND ( " + String.join(" OR ", orColorStatement) + ")"; 
        }

        if (filterCommon || filterUncommon || filterRare || filterMythic) {
            ArrayList<String> orRarityStatement = new ArrayList<String>();

        if (filterCommon) {
            orRarityStatement.add("rarity = 'common'");
        }
        if (filterUncommon) {
            orRarityStatement.add("rarity = 'uncommon'");
        }
        if (filterRare) {
            orRarityStatement.add("rarity = 'rare'");
        }
        if (filterMythic) {
            orRarityStatement.add("rarity = 'mythic'");
        }
        sql += " AND ( " + String.join(" OR ", orRarityStatement) + ")"; 

    }

    if (priceLow) {

     sql += " AND price < ?";
    
    }
     //double priceMin, 
    
    // boolean priceHigh, double priceMax
    /*
    
    try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // set the corresponding param
        pstmt.setInt(1, id);
        // update
        pstmt.executeUpdate();
    }
*/
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("name") + "\t" + rs.getString("colors"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (connect() != null)
                connect().close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}