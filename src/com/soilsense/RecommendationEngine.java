package com.soilsense;

public class RecommendationEngine {
    public static String getRecommendation(double ph, int n, int p, int k) {
        String crop = "Unknown";
        String fertilizer = "General purpose NPK (10:10:10)";

        if (ph >= 6.0 && ph <= 7.0) {
            crop = "Wheat or Maize";
        } else if (ph < 6.0) {
            crop = "Rice or Potato";
        } else {
            crop = "Millet or Barley";
        }

        if (n < 50 || p < 30 || k < 30) {
            fertilizer = "Urea + DAP with Potash supplement";
        } else if (n > 80 && p > 60 && k > 60) {
            fertilizer = "Low-nitrogen blend like 5:10:10";
        }

        return "Recommended Crop: " + crop + "\nRecommended Fertilizer: " + fertilizer;
    }
}