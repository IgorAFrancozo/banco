import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conta {

        private double saldo;
        private double limite;
        private String tipo;
        private String agencia;
        private LocalDateTime dataAbertura;
        private String numero;
        private boolean ativa;
        private Cliente cliente;
        private static int contador;

        Conta(Cliente cliente, String agencia, String numero, String tipo) {
                this.cliente = cliente;
                this.agencia = agencia;
                this.numero = numero;
                this.tipo = tipo;
                this.saldo = 0;
                this.ativa = true;
                this.dataAbertura = LocalDateTime.now();
                Conta.contador++;
        }
        // outros atributo

        Boolean sacar(double quantidade) {
                double novoSaldo = this.saldo - quantidade;
                if (novoSaldo >= 0) {
                        this.saldo = novoSaldo;
                        return true;
                } else {
                        System.out.println("Saldo insuficiente!");
                        return false;
                }
        }

        void depositar(double quantidade) {
                if (quantidade <= 0) {
                        System.out.println("Valor inválido!");
                } else {
                        this.saldo += quantidade;
                }
        }

        void pix(double valorPIX, Conta contaDestino) {
                if (this.sacar(valorPIX)) {
                        contaDestino.depositar(valorPIX);
                } else {
                        System.out.println("Saldo Insuficiente!");
                }
        }

        void agencia(String agencia) {
                String nAgencia = this.agencia;
                this.agencia = nAgencia;
        }

        void numero(String numero) {
                String nNumero = this.numero;
                this.numero = nNumero;
        }

        void tipo(String tipo) {
                String nTipo = this.tipo;
                this.tipo = nTipo;
        }

        void limite(double limite) {
                double nLimite = this.limite;
                this.limite = nLimite;

        }

        void ativa(boolean ativa) {
                boolean tipoConta = this.ativa;
                this.ativa = tipoConta;
        }

        double calcularRendimentoMensal(double taxa) {
                return this.saldo * taxa;
        }

        public void aumentarLimite(double valor) {
                this.limite += valor;
        }
        public static int getTotalDeContas(){
                return Conta.contador;
        }

        public String getAgencia() {
                return agencia;
        }

        public Cliente getCliente() {
                return cliente;
        }

        public LocalDateTime getDataAbertura() {
                return dataAbertura;
        }

        public double getLimite() {
                return limite;
        }

        public String getNumero() {
                return numero;
        }

        public double getSaldo() {
                return saldo + this.getLimite();
        }

        public String getTipo() {
                return tipo;
        }

        public boolean isAtiva() {
                return ativa;
        }

        @Override
        public String toString() {
                return "Nome do titular: " + this.cliente + "\n" +
                                "Agencia: " + this.agencia + "\n" +
                                "Conta-Corrente: " + this.numero + "\n" +
                                "Data de abertura: "
                                + this.dataAbertura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy G")) + "\n" +
                                "Saldo: " + String.format("%.2f", this.saldo);

        }
}