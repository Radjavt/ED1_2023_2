package ListaSEncadeada;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ListaSimpEnc<Integer> listaCorrente = new ListaSimpEnc<>();
        ListaSimpEnc<Integer> listaOriginal = new ListaSimpEnc<>();
        listaOriginal.InserirFim(1);
        listaOriginal.InserirFim(2);
        listaOriginal.InserirFim(3);
        listaOriginal.InserirFim(4);

        System.out.println("Lista Original: " + listaOriginal);

        ListaSimpEnc<Integer> novaLista = new ListaSimpEnc<>();
        novaLista.InserirPartes(listaOriginal, 2);

        System.out.println("Nova Lista após InserirPartes: " + novaLista);

        /*ListaSimpEnc<Integer> lista = new ListaSimpEnc<>();
        lista.InserirFim(5);
        lista.InserirFim(7);
        lista.InserirFim(3);
        lista.InserirFim(4);

        System.out.println("Lista antes do Insertion Sort:");
        lista.imprimirLista();

        lista.InsertionSort(Comparator.naturalOrder());

        System.out.println("\nLista depois do Insertion Sort:");
        lista.imprimirLista();

   */
    }
}