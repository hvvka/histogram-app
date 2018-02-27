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
 * Controller of the histogram's frame.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class HistogramFrameController {

    /**
     * Text for the data series displayed on chart.
     */
    private static String series = "Wyniki kolokwium";

    /**
     * Histogram's frame.
     */
    private HistogramFrame histogramFrame;

    /**
     * Default constructor.
     */
    HistogramFrameController() {
        histogramFrame = new HistogramFrame();
    }

    /**
     * Sets data for creating score histogram.
     *
     * @param scoreHistogramData data from the process module
     * @return histogram's frame
     */
    HistogramFrame setScoreHistogramData(List<Integer> scoreHistogramData) {
        createHistogram(convertToScoreDataset(scoreHistogramData),
                "Histogram punktów", "Liczba punktów", "Liczba studentów");
        return histogramFrame;
    }

    /**
     * Converts the list of integers to the dataset if order to process it further and set on the chart.
     *
     * @param scoreHistogramData data for the score histogram
     * @return processed dataset
     */
    private CategoryDataset convertToScoreDataset(List<Integer> scoreHistogramData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Integer index = 0; index < scoreHistogramData.size(); index++) {
            dataset.addValue(scoreHistogramData.get(index), series, index);
        }
        return dataset;
    }

    /**
     * Sets data for creating mark histogram.
     *
     * @param markHistogramData data from the process module
     * @return histogram's frame
     */
    HistogramFrame setMarkHistogramData(Map<String, Long> markHistogramData) {
        createHistogram(convertToMarkDataset(markHistogramData),
                "Histogram ocen", "Ocena", "Liczba studentów");
        return histogramFrame;
    }

    /**
     * Converts the map with string and long number to the dataset if order to process it further and set on the chart.
     *
     * @param markHistogramData data for the score histogram
     * @return processed dataset
     */
    private CategoryDataset convertToMarkDataset(Map<String, Long> markHistogramData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        markHistogramData.forEach((key, value) ->
            dataset.addValue(value, series, key)
        );
        return dataset;
    }

    /**
     * Sets data for creating mark histogram.
     *
     * @param questionHistogramData data from the process module
     * @return histogram's frame
     */
    HistogramFrame setQuestionHistogramData(Map<Integer, Integer> questionHistogramData) {
        createHistogram(convertToQuestionDataset(questionHistogramData),
                "Histogram poprawnych odpowiedzi", "Pytania", "Liczba poprawnych odpowiedzi");
        return histogramFrame;
    }

    /**
     * Converts the map with two integers to the dataset if order to process it further and set on the chart.
     *
     * @param questionHistogramData data for the score histogram
     * @return processed dataset
     */
    private CategoryDataset convertToQuestionDataset(Map<Integer, Integer> questionHistogramData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        questionHistogramData.forEach((key, value) ->
                dataset.addValue(value, series, key)
        );
        return dataset;
    }

    /**
     * Creates chart's object and passes it to the histogram's frame.
     *
     * @param scoreDataset dataset to be shown in the chart
     * @param title chart's title
     * @param axisX the name of the X axis
     * @param axisY the name of the Y axis
     */
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

    /**
     * Return the chart's plot.
     *
     * @param chart histogram's chart
     * @return the plot
     */
    private CategoryPlot getCategoryPlot(JFreeChart chart) {
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);
        return plot;
    }
}
