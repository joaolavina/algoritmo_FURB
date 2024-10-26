package model;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<T>();

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    public T pop () {
        T valor = peek();
        lista.retirar(valor);

        return valor;
    }

    public T peek () {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        NoLista<T> primeiro = lista.getPrimeiro();

        return primeiro.getInfo();
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    public void liberar () {
        while (!estaVazia()) {
            pop();
        }
    }

    public String toString() {
        return lista.toString();
    }
}