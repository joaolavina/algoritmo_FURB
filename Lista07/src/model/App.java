package model;

public class App {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> a = new ArvoreBinaria<>();
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);

        no1.setEsquerda(no2);
        no1.setDireita(no3);

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);

        no2.setDireita(no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no3.setEsquerda(no5);
        no3.setDireita(no6);



        a.setRaiz(no1);

        a.pertence(10);
    }
}
