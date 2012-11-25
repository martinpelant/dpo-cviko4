
package cz.pelantciz.dpo4.shapes;

import java.awt.Color;
import java.awt.Graphics;

import cz.pelantciz.dpo4.ui.ShapeTableModel;

public class Circle implements Shape {
    long id;
    int d;
    int x;
    int y;

    public Circle(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        d=10;
        id=System.currentTimeMillis();
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

    public long getId() {
        return id;
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.black);
        g.drawOval(x, y, d, d);
    }

    @Override
    public void accept(ShapeTableModel tableModel) {
       System.out.println("accept(AbstractTableModel tableModel)");
       tableModel.visit(this);
    }
    
   

}
