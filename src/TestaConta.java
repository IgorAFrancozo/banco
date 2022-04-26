import java.time.LocalDate;
import java.time.Month;

public class TestaConta {
    public static void main(String[] args) {
        LocalDate dataNascimento = LocalDate.of(1993, Month.JULY, 01);
        Cliente cliente = new Cliente("Igor", "123123", dataNascimento, new Endereco());
        Conta contaCorrente = new Conta(cliente, "054", "15975-9", "Conta Corrente");
        contaCorrente.depositar(100);

        double rendimentoAbril = contaCorrente.calcularRendimentoMensal(0.1);
        System.out.println("O rendimento de abril é: " + rendimentoAbril);

        System.out.println(contaCorrente);

        Conta contaPoupanca = new Conta(cliente, "0012", "95184-8", "Conta Poupança");
        contaPoupanca.depositar(200);
        System.out.println(Conta.getTotalDeContas());
    }
}