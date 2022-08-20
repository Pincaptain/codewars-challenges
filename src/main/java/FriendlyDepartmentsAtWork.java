import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

class Graph {

    private static int uidCounter = 0;
    Set<Vertex> vertices;
    Set<Edge> edges;

    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public void addVertices(Vertex... vertices) {
        for (Vertex v : vertices)
            addVertex(v);
    }

    public void addEdge(Vertex v1, Vertex v2) {
        addEdge(new Edge(v1, v2));
    }

    public void addEdge(Edge edge) {
        vertices.add(edge.v1);
        vertices.add(edge.v2);
        edges.add(edge);
    }

    public void addEdges(Vertex... vertices) {
        if (vertices.length % 2 != 0)
            throw new IllegalArgumentException();

        for (int i = 0; i < vertices.length; i = i + 2) {
            addEdge(vertices[i], vertices[i + 1]);
        }
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    static int getUidForNode() {
        return uidCounter++;
    }
}

class Vertex {

    private final int uid;

    Vertex() {
        uid = Graph.getUidForNode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex other = (Vertex) o;
        return uid == other.uid;
    }

    @Override
    public int hashCode() {
        return uid;
    }
}

class Edge {

    Vertex v1;
    Vertex v2;

    Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge other = (Edge) o;
        return (v1.equals(other.v1) && v2.equals(other.v2)) || (v1.equals(other.v2) && v2.equals(other.v1));
    }

    @Override
    public int hashCode() {
        return v1.hashCode() + v2.hashCode();
    }
}

public class FriendlyDepartmentsAtWork {

    public static int departmentConnections(Graph graph, Set<Vertex> department1, Set<Vertex> department2) {
        return graph.getEdges().stream()
                .mapToInt(edge -> (department1.contains(edge.getV1()) && department2.contains(edge.getV2())) ||
                        (department1.contains(edge.getV2()) && department2.contains(edge.getV1())) ? 1 : 0).sum();
    }

    public static void main(String[] args) {

    }
}
