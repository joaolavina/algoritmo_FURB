package view;
public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T>{

    public T[] info;

    @Override
    public void ordenar() {
        info = super.getInfo();
        for (int i = info.length-1; i >= 1; i--) {
            for (int j = 0; j <= i-1; j++) {
                if(info[j].compareTo(info[j+1]) > 0){
                    trocar(j, j+1);
                }
            }
        }
    }

}
