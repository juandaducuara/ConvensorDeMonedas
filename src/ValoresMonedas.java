import com.google.gson.annotations.SerializedName;

public class ValoresMonedas {
    private double valorBase;
    private double valorFinal;

    public ValoresMonedas(MonedaOmdb monedasOmdb) {
        this.valorBase =monedasOmdb.conversion_rate();
        this.valorFinal=monedasOmdb.conversion_result();
    }


    @Override
    public String toString() {
        return  "Valor moneda actual: " + valorBase+
                "\nValor convertido: " + valorFinal
                ;
    }
}
