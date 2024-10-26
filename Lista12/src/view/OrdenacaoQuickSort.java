package view;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public T[] info;

    @Override
    public void ordenar() {
        info = super.getInfo();
        quickSort(0, info.length - 1);
    }

    private void quickSort(int inicio, int fim){
        if(inicio < fim){
            int idxPivo =  particionar(inicio, fim);
            quickSort(inicio, idxPivo-1);
            quickSort(idxPivo+1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int a = inicio;
        int b = fim + 1;
        T pivo = info[inicio];

        while (true) {

            // procura valor maior que o pivo
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);

            // procura valor menor que o pivo
            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            if (a >= b)
                break;

            trocar(a, b);
        }

        trocar(b, inicio);
        return b;
    }
}
