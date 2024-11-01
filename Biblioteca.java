import java.util.Scanner;

public class Biblioteca {
    private static final int CAPACIDAD_MAXIMA = 100;
    private Libro[] libros;
    private int contadorLibros;

    public Biblioteca() {
        libros = new Libro[CAPACIDAD_MAXIMA];
        contadorLibros = 0;
    }

    public void agregarLibro() {
        if (contadorLibros < CAPACIDAD_MAXIMA) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el título del libro: ");
            String titulo = scanner.nextLine();

            System.out.print("Ingrese el autor del libro: ");
            String autor = scanner.nextLine();

            System.out.print("Ingrese el género del libro: ");
            String genero = scanner.nextLine();

            System.out.print("Ingrese el año de publicación del libro: ");
            int anioPublicacion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            Libro libro = new Libro(titulo, autor, genero, anioPublicacion);
            libros[contadorLibros] = libro;
            contadorLibros++;

            System.out.println("Libro agregado exitosamente.");
        } else {
            System.out.println("La biblioteca ha alcanzado su capacidad máxima.");
        }
    }

    public void listarLibros() {
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i] != null) {
                System.out.println(libros[i]);
            }
        }
    }

    public int buscarLibro(String titulo) {
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i] != null && libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                return i; // Devolver el índice del libro
            }
        }
        return -1; // Devolver -1 si no se encuentra el libro
    }

    public boolean prestarLibro(String titulo) {
        int indice = buscarLibro(titulo);
        if (indice != -1) {
            libros[indice].setPrestado(true); // Marcar libro como prestado
            return true;
        }
        return false;
    }

    public boolean devolverLibro(String titulo) {
        int indice = buscarLibro(titulo);
        if (indice != -1 && libros[indice].isPrestado()) {
            libros[indice].setPrestado(false); // Marcar libro como no prestado
            return true;
        }
        return false;
    }

    public boolean eliminarLibro(String titulo) {
        int indice = buscarLibro(titulo);
        if (indice != -1) {
            for (int i = indice; i < contadorLibros - 1; i++) {
                libros[i] = libros[i + 1];
            }
            libros[contadorLibros - 1] = null;
            contadorLibros--;
            return true;
        }
        return false;
    }

    // Nuevo método para obtener un libro por su índice
    public Libro obtenerLibroPorIndice(int indice) {
        if (indice >= 0 && indice < contadorLibros && libros[indice] != null) {
            return libros[indice];
        }
        return null;
    }
}
