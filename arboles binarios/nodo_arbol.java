package arboles_binarios;

public class nodo_arbol {
    
    int dato;
    nodo_arbol derecha;
    nodo_arbol izquierda;
    
    public nodo_arbol(int q){
        dato = q;
    }
    
    public void mostrar(){
        System.out.println("dato = " + dato);
    }
}
