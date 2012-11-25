
package cz.pelantciz.dpo4.ui;

import java.util.ArrayList;
import java.util.List;

import cz.pelantciz.dpo4.Window;
import cz.pelantciz.dpo4.shapes.Circle;
import cz.pelantciz.dpo4.shapes.Shape;

public class CircleTableModel extends BaseTableModel {
   


    private static final long serialVersionUID = 1L;

    public static final String TAG = "CircleTableModel";

    private List<Circle> circles = new ArrayList<Circle>();


    public CircleTableModel(Window window, List<Shape> shapes) {
        super(window, shapes);
    }
    
    public void invalidate() {
        circles.clear();
        for (Shape shape : shapes) {
            shape.accept(this);
        }

    }

    @Override
    public void visit(Circle c) {
        circles.add(c);
        System.out.println("Circle table model " + circles.size());
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return circles.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Circle c = circles.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getX();
            case 2:
                return c.getY();
            case 3:
                return c.getD();
            default:
                return getValueAt(rowIndex, 0);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex != 0)
            return true;
        return false;
        
    }

    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String value = aValue+"";
        Circle c = circles.get(rowIndex);
        try {
            switch (columnIndex) {
                case 0:
                    break;
                case 1:
                    c.setX(Integer.parseInt(value));
                    break;
                case 2:
                    c.setY(Integer.parseInt(value));
                    break;
                case 3:
                    c.setD(Integer.parseInt(value));
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        window.invalidateViews();
       
       
    }

}
