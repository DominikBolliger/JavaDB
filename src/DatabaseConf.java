import java.sql.*;

public class DatabaseConf {

    String server, user, password;
    Connection con;

    public DatabaseConf(String server, String user, String password){
        this.server = server;
        this.user = user;
        this.password = password;
    }

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con= DriverManager.getConnection("jdbc:mysql://" + password + ":3306/sa",user,password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void read(){
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM position");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getInt(3)+ "  " + rs.getInt(4));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void write(int posX, int posY, int posZ){
        try {
            PreparedStatement prestmt = this.con.prepareStatement("INSERT INTO position (posx, posy, posz) VALUES (?,?,?)");
            prestmt.setInt(1, posX);
            prestmt.setInt(2, posY);
            prestmt.setInt(3, posZ);
            prestmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void closeConnection(){
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

