import java.util.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CaixaEletronico c1 = new CaixaEletronico("Jose","2000");

        System.out.println("Qual o valor que voce deseja sacar?");
        c1.sacar(new BigDecimal(teclado.nextLine()));
        c1.contadorDeCedulas();

    }
}