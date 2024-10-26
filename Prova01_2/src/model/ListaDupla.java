package model;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    private int tamanho;

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
        tamanho++;
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

    public ListaDupla<T> criarSubLista(int inicio, int fim) {
        if (inicio < 0 || fim < 0 || fim < inicio) {
            throw new IndexOutOfBoundsException();
        }

        ListaDupla<T> subLista = new ListaDupla<>();
        NoListaDupla<T> no = getPrimeiro();

        for (int i = 0; i < fim; i++) {
            no = no.getProximo();
        
            if (no == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        for (int i = fim; i >= inicio; i--) {
            subLista.inserir(no.getInfo());
            no = no.getAnterior();
        }
        return subLista;
    }

    @Override
    public String toString() {
        String listaString = "";
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p != primeiro)
                listaString += ",";

            listaString += p.getInfo().toString();
            p = p.getProximo();
        }

        return listaString;
    }
}