package view;

public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public T[] info;

    @Override
    public void ordenar() {
        info = super.getInfo();

        for (int i = info.length - 1; i >= 1; i--) {
            boolean trocou = false;
            for (int j = 0; j <= i - 1; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou)
                return;
        }
    }

}
