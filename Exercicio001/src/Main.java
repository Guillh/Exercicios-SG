import java.util.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CaixaEletronico c1 = new CaixaEletronico("Jose");
        Saque saque = new Saque("9999999999999999");

        System.out.println("Qual o valor que voce deseja sacar?");
        saque.sacar(new BigDecimal(teclado.nextLine()));
        if (saque.getStatus()) {
            saque.contadorDeCedulas();
        }
    }
}