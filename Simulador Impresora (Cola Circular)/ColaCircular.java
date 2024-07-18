// ColaCircular modificada para aceptar unicamente Objetos de la clase Impresion
// Originalmente diseñada para Objetos en general
public class ColaCircular {
    Impresion[] cola;
    int frente;
    int finalCola;
    int tamanho;
    int capacidad;

    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        cola = new Impresion[capacidad];
        frente = 0;
        finalCola = -1;
        tamanho = 0;
    }

    // Encolar
    public void encolar(Impresion elemento) {
        if (tamanho == capacidad) {
            System.out.println("La cola está llena");
            return;
        }

        if (finalCola == capacidad - 1) {
            finalCola = 0;
        } else {
            finalCola++;
        }

        cola[finalCola] = elemento;
        tamanho++;

        if (tamanho == 1) {
            frente = finalCola;
        }
    }

    // Eliminar elemento
    public Impresion desencolar() {
        if (tamanho == 0) {
            System.out.println("La cola está vacía");
            return null;
        }

        Impresion elemento = cola[frente];
        cola[frente] = null;

        if (frente == capacidad - 1) {
            frente = 0;
        } else {
            frente++;
        }

        tamanho--;

        return elemento;
    }

    //Frente de la cola
    public Impresion frente() {
        if (tamanho == 0) {
            System.out.println("La cola está vacía");
            return null;
        } else {
            return cola[frente];
        }


    }

    // Vacío
    public boolean vacio() {
        return tamanho == 0;
    }

    // Tamaño
    public int tamano() {
        return tamanho;
    }
}