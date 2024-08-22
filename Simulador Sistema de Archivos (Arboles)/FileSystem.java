import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private Node root;
    private Node current;

    FileSystem() {
        root = new Node("root", false, null);
        current = root;
    }

    void enterFolder(String folderName) {
        Node folder = current.findChild(folderName);
        if (folder != null && !folder.isFile) {
            current = folder;
            printFullPath();
        } else {
            System.out.println("Carpeta no encontrada.");
        }
    }

    void exitFolder() {
        if (current.parent != null) {
            current = current.parent;
            printFullPath();
        } else {
            System.out.println("Ya se encuentra en el directorio raiz.");
        }
    }

    void createFolder(String folderName) {
        if (current.findChild(folderName) == null) {
            current.children.add(new Node(folderName, false, current));
            System.out.println("Carpeta creada: " + folderName);
        } else {
            System.out.println("La carpeta ya existe.");
        }
    }

    void createFile(String fileName) {
        if (current.findChild(fileName) == null) {
            current.children.add(new Node(fileName, true, current));
            System.out.println("Archivo creado: " + fileName);
        } else {
            System.out.println("El archivo ya existe.");
        }
    }

    void deleteNode(String nodeName) {
        Node node = current.findChild(nodeName);
        if (node != null) {
            current.children.remove(node);
            System.out.println((node.isFile ? "File" : "Folder") + " deleted: " + nodeName);
        } else {
            System.out.println("Node no encontrado.");
        }
    }

    boolean buildPath(Node root, Node target, List<String> path) {
        if (root == target) {
            path.add(root.name);
            return true;
        }

        for (Node child : root.children) {
            if (buildPath(child, target, path)) {
                path.add(0, root.name);
                return true;
            }
        }

        return false;
    }

    void printFullPath() {
        List<String> path = new ArrayList<>();
        buildPath(root, current, path);
        System.out.println("Directorio actual: /" + String.join("/", path));
    }

    void listDirectory() {
        System.out.println("Contenidos de " + current.name + ":");
        for (Node child : current.children) {
            System.out.println((child.isFile ? "[FILE] " : "[DIR] ") + child.name);
        }
    }
}