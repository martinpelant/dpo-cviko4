
package cz.pelantciz.dpo4.ui;

import cz.pelantciz.dpo4.shapes.Circle;
import cz.pelantciz.dpo4.shapes.Square;

public interface ShapeTableModel {
    public void visit(Circle c);

    public void visit(Square s);
}
