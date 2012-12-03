
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
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "x";
            case 2:
                return "y";
            case 3:
                return "d";
            default:
                return super.getColumnName(column);
        }
        
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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String value = aValue + "";
        Circle original = circles.get(rowIndex);
        Circle tmp = new Circle(original);
        try {
            switch (columnIndex) {
                case 0:
                    break;
                case 1:
                    tmp.setX(Integer.parseInt(value));
                    break;
                case 2:
                    tmp.setY(Integer.parseInt(value));
                    break;
                case 3:
                    tmp.setD(Integer.parseInt(value));
                    break;
                default:
                    break;
            }
            setIfValid(original, tmp);
        } catch (NumberFormatException e) {
        }
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

}
