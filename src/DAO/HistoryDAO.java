/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.DAO;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import src.Model.History;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class HistoryDAO {
    public static ArrayList<History> getAllHistory() throws SQLException{
    ArrayList<History> list = new ArrayList<History>();
    Connection connection = JDBCConnection.getJDBCConnection();
    String sql = "SELECT * FROM test.history";
    try{
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ResultSet rs = prepareStatement.executeQuery();
        while (rs.next()){
            History history = new History();
            history.setLevel(rs.getInt("Level"));
            history.setTopic(rs.getString("Topic"));
            history.setScore(rs.getInt("Score"));
            history.setDate(rs.getTimestamp("Date").toLocalDateTime());
            list.add(history);
        }
    } catch (SQLException e){
        e.printStackTrace();
        }
    return list;
    }
    public static void addHistory(History history){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO test.history(Level, Topic, Score, Date) VALUE(?,?,?,?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, history.getLevel());
            prepareStatement.setString(2, history.getTopic());
            prepareStatement.setInt(3, history.getScore());
            prepareStatement.setObject(4, history.getDate());
            int rs = prepareStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(HistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
