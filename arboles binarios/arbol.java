package arboles_binarios;

public class arbol {

    nodo_arbol raiz;
    int can;

    public arbol() {
        raiz = null;
        can = 0;
    }

    public void insertar(int n) {
        can++;
        nodo_arbol nuevo = new nodo_arbol(n);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            nodo_arbol aux = raiz;

            while (true) {
                if (n > aux.dato) {
                    if (aux.derecha == null) {
                        aux.derecha = nuevo;
                        return;
                    }
                    aux = aux.derecha;
                } else {
                    if (aux.izquierda == null) {
                        aux.izquierda = nuevo;
                        return;
                    }
                    aux = aux.izquierda;
                }
            }
        }
    }

    public boolean buscar(int n) {
        nodo_arbol aux = raiz;

        while (aux != null) {
            if (aux.dato == n) {
                return true;
            }

            if (n > aux.dato) {
                aux = aux.derecha;
            } else {
                aux = aux.izquierda;
            }
        }
        
        return false;
    }
    
    public void mostrar(nodo_arbol aux){
        if (aux != null) {
            mostrar(aux.izquierda);
            mostrar(aux.derecha);
            System.out.println(aux.dato);
        }
    }
}
