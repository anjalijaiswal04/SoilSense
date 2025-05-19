package com.soilsense;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ReportGenerator {
    public static void exportReport(String content) {
        try {
            String fileName = "Soil_Report_" + LocalDate.now() + ".txt";
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Report saved as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}