package model;

public class App {
    public static void main(String[] args) {
        ListaDupla<Integer> l;
        l = new ListaDupla<>();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.inserir(25);
        l.inserir(30);
        l.inserir(35);
        l.inserir(40);
        l.inserir(45);
        l.inserir(50);
        ListaDupla<Integer> subLista = l.criarSubLista(2,5);
        System.out.println(subLista.toString());
    }
}
