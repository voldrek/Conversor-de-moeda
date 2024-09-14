import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);

        // Exibe opções para a moeda de origem
        System.out.println("Escolha a moeda de origem:");
        System.out.println("1) Dólar Americano (USD)");
        System.out.println("2) Real Brasileiro (BRL)");
        System.out.println("3) Euro (EUR)");
        System.out.println("4) Libra Esterlina (GBP)");
        System.out.println("5) Iene Japonês (JPY)");
        System.out.println("6) Dólar Canadense (CAD)");
        System.out.println("7) Franco Suíço (CHF)");
        int opcaoOrigem = input.nextInt();

        // Determina o código da moeda de origem com base na escolha
        String moedaOrigem = getCodigoMoeda(opcaoOrigem);
        if (moedaOrigem == null) {
            System.out.println("Opção inválida para a moeda de origem!");
            return;
        }
        String nomeMoedaOrigem = getNomeMoeda(moedaOrigem);

        // Exibe opções para a moeda de destino
        System.out.println("Escolha a moeda de destino:");
        System.out.println("1) Dólar Americano (USD)");
        System.out.println("2) Real Brasileiro (BRL)");
        System.out.println("3) Euro (EUR)");
        System.out.println("4) Libra Esterlina (GBP)");
        System.out.println("5) Iene Japonês (JPY)");
        System.out.println("6) Dólar Canadense (CAD)");
        System.out.println("7) Franco Suíço (CHF)");
        int opcaoDestino = input.nextInt();

        // Determina o código da moeda de destino com base na escolha
        String moedaDestino = getCodigoMoeda(opcaoDestino);
        if (moedaDestino == null) {
            System.out.println("Opção inválida para a moeda de destino!");
            return;
        }
        String nomeMoedaDestino = getNomeMoeda(moedaDestino);

        // Solicita o valor a ser convertido
        System.out.println("Digite o valor a ser convertido: ");
        double valor = input.nextDouble();

        // Exibe os nomes oficiais das moedas
        System.out.println("Convertendo " + valor + " de " + nomeMoedaOrigem + " para " + nomeMoedaDestino);

        // Faz a requisição para a API com a moeda de origem
        String apiUrl = "https://v6.exchangerate-api.com/v6/734e179cc5fc7a18f94edd3f/latest/" + moedaOrigem;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);

        // Obtém a taxa de conversão da moeda de destino
        double taxaConversao = apiResponse.conversion_rates.getTaxa(moedaDestino);

        // Calcula o valor convertido
        double valorConvertido = valor * taxaConversao;

        // Exibe o valor convertido
        System.out.println("Valor convertido: " + valorConvertido + " " + nomeMoedaDestino);
    }

    // Método para obter o código da moeda com base na escolha do usuário
    public static String getCodigoMoeda(int opcao) {
        switch (opcao) {
            case 1:
                return "USD";
            case 2:
                return "BRL";
            case 3:
                return "EUR";
            case 4:
                return "GBP";
            case 5:
                return "JPY";
            case 6:
                return "CAD";
            case 7:
                return "CHF";
            default:
                return null;  // Retorna nulo se a opção for inválida
        }
    }

    // Método para obter o nome oficial da moeda
    public static String getNomeMoeda(String codigoMoeda) {
        switch (codigoMoeda) {
            case "USD":
                return "Dólar Americano";
            case "BRL":
                return "Real Brasileiro";
            case "EUR":
                return "Euro";
            case "GBP":
                return "Libra Esterlina";
            case "JPY":
                return "Iene Japonês";
            case "CAD":
                return "Dólar Canadense";
            case "CHF":
                return "Franco Suíço";
            default:
                return "Moeda Desconhecida";
        }
    }
}

// Classes para deserializar o JSON
class ApiResponse {
    String result;
    ConversionRates conversion_rates;
}

class ConversionRates {
    double USD;
    double EUR;
    double BRL;
    double GBP;
    double JPY;
    double CAD;
    double CHF;

    public double getTaxa(String moeda) {
        switch (moeda) {
            case "USD":
                return USD;
            case "EUR":
                return EUR;
            case "BRL":
                return BRL;
            case "GBP":
                return GBP;
            case "JPY":
                return JPY;
            case "CAD":
                return CAD;
            case "CHF":
                return CHF;
            default:
                return 0;
        }
    }
}
