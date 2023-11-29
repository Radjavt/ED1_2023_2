package ListaSEncadeada;
import java.util.Iterator;

public interface IListaSimpEnc<T> {
    public NoSimpEnc<T> getInicio();
    public NoSimpEnc<T> getFim();
    public void clear();
    public int size();
    public boolean estaVazia();
    public void InserirInicio(T elemento);
    public void InserirFim(T elemento);
    public void Inserir(int pos, T elemento);
    public boolean contem(T elemento);
    public void RemoverInicio();
    public void RemoverFim();
    public void RemoverElemento(T Elemento);
    public String toString();
    public Iterator<T> iterator();

}