package com.hania.stats.gui.controller;

import com.hania.stats.gui.view.GenerateStatsFrame;
import com.hania.stats.gui.view.HistogramFrame;
import com.hania.stats.gui.view.MainFrame;
import com.hania.stats.process.DataConverter;

import javax.swing.*;

/**
 * Controller of frame for generating statistics.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
class GenerateStatsFrameController {

    /**
     * The frame for choosing histograms
     */
    private GenerateStatsFrame generateStatsFrame;
    /**
     * {@link MainFrameController#mainFrame}
     */
    private MainFrame mainFrame;
    /**
     * The controller for HistogramFrame
     */
    private HistogramFrameController histogramFrameController;
    /**
     * @see DataConverter
     */
    private DataConverter converter;

    /**
     * {@link GenerateStatsFrame#scoreHistogramButton}
     */
    private JButton scoreHistogramButton;
    /**
     * {@link GenerateStatsFrame#questionHistogramButton}
     */
    private JButton questionHistogramButton;
    /**
     * {@link GenerateStatsFrame#markHistogramButton}
     */
    private JButton markHistogramButton;
    /**
     * {@link GenerateStatsFrame#returnButton}
     */
    private JButton returnButton;

    /**
     * Frame for the score histogram.
     */
    private HistogramFrame scoreHistogramFrame;
    /**
     * Frame for the mark histogram.
     */
    private HistogramFrame markHistogramFrame;
    /**
     * Frame for the question histogram.
     */
    private HistogramFrame questionHistogramFrame;

    /**
     * Default constructor.
     */
    GenerateStatsFrameController(DataConverter converter, MainFrame mainFrame) {
        this.converter = converter;
        this.mainFrame = mainFrame;

        initComponents();
        initListeners();
    }

    /**
     * Initializes actions listeners.
     */
    private void initListeners() {
        scoreHistogramButton.addActionListener(ae -> {
            histogramFrameController = new HistogramFrameController();
            scoreHistogramFrame = histogramFrameController.setScoreHistogramData(converter.createScoreHistogram());
        });

        questionHistogramButton.addActionListener(ae -> {
            histogramFrameController = new HistogramFrameController();
            markHistogramFrame = histogramFrameController.setQuestionHistogramData(converter.createQuestionHistogram());
        });

        markHistogramButton.addActionListener(ae -> {
            histogramFrameController = new HistogramFrameController();
            questionHistogramFrame = histogramFrameController.setMarkHistogramData(converter.createMarkHistogram());
        });

        returnButton.addActionListener(ae -> {
            mainFrame.setVisible(true);
            scoreHistogramFrame.dispose();
            markHistogramFrame.dispose();
            questionHistogramFrame.dispose();
            generateStatsFrame.dispose();
        });
    }

    /**
     * Initializes frame's componenets.
     */
    private void initComponents() {
        generateStatsFrame = new GenerateStatsFrame();
        generateStatsFrame.setVisible(true);

        scoreHistogramButton = generateStatsFrame.getScoreHistogramButton();
        questionHistogramButton = generateStatsFrame.getQuestionHistogramButton();
        markHistogramButton = generateStatsFrame.getMarkHistogramButton();
        returnButton = generateStatsFrame.getReturnButton();
    }

}
