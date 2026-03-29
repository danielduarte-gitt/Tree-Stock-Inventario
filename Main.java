import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolInventario inventario = new ArbolInventario();
        Scanner sc = new Scanner(System.in);
        int opcion, id;
        String nombre;

        do {
            System.out.println("\n--- SISTEMA TREE-STOCK ---");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario (Ordenado)");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    id = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese Nombre: ");
                    nombre = sc.nextLine();
                    inventario.insertar(id, nombre);
                    System.out.println("Producto registrado con éxito.");
                    break;
                case 2:
                    System.out.println("\nInventario Actual:");
                    inventario.mostrarInorden(inventario.raiz);
                    break;
                case 3:
                    System.out.print("Ingrese ID a buscar: ");
                    id = sc.nextInt();
                    Producto resultado = inventario.buscar(inventario.raiz, id);
                    if (resultado != null) {
                        System.out.println("¡Encontrado! -> " + resultado.nombre);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}