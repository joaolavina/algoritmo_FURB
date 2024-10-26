package model;

public class App {
    public static void main(String[] args) {
        ListaEstatica<Integer> l;
        l = new ListaEstatica<>();
        for (int i = 1; i <= 10; i++) {
            l.inserir(i);
        }
        
        // l.inserir(11,78);

        System.out.println(l.toString());
    }
}
