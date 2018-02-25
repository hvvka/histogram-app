package com.hania.stats.gui.view;

import javax.swing.*;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class GenerateStatsFrame extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private JPanel generateStatsPanel;
    private JButton scoreHistogramButton;
    private JButton questionHistogramButton;
    private JButton markHistogramButton;
    private JButton returnButton;

    public GenerateStatsFrame() {
        super("Generuj histogramy");
        setSize(WIDTH, HEIGHT);
        setContentPane(generateStatsPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JButton getScoreHistogramButton() {
        return scoreHistogramButton;
    }

    public JButton getQuestionHistogramButton() {
        return questionHistogramButton;
    }

    public JButton getMarkHistogramButton() {
        return markHistogramButton;
    }

    public JButton getReturnButton() {
        return returnButton;
    }
}
