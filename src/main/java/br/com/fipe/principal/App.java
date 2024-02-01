package br.com.fipe.principal;

import br.com.fipe.model.Dados;
import br.com.fipe.model.DadosVeiculo;
import br.com.fipe.model.Modelos;
import br.com.fipe.model.Veiculo;
import br.com.fipe.service.ConsumoApi;
import br.com.fipe.service.ConversorDados;

import java.util.Comparator;
import java.util.Scanner;

public class App {
    private final String URL = "https://parallelum.com.br/fipe/api/v1/";

    private final ConsumoApi consumo = new ConsumoApi();
    private final Scanner scanner = new Scanner(System.in);
    private final ConversorDados conversor = new ConversorDados();

    public void menu(){
        System.out.println("Qual tipo de veículo gostaria de pesquisar?");
        String opcao = scanner.nextLine();
        String endereco = URL;

        if (opcao.toLowerCase().contains("carr")){
            endereco += "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco += "motos/marcas";
        } else {
            endereco += "caminhoes/marcas";
        }
        String dados = consumo.obterDados(endereco);

        var listaMarcas = conversor.obterLista(dados, Dados.class);
        listaMarcas.stream()
                        .sorted(Comparator.comparing(Dados::codigo))
                        .forEach(System.out::println);

        System.out.println("Informe o codigo para exibir informações do modelo: ");
        opcao = scanner.nextLine();

        endereco += "/" + opcao + "/modelos";

        dados = consumo.obterDados(endereco);
        var listaModelos = conversor.obterDados(dados, Modelos.class);

        listaModelos.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o codigo para exibir anos disponíveis para o veículo selecionado previamente: ");
        opcao = scanner.nextLine();

        endereco += "/" + opcao + "/anos";

        dados = consumo.obterDados(endereco);

        var listaAnos = conversor.obterLista(dados, Dados.class);
        listaAnos.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        listaAnos.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Por fim, informe o codigo do veículo no qual deseja informações: ");
        opcao = scanner.nextLine();

        endereco += "/" + opcao;

        dados = consumo.obterDados(endereco);
        var json = conversor.obterDados(dados, DadosVeiculo.class);
        Veiculo veiculo = new Veiculo(json);
        System.out.println(veiculo);
    }


}
