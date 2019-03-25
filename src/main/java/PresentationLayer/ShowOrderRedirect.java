package PresentationLayer;

import DBAccess.BrickCalculator;
import DBAccess.Order;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
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
public class ShowOrderRedirect extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        LogicFacade lf = new LogicFacade();
        try{
        Order order = lf.getOrderByOrderID(Integer.parseInt(request.getParameter("orderID")));
        Map<String, Integer> bricks = new BrickCalculator().calcBricks(order);
        session.setAttribute("order", order);
        session.setAttribute("bricks", bricks);
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        } 
        return "ShowOrder";
    }

}
