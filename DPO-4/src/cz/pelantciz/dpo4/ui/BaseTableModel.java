
package cz.pelantciz.dpo4.ui;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import cz.pelantciz.dpo4.Controller;
import cz.pelantciz.dpo4.Window;
import cz.pelantciz.dpo4.shapes.Circle;
import cz.pelantciz.dpo4.shapes.Shape;
import cz.pelantciz.dpo4.shapes.Square;

public class BaseTableModel extends AbstractTableModel implements ShapeTableModel, View {
    public static final String TAG = "BaseTableModel";
    protected final Controller model;
    protected final JTable table;
    protected final List<Shape> shapes;

    public BaseTableModel(Controller model, JTable table) {
        this.model = model;
        this.shapes = model.getShapes();
        this.table=table;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
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
        model.invalidateViews();
    }

    protected void setIfValid(Shape original, Shape tmp) {
        if (tmp.isValid()) {
            System.out.println("is valid");
            int globalIndex = shapes.indexOf(original);
            if (globalIndex != -1) {
                shapes.set(globalIndex, tmp);
            }
        } else {
            System.out.println("is NOT valid");
        }
    }

    @Override
    public void refresh() {
        table.revalidate(); // this works 99% of the time
        table.repaint(); // sometimes needed.
    }
}
