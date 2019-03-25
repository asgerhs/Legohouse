package FunctionLayer;

import DBAccess.User;
import DBAccess.Order;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.sql.SQLException;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static Order createOrder(int userID, int length, int width, int height) throws LoginSampleException, ClassNotFoundException{
        Order order = new Order(userID, length, width, height);
        OrderMapper.createOrder(order);
        return order;
    }
    
    public static Order getOrderByOrderID(int orderID) throws ClassNotFoundException, SQLException{
       return OrderMapper.getOrderByOrderID(orderID);
    }
    
    public static List<Order> getOrderByUserID(int UserID) throws ClassNotFoundException, SQLException{
        return OrderMapper.getOrderByUserID(UserID);
    }

}
