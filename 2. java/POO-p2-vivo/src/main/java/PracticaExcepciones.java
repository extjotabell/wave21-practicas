import java.io.PipedWriter;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            int cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();
        practica.calcularCociente();
    }
}

public class PracticaExcepciones2 {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones();
        practica.calcularCociente();
    }
}

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    // Método para calcular el precio total
    public double calcular(int cantidadDeProductos) {
        return precio * cantidadDeProductos;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + "\nPrecio: " + precio;
    }
}

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    // Getter y setter para diasPorCaducar
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    // Sobrescritura del método calcular
    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);

        if (diasPorCaducar == 1) {
            precioFinal -= precioFinal * 4;
        } else if (diasPorCaducar == 2) {
            precioFinal -= precioFinal * 3;
        } else if (diasPorCaducar == 3) {
            precioFinal /= 2;
        }

        return precioFinal;
    }

    // Sobrescritura del método toString
    @Override
    public String toString() {
        return super.toString() + "\nDías por caducar: " + diasPorCaducar;
    }
}

public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    // Getters y setters para el atributo tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Sobrescritura del método calcular
    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }

    // Sobrescritura del método toString
    @Override
    public String toString() {
        return super.toString() + "\nTipo: " + tipo;
    }
}






