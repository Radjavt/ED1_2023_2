package ListaDEncadeada;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDupEnc<T> implements IListaDupEnc<T>, Iterable <T> {

    int contElementos;
    NoDupEnc<T> noCabeca;

    public ListaDupEnc() {
        this.noCabeca = new NoDupEnc<T>(null);
        this.contElementos = 0;
    }

    @Override
    public NoDupEnc<T> getInicio() {
        return this.noCabeca.getAnterior();
    }

    @Override
    public NoDupEnc<T> getFim() {
        return this.noCabeca.getProximo();
    }

    @Override
    public void clear() {
        noCabeca.setAnterior(null);
        noCabeca.setAnterior(null);
        contElementos = 0;
    }

    @Override
    public int size() {
        return contElementos;
    }

    @Override
    public boolean estaVazia() {
        return contElementos == 0;
    }

    @Override
    public void InserirInicio(T elemento) {
        NoDupEnc<T> novoNo = new NoDupEnc<T>(elemento);

        if(estaVazia()){
            noCabeca.setAnterior(novoNo);
            noCabeca.setProximo(novoNo);
        }else{
            novoNo.setProximo(noCabeca.getProximo());
            noCabeca.getProximo().setAnterior(novoNo);
            noCabeca.setProximo(novoNo);
        }
        contElementos++;
    }

    @Override
    public void InserirFim(T elemento) {
        NoDupEnc<T> novoNo = new NoDupEnc<T>(elemento);

        if(estaVazia()){
            noCabeca.setAnterior(novoNo);
            noCabeca.setProximo(novoNo);
        }else{
            novoNo.setAnterior(noCabeca.getAnterior());
            noCabeca.getAnterior().setProximo(novoNo);
            noCabeca.setAnterior(novoNo);
        }
        contElementos++;
    }

    @Override
    public void Inserir(int pos, T elemento) {

    }

    @Override
    public boolean contem(T elemento) {
        NoDupEnc<T> atual = noCabeca.getProximo();

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getAnterior();
        }
        return false;
    }

    @Override
    public void RemoverInicio() {

    }

    @Override
    public void RemoverFim() {

    }

    @Override
    public void Remover(int pos) {

    }

    @Override
    public Iterator iterator() {
        Iterator<T> myIterator = new Iterator<T>() {

            NoDupEnc posicao = noCabeca.getProximo();

            @Override
            public boolean hasNext() {
                if (posicao != null) {
                    return true;
                } else {
                    posicao = noCabeca.getProximo();
                    return false;
                }
            }

            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    T elemento = (T) posicao.getElemento();
                    posicao = posicao.getAnterior();
                    return elemento;
                }
            }
        };
        return myIterator;
    }
}