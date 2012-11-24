
package cz.pelantciz.dpo4.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Square implements Shape {
    int x;
    int y;
    int a;

    public Square(int x, int y) {
        super();
        a=10;
        this.x = x;
        this.y = y;
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

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x, y, a, a);

    }

}
