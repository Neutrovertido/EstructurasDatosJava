import java.util.Random;
import java.util.Scanner;
public class Impresora {

    private String name;

    public Impresora(String name) {
        this.name = name;
    }

    void imprimir () {
        System.out.println("================================");
        System.out.println("IMPRESORA " + name);
        System.out.println("================================");

        Scanner s = new Scanner(System.in);
        Random r = new Random();

        String e;
        int cant = 0;

        do {
            System.out.print("\nIngrese la cantidad de elementos a imprimir: ");
            e = s.nextLine();
            try {
                cant = Integer.parseInt(e);
            } catch (Exception ex) {
                System.out.println("Valor inválido!");
            }
        } while (cant <= 0);

        ColaCircular cola = new ColaCircular(cant);

        for (int i = 0; i < cant; i++) {
            String nom = "Documento " + (i + 1);
            System.out.println("-=" + nom + "=-");

            System.out.print("Ingrese la direccion del documento: ");
            String doc = s.nextLine();

            String e2;
            int cant2 = 0;
            do {
                System.out.print("Ingrese la cantidad de copias: ");
                e2 = s.nextLine();
                try {
                    cant2 = Integer.parseInt(e2);
                } catch (Exception ex) {
                    System.out.println("Valor inválido!");
                }

            } while (cant2 <= 0);

            Impresion imp = new Impresion(nom, doc, cant2);
            cola.encolar(imp);
        }

        System.out.println("Elementos agregados a la cola de impresión correctamente!");

        do {
            for (int i = 0; i < cola.tamanho; i++) {
                Impresion imprimiendo = cola.desencolar();
                int max = 10;
                int min = 1;

                System.out.println("Imprimiendo documento...");
                int factor = r.nextInt((max - min) + 1) + min;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex2) {
                    System.out.println("Impresión cancelada!");
                }

                if (factor == 1) {
                    System.out.println("Error crítico al imprimir el documento...");
                    System.out.println("Reintentando en el siguiente lote.");
                    cola.encolar(imprimiendo);
                    break;
                } else {
                    System.out.println(imprimiendo.getAtributos());
                }

            }
        } while (cola.tamanho != 0);

        System.out.println("TODAS LAS IMPRESIONES FUERON REALIZADAS CORRECTAMENTE!");
    }
}
