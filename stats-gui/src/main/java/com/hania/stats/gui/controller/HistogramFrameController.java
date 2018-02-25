package com.hania.stats.gui.controller;

import com.hania.stats.gui.view.HistogramFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class HistogramFrameController {

    private static String series = "Wyniki kolokwium";

    private HistogramFrame histogramFrame;

    HistogramFrameController() {
        histogramFrame = new HistogramFrame();
    }

    HistogramFrame setScoreHistogramData(List<Integer> scoreHistogramData) {
        createHistogram(convertToScoreDataset(scoreHistogramData),
                "Histogram punktów", "Liczba punktów", "Liczba studentów");
        return histogramFrame;
    }

    private CategoryDataset convertToScoreDataset(List<Integer> scoreHistogramData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Integer index = 0; index < scoreHistogramData.size(); index++) {
            dataset.addValue(scoreHistogramData.get(index), series, index);
        }
        return dataset;
    }

    HistogramFrame setMarkHistogramData(Map<String, Long> markHistogramData) {
        createHistogram(convertToMarkDataset(markHistogramData),
                "Histogram ocen", "Ocena", "Liczba studentów");
        return histogramFrame;
    }

    private CategoryDataset convertToMarkDataset(Map<String, Long> markHistogramData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        markHistogramData.forEach((key, value) ->
            dataset.addValue(value, series, key)
        );
        return dataset;
    }

    HistogramFrame setQuestionHistogramData(Map<Integer, Integer> questionHistogramData) {
        createHistogram(convertToQuestionDataset(questionHistogramData),
                "Histogram poprawnych odpowiedzi", "Pytania", "Liczba poprawnych odpowiedzi");
        return histogramFrame;
    }

    private CategoryDataset convertToQuestionDataset(Map<Integer, Integer> questionHistogramData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        questionHistogramData.forEach((key, value) ->
                dataset.addValue(value, series, key)
        );
        return dataset;
    }

    private void createHistogram(CategoryDataset scoreDataset, String title, String axisX, String axisY) {
        JFreeChart chart = ChartFactory.createBarChart(
                title,          // chart title
                axisX,          // domain axis label
                axisY,          // range axis label
                scoreDataset,   // data
                PlotOrientation.VERTICAL, // orientation
                true,    // include legend
                true,   // tooltips?
                false      // URLs?
        );

        chart.setBackgroundPaint(Color.WHITE);

        CategoryPlot plot = getCategoryPlot(chart);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        GradientPaint gp = new GradientPaint(0, 0, Color.PINK, 400, 400, Color.MAGENTA);
        renderer.setSeriesPaint(0, gp);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));

        histogramFrame.loadHistogram(chart);
    }

    private CategoryPlot getCategoryPlot(JFreeChart chart) {
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);
        return plot;
    }
}
