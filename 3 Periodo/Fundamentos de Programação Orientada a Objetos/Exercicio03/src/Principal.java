import Exercicio03.ContaCorrente;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("Alysson Jose de Franca Ferreira", "123.456.789-10", "123456");

        System.out.println(conta.toString());
        // Output: Titular: Alysson Jose de Franca Ferreira [123.456.789-10]
        //         Ag: 1234 Cc: 1234567
        //         Saldo atual: 0.0

        conta.depositar(500.0);
        conta.sacar(100.0);
        conta.transferir("1234", 1234567, 200.0);
        conta.transferirPix("alyssonjfranca@gmail.com", 25.0);

        ArrayList<String> extrato = conta.getExtrato();
        for (String lancamento : extrato) {
            System.out.println(lancamento);
        }

    }
}