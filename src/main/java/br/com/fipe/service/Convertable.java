package br.com.fipe.service;

import java.util.List;

public interface Convertable {

    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
