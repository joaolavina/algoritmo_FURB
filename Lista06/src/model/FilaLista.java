package model;

public class FilaLista<T> implements Fila<T> {

    ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (estaVazia())
            throw new FilaVaziaException();

        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public void liberar() {
        try {
            while (true) {
                this.retirar();
            }
        } catch (FilaVaziaException e) {

        }
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}