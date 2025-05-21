package client;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.ConversionRateResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ExchangeRateClient {

    private final String apiKey = ApiKeyProvider.getApiKey();
    private final String baseUrl = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient client;
    private final Gson gson;

    public ExchangeRateClient(){
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
    }

    public ConversionRateResponse getExchangeRate(String sourceCurrency, String targetCurrency, double amount) {
        String url = this.baseUrl + this.apiKey + "/pair/" + sourceCurrency + "/" + targetCurrency + "/" + amount;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        try {
            if(amount < 0){
                throw  new RuntimeException("Não é possível converter valores negativos.");
            }

            HttpResponse<String> response = client.
                    send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro na API: status " + response.statusCode());
            }

            return gson.fromJson(response.body(), ConversionRateResponse.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível realizar conversão, tente mais tarde" + e.getMessage(),e);
        }

    }

}
