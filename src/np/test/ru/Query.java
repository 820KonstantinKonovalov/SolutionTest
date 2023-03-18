package np.test.ru;

public class Query {
    //private String from;
    //private String to;

    public String[] getEdge() {
        return edge;
    }

    private String[] edge = new String[2];

    @Override
    public String toString() {
        return "Query{" +
                "from='" + edge[0] + '\'' +
                ", to='" + edge[1] + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Query)) return false;

        Query query = (Query) o;

        if (!edge[0].equals(query.edge[0])) return false;
        return edge[1].equals(query.edge[1]);
    }

    @Override
    public int hashCode() {
        int result = edge[0].hashCode();
        result = 31 * result + edge[1].hashCode();
        return result;
    }

    public String getFrom() {
        return edge[0];
    }

    public String getTo() {
        return edge[1];
    }

    public Query(String from, String to){
        edge[0] = from;
        edge[1] = to;
    }
}
