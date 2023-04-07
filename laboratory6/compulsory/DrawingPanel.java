package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image;
    Graphics2D graphics;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
            }
        });
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }
    final void createBoard() {
        numVertices  = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability =(Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        graphics.setColor(Color.DARK_GRAY);
        createVertices();
        drawLines(graphics);
        drawVertices(graphics);
        graphics.setColor(Color.BLACK);
        repaint();
    }
    private void createVertices() {
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }
    private void drawLines(Graphics g) {
        double prob=0;
        for (int i=0; i< numVertices; i++)
            for(int j=0; j< numVertices; j++) {
                prob=(prob+1)%edgeProbability;
                if(prob==0) {
                    g.drawLine(x[i] + 5, y[i] + 5, x[j] + 5, y[j] + 5);
                }
            }
    }
    private void drawVertices(Graphics g) {
        int radius =5; //board radius
        for (int i = 0; i < numVertices; i++) {
            g.fillOval(x[i] , y[i] , radius * 2, radius * 2);
        }
    }
    @Override
    public void update(Graphics g) { } //No need for update

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}