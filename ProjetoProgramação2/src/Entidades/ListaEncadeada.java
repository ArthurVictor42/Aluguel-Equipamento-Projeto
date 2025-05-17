package Entidades;

import java.util.ArrayList;
import java.util.List;

// Lista encadeada genérica
public class ListaEncadeada<T> {
    private No<T> inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }

    // Inserir no início
    public void inserirInicio(T valor) {
        No<T> novo = new No<>(valor);
        novo.proximo = inicio;
        inicio = novo;
    }

    // Inserir no fim
    public void inserirFim(T valor) {
        No<T> novo = new No<>(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    // Remover valor (primeira ocorrência)
    public void remover(T valor) {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        if (inicio.dado.equals(valor)) {
            inicio = inicio.proximo;
            return;
        }

        No<T> atual = inicio;
        while (atual.proximo != null && !atual.proximo.dado.equals(valor)) {
            atual = atual.proximo;
        }

        if (atual.proximo != null) {
            atual.proximo = atual.proximo.proximo;
        } else {
            System.out.println("Valor não encontrado na lista.");
        }
    }

    public List<T> exibir() {
        List<T> elementos = new ArrayList<>();

        No<T> atual = inicio;
        while (atual != null) {
            elementos.add(atual.dado);
            atual = atual.proximo;
        }

        return elementos;
    }

    public No<T> getInicio() {
        return inicio;
    }
}
