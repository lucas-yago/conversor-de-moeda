import client.ExchangeRateClient;
import model.ConversionRateResponse;
import model.Menu;
import service.ConversionHistorySaver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        ConversionHistorySaver conversionsHistory = new ConversionHistorySaver();
        ExchangeRateClient exchangeRateClient = new ExchangeRateClient();
        List<ConversionRateResponse> conversions = new ArrayList<>();

        int selectedOption;

        while (true) {
            menu.showMenu();
            selectedOption = scanner.nextInt();

            if (selectedOption == 9) {
                System.out.println("Conversor finalizado!");
                break;
            }

            try {
                String[] menuOption = menu.selectMenuOption(selectedOption);

                System.out.println("Digite o valor que deseja converter:");
                double amount = scanner.nextDouble();

                ConversionRateResponse request = exchangeRateClient.getExchangeRate(menuOption[0], menuOption[1], amount);
                System.out.printf("Valor %S [%s] corresponde ao valor final de => %.2f [%s]%n \n", amount, request.baseCode(), request.conversionResult(), request.targetCode());

                conversions.add(request);

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        }
        scanner.close();
        conversionsHistory.saveConversionToFile(conversions);
    }

}