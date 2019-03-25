package PresentationLayer;

import DBAccess.Order;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import DBAccess.User;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        
        LogicFacade lf = new LogicFacade();
        try{
            if(user.getRole().equals("employee")){
                List<Order> orders = lf.getAllOrders();
                session.setAttribute("orders", orders);
            }
            else{
                List<Order> orders = lf.getOrderByUserID(user.getId());
                session.setAttribute("orders", orders);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
        
        return user.getRole() + "page";
    }
    
   
    

}
