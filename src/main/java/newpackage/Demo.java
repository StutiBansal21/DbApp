package newpackage;

import java.sql.SQLOutput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) {

        try{
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String uname = "postgres";
            String pwd = "root";

            Connection con = DriverManager.getConnection(url,uname,pwd);

            Statement stmt = con.createStatement();

            String q = "select * from student";

            ResultSet rs = stmt.executeQuery(q);


            while(rs.next()) {
                System.out.println(rs.getInt(1) + " : " + rs.getString(2));
            }

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
