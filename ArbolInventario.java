public class ArbolInventario {
    Producto raiz;

    public ArbolInventario() {
        raiz = null;
    }

    // Método Insertar (Recursivo)
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        if (actual == null) {
            return new Producto(id, nombre);
        }
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        }
        return actual;
    }

    // Método Recorrido Inorden (Izquierda - Raíz - Derecha)
    public void mostrarInorden(Producto nodo) {
        if (nodo != null) {
            mostrarInorden(nodo.izquierdo);
            System.out.println("ID: " + nodo.id + " | Producto: " + nodo.nombre);
            mostrarInorden(nodo.derecho);
        }
    }

    // Método Buscar por ID
    public Producto buscar(Producto actual, int id) {
        if (actual == null || actual.id == id) {
            return actual;
        }
        if (id < actual.id) {
            return buscar(actual.izquierdo, id);
        }
        return buscar(actual.derecho, id);
    }
}