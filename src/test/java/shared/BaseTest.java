package shared;

import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BaseTest {

    protected Connection con = null;
    protected Statement stmt;

    @Before
    public void setUp() {
        try {
            String DB_CLASS = "com.mysql.jdbc.Driver";
            Class.forName(DB_CLASS).newInstance();
            String DB_URL = "jdbc:mysql://localhost:3306/mysql";
            String DB_USER = "root";
            String DB_PASSWORD = "test";
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        if (con != null) {
            con.close();
        }
    }
}
