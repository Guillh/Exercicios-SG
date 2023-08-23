import java.math.BigDecimal;

public class CaixaEletronico {
    public int numero = 0;
    public BigDecimal sacado;
    private BigDecimal saldo;
    private String nome;
    private final String[] cedulas = {"200", "100", "50", "20", "10", "5", "2", "1", "0.5", "0.25", "0.1", "0.05", "0.01"};
    private final int[] quantidadeCedulas = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    private final int[] cedulasRestantes = {8,6,4,2,6,4,8,4,20,32,65,24,73};

    public CaixaEletronico(String nome, String saldo) {
        this.setNome(nome);
        this.setSaldo(new BigDecimal(saldo));
    }

    public void sacar(BigDecimal quantidade) {
        if (quantidade.compareTo(new BigDecimal(String.valueOf(this.saldo))) > 0) {
            System.out.println("Saldo insuficiente para saque!");

        } else {
            this.setSaldo(this.getSaldo().subtract(quantidade));
            this.setSacado(quantidade);
            System.out.println("Saque realizado com sucesso!");
        }
    }

    public void contadorDeCedulas() {
        for (numero = 0; this.getSacado().compareTo(new BigDecimal("0")) > 0;) {
            if (this.getSacado().compareTo(new BigDecimal(this.cedulas[numero])) >= 0 ) {
                if (this.getCedulasRestantes(numero) == 0){

                }
                this.setSacado( this.getSacado().subtract(new BigDecimal(this.getCedulas(numero))));
                quantidadeCedulas[numero] += 1;
            } else {
                numero += 1;
            }
        }

        System.out.println("200 : " +  this.quantidadeCedulas[0]);
        System.out.println("100 : " +  this.quantidadeCedulas[1]);
        System.out.println("50  : " +  this.quantidadeCedulas[2]);
        System.out.println("20  : " +  this.quantidadeCedulas[3]);
        System.out.println("10  : " +  this.quantidadeCedulas[4]);
        System.out.println("5   : " +  this.quantidadeCedulas[5]);
        System.out.println("2   : " +  this.quantidadeCedulas[6]);
        System.out.println("1   : " +  this.quantidadeCedulas[7]);
        System.out.println("0.50: " +  this.quantidadeCedulas[8]);
        System.out.println("0.25: " +  this.quantidadeCedulas[9]);
        System.out.println("0.10: " +  this.quantidadeCedulas[10]);
        System.out.println("0.05: " +  this.quantidadeCedulas[11]);
        System.out.println("0.01: " +  this.quantidadeCedulas[12]);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSacado() {
        return sacado;
    }
    public void setSacado(BigDecimal sacado) {
        this.sacado = sacado;//.setScale(2,BigDecimal.ROUND_HALF_EVEN);
    }

    public String getCedulas(int numero) {
        return cedulas[numero];
    }

    public int getCedulasRestantes(int numero) {
        return cedulasRestantes[numero];
    }
}
