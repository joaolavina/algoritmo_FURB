package model;

public class PilhaVetor<T> implements Pilha<T> {

    private Object[] info;

    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.limite = limite;
        info = new Object[limite];
        tamanho = 0;
    }

    @Override
    public void push(T info) {
        if (limite == tamanho)
            throw new PilhaCheiaException();

        this.info[tamanho] = info;
        tamanho++;
    }

    @Override
    public T pop() {
        T valor = peek();

        info[tamanho-1] = null;
        tamanho--;

        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia())
            throw new PilhaVaziaException();

        return (T) info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        if (info[0] == null)
            return true;

        return false;
    }

    @Override
    public void liberar() {
        try {
            while (true) {
                pop();
            }
        } catch (PilhaVaziaException e) {

        }
    }

    @Override
    public String toString() {
        String listaString = "";

        for (int i = tamanho-1; i >= 0; i--) {
            listaString += info[i].toString();
            if (i > 0)
                listaString += ",";
        }

        return listaString;
    }

    public void concatenar(PilhaVetor<T> p) {
        if(this.tamanho + p.tamanho > this.limite)
            throw new RuntimeException("Não há espaço para empilhar todos os dados");

        for (int i = 0; i < p.tamanho; i++) {
            this.push((T) p.info[i]);
        }
    }
}
