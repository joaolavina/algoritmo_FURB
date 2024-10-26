package model;

public class FilaVetor<T> implements Fila<T> {

    private Object[] info;

    public int limite;
    public int tamanho;
    public int inicio;

    public FilaVetor(int limite) {
        info = new Object[limite];
        this.limite = limite;
        tamanho = 0;
        inicio = 0;
    }

    @Override
    public void inserir(Object valor) {
        if (tamanho == limite)
            throw new FilhaCheiaException();

        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        if (info[inicio] == null)
            return true;

        return false;
    }

    @Override
    public T peek() {
        if (estaVazia())
            throw new FilaVaziaException();

        return (T) info[inicio];
    }

    @Override
    public T retirar() {
        Object valor = peek();

        info[inicio] = null;

        inicio = (inicio + 1) % limite;
        tamanho--;
        return (T) valor;
    }

    @Override
    public void liberar() {
        try {
            while (true) {
                retirar();
            }
        } catch (FilaVaziaException e) {

        }
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(this.limite + f2.limite);

        for (int i = 0; i < tamanho; i++) {
            f3.inserir((T) this.info[(this.inicio + i) % this.limite]);
        }

        for (int i = 0; i < f2.tamanho; i++) {
            f3.inserir((T) f2.info[(f2.inicio + i) % f2.limite]);
        }

        return f3;
    }

    @Override
    public String toString() {
        String stringFila = "";

        int indice = inicio;
        for (int i = 0; i < tamanho; i++) {
            if (i > 0)
                stringFila += ",";

            stringFila += info[indice];
            indice = (indice + 1) % limite;
        }

        return stringFila;
    }

    public int getLimite() {
        return limite;
    }

    public void encolher() {
        Object[] vetor = new Object[tamanho];

        int indice = inicio;
        for (int i = 0; i < tamanho; i++) {
            if(info[indice] != null)
                vetor[i] = info[indice];

            indice = (indice + 1) % limite;
        }

        inicio = 0;
        limite = tamanho;
        info = vetor;
    }
}; 