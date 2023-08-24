import java.math.BigDecimal;

public class Saque {
    public int numero = 0;
    public BigDecimal sacado;
    public String mensagemSistema;
    private  BigDecimal saldoCaixa;
    private BigDecimal saldo;
    private final String[] cedulas = {"200", "100", "50", "20", "10", "5", "2", "1", "0.5", "0.25", "0.1", "0.05", "0.01"};
    private final int[] quantidadeCedulas = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    private final int[] cedulasRestantes = /*{7,6,4,2,6,4,1,4,20,32,65,24,73};*//*{1,1,1,1,1,1,1,1,1,1,1,1,1};*/{1,1,1,0,0,0,0,0,0,0,0,0,0};
    private boolean status;

    public Saque(String saldo){
        this.setSaldo(new BigDecimal(saldo));
    }

    public void sacar(BigDecimal quantidade) {
        this.verificarDinheiro(quantidade);
        if (this.getStatus()){
            this.verificarCedulasSaque(quantidade);
        }
        if (this.getStatus()) {
            if (quantidade.compareTo(this.getSaldo()) > 0) {
                System.out.println("Saldo insuficiente para saque!");
            } else {
                this.setSaldo(this.getSaldo().subtract(quantidade));
                this.setSacado(quantidade);
                System.out.println("Saque realizado com sucesso!");
            }
        } else {
            System.out.println(this.getMensagemSistema());
        }
    }public void verificarDinheiro(BigDecimal valorSaque) {
        BigDecimal total = BigDecimal.valueOf(0);
        int quantidade = 0;
        for (int i = 0; i < 12; i++ ) {
            total = total.add(new BigDecimal(this.getCedulas(i)).multiply(new BigDecimal(this.getCedulasRestantes(i))));

        }
        if (total.compareTo(valorSaque) >= 0){
            this.setStatus(true);
            this.setSaldoCaixa(total);
        } else {
            this.setStatus(false);
            this.setMensagem("Saldo em caixa insuficiente para saque!");
        }


    }
    public void verificarCedulasSaque(BigDecimal valorSaque) {
        BigDecimal verificarCedulasSaque = valorSaque;
        for (int i = 0;i < 12 ;) {
            if (new BigDecimal(this.getCedulasRestantes(i)).compareTo(new BigDecimal("0")) == 0){
                i++;
            } else if (new BigDecimal(this.getCedulas(i)).compareTo(verificarCedulasSaque) <= 0) {
                verificarCedulasSaque = verificarCedulasSaque.subtract(new BigDecimal(this.getCedulas(i)));
            } else {
                i++;
            }
        }

        if (verificarCedulasSaque.compareTo(new BigDecimal("0")) != 0) {
            this.setStatus(false);
            this.setMensagem("Cedulas insuficientes para o saque exigido!");
        }
    }
    public void contadorDeCedulas() {
        for (numero = 0; this.getSacado().compareTo(new BigDecimal("0")) > 0;) {
            if (this.getSacado().compareTo(new BigDecimal(this.cedulas[numero])) >= 0) {
                if (this.getCedulasRestantes(numero) == 0){
                    numero++;
                }
                this.setSacado( this.getSacado().subtract(new BigDecimal(this.getCedulas(numero))));
                quantidadeCedulas[numero]++;
                cedulasRestantes[numero]--;

            } else {
                numero++;
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

    public BigDecimal getSaldoCaixa() {
        return saldoCaixa;
    }

    public void setSaldoCaixa(BigDecimal saldoCaixa) {
        this.saldoCaixa = saldoCaixa;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }public BigDecimal getSacado() {
    return sacado;
}
    public void setSacado(BigDecimal sacado) {
        this.sacado = sacado;//.setScale(2,BigDecimal.ROUND_HALF_EVEN);
    }

    public String getCedulas(int numero) {
        return cedulas[numero];
    }
    public int setCedulasRestantes(int quantidade) {
        return this.cedulasRestantes[numero] = quantidade;    }
    public int getCedulasRestantes(int numero) {
        return cedulasRestantes[numero];
    }

    public String getMensagemSistema() {
        return mensagemSistema;
    }
    public String setMensagem(String mensagem){
        return mensagemSistema = mensagem;
    }
}
