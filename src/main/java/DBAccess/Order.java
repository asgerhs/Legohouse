package DBAccess;

/**
 *
 * @author Asger Hermind Sørensen
 */
public class Order {
    
    private int id;
    private int length;
    private int width;
    private int height; 
    private int userID;

    public Order(int userID, int length, int width, int height) {
        this.userID = userID;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getUserID() {
        return userID;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
