
package cz.pelantciz.dpo4.ui;

import java.awt.Canvas;
import java.awt.Graphics;

import cz.pelantciz.dpo4.Controller;
import cz.pelantciz.dpo4.shapes.Shape;

public class MyCanvas extends Canvas implements View {
    private static final long serialVersionUID = 1L;
    public static final String TAG = "MyCanvas";
    private Controller model;

    public MyCanvas(Controller model) {
        this.model = model;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (model != null) {
            System.out.println("painted " + model.getShapes().size() + " shapes");
            for (Shape shape : model.getShapes()) {
                shape.draw(g);
            }
        }
    }

    @Override
    public void refresh() {
        update(getGraphics());
    }

}
