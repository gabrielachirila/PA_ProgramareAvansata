import java.util.*;
import java.util.Comparator;

public class Network {
    static private List<Node> nodes = new ArrayList<>();

    public Network() {
    }
    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
    public void addNode(Node node) {

        nodes.add(node);
    }

    @Override
    public String toString() {
            Collections.sort(nodes, new Comparator<Node>() {
                public int compare(Node n1, Node n2) {
                    return n1.getNodeImportance().compareTo(n2.getNodeImportance());
                }
            });
        final StringBuffer sb = new StringBuffer("Network{");
        sb.append("nodes=").append(nodes);
        sb.append('}');
        return sb.toString();
    }
}
