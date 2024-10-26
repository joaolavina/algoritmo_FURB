package model;

public class ArvoreBinaria<T> {

    public NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        } else {
            return (no.getInfo() == info || pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info));
        }
    }

    @Override
    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        } else {
            return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
        }
    }

    public int ContarNos() {
        return ContarNos(raiz);
    }

    private int ContarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + ContarNos(no.getEsquerda()) + ContarNos(no.getDireita());
        }
    }

    public int contarFolhas(NoArvoreBinaria<T> sa) {
        if (sa == null) {
            return 0;
        } else if (sa.getDireita() == null && sa.getEsquerda() == null) {
            return 1;
        }

        return contarFolhas(sa.getDireita()) + contarFolhas(sa.getEsquerda());
    }
}
