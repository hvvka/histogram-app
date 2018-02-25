package com.hania.stats.gui.view;

import javax.swing.*;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class MainFrame extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private JTextField templateTextField;
    private JTextField answersTextField;
    private JButton loadButton;
    private JPanel mainPanel;

    public MainFrame() {
        super("SuperApp");
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JTextField getTemplateTextField() {
        return templateTextField;
    }

    public JTextField getAnswersTextField() {
        return answersTextField;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

}
