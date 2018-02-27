package com.hania.stats.gui.view;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;

/**
 * Frame for all the histograms' types.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class HistogramFrame extends JFrame {

    /**
     * Default frame's width.
     */
    private static final int WIDTH = 500;
    /**
     * Default frame's height.
     */
    private static final int HEIGHT = 500;

    /**
     * Default constructor.
     */
    public HistogramFrame() {
        super("Histogram");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Displays the chart on the panel.
     *
     * @param scoreChart sets the chart one the panel
     */
    public void loadHistogram(JFreeChart scoreChart) {
        ChartPanel chartPanel = new ChartPanel(scoreChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        setContentPane(chartPanel);
    }
}
