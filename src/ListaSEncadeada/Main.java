package ListaSEncadeada;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ListaSimpEnc<Integer> lista = new ListaSimpEnc<>();
        lista.InserirFim(5);
        lista.InserirFim(7);
        lista.InserirFim(3);
        lista.InserirFim(4);

        System.out.println("Lista antes do Insertion Sort:");
        lista.imprimirLista();

        lista.InsertionSort(Comparator.naturalOrder());

        System.out.println("\nLista depois do Insertion Sort:");
        lista.imprimirLista();
    }
}
