package DBAccess;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asger Hermind Sørensen
 */
public class BrickCalculator {
    
 
public static HashMap<String, Integer> calcBricks(Order order) {
     HashMap<String, Integer> bricks = new HashMap<>();
     int small = 0;
     int medium = 0;
     int large = 0;
     int remain = 0;

     large = (order.getLength() - 2) / 4;
     remain = (order.getLength() - 2) % 4;
     medium = remain / 2;
     small = remain % 2;

     large += (order.getWidth() - 2) / 4;
     remain = (order.getWidth() - 2) % 4;
     medium += remain / 2;
     small += remain % 2;

     large *= order.getHeight();
     medium *= order.getHeight();
     small *= order.getHeight();

     bricks.put("2x4", large*2);
     bricks.put("2x2", medium*2);
     bricks.put("2x1", small*2);
     
     System.out.println(bricks.keySet().toString() + bricks.values().toString());
     return bricks;
 }

    public static void main(String[] args) {
        Order order = new Order(1,8,8,1);
        BrickCalculator.calcBricks(order);
        
    }

    
      
}
