import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private final String url = "jdbc:postgresql://localhost:5432/jdbc";
    private final String username = "root";
    private final String password = "root";

    private DatabaseConnection() throws SQLException {

        try {
            // It is used to load the database specific Driver . Only then we can use JDBC operations.
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if(instance==null){
            instance = new DatabaseConnection();
        } else if(instance.getConnection().isClosed()){
            instance= new DatabaseConnection();
        }
        return instance;
    }

}
