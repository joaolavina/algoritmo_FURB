package model;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }

        primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }

        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);

        if (p != null) {
            if (primeiro.getInfo().equals(p.getInfo()))
                primeiro = p.getProximo();
            else
                p.getAnterior().setProximo((p.getProximo()));

            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    private NoListaDupla<T> obterUltimo() {
        NoListaDupla<T> ultimo = primeiro;

        NoListaDupla<T> p = primeiro;
        while (p != null) {
            ultimo = p;
            p = p.getProximo();
        }

        return ultimo;
    }

    public void exibirOrdemInverse() {
        NoListaDupla<T> p = obterUltimo();

        while (p.getAnterior() != null) {
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }
    }

    public void liberar() {
        NoListaDupla<T> p = primeiro;

        while (p != null) {
            p.setAnterior(null);
            NoListaDupla<T> backup = p.getProximo();
            p.setProximo(null);
            p = backup;
        }

        primeiro = null;
    }

    @Override
    public String toString() {
        String listaString = "";
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p != primeiro)
                listaString += ",";

            listaString += p.getInfo().toString();
            p.getProximo();
        }

        return listaString;
    }
}
