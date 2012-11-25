
package cz.pelantciz.dpo4;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import cz.pelantciz.dpo4.shapes.Circle;
import cz.pelantciz.dpo4.shapes.Shape;
import cz.pelantciz.dpo4.shapes.Square;
import cz.pelantciz.dpo4.ui.CircleTableModel;
import cz.pelantciz.dpo4.ui.MyCanvas;

public class Window extends JFrame implements MouseListener {
    public static final String TAG = "Window";

    private List<Shape> shapes = new ArrayList<Shape>();
    private Canvas canvas;
    private CircleTableModel cTableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window frame = new Window();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Window() {
        cTableModel = new CircleTableModel();
        cTableModel.setShapes(shapes);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 529, 363);
        getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

        canvas = prepareCanvas();
        getContentPane().add(canvas);
        getContentPane().add(prepareRightPanel());

    }

    private void invalidateViews() {
        canvas.update(canvas.getGraphics());
        cTableModel.invalidate();
        System.out.println("invalidated");
    }

    private Canvas prepareCanvas() {
        MyCanvas canvas = new MyCanvas();
        canvas.setShapes(shapes);
        canvas.addMouseListener(this);
        return canvas;
    }

    private JPanel prepareRightPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;

        JTable table_1 = new JTable();
        table_1.setBackground(Color.BLACK);
        panel.add(table_1, c);

        JTable table = new JTable();
        table.setBackground(Color.YELLOW);
        c.gridy = 1;
        panel.add(table, c);

        JButton button = new JButton("Clear");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                shapes.clear();
                invalidateViews();
            }
        });
        c.weighty = 0;
        c.gridy = 2;
        panel.add(button, c);

        return panel;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if (event.getButton() == event.BUTTON1) {
            shapes.add(new Circle(event.getX(), event.getY()));
            invalidateViews();
        } else if (event.getButton() == event.BUTTON3) {
            shapes.add(new Square(event.getX(), event.getY()));
            invalidateViews();
        }

    }
}
