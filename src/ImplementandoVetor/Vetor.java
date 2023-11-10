package ImplementandoVetor;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Vetor<T> implements IVetor<T>, Iterable<T> {
    private final int tamVetor;
    private T[] elementos;
    private int contElementos;
    private int VIncremento;
    private int tamanho;

    public Vetor() {
        tamVetor = 10;
        elementos = (T[]) new Object[this.tamVetor];
        contElementos = 0;
        VIncremento = 10;
    }

    public Vetor(int tamVetor) {
        this.tamVetor = tamVetor;
        elementos = (T[]) new Object[this.tamVetor];
        contElementos = 0;
        VIncremento = 10;
    }

    public Vetor(int tamVetor, int incremento) {
        this.tamVetor = tamVetor;
        this.VIncremento = incremento;
        elementos = (T[]) new Object[this.tamVetor];
        contElementos = 0;
    }
    private boolean estaVazio() {
        if(contElementos == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void Adicionar(T elemento) {
        this.Redimensionar();
        this.elementos[contElementos] = elemento;
        this.contElementos++;
    }

    @Override
    public void Adicionar(int posicao, T elemento) throws IndexOutOfBoundsException {
        this.Redimensionar();
        if(posicao > tamVetor || posicao < 0){
           throw new IndexOutOfBoundsException();
        } else if (posicao == contElementos) {
            Adicionar(elemento);
        }else{
            for(int i = contElementos; i > posicao; i--){
              elementos[i] = elementos[i + 1];
            }
            elementos[posicao] = elemento;
            contElementos++;
        }
    }

    @Override
    public void AdicionarInicio(T elemento) {
        Adicionar(0, elemento);
    }

    @Override
    public void Remover(int posicao) throws IndexOutOfBoundsException {
        if(!(estaVazio())|| posicao < 0 || posicao >= this.contElementos){
          if(posicao == contElementos - 1){
              this.RemoverFim();
          }else{
              for(int i = posicao; i < this.contElementos; i++){
                  this.elementos[i] = this.elementos[i + 1];
              }
              contElementos--;
          }

        }else{
            throw new IndexOutOfBoundsException("Vetor vazio ou posição inválida!");
        }
    }

    @Override
    public void RemoverElemento(T elemento) {
      if(this.contem(elemento)){
          for(int i = 0; i < this.contElementos; i++){
              if(elementos[i].equals(elemento)){
                  this.Remover(i);
                  break;
              }
          }
      }else{
          System.out.println("Este elemento não existe na estrutura");
      }
    }

    @Override
    public void RemoverIncio() {
        Remover(0);
    }

    @Override
    public void RemoverFim() {
        if(this.estaVazio()){
            System.out.println("Vetor vazio");
        }else{
            elementos[contElementos - 1] = null;
            contElementos--;
        }
    }

    @Override
    public int Tamanho() {
        return this.contElementos;
    }

    @Override
    public void Limpar() {
      elementos = (T[]) new Object[this.tamVetor];
      contElementos = 0;
    }

    @Override
    public boolean contem(T elemento) {
        for (int i = 0; i < this.contElementos; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public void Redimensionar() {
        if(this.contElementos == this.tamVetor){
            T[] novoElementos = (T[]) new Object[this.tamVetor + this.VIncremento];
            for(int i = 0; i < novoElementos.length; i++){
                novoElementos[i] = elementos[i];
            }
            this.elementos = novoElementos;
        }
    }

    public void redimensionar2() {
        if (this.contElementos == this.tamVetor) {
            T[] novoElementos = (T[]) new Object[this.tamVetor + this.VIncremento];
            System.arraycopy(this.elementos, 0, novoElementos, 0, novoElementos.length);
            this.elementos = novoElementos;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < contElementos; i++) { // Use contElementos em vez de tamanho
            builder.append(elementos[i]);
            if (i < contElementos - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public Iterator<T> myIterator = new Iterator<T>() {
        private int posicao = 0;

        @Override
        public boolean hasNext() {
            if (posicao < contElementos) {
                return true;
            } else {
                return false;
            }
        }
        public T next() throws NoSuchElementException{
            if(!hasNext()){
              throw new NoSuchElementException();
            }else{
                T elemento = elementos[posicao];
                posicao++;
                return elemento;
            }
        }
    };

    public void AdicionarElementosPosRandom(Vetor<T> elementos) {
        int qtdElementos = this.elementos.length + elementos.Tamanho();
        if (qtdElementos >= tamVetor) {
            this.Redimensionar();
        }
        if (this.estaVazio()) {
            for (T elemento : elementos) {
                this.Adicionar(elemento);
            }
        } else {
            Random gerador = new Random();
            int[] posicoes = new int[elementos.Tamanho()];
            for (int i = 0; i < posicoes.length; i++) {
                posicoes[i] = gerador.nextInt(this.Tamanho());
                //imprimindo só pra teste
                //System.out.println("posiçao: " + posicoes[i]);
                //FALTA VERIFICAR REPETIÇÕES
            }
            int contPos = 0;
            for (T elemento: elementos) {
                this.Adicionar(posicoes[contPos], elemento);
                contPos++;
            }
        }
    }

    public int PosElemento (T elemento) {
        for (int i = 0; i < Tamanho() ; i++) {
            if ( elemento.equals(elementos[i]) ) {
                return i;
            }
        }
        return -1;
    }

    public void InserirElementoApos(T elementoProcurado, T elementoParaInserir){
        if (contem(elementoProcurado)) {
            int pos = PosElemento(elementoProcurado)+ 1;
            Adicionar(pos, elementoParaInserir);
        } else {
            System.out.println("Não foi possível inserir o elemento!");
        }

    }

    public void AdicionarElementosPosPares(Vetor<T> elementos){
        if (this.estaVazio()){
            for (T elemento : this.elementos) {
                this.Adicionar(elemento);
            }
        } else {
            int [] pos = new int[this.Tamanho()];
            int tam = 0;

            int par = 0;
            for (int i = 0; i< this.Tamanho(); i = i++) {
                pos[i] = par;
                par = par + 2;
            }

            int cont = 0;
            if (elementos.Tamanho() < this.Tamanho()){
                for (T elemento:elementos) {
                    this.Adicionar(pos[cont],elemento);
                }
            } else {
                //para implementar em casaaaaa
            }

        }
    }

    public void RemoverMax(Vetor<T> outroVetor) {
        IVetor<Integer> indicesParaRemover = new Vetor<>();

        for (int i = 0; i < contElementos; i++) {
            for (int j = 0; j < outroVetor.Tamanho(); j++) {
                if (elementos[i].equals(outroVetor.get(j))) {
                    int comparacao = ((Comparable<T>) elementos[i]).compareTo(outroVetor.get(j));
                    if (comparacao > 0) {
                        indicesParaRemover.Adicionar(j); // Marca para remover de outroVetor
                    } else if (comparacao < 0) {
                        indicesParaRemover.Adicionar(i); // Marca para remover do seu vetor
                    }
                }
            }
        }

        // Remova os elementos marcados após o loop
        for (int i = indicesParaRemover.Tamanho() - 1; i >= 0; i--) {
            int index = ((Vetor<Integer>) indicesParaRemover).get(i);
            outroVetor.Remover(index);
            Remover(i);
        }
    }

    private T get(int j) {
        if (j >= 0 && j < contElementos) {
            return elementos[j];
        }
        return null; // Retorna null se o índice estiver fora dos limites
    }

    public Iterator<T> iterator(){
        return myIterator;
    }
}