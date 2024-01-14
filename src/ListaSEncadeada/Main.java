package ListaSEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaSimpEnc<Integer> listaOriginal = new ListaSimpEnc<>();
        listaOriginal.InserirFim(1);
        listaOriginal.InserirFim(2);
        listaOriginal.InserirFim(3);
        listaOriginal.InserirFim(4);

        System.out.println("Lista Original: " + listaOriginal);

        ListaSimpEnc<Integer> ListaCorrente = new ListaSimpEnc<>();
        ListaCorrente.InserirPartes(listaOriginal, 2);

        System.out.println("Lista Corrente: " + ListaCorrente);

    }
}