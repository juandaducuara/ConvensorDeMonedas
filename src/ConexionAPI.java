import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionAPI {
    private String url="https://v6.exchangerate-api.com/v6/68484e380fb7e81622ce5d38/pair";
    private String monedaInicial;
    private String monedaFinal;
    private String valorAConvertir;



    public void setMonedaInicial(String monedaInicial) {
        this.monedaInicial = monedaInicial;
    }

    public void setMonedaFinal(String monedaFinal) {
        this.monedaFinal = monedaFinal;
    }

    public void setValorAConvertir(String valorAConvertir) {
        this.valorAConvertir = valorAConvertir;
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public String getValorAConvertir() {
        return valorAConvertir;
    }

    public ConexionAPI(String monedaInicial, String monedaFinal, String valorAConvertir) {
        this.monedaInicial = monedaInicial;
        this.monedaFinal = monedaFinal;
        this.valorAConvertir = valorAConvertir;
    }

    /*public ValoresMonedas conexion() throws IOException, InterruptedException {


        return valoresMonedas;
    }*/
}
