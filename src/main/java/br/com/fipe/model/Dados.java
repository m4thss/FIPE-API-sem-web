package br.com.fipe.model;

public record Dados(String codigo, String nome) {

    @Override
    public String toString() {
        return "codigo = " + codigo +
                "\n" + "nome = " + nome + "\n";
    }
}
