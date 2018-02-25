package com.hania.stats.gui.controller;

import com.hania.stats.gui.view.GenerateStatsFrame;
import com.hania.stats.gui.view.HistogramFrame;
import com.hania.stats.gui.view.MainFrame;
import com.hania.stats.process.DataConverter;

import javax.swing.*;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
class GenerateStatsFrameController {

    private GenerateStatsFrame generateStatsFrame;
    private MainFrame mainFrame;
    private HistogramFrameController histogramFrameController;
    private DataConverter converter;

    private JButton scoreHistogramButton;
    private JButton questionHistogramButton;
    private JButton markHistogramButton;
    private JButton returnButton;

    private HistogramFrame scoreHisogramFrame;
    private HistogramFrame markHisogramFrame;
    private HistogramFrame questionHisogramFrame;

    GenerateStatsFrameController(DataConverter converter, MainFrame mainFrame) {
        this.converter = converter;
        this.mainFrame = mainFrame;

        initComponents();
        initListeners();
    }

    private void initListeners() {
        scoreHistogramButton.addActionListener(ae -> {
            histogramFrameController = new HistogramFrameController();
            scoreHisogramFrame = histogramFrameController.setScoreHistogramData(converter.createScoreHistogram());
        });

        questionHistogramButton.addActionListener(ae -> {
            histogramFrameController = new HistogramFrameController();
            markHisogramFrame = histogramFrameController.setQuestionHistogramData(converter.createQuestionHistogram());
        });

        markHistogramButton.addActionListener(ae -> {
            histogramFrameController = new HistogramFrameController();
            questionHisogramFrame = histogramFrameController.setMarkHistogramData(converter.createMarkHistogram());
        });

        returnButton.addActionListener(ae -> {
            mainFrame.setVisible(true);
            scoreHisogramFrame.dispose();
            markHisogramFrame.dispose();
            questionHisogramFrame.dispose();
            generateStatsFrame.dispose();
        });
    }

    private void initComponents() {
        generateStatsFrame = new GenerateStatsFrame();
        generateStatsFrame.setVisible(true);

        scoreHistogramButton = generateStatsFrame.getScoreHistogramButton();
        questionHistogramButton = generateStatsFrame.getQuestionHistogramButton();
        markHistogramButton = generateStatsFrame.getMarkHistogramButton();
        returnButton = generateStatsFrame.getReturnButton();
    }

}
