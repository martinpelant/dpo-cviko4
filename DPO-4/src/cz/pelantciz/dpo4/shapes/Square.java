
package cz.pelantciz.dpo4.shapes;

import java.awt.Color;
import java.awt.Graphics;

import cz.pelantciz.dpo4.ui.ShapeTableModel;

public class Square implements Shape{
    long id;
    int x;
    int y;
    int a;

    public Square(int x, int y) {
        super();
        id = System.currentTimeMillis();
        a = 10;
        this.x = x;
        this.y = y;
    }
    public Square(Square src) {
        x=src.x;
        y=src.y;
        a=src.a;
        id=src.id;
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

    public long getId() {
        return id;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x, y, a, a);

    }

    @Override
    public void accept(ShapeTableModel tableModel) {
        System.out.println("accept(AbstractTableModel tableModel)");
        tableModel.visit(this);
    }

    @Override
    public boolean isValid() {
        return a>=0;
    }
    
    
    @Override
    public String toString() {
       return "Square " + id  + ": a=" + a;
    }

}
