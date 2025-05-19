package com.soilsense;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoilSenseApp extends JFrame {
    private JTextField phField, nitrogenField, phosphorusField, potassiumField;
    private JTextArea outputArea;

    public SoilSenseApp() {
        setTitle("SoilSense - Fertilizer & Crop Recommendation");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel phLabel = new JLabel("Soil pH:");
        phLabel.setBounds(20, 20, 80, 25);
        add(phLabel);

        phField = new JTextField();
        phField.setBounds(120, 20, 100, 25);
        add(phField);

        JLabel nitrogenLabel = new JLabel("Nitrogen (N):");
        nitrogenLabel.setBounds(20, 60, 100, 25);
        add(nitrogenLabel);

        nitrogenField = new JTextField();
        nitrogenField.setBounds(120, 60, 100, 25);
        add(nitrogenField);

        JLabel phosphorusLabel = new JLabel("Phosphorus (P):");
        phosphorusLabel.setBounds(20, 100, 120, 25);
        add(phosphorusLabel);

        phosphorusField = new JTextField();
        phosphorusField.setBounds(140, 100, 100, 25);
        add(phosphorusField);

        JLabel potassiumLabel = new JLabel("Potassium (K):");
        potassiumLabel.setBounds(20, 140, 120, 25);
        add(potassiumLabel);

        potassiumField = new JTextField();
        potassiumField.setBounds(140, 140, 100, 25);
        add(potassiumField);

        JButton recommendButton = new JButton("Get Recommendations");
        recommendButton.setBounds(20, 180, 200, 30);
        add(recommendButton);

        outputArea = new JTextArea();
        outputArea.setBounds(20, 220, 440, 100);
        add(outputArea);

        JButton exportButton = new JButton("Export Report");
        exportButton.setBounds(240, 180, 150, 30);
        add(exportButton);

        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double ph = Double.parseDouble(phField.getText());
                int n = Integer.parseInt(nitrogenField.getText());
                int p = Integer.parseInt(phosphorusField.getText());
                int k = Integer.parseInt(potassiumField.getText());

                String recommendation = RecommendationEngine.getRecommendation(ph, n, p, k);
                outputArea.setText(recommendation);
            }
        });

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportGenerator.exportReport(outputArea.getText());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SoilSenseApp().setVisible(true));
    }
}