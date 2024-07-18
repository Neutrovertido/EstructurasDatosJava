import java.util.Random;

public class Impresion {
    private String nombre;
    private String documento;
    private int pags;
    private int copias;

    private Random random = new Random();
    private int max = 9;
    private int min = 1;

    public Impresion(String nombre, String documento, int copias) {
        this.nombre = nombre;
        this.documento = documento;
        this.copias = copias;

        this.pags = random.nextInt((max - min) + 1) + min;

    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDocumento() {
        return this.documento;
    }

    public int getPaginas() {
        return this.pags;
    }

    public int getCopias() {
        return this.copias;
    }

    public String getAtributos() {
        return "Nombre: " + getNombre() + "\n" +
                "Documento: " + getDocumento() + "\n" +
                "Paginas: " + getPaginas() + "\n" +
                "Copias: " + getCopias() + "\n";
    }
}
