package at.htlinn.ccc.Levels;

public class NodeConnection
{
    public String nodeID1;
    public String nodeID2;
    public double latency;

    public NodeConnection(String n1, String n2, double latency)
    {
        nodeID1 = n1;
        nodeID2 = n2;
        this.latency = latency;
    }
}
