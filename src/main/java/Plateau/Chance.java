package plateau;
import java.awt.Color;

public class Chance extends Case {
    public Chance(String name, int price, Color color) {
        super(name, price);
        setColor(color);
    }
}

