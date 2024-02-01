package br.com.fipe.model;

public class Veiculo {
    private String valor;
    private String marca;
    private Integer ano;
    private String modelo;

    public Veiculo(DadosVeiculo dados) {
        this.valor = dados.Valor();
        this.marca = dados.Marca();
        this.ano = dados.ano();
        this.modelo = dados.Modelo();
    }

    @Override
    public String toString() {
        return "Modelo: " + marca + ", " + modelo
                + " - " + ano + "\n"
                + "Valor: " + valor;
    }
}

