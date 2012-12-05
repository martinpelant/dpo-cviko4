package cz.pelantciz.dpo4;

import java.util.ArrayList;
import java.util.List;

import cz.pelantciz.dpo4.shapes.Circle;
import cz.pelantciz.dpo4.shapes.Shape;
import cz.pelantciz.dpo4.shapes.Square;
import cz.pelantciz.dpo4.ui.View;

public class Controller {
    public static final String TAG = "Controller";
    private List<Shape> shapes = new ArrayList<Shape>();
    private List<View> views  =new ArrayList<View>();
    
    public void clearAll() {
        shapes.clear();
        invalidateViews();
    }
    
    
    public void invalidateViews() {
        for (View view : views) {
            view.refresh();
        }
    }
    
    public List<Shape> getShapes(){
        return shapes;
    }
    
    
    public void addCircle(int x, int y) {
        shapes.add(new Circle(x, y));
        invalidateViews();
    }
    
    public void addSquare(int x, int y) {
        shapes.add(new Square(x, y));
        invalidateViews();
    }
    
    public void addView(View view) {
        views.add(view);
    }

}
