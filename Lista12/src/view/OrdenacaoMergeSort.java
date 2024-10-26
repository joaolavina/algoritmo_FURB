package view;
public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public T[] info;

    @Override
    public void ordenar() {
        info = super.getInfo();
        mergeSorte(0, info.length-1);
    }

    private void mergeSorte(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSorte(inicio, meio);
            mergeSorte(meio + 1, fim);
            merge(inicio, meio, fim);
        }
    }

    private void merge(int inicio, int meio, int fim) {

        // cria e preenche o array com os dados que estão a esquerda
        int tamEsq = meio - inicio +1;
        T[] esquerda = (T[]) new Comparable[tamEsq];
        for (int i = 0; i <= tamEsq - 1; i++) {
            esquerda[i] = info[inicio + i];
        }

        int tamDir = fim - meio;
        T[] direita = (T[]) new Comparable[tamDir];
        for (int i = 0; i <= tamDir - 1; i++) {
            direita[i] = info[meio + 1 + i];
        }

        int cEsq = 0;
        int cDir = 0;

        int i;
        for (i = inicio; i <= fim; i++) {
            if (cEsq < tamEsq && cDir < tamDir) {
                if (esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                    info[i] = esquerda[cEsq];
                    cEsq++;
                } else {
                    info[i] = direita[cDir];
                    cDir++;
                }
            } else{
                break;
            }
        }

        while (cEsq < tamEsq) {
            info[i] = esquerda[cEsq];
            cEsq++;
            i++;
        }

        while (cDir < tamDir) {
            info[i] = direita[cDir];
            cDir++;
            i++;
        }
    }
}