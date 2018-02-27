package com.hania.stats.gui.view;

import javax.swing.*;

/**
 * Frame of the window for choosing the histogram.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class GenerateStatsFrame extends JFrame {

    /**
     * Default frame's width.
     */
    private static final int WIDTH = 500;
    /**
     * Default frame's height.
     */
    private static final int HEIGHT = 500;

    /**
     * Panel for the histogram chooser.
     */
    private JPanel generateStatsPanel;
    /**
     * Button to view score histogram.
     */
    private JButton scoreHistogramButton;
    /**
     * Button to view question histogram.
     */
    private JButton questionHistogramButton;
    /**
     * Button to view mark histogram.
     */
    private JButton markHistogramButton;
    /**
     * Button to return the previous frame.
     * @see MainFrame
     */
    private JButton returnButton;

    /**
     * Default constructor.
     */
    public GenerateStatsFrame() {
        super("Generuj histogramy");
        setSize(WIDTH, HEIGHT);
        setContentPane(generateStatsPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * {@link GenerateStatsFrame#scoreHistogramButton}
     *
     * @return button for score histogram
     */
    public JButton getScoreHistogramButton() {
        return scoreHistogramButton;
    }

    /**
     * {@link GenerateStatsFrame#questionHistogramButton}
     *
     * @return button for question histogram
     */
    public JButton getQuestionHistogramButton() {
        return questionHistogramButton;
    }

    /**
     * {@link GenerateStatsFrame#markHistogramButton}
     *
     * @return button for mark histogram
     */
    public JButton getMarkHistogramButton() {
        return markHistogramButton;
    }

    /**
     * {@link GenerateStatsFrame#returnButton}
     *
     * @return button for return action
     */
    public JButton getReturnButton() {
        return returnButton;
    }
}
