package com.hania.stats.gui.controller;

import com.hania.stats.gui.view.MainFrame;
import com.hania.stats.process.DataConverter;
import com.hania.stats.process.DataConverterImpl;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Controller of the main frame.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class MainFrameController {

    /**
     * The main frame (shows first as it starts)
     */
    private MainFrame mainFrame;

    /**
     * {@link MainFrame#templateTextField}
     */
    private JTextField templateTextField;
    /**
     * {@link MainFrame#answersTextField}
     */
    private JTextField answersTextField;
    /**
     * {@link MainFrame#loadButton}
     */
    private JButton loadButton;

    /**
     * @see DataConverter
     */
    private DataConverter converter;

    /**
     * Default constructor.
     */
    public MainFrameController() {
        initComponents();
        initListeners();
    }

    /**
     * Initializes actions listeners.
     */
    private void initListeners() {
        loadButton.addActionListener(ae -> {
                    try {
                        converter.loadData(Paths.get(templateTextField.getText()).toAbsolutePath(),
                                Paths.get(answersTextField.getText()).toAbsolutePath());
                        showGenerateStatsFrame();
                    } catch (IOException e) {
                        showErrorLoadDataMessage(e);
                    }
                }
        );
    }

    /**
     * Creates JOptionPane with an error message related with file's wrong path.
     *
     * @param e IOException message
     */
    private void showErrorLoadDataMessage(IOException e) {
        String messageWrapped = "<html><body><p style='width: 400px;'>"+e.toString()+"</p></body></html>";
        String title = "Błąd wczytywania!";
        JOptionPane.showMessageDialog(new Frame(), messageWrapped, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Creates new frame and hides main frame.
     */
    private void showGenerateStatsFrame() {
        showSuccessfulLoadDataMessage();
        mainFrame.setVisible(false);
        new GenerateStatsFrameController(converter, mainFrame);
    }

    /**
     * Shows the message (in JOptionPane) if the data was loaded successfully.
     */
    private void showSuccessfulLoadDataMessage() {
        String message = "Dane zostały wczytane pomyślnie";
        String title = "Sukces!";
        JOptionPane.showMessageDialog(new Frame(), message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Initializes frame's componenets.
     */
    private void initComponents() {
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        converter = new DataConverterImpl();

        loadButton = mainFrame.getLoadButton();
        templateTextField = mainFrame.getTemplateTextField();
        answersTextField = mainFrame.getAnswersTextField();
    }

}
