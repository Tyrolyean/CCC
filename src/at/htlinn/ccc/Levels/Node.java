package at.htlinn.ccc.Levels;

import java.util.ArrayList;

public class Node {

public String id;
public double hashRate;
public ArrayList<NodeConnection> conns;

    public Node(String id, double hashRate) {
        this.id = id;
        this.hashRate = hashRate;
        this.conns = new ArrayList<NodeConnection>();

    }

    public void addCon(Node n , double latency){
        conns.add(new NodeConnection(this, n , latency));
    }



}
