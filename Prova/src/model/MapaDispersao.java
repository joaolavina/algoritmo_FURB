package model;

public class MapaDispersao<T> {

    public ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }

    public int calcularHash(int chave) {
        int tamanho = info.length;
        return chave % tamanho;
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);
        if (info[indice] == null) {
            info[indice] = new ListaEncadeada<>();
        }

        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setInfo(dado);

        info[indice].inserir(noMapa);
    }

    public void remover(int chave) {
        int indice = calcularHash(chave);

        info[indice] = null;
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);

            if (no != null) {
                return no.getInfo().getInfo();
            }
        }

        return null;
    }

    public void realocarMapa(int novoTamanho) {
        ListaEncadeada<NoMapa<T>>[] temp = new ListaEncadeada[novoTamanho];

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                NoLista<NoMapa<T>> p = info[i].getPrimeiro();
                while (p != null) {
                    int chave = p.getInfo().getChave();

                    int indice = chave % temp.length;
                    if (temp[indice] == null) {
                        temp[indice] = new ListaEncadeada<>();
                    }

                    NoMapa<T> noMapa = new NoMapa<>();
                    noMapa.setChave(chave);
                    noMapa.setInfo(p.getInfo().getInfo());

                    temp[indice].inserir(noMapa);

                    p = p.getProximo();
                }
            }
        }

        info = temp;
    }
}
