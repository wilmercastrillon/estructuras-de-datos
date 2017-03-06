package estructuras_de_datos;

public class lista {

    nodo first;
    nodo last;
    int tam;

    public lista() {
        first = last = null;
        tam = 0;
    }

    public boolean IsEmpety() {
        return first == null;
    }

    public void Borrar_Lista() {
        while (!IsEmpety()) {
            Borrar_Nodo(first);
        }
    }

    public void Insertar_Primero(String nom, String dir) {
        nodo nuevo = new nodo(nom, dir);
        if (IsEmpety()) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.siguiente = first;
            first.anterior = nuevo;
            first = nuevo;
        }
        tam++;
    }

    public void Insertar_Ultimo(String nom, String dir) {
        nodo nuevo = new nodo(nom, dir);
        if (IsEmpety()) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.anterior = last;
            last.siguiente = nuevo;
            last = nuevo;
        }
        tam++;
    }
    
    public void Insertar_En(String nom, String dir, int index){
        if (index == 0) {
            Insertar_Primero(nom, dir);
            return;
        }
        if (index == tam) {
            Insertar_Ultimo(nom, dir);
            return;
        }
        
        nodo nuevo = new nodo(nom, dir);
        nodo aux = first.siguiente;
        int x = 1;
        
        while (aux != null) {            
            if (x == index) {
                aux.anterior.siguiente = nuevo;
                nuevo.anterior = aux.anterior;
                aux.anterior = nuevo;
                nuevo.siguiente = aux;
                return;
            }
            aux = aux.siguiente;
        }
    }

    public int Index_of(nodo b) {
        nodo aux = first;
        int con = 0;

        while (aux != null) {
            if (aux == b) {
                return con;
            }
            aux = aux.siguiente;
            con++;
        }
        return -1;
    }

    public int Last_Index_of(nodo b) {
        nodo aux = last;
        int con = tam - 1;

        while (aux != null) {
            if (aux == b) {
                return con;
            }
            aux = aux.anterior;
            con--;
        }
        return -1;
    }
    
    public int Index_of(String id) {
        nodo aux = first;
        int con = 0;

        while (aux != null) {
            if (aux.nombre.equals(id)) {
                return con;
            }
            aux = aux.siguiente;
            con++;
        }
        return -1;
    }

    public int Last_Index_of(String id) {
        nodo aux = last;
        int con = tam - 1;

        while (aux != null) {
            if (aux.nombre.equals(id)) {
                return con;
            }
            aux = aux.anterior;
            con--;
        }
        return -1;
    }

    public nodo Get_Nodo(int index) {
        if (index < 0 || index >= tam) {
            return null;
        }

        int n = 0;
        nodo aux = first;
        while (n != index) {
            aux = aux.siguiente;
            n++;
        }

        return aux;
    }

    public nodo Get_Nodo(String id) {
        nodo aux = first;
        while (aux != null) {
            if (aux.nombre.equals(id)) {
                return aux;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public void Borrar_Nodo(nodo b) {
        if (b == null) {
            return;
        }
        
        if (b == first) {
            if (tam == 1) {
                first = null;
                tam--;
                return;
            }
            first.siguiente.anterior = null;
            first = first.siguiente;
            tam--;
            return;
        }
        tam--;
        if (b == last) {
            last.anterior.siguiente = null;
            last = last.anterior;
            return;
        }
        b.siguiente.anterior = b.anterior;
        b.siguiente.anterior.siguiente = b.siguiente;
    }

    public void Borrar_Nodo(String id) {
        Borrar_Nodo(Get_Nodo(id));
    }
    
    public boolean Contiene(nodo b){
        return Index_of(b) != -1;
    }
    
    public boolean Contiene(String id){
        return Index_of(id) != -1;
    }
}
