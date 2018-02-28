package com.hania.stats.gui.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class MainFrame extends JFrame {

    /**
     * Default frame's width.
     */
    private static final int WIDTH = 500;
    /**
     * Default frame's height.
     */
    private static final int HEIGHT = 500;

    /**
     * Text field for the template file path (XML).
     */
    private JTextField templateTextField;
    /**
     * Text field for the answers file path (CSV).
     */
    private JTextField answersTextField;
    /**
     * Button for loading the files (XML and CSV).
     */
    private JButton loadButton;
    /**
     * Main panel.
     */
    private JPanel mainPanel;

    /**
     * Default constructor.
     */
    public MainFrame() {
        super("SuperApp");
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("resources/bird.png"));
    }

    /**
     * {@link MainFrame#templateTextField}
     *
     * @return template's text field
     */
    public JTextField getTemplateTextField() {
        return templateTextField;
    }

    /**
     * {@link MainFrame#answersTextField}
     *
     * @return answers' text field
     */
    public JTextField getAnswersTextField() {
        return answersTextField;
    }

    /**
     * {@link MainFrame#loadButton}
     *
     * @return load button
     */
    public JButton getLoadButton() {
        return loadButton;
    }

}
