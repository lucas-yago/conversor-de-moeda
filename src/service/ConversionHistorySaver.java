package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.ConversionRateResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConversionHistorySaver {
    private final Gson gson;

    public ConversionHistorySaver() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void saveConversionToFile(List<ConversionRateResponse> conversions) {
        try {
            FileWriter conversionHistory = new FileWriter("conversionHistory.json");
            conversionHistory.write(gson.toJson(conversions));
            conversionHistory.close();
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível salvar o arquivo. tente novamente!");
        }
    }
}
