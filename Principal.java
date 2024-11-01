import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n---MENÚ---");
            System.out.println("1. Agregar un libro.");
            System.out.println("2. Listar libros.");
            System.out.println("3. Buscar un libro.");
            System.out.println("4. Prestar un libro.");
            System.out.println("5. Devolver un libro.");
            System.out.println("6. Eliminar un libro.");
            System.out.println("7. Salir del programa.");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    biblioteca.agregarLibro();
                    break;
                case 2:
                    biblioteca.listarLibros();
                    break;
                case 3:
                    System.out.print("Ingrese el título del libro a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    int indiceBuscado = biblioteca.buscarLibro(tituloBuscar);
                    if (indiceBuscado != -1) {
                        Libro libroBuscado = biblioteca.obtenerLibroPorIndice(indiceBuscado);
                        System.out.println("Libro encontrado: " + libroBuscado);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    if (biblioteca.prestarLibro(tituloPrestar)) {
                        System.out.println("Libro prestado con éxito.");
                    } else {
                        System.out.println("No se pudo prestar el libro.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    if (biblioteca.devolverLibro(tituloDevolver)) {
                        System.out.println("Libro devuelto con éxito.");
                    } else {
                        System.out.println("No se pudo devolver el libro.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el título del libro a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    if (biblioteca.eliminarLibro(tituloEliminar)) {
                        System.out.println("Libro eliminado con éxito.");
                    } else {
                        System.out.println("No se pudo eliminar el libro.");
                    }
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saliendo del programa, hasta luego...");
                    break;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }

        scanner.close();
    }
}
