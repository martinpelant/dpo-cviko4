
package cz.pelantciz.dpo4.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Shape {
    int d;
    int x;
    int y;

    public Circle(int d, int x, int y) {
        super();
        this.d = d;
        this.x = x;
        this.y = y;
    }
    
    public Circle(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        d=10;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.black);
        g.drawOval(x, y, d, d);
    }

}
