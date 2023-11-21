package plateau;
import java.awt.Color;

public class Parking extends Case {
    public Parking(String name, int price, Color color) {
        super(name, price);
        setColor(color);
    }
}

