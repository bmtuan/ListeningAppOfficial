package src.DAO;

import java.sql.*;
import src.Model.*;
public class UserDAO {
        public static User getUser(String useId) throws SQLException {
            Connection connection = JDBCConnection.getJDBCConnection();
            User user = new User();
            String sql = "SELECT user.UserName, user.UserID, user.Password, user.DateOfBirth, user.Gender FROM test.user WHERE user.UserID = " + "\"" + useId +"\"";
            try {
                PreparedStatement prepareStatement = connection.prepareStatement(sql);
                ResultSet rs = prepareStatement.executeQuery();
                while (rs.next()) {
                    user.setUserName(rs.getString(1));
                    user.setUserID(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setDateOfBirth(rs.getString(4));
                    user.setGender(rs.getString(5));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
        }
    
        public static void addUser(User user) throws SQLException {
            Connection connection = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO test.user(UserName, UserID, PassWord, DateOfBirth, Gender) VALUE(?,?,?,?,?)";
                PreparedStatement prepareStatement = connection.prepareStatement(sql);
                prepareStatement.setString(1, user.getUserName());
                prepareStatement.setString(2, user.getUserID());
                prepareStatement.setString(3, user.getPassword());
                prepareStatement.setString(4, user.getDateOfBirth());
                prepareStatement.setString(5, user.getGender());
                int rs = prepareStatement.executeUpdate();
                System.out.println(rs);
        }
        // public static void main(String[] args) throws SQLException {
        //     // System.out.println(UserDAO.getUser("bmt050720").toString());
        //     User user = new User("Bùi Mạnh Tuấn", "phoneixhp123", "wtfisthis", "05 Tháng 7 2000", "Nam");
        //     UserDAO.addUser(user);
        // }
}