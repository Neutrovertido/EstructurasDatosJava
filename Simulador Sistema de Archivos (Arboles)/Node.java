import java.util.ArrayList;
import java.util.List;

public class Node {
    String name;
    boolean isFile;
    List<Node> children;
    Node parent;

    Node(String name, boolean isFile, Node parent) {
        this.name = name;
        this.isFile = isFile;
        this.children = new ArrayList<>();
        this.parent = parent;
    }

    Node findChild(String name) {
        for (Node child : children) {
            if (child.name.equals(name)) {
                return child;
            }
        }
        return null;
    }
}