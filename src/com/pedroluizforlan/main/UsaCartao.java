package com.pedroluizforlan.main;


import java.util.Scanner;

public class UsaCartao {

    public static void atualizarBandeira(CartaoCredito cartaoCredito, String bandeira) {
        cartaoCredito.setBandeira(bandeira);
        System.out.println("Nova bandeira do cartão: " + cartaoCredito.getBandeira());
    }

    public static void atualizarLimite(CartaoCredito cartaoCredito, double limiteNovo) {
        cartaoCredito.setLimite(limiteNovo);
        System.out.println("Novo limite do cartão: R$" + cartaoCredito.getLimite());
    }

    public static void comprar(CartaoCredito cartaoCredito, double valor) {
        cartaoCredito.addCompra(valor);
    }

    public static void pagar(CartaoCredito cartaoCredito, double valor) {
        cartaoCredito.addPagar(valor);
    }

    public static void consultar(CartaoCredito cartaoCredito) {
        System.out.println("Numero do cartão: " + cartaoCredito.getNumero() +
                        "\nBandeira do cartão: " + cartaoCredito.getBandeira() +
                        "\nSaldo do cartão: R$" + cartaoCredito.getSaldo() +
                        "\nBônus do cartão: R$" + cartaoCredito.getBonus() +
                        "\nLimite do cartão: R$" + cartaoCredito.getLimite() + "\n");
    }


    public static void main(String[] args) {
        CartaoCredito cartaoCredito = new CartaoCredito(1, 1000, "VISA");
        Scanner input = new Scanner(System.in);
        int opMenu = 0;

        while (opMenu != 9) {
            System.out.println("========Menu========\n" +
                    "Escolha uma das opções abaixo:\n" +
                    "1 - Atualizar bandeira\n" +
                    "2 - Atualizar limite\n" +
                    "3 - Comprar\n" +
                    "4 - Pagar\n" +
                    "5 – Consulta cartão (mostre o número do cartão, bandeira, saldo, bônus e limite)\n" +
                    "9 - Encerrar o programa"
            );
            opMenu = input.nextInt();

            switch (opMenu) {
                case 1:
                    System.out.println("Insira a nova bandeira: ");
                    String bandeira = input.next();
                    atualizarBandeira(cartaoCredito, bandeira);
                    break;
                case 2:
                    System.out.println("Insira o novo limite: ");
                    int limite = input.nextInt();
                    atualizarLimite(cartaoCredito, limite);
                    break;
                case 3:
                    System.out.println("Insira o valor da compra: ");
                    double compra = input.nextDouble();
                    comprar(cartaoCredito,compra);
                    break;
                case 4:
                    System.out.println("Insira o valor de pagamento: ");
                    double pagamento = input.nextDouble();
                    pagar(cartaoCredito,pagamento);
                    break;
                case 5:
                    System.out.println("Consultando cartão");
                    consultar(cartaoCredito);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Valor inválido");
                    break;
            }

        }
    }
}
