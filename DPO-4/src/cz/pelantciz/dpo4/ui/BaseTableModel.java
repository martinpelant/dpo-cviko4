package cz.pelantciz.dpo4.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cz.pelantciz.dpo4.Window;
import cz.pelantciz.dpo4.shapes.Circle;
import cz.pelantciz.dpo4.shapes.Shape;
import cz.pelantciz.dpo4.shapes.Square;

public class BaseTableModel extends AbstractTableModel implements ShapeTableModel {
    public static final String TAG = "BaseTableModel";
    protected final Window window;
    protected final List<Shape> shapes;

    
    public BaseTableModel(Window window, List<Shape> shapes) {
        this.window=window;
        this.shapes = shapes;
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
    public void visit(Circle c) {
    }

    @Override
    public void visit(Square s) {
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex != 0)
            return true;
        return false;
        
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        window.invalidateViews();
    }

}
