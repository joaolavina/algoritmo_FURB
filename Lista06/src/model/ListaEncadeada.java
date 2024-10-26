package model;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }
   
    public void inserir(T info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public void inserirNoFinal(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);
        novo.setProximo(null);
        
        if(this.estaVazia())
            primeiro = novo;
        else
            ultimo.setProximo(novo);

        ultimo = novo;            
    }

    
    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }

        return null;
    }

    public void retirar(T info) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && !(p.getInfo().equals(info))) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro) 
                primeiro = p.getProximo();
            else 
                anterior.setProximo(p.getProximo());
            
            if(p == ultimo)
                ultimo = anterior;

        }
    }

    public int obterComprimento() {
        NoLista<T> p = primeiro;
        int comprimento = 0;

        while (p != null) {
            comprimento++;
            p = p.getProximo();
        }

        return comprimento;
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0)
            throw new IndexOutOfBoundsException();

        NoLista<T> p = getPrimeiro();

        while (idx > 0 && p != null) {
            idx--;
            p = p.getProximo();
        }

        if(p == null)
            throw new IndexOutOfBoundsException(); 

        return p;
    }

    @Override
    public String toString() {
        String listaString = "";
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p != primeiro)
                listaString += ",";

            listaString += p.getInfo().toString();
            p.getProximo();
        }

        return listaString;
    }
}
