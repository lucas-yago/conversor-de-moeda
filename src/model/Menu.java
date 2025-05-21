package model;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private final HashMap<Integer, String[]> currencyCodeMap = new HashMap<>(Map.of(
            1, new String[]{"USD", "ARS"},
            2, new String[]{"ARS", "USD"},
            3, new String[]{"USD", "BRL"},
            4, new String[]{"BRL", "USD"},
            5, new String[]{"USD", "COP"},
            6, new String[]{"COP", "USD"},
            7, new String[]{"USD", "CLP"},
            8, new String[]{"CLP", "USD"}
    ));

    public void showMenu() {
        System.out.println("""
                *******************************************
                Seja bem-vindo/a ao Conversor de Moeda =]
                
                1) Dólar => Peso argentino \s
                2) Peso argentino => Dólar \s
                3) Dólar => Real brasileiro \s
                4) Real brasileiro => Dólar \s
                5) Dólar => Peso colombiano \s
                6) Peso colombiano => Dólar \s
                7) Dólar => Peso chileno \s
                8) Peso chileno => Dólar \s
                9) Sair
                
                Escolha uma opção válida:
                *******************************************
                """);
    }

    public String[] selectMenuOption(int menuOption) {
        if (!currencyCodeMap.containsKey(menuOption)) {
            throw new IllegalArgumentException("""
        A opção de conversão selecionada é inexistente.
        O conversor será finalizado!
        """);
        }
        return currencyCodeMap.get(menuOption);
    }

}
