
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;

public class DB_Connect {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbtable?"
                    + "user=root&password=");
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
//sdad
        Statement stmt = conn.createStatement();

        String queryStudents = "select * from students";
        ResultSet rs = stmt.executeQuery(queryStudents);

        //while (rs.next()) {
        //    long id = rs.getLong("ID");
        //    String fname = rs.getString("FirstName");
        //    String lname = rs.getString("LastName");
        //    String faculty = rs.getString("Faculty");
        //    double gpax = rs.getDouble("GPAX");
        //    System.out.println(id + "\t" + fname + "\t" + lname + "\t" + faculty + "\t" + gpax);
        // }
        rs = stmt.executeQuery("select * from students");

        while (rs.next()) {
            long id = rs.getLong(1);
            String fname = rs.getString(2);
            String lname = rs.getString(3);
            String fac = rs.getString(4);
            double gpax = rs.getDouble(5);

            System.out.println(id + "\t" + fname + "\t" + lname + "\t" + fac + "\t" + gpax);
        }

    }

}
