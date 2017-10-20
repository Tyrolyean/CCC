package at.htlinn.ccc.Levels;

public class NodeConnection
{
    public Node nodeID1;
    public Node nodeID2;
    public double latency;

    public NodeConnection(Node n1, Node n2, double latency)
    {
        nodeID1 = n1;
        nodeID2 = n2;
        this.latency = latency;
    }
}
