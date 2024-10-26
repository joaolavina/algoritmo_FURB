package model;

public class ListaEstatica<T> {

    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        liberar();
    }

    private void redimensionar() {
        Object[] provisorio = new Object[tamanho + 10];

        int index = 0;
        for (Object i : info) {
            provisorio[index] = i;
            index++;
        }

        info = provisorio;
    }

    public void inserir(T valor) {
        if (info.length == tamanho) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void inserir(int posicao, T valor) {
        if (posicao < 0 || posicao > tamanho + 1) {
            throw new IndexOutOfBoundsException();
        } else if (posicao > tamanho){
            posicao--;
        }
        
        if (info.length == tamanho) {
            redimensionar();
        }

        for (int i = posicao; i <= tamanho+1; i++) {
            T reserva = (T) info[i];
            info[i] = valor;
            valor = reserva;
        }
        
        tamanho++;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(T valor) {

        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int posicao = buscar(valor);
        if (posicao > -1) {
            info[posicao] = null;

            for (int i = posicao; i < tamanho; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        info = new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int posicao) throws IndexOutOfBoundsException {

        if (tamanho < posicao || posicao < 0)
            throw new IndexOutOfBoundsException();

        return (T) info[posicao];
    }

    public void inverter() {
        // for (int i = 1; i <= tamanho; i++) {
        // T a = (T) info[tamanho-i];
        // retirar(a);
        // inserir(a);
        // }

        for (int i = 0; i < (tamanho / 2); i++) {
            Object variavel = info[i];
            info[i] = info[tamanho - 1 - i];
            info[tamanho - 1 - i] = variavel;
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String arrayString = "";

        for (int i = 0; i < tamanho; i++) {
            if (i > 0)
                arrayString += ",";

            arrayString += info[i].toString();
        }

        return arrayString;
    }
}
