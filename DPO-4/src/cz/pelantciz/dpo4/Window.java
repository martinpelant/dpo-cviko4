
package cz.pelantciz.dpo4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cz.pelantciz.dpo4.ui.CircleTableModel;
import cz.pelantciz.dpo4.ui.MyCanvas;
import cz.pelantciz.dpo4.ui.SquareTableModel;

public class Window extends JFrame implements MouseListener {
    public static final String TAG = "Window";

    private MyCanvas canvas;
    private CircleTableModel circleTableModel;
    private SquareTableModel squareTableModel;

    private JTable circleTable;
    private JTable squareTable;
    private Controller model;

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
        model = new Controller();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 529, 363);
        getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

        getContentPane().add(prepareCanvas());
        getContentPane().add(prepareRightPanel());

    }

    private MyCanvas prepareCanvas() {
        MyCanvas canvas = new MyCanvas(model);
        canvas.addMouseListener(this);
        model.addView(canvas);
        return canvas;
    }

    private JPanel prepareRightPanel() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;

        // Circle Table
        circleTable = new JTable();
        circleTableModel = new CircleTableModel(model, circleTable);
        circleTable.setModel(circleTableModel);
        circleTable.setBackground(Color.WHITE);
        model.addView(circleTableModel);
        panel.add(new JScrollPane(circleTable), c);

        // Square tale
        squareTable = new JTable();
        squareTableModel = new SquareTableModel(model, squareTable);
        squareTable.setModel(squareTableModel);
        squareTable.setBackground(Color.WHITE);
        model.addView(squareTableModel);
        c.gridy = 1;
        panel.add(new JScrollPane(squareTable), c);

        // Clear all button
        JButton button = new JButton("Clear");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                model.clearAll();
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
            model.addCircle(event.getX(), event.getY());
        } else if (event.getButton() == event.BUTTON3) {
            model.addSquare(event.getX(), event.getY());
        }

    }
}
