import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        CaixaEletronico c1 = new CaixaEletronico("Jose","2000");
        c1.sacar(BigDecimal.valueOf(1964.12F));
        c1.contadorDeCedulas();
    }
}