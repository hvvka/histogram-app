package com.hania.stats.gui.view;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class HistogramFrame extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public HistogramFrame() {
        super("Histogram");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void loadHistogram(JFreeChart scoreChart) {
        ChartPanel chartPanel = new ChartPanel(scoreChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        setContentPane(chartPanel);
    }
}
