package PresentationLayer;

import DBAccess.BrickCalculator;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import DBAccess.Order;
import DBAccess.User;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asger Hermind Sørensen
 */
public class CreateOrder extends Command {

    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        LogicFacade lf = new LogicFacade();
        User user = (User) session.getAttribute("user");
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));

        try {
            Order order = LogicFacade.createOrder(user.getId(), length, width, height);
            session.setAttribute("order", order);
            
            Map<String, Integer> bricks = new BrickCalculator().calcBricks(order);
            session.setAttribute("order", order);
            session.setAttribute("bricks", bricks);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
        return "ShowOrderLine";
    }

}
