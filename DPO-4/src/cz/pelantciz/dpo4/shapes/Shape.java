package cz.pelantciz.dpo4.shapes;

import java.awt.Graphics;

import javax.swing.table.AbstractTableModel;

import cz.pelantciz.dpo4.ui.ShapeTableModel;

public interface Shape {
    public void draw(Graphics g);
    public void accept(ShapeTableModel tableModel);
}
