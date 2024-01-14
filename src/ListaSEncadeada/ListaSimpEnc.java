package ListaSEncadeada;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaSimpEnc<T> implements IListaSimpEnc<T> {
    private NoSimpEnc<T> inicio;
    private NoSimpEnc<T> fim;
    private int contElementos;

    @Override
    public NoSimpEnc getInicio() {
        return this.inicio;
    }

    @Override
    public NoSimpEnc getFim() {
        return this.fim;
    }

    @Override
    public void clear() {
        inicio = fim = null;
        contElementos = 0;
    }

    @Override
    public int size() {
        return this.contElementos;
    }

    @Override
    public boolean estaVazia() {
        if(contElementos == 0){
            return true;
        }
        return false;
    }

    @Override
    public void InserirInicio(T elemento) {
        NoSimpEnc<T> novoNo = new NoSimpEnc<>(elemento);
        if(inicio==null){
            inicio = fim = novoNo;
        }else{
            novoNo.setProximo(inicio);
            inicio = novoNo;
        }
        contElementos++;
    }

    @Override
    public void InserirFim(T elemento) {
        NoSimpEnc<T> novoNo = new NoSimpEnc<>(elemento);
        if(inicio == null){
            inicio = fim = novoNo;
        }else{
            fim.setProximo(novoNo);
            fim=novoNo;
        }
        contElementos++;
    }

    @Override
    public void Inserir(int pos, T elemento) {
        NoSimpEnc<T> novoNo = new NoSimpEnc<T>(elemento);
        NoSimpEnc<T> aux = inicio;
        if(pos<0 || pos>contElementos) {
            throw new IndexOutOfBoundsException();
        }else if(pos==0){
            this.InserirInicio(elemento);
        }else if(pos==contElementos){
            this.InserirFim(elemento);
        }else{
            for(int i = 1; i < contElementos; i++){
                if(i==pos){
                    novoNo.setProximo(aux.getProximo());
                    aux.setProximo(novoNo);
                    contElementos++;
                }
                aux = aux.getProximo();
            }
        }
    }

    @Override
    public boolean contem(T elemento) {
        NoSimpEnc<T> aux = inicio;
        for(int i = 0; i < contElementos; i++){
           if(aux.getElemento().equals(elemento)) {
               return true;
           }
           aux = aux.getProximo();
        }
        return false;
    }

    @Override
    public T RemoverInicio() {
        if(!estaVazia()){
            inicio = inicio.getProximo();
            contElementos--;
        }
        return RemoverInicio();
    }

    @Override
    public void RemoverFim() {
        if (!estaVazia()){
            NoSimpEnc<T> aux = inicio;
            if (contElementos == 1){
                this.clear();
            } else {
                for (int i = 0; i < contElementos-2;i++){
                    aux = aux.getProximo();
                }
                aux.setProximo(null);
                fim = aux;
                contElementos--;
            }
        }
    }

    @Override
    public void RemoverElemento(T Elemento) {

    }

    @Override
    public void InserirPartes(ListaSimpEnc<T> lista, int quantidade) {
        if (lista == null || quantidade <= 0) {
            return;
        }

        // Chama o método auxiliar recursivo para iniciar a inserção
        InserirPartesRecursivo(lista.getInicio(), quantidade);
    }

    private void InserirPartesRecursivo(NoSimpEnc<T> noAtual, int quantidade) {
        if (noAtual == null || quantidade <= 0) {
            return;
        }

        // Insere o elemento atual na nova lista
        this.InserirFim(noAtual.getElemento());

        // Chama recursivamente para o próximo elemento
        InserirPartesRecursivo(noAtual.getProximo(), quantidade - 1);
    }


    private int posicao(T Elemento) {
        NoSimpEnc<T> aux = inicio;
        int pos =-1;
        for (int i = 0; i < contElementos ; i++) {
            if (aux.getElemento().equals(Elemento)){
                return i;
            }
            aux = aux.getProximo();
        }
        return pos;
    }

    public String toString() {
        StringBuilder resultado = new StringBuilder();
        NoSimpEnc<T> aux = inicio;
        while (aux != null) {
            resultado.append(aux.getElemento()).append(" ");
            aux = aux.getProximo();
        }
        return resultado.toString().trim();
    }

    @Override
    public Iterator iterator() {
        Iterator<T> myIterator = new Iterator<T>() {

            NoSimpEnc posicao = inicio;

            @Override
            public boolean hasNext() {
                if (posicao != null) {
                    return true;
                } else {
                    this.posicao = inicio;
                    return false;
                }
            }

            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    T elemento = (T) posicao.getElemento();
                    posicao = posicao.getProximo();
                    return elemento;
                }
            }
        };
        return myIterator;
    }
/*
    public void InserirPartes(ListaSimpEnc<T> lista, int quantidade) {
        NoSimpEnc<T> no = lista.getInicio();
        for (int i = 0; i < quantidade && no != null; i++) {
            this.InserirFim(no.getElemento());
            no = no.getProximo();
        }
    }

    public void InsertionSort(Comparator<T> comparator) {
        inicio = insertionSort(inicio, comparator);
    }

    private NoSimpEnc<T> insertionSort(NoSimpEnc<T> start, Comparator<T> comparator) {
        if (start == null || start.getProximo() == null) {
            return start;
        }

        NoSimpEnc<T> sorted = null;
        NoSimpEnc<T> current = start;

        while (current != null) {
            NoSimpEnc<T> next = current.getProximo();
            sorted = sortedInsert(sorted, current, comparator);
            current = next;
        }

        return sorted;
    }

    private NoSimpEnc<T> sortedInsert(NoSimpEnc<T> head, NoSimpEnc<T> newNode, Comparator<T> comparator) {
        if (head == null || comparator.compare(head.getElemento(), newNode.getElemento()) >= 0) {
            newNode.setProximo(head);
            return newNode;
        }

        NoSimpEnc<T> current = head;
        while (current.getProximo() != null && comparator.compare(current.getProximo().getElemento(), newNode.getElemento()) < 0) {
            current = current.getProximo();
        }

        newNode.setProximo(current.getProximo());
        current.setProximo(newNode);

        return head;
    }

    public void imprimirLista() {
        NoSimpEnc<T> current = inicio;

        while (current != null) {
            System.out.print(current.getElemento() + " ");
            current = current.getProximo();
        }

        System.out.println();
    }

 */
}