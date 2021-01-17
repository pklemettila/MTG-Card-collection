import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Database {

    private Connection connect() {

        String url = "jdbc:sqlite:MtgCards.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public double getPrice(int id) {

        double price = 0;
        String sql = "SELECT price FROM cards WHERE id = ?";
        try (Connection connection = this.connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, id);
            ResultSet rs = pstmt.executeQuery();
            price = rs.getDouble("price");
            return price;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return price;
        }
    }

    public int searchOwnedById(int id) {

        int amount = 0;
        String sql = "SELECT own FROM cards WHERE id = ?";
        try (Connection connection = this.connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            amount = rs.getInt("own");
            return amount;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return amount;
        }
    }

    public String searchCardsById(int id) {

        String name = "";
        String sql = "SELECT name FROM cards WHERE id = ?";
        try (Connection connection = this.connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            name = rs.getString("name");
            return name;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return name;
    }

    public void updatePrice(double price, String rarity, String artist) {

        String sql = "UPDATE cards SET price = ? " + "WHERE rarity = ?" + "AND artist = ?";
        try (Connection connection = this.connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, price);
            pstmt.setString(2, rarity);
            pstmt.setString(3, artist);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void substractFromOwned(int id) {

        String sql = "UPDATE cards SET own = own - 1 " + "WHERE id = ?";
        try (Connection connection = this.connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addToOwned(int id) {

        String sql = "UPDATE cards SET own = own + 1 " + "WHERE id = ?";
        try (Connection connection = this.connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Searches the database for cards matching the user defined criteria. Searches
     * the database for cards that match these criteria. Returns the ids of those
     * cards that match the criteria. Limits matches to 32.
     */
    public ArrayList<Integer> searchAll(boolean filterW, boolean filterU, boolean filterB, boolean filterR,
            boolean filterG, boolean filterC, boolean filterM, boolean filterCommon, boolean filterUncommon,
            boolean filterRare, boolean filterMythic, boolean priceLow, double priceMin, boolean priceHigh,
            double priceMax, boolean owned, boolean cardTypeSelected, String cardType, boolean searchField,
            boolean searchByName, boolean searchByArtist, boolean searchByKeyword, String search) {

        ArrayList<Integer> filteredCardsArrayList = new ArrayList<>();
        // Creates an sql query based on the user defined filters.
        String sql = "SELECT id FROM cards WHERE 1=1";
        // Filters the search results by color
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
        // Filters the search results according to rarity
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
        // Filters by price
        if (priceLow || priceHigh) {
            ArrayList<String> orPriceStatement = new ArrayList<String>();
            if (priceLow) {
                orPriceStatement.add("price > " + priceMin);
            }
            if (priceHigh) {
                orPriceStatement.add("price < " + priceMax);
            }
            sql += " AND ( " + String.join(" AND ", orPriceStatement) + ")";
        }
        // Filters based on whether the user owns cards
        if (owned) {
            sql += " AND own > 0";
        }
        // Filters based on Card Type
        if (cardTypeSelected) {
            sql += " AND types = '" + cardType + "'";
        }
        // Filters based on the search bar user input
        if (searchField) {
            ArrayList<String> searchByArrayList = new ArrayList<String>();
            if (!searchByName && !searchByArtist && !searchByKeyword) {
                searchByArrayList.add("name LIKE '%" + search + "%'");
                searchByArrayList.add("artist LIKE '%" + search + "%'");
                searchByArrayList.add("keywords LIKE '%" + search + "%'");
            }
            if (searchByName) {
                searchByArrayList.add("name LIKE '%" + search + "%'");
            }
            if (searchByArtist) {
                searchByArrayList.add("artist LIKE '%" + search + "%'");
            }
            if (searchByKeyword) {
                searchByArrayList.add("keywords LIKE '%" + search + "%'");
            }
            sql += " AND ( " + String.join(" OR ", searchByArrayList) + ")";
        }
        // Limits results into 32
        sql += " LIMIT 32";
        try (Connection connection = this.connect();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                filteredCardsArrayList.add(rs.getInt("id"));
            }
            return filteredCardsArrayList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (connect() != null)
                connect().close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}