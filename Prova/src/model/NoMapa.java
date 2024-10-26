package model;
public class NoMapa<T>{
    
    private int chave;
    private T info;

    public int getChave() {
        return chave;
    }
    public void setChave(int chave) {
        this.chave = chave;
    }
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        
        NoMapa<T> other = (NoMapa<T>) obj;
        if(this.chave != other.chave)
            return false;
        return true;
    }
}
