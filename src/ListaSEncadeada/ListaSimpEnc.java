package ListaSEncadeada;

import java.util.Comparator;
import java.util.Iterator;

public class ListaSimpEnc<T> implements IListaSimpEnc<T> {
    private NoSimpEnc<T> inicio;
    private NoSimpEnc<T> fim;
    private int contElementos;

    @Override
    public NoSimpEnc getInicio() {
        return inicio;
    }

    @Override
    public NoSimpEnc getFim() {
        return fim;
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
    public void Inserir(int pos, Object elemento) {

    }

    @Override
    public boolean contem(Object elemento) {
        return false;
    }

    @Override
    public void RemoverInicio() {
        if(!estaVazia()){
            inicio = inicio.getProximo();
            contElementos--;
        }
    }

    @Override
    public void RemoverFim() {

    }

    @Override
    public void RemoverElemento(Object Elemento) {

    }

    @Override
    public Iterator iterator() {
        return null;
    }

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
}
