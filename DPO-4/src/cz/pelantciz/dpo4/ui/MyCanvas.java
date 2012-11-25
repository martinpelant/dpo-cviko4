package cz.pelantciz.dpo4.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.List;

import cz.pelantciz.dpo4.shapes.Shape;

public class MyCanvas extends Canvas{
    private static final long serialVersionUID = 1L;
    public static final String TAG = "MyCanvas";
    private List<Shape> shapes;
    
    
    public MyCanvas(List<Shape> shapes) {
        this.shapes=shapes;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
       
        if(shapes!=null) {
            System.out.println("painted " + shapes.size() + " shapes");
            for (Shape shape : shapes) {
                shape.draw(g);
            }
        }
    }
    
    
   

}
