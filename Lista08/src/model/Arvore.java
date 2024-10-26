package model;

public class Arvore<T> {

    NoArvore<T> raiz;

    public Arvore() {
        raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        if (raiz == null)
            return "";

        return obterRepresentacaoTextual(raiz);
    }

    public boolean estaVazia(){
        return getRaiz() == null;
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String stringArvore = "<";
        stringArvore += no.getInfo();

        NoArvore<T> p = no.primeiro;

        while (p != null) {
            stringArvore += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        stringArvore += ">";

        return stringArvore;
    }

    public boolean pertence(T info) {
        if (raiz == null)
            return false;

        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.info == info) {
            return true;
        } else {
            NoArvore<T> p = no.primeiro;
            while (p != null) {
                if(pertence(p, info)){
                    return true;
                }

                p = p.getProximo();
            }

            return false;
        }
    }

    public int ContarNos(){
        if(raiz == null)
            return 0;
        else 
            return ContarNos(raiz);
    }

    private int ContarNos(NoArvore<T> no){
        int qnt = 1;

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            qnt += ContarNos(p);
            p = p.getProximo();
        }

        return qnt;
    }
}
