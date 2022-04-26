public class App {
    public static void main(String[] args) throws Exception {
        // Conta

        Conta conta = new Conta();
        conta.ativa(true);
        conta.limite(500);
        conta.tipo("Conta-Corrente");
        conta.numero("159753");
        conta.agencia("111");
        conta.depositar(10);

        Conta novaConta = new Conta();
        novaConta.agencia("222");
        novaConta.numero("951951");
        novaConta.tipo("Poupança");
        novaConta.limite(1000);
        novaConta.ativa(true);
        novaConta.depositar(5);
        
        conta.pix(60, novaConta);
        System.out.println("Saldo na conta é igual a: " + conta.saldo);
        System.out.println("Saldo na nova conta é igual a: " + novaConta.saldo);

        System.out.println("Você possui: " + conta.saldo);
        conta.sacar(15);
        System.out.println("Saldo: " + conta.saldo);

        // Cliente

        Cliente cliente = new Cliente();
        cliente.nomeCompleto = "Igor Françozo";
        cliente.cpf = "20202020";
        cliente.dataNascimento = "01/07/93";

        // Endereço

        Endereco endereco = new Endereco();
        endereco.rua = "Rua Receba";
        endereco.bairro = "VidaLoka";
        endereco.numero = "12A";
        endereco.cep = "79500-93";

        cliente.endereco = endereco;

        conta.cliente = cliente;

        System.out.println("Nome: " + conta.cliente.nomeCompleto);
        System.out.println("Rua: " + conta.cliente.endereco.rua);
        System.out.println("Bairro: " + conta.cliente.endereco.bairro);
        System.out.println("Número: " + conta.cliente.endereco.numero);
        System.out.println("CEP: " + conta.cliente.endereco.cep);
        System.out.println("Dados Bancários:");
        System.out.println("Saldo: " + String.format("%.2f", conta.saldo) + " Reais");
    }
}
