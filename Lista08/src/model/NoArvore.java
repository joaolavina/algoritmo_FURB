package model;

public class NoArvore<T> {

    T info;

    NoArvore<T> primeiro;
    NoArvore<T> proximo;

    public NoArvore(T info) {
        this.info = info;
        primeiro = null;
        proximo = null;
    }

    public void inserirFilho(NoArvore<T> sa) {
        sa.proximo = primeiro;
        primeiro = sa;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvore<T> primeiro) {
        this.primeiro = primeiro;
    }

    public NoArvore<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore<T> proximo) {
        this.proximo = proximo;
    }
}
