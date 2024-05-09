package com.pedroluizforlan.main;

public class CartaoCredito {
    private int numero;
    private double saldo;
    private double limite;
    private double bonus;
    private String bandeira;

    public CartaoCredito(int numero, double limite, String bandeira) {
        this.numero = numero;
        this.limite = limite;
        this.bandeira = bandeira;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        if (limite > 0 && limite >= saldo) {
            this.limite = limite;
        } else {
            System.out.println("Limite não pode ser menor que 0 ou menor que o saldo atual");
        }
    }

    public double getBonus() {
        return bonus;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        if (!bandeira.isBlank()) {
            this.bandeira = bandeira.trim();
        }
    }

    public void addCompra(double valor) {
        double compra = valor + saldo;
        if (compra <= limite) {
            this.saldo += valor;
            creditaBonus(valor * 0.03);
            System.out.println("Compra no valor de R$" + valor + " realizada! ");
        } else {
            System.out.println("Valor da compra supera o limite da conta");
        }
    }

    public void addPagar(double valor) {
        if (valor > saldo) {
            System.out.println("Valor mais alto que o saldo");
        } else {
            this.saldo -= valor;
            creditaBonus(valor * 0.02);
            System.out.println("Novo saldo R$ " + saldo);
        }
    }

    private void creditaBonus(double valor) {
        this.bonus += valor;
    }

}
