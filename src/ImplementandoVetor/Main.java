package ImplementandoVetor;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        IVetor<Integer> vetor1 = new Vetor<>();
        IVetor<Integer> vetor2 = new Vetor<>();

            vetor1.Adicionar(10);
            vetor1.Adicionar(20);
            vetor1.Adicionar(30);

            vetor2.Adicionar(20);
            vetor2.Adicionar(40);

            System.out.println("Vetor 1: " + vetor1);
            System.out.println("Vetor 2: " + vetor2);

            vetor1.RemoverMax((Vetor<Integer>) vetor2);

            System.out.println("Vetor 1 após removerMax: " + vetor1);
            System.out.println("Vetor 2 após removerMax: " + vetor2);
        }
    }