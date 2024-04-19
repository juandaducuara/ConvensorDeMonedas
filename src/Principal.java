import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    private static String url="https://v6.exchangerate-api.com/v6/68484e380fb7e81622ce5d38/pair";
    private static String monedaInicial;
    private static String monedaFinal;
    private static String valorAConvertir;



    public static String getMonedaInicial() {
        return monedaInicial;
    }

    public static String getMonedaFinal() {
        return monedaFinal;
    }

    public static String getValorAConvertir() {
        return valorAConvertir;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();



        do {
            System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
            System.out.println("Elija la moneda desde la que quiere convertir");
            System.out.println("1 - ARS - Peso argentino");
            System.out.println("2 - BOB - Boliviano boliviano");
            System.out.println("3 - BRL - Real brasileño");
            System.out.println("4 - CLP - Peso chileno");
            System.out.println("5 - COP - Peso colombiano");
            System.out.println("6 - USD - Dólar estadounidense");
            System.out.println("9 - Salir del programa");
            System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
            var seleccionMonedaInicial = lectura.nextLine();
            if (seleccionMonedaInicial.equalsIgnoreCase("salir")|| seleccionMonedaInicial.equals("9")){
                System.out.println("Saliendo del programa");
                break;
            }
            switch (seleccionMonedaInicial.toUpperCase()){
                case "1":
                case "ARS":
                    monedaInicial="/ARS";
                    break;
                case "2":
                case "BOB":
                    monedaInicial="/BOB";
                    break;
                case "3":
                case "BRL":
                    monedaInicial="/BRL";
                    break;
                case "4":
                case "CLP":
                    monedaInicial="/CLP";
                    break;
                case "5":
                case "COP":
                    monedaInicial="/COP";
                    break;
                case "6":
                case "USD":
                    monedaInicial="/USD";
                    break;
                default:
                    System.out.println("XxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXx");
                    System.out.println("Seleccione una opcion correcta");
                    System.out.println("XxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXx");
                    break;
            }
            System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
            System.out.println("Elija la moneda desde a la que saber el valor");
            System.out.println("1 - ARS - Peso argentino");
            System.out.println("2 - BOB - Boliviano boliviano");
            System.out.println("3 - BRL - Real brasileño");
            System.out.println("4 - CLP - Peso chileno");
            System.out.println("5 - COP - Peso colombiano");
            System.out.println("6 - USD - Dólar estadounidense");
            System.out.println("9 - Salir del programa");
            System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
            var seleccionMonedaFinal = lectura.nextLine();
            switch (seleccionMonedaFinal.toUpperCase()){
                case "1":
                case "ARS":
                    monedaFinal="/ARS";
                    break;
                case "2":
                case "BOB":
                    monedaFinal="/BOB";
                    break;
                case "3":
                case "BRL":
                    monedaFinal="/BRL";
                    break;
                case "4":
                case "CLP":
                    monedaFinal="/CLP";
                    break;
                case "5":
                case "COP":
                    monedaFinal="/COP";
                    break;
                case "6":
                case "USD":
                    monedaFinal="/USD";
                    break;
                default:
                    System.out.println("XxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXx");
                    System.out.println("Seleccione una opcion correcta");
                    System.out.println("XxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXx");
                    break;
            }
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("Digite el valor que desea convertir: ");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            valorAConvertir= lectura.nextLine();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url+monedaInicial+monedaFinal+"/"+valorAConvertir))
                    .build();
            HttpResponse<String> reponse = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = reponse.body();

            MonedaOmdb monedasOmdb = gson.fromJson(json,MonedaOmdb.class);

            ValoresMonedas valoresMonedas = new ValoresMonedas(monedasOmdb);
            System.out.println("████████████████████████████");
            System.out.println(valorAConvertir+monedaInicial.replace("/","-") + " convirtiendo a "+monedaFinal.replace("/","->"));
            System.out.print(valoresMonedas + monedaFinal);
            System.out.println("\n████████████████████████████");


        }while (true);

    }
}
