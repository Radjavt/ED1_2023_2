package ImplementandoVetor;

import java.util.Iterator;

public interface IVetor<T> {

    public void Adicionar(T elemento);
    public void Adicionar(int posicao, T elemento) throws IndexOutOfBoundsException;
    public void AdicionarInicio(T elemento);
    public void Remover(int posicao) throws IndexOutOfBoundsException;
    public void RemoverElemento(T elemento);
    public void RemoverIncio();
    public void RemoverFim();
    public int Tamanho();
    public void Limpar();
    public boolean contem(T elemento);
    public void RemoverMax(Vetor<T> outroVetor);

    public String toString();

    public Iterator<T> iterator();
}
