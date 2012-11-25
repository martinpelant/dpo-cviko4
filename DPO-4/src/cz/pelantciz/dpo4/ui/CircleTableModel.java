
package cz.pelantciz.dpo4.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cz.pelantciz.dpo4.shapes.Circle;
import cz.pelantciz.dpo4.shapes.Shape;
import cz.pelantciz.dpo4.shapes.Square;

public class CircleTableModel extends BaseTableModel {
    public static final String TAG = "CircleTableModel";

    private List<Circle> circles = new ArrayList<Circle>();

    private List<Shape> shapes;

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

   

}
