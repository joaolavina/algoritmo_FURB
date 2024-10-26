package model;
public class MapaDispersao<T> {
    
    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho){
        info = new ListaEncadeada[tamanho];
    }

    public int calcularHash(int chave){
        int tamanho = info.length;
        return chave % tamanho;
    }

    public void inserir(int chave, T dado){
        int indice = calcularHash(chave);
        if(info[indice] == null){
            info[indice] = new ListaEncadeada<>();
        }

        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setInfo(dado);

        info[indice].inserir(noMapa);
    }

    public void remover(int chave){
        int indice = calcularHash(chave);

        info[indice] = null;
    }

    public T buscar(int chave){
        int indice = calcularHash(chave);

        if(info[indice] != null){
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);

            if(no != null){
                return no.getInfo().getInfo();
            }
        }

        return null;
    }
}
