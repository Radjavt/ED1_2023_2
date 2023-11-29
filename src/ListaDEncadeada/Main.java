package ListaDEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaDupEnc<Integer> lista = new ListaDupEnc<>();
        System.out.println("A lista está vazia? "+ lista.estaVazia());
        lista.InserirInicio(1);
        lista.InserirInicio(2);
        lista.InserirInicio(3);

        lista.InserirFim(4);
        lista.InserirFim(5);

        System.out.println("A lista contem o elemento: "+lista.contem(3));

        System.out.println("Elementos da lista:");
        for (Integer elemento:lista){
            System.out.println(elemento);
        }

        lista.clear();
        System.out.println("A lista está vazia? "+ lista.estaVazia());
    }
}