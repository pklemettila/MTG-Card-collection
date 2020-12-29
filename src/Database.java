    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;

    public class Database
    {
      public Database()
      {
        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);

          statement.executeUpdate("drop table if exists card");
          statement.executeUpdate("create table card (id integer, name string, price double, keyword string, artist string, rarity string, color string, own int)");
          statement.executeUpdate("insert into card values(1, 'smell of god', 0.7, 'haste', 'Pauli', 'mythic rare', 'blue', 3)");
          statement.executeUpdate("insert into card values(2, 'well of god', 1.0, 'flying', 'Pauli', 'rare', 'red', 0)");
          ResultSet rs = statement.executeQuery("select * from card");
          while(rs.next())
          {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
            System.out.println("price = " + rs.getInt("price"));
          }
        }
        catch(SQLException e)
        {

          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
      }
    }