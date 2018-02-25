package com.hania.stats.gui.controller;

import com.hania.stats.gui.view.MainFrame;
import com.hania.stats.process.DataConverter;
import com.hania.stats.process.DataConverterImpl;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class MainFrameController {

    private MainFrame mainFrame;

    private JTextField templateTextField;
    private JTextField answersTextField;
    private JButton loadButton;

    private DataConverter converter;

    public MainFrameController() {
        initComponents();
        initListeners();
    }

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

    private void showErrorLoadDataMessage(IOException e) {
        String messageWrapped = "<html><body><p style='width: 400px;'>"+e.toString()+"</p></body></html>";
        String title = "Błąd wczytywania!";
        JOptionPane.showMessageDialog(new Frame(), messageWrapped, title, JOptionPane.ERROR_MESSAGE);
    }

    private void showGenerateStatsFrame() {
        showSuccessfulLoadDataMessage();
        mainFrame.setVisible(false);
        new GenerateStatsFrameController(converter, mainFrame);
    }

    private void showSuccessfulLoadDataMessage() {
        String message = "Dane zostały wczytane pomyślnie";
        String title = "Sukces!";
        JOptionPane.showMessageDialog(new Frame(), message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void initComponents() {
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        converter = new DataConverterImpl();

        loadButton = mainFrame.getLoadButton();
        templateTextField = mainFrame.getTemplateTextField();
        answersTextField = mainFrame.getAnswersTextField();
    }

}
