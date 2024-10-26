package view;

public abstract class OrdenacaoAbstract<T extends Comparable<T>> {

    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public void trocar(int a, int b) {
        T temporario = info[a];
        info[a] = info[b];
        info[b] = temporario;
    }

    public abstract void ordenar();

}
