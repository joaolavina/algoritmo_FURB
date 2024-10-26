package model;
public class NoListaDupla<T> {

    private NoListaDupla<T> anterior;

    private NoListaDupla<T> proximo;

    private T info;

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    public NoListaDupla<T> getProximo() {
        return proximo;
    }

    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }
}
