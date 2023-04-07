package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons

        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        resetBtn.addActionListener(this::resetGame);
        saveBtn.addActionListener(this::saveGame);

    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void loadGame(ActionEvent e) {
        frame.canvas.createBoard();
    }
    private void resetGame(ActionEvent e) {

    }
    private void saveGame(ActionEvent e) {

    }

}
