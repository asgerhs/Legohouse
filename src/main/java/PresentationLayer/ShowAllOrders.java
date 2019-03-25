package PresentationLayer;

import DBAccess.Order;
import DBAccess.User;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asger Hermind Sørensen
 */
public class ShowAllOrders extends Command {
    
    
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        LogicFacade fc = new LogicFacade();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> orders = new ArrayList();
        
        try{
            fc.getOrderByUserID(user.getId());
            session.setAttribute("orders", orders);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } 
        return "customerpage";
    }
    
    

}
