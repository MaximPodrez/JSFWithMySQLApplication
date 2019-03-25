
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxim
 */
public class DBConnection {
    private List<Player> list = new ArrayList<>();

    public DBConnection() {
        read();
    }
    
    private void read()
    {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String login = "root";
            String password = "Maxim2000!";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Player pl;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM players");
                while (rs.next()) {
                    pl = new Player();
                    pl.setId(rs.getInt("user_id"));
                    pl.setName(rs.getString("name"));
                    pl.setSurname(rs.getString("surname"));
                    pl.setAge(rs.getInt("age"));
                    list.add(pl);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
    }

    public List<Player> getList() {
        return list;
    }
}
