package model;

public class ListaEstatica {

    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        liberar();
    }

    private void redimensionar() {
        int[] provisorio = new int[tamanho + 10];

        int index = 0;
        for (int i : info) {
            provisorio[index] = i;
            index++;
        }

        info = provisorio;
    }

    public void inserir(int valor) {
        if (info.length == tamanho) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(int valor) {

        for (int i = 0; i < tamanho; i++) {
            if (i == valor) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        if (buscar(valor) > -1) {
            for (int i = buscar(valor); i < tamanho; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        info = new int[10];
        tamanho = 0;
    }

    public int obterElemento(int posicao) throws IndexOutOfBoundsException {

        if (tamanho < posicao || posicao < 0)
            throw new IndexOutOfBoundsException();

        return info[posicao];
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
            if(i > 0){
                arrayString += ",";
            }
            arrayString += info[i];
        }

        return arrayString;
    }
}
