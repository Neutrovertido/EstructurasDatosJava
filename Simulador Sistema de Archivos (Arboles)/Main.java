import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Bienvenido al simulador de Sistema de Archivos!");
        System.out.println("Los comandos a utilizar son los mismos de UNIX/Linux con una excepcion:\n'cd ..' -> 'back'");
        fs.printFullPath();
        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();
            String[] cmdParts = command.split(" ", 2);
            switch (cmdParts[0].toLowerCase()) {
                case "cd":
                    fs.enterFolder(cmdParts[1]);
                    break;
                case "back":
                    fs.exitFolder();
                    break;
                case "mkdir":
                    fs.createFolder(cmdParts[1]);
                    break;
                case "touch":
                    fs.createFile(cmdParts[1]);
                    break;
                case "rm":
                    fs.deleteNode(cmdParts[1]);
                    break;
                case "ls":
                    fs.listDirectory();
                    break;
                case "pwd":
                    fs.printFullPath();
                    break;
                case "quit":
                    System.out.println("Saliendo del simulador.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Comando invalido.");
                    break;
            }
        }
    }
}
