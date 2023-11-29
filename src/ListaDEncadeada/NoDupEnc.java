package ListaDEncadeada;

public class NoDupEnc <T>{
    private T elemento;
    private NoDupEnc<T> proximo;
    private NoDupEnc<T> anterior;
    public NoDupEnc(T objeto) {
        this.setElemento(objeto);
        this.setProximo(null);
        this.setAnterior(null);
    }

    public NoDupEnc(T objeto, NoDupEnc<T> proximo, NoDupEnc<T> anterior) {
        this.setElemento(objeto);
        this.setProximo(proximo);
        this.setAnterior(anterior);
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoDupEnc<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoDupEnc<T> proximo) {
        this.proximo = proximo;
    }

    public NoDupEnc<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDupEnc<T> anterior) {
        this.anterior = anterior;
    }
}