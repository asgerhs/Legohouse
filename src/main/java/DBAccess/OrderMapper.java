package DBAccess;

import FunctionLayer.LoginSampleException;
import DBAccess.User;
import PresentationLayer.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Asger Hermind Sørensen
 */
public class OrderMapper {

    public static void createOrder(Order order) throws LoginSampleException, ClassNotFoundException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Orders (userID, length, width, height) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUserID());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static List<Order> getAllOrders() throws SQLException, ClassNotFoundException{
        List<Order> orders = new ArrayList();
        try{
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Order order = new Order(
                        rs.getInt("userID"), 
                        rs.getInt("length"), 
                        rs.getInt("width"), 
                        rs.getInt("height"));
                order.setId(rs.getInt("orderID"));
                orders.add(order);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return orders;
    }

    public static List<Order> getOrderByUserID(int userID) throws ClassNotFoundException, SQLException {
        List<Order> orders = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders where userID = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("userID"),
                        rs.getInt("length"),
                        rs.getInt("width"),
                        rs.getInt("height"));
                order.setId(rs.getInt("orderID"));
                orders.add(order);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    public static Order getOrderByOrderID(int orderID) throws ClassNotFoundException, SQLException {
        Order order = null;
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders where orderID = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                order = new Order(
                        rs.getInt("userID"),
                        rs.getInt("length"),
                        rs.getInt("width"),
                        rs.getInt("height"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return order;
    }

}
