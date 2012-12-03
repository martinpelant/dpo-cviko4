
package cz.pelantciz.dpo4.ui;

import java.util.ArrayList;
import java.util.List;

import cz.pelantciz.dpo4.Window;
import cz.pelantciz.dpo4.shapes.Circle;
import cz.pelantciz.dpo4.shapes.Shape;
import cz.pelantciz.dpo4.shapes.Square;

public class SquareTableModel extends BaseTableModel {

    private static final long serialVersionUID = 1L;

    private List<Square> squares = new ArrayList<Square>();

    public SquareTableModel(Window window, List<Shape> shapes) {
        super(window, shapes);
    }

    public void invalidate() {
        squares.clear();
        for (Shape shape : shapes) {
            shape.accept(this);
        }

    }

    @Override
    public void visit(Square s) {
        squares.add(s);
        System.out.println("Square table model " + squares.size());
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return squares.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Square s = squares.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getId();
            case 1:
                return s.getX();
            case 2:
                return s.getY();
            case 3:
                return s.getA();
            default:
                return getValueAt(rowIndex, 0);
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String value = aValue + "";
        Square original = squares.get(rowIndex);
        Square tmp = new Square(original);
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
                    tmp.setA(Integer.parseInt(value));
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
