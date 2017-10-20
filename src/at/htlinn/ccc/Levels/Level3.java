package at.htlinn.ccc.Levels;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Level3 extends Level {


    ArrayList<Node> allNodes = new ArrayList<>();
    ArrayList<Node> ways = new ArrayList<>();



    @Override
    public String main(String[] input) {
        Map<String, Double> nodes = new HashMap<>();
        Map<String, Double> pools = new HashMap<>();

        int nodeNr = Integer.parseInt(input[0]);
        int poolNr;

        ArrayList<String> poolIDs = new ArrayList<>();
        ArrayList<String> nodeIDs = new ArrayList<>();


        int i = 0;
        for (i = 1; i <= nodeNr; i++) {


            if(input[i].equalsIgnoreCase("0")){
                i++;
                break;
            }
            String[] input_ = input[i].split(" ");
            nodes.put(input_[0], Double.parseDouble(input_[1]));
            nodeIDs.add(input_[0]);
            allHashPower += Integer.parseInt(input_[1]);

            Node n = new Node(input_[0],Double.parseDouble(input_[1]));

            allNodes.add(n);

        }

        i++;

        for(;i <= input.length; i++){

            String[] input_ = input[i].split(" ");


            Node n1;
            Node n2;
            for(Node n : allNodes) {
                if(n.id.equalsIgnoreCase(input_[0])){
                    n1 = n;
                }else if( n.id.equalsIgnoreCase(input_[1])){
                    n2 = n;
                }
            }

            NodeConnection con = new NodeConnection(n1, n2, Double.parseDouble(input_[2]));

            n1.addCon(n2, Double.parseDouble(input_[2]));
            n2.addCon(n1, Double.parseDouble(input_[2]));

        }



        for(Node n : allNodes){
            for(NodeConnection con : n.conns){

                ArrayList<NodeConnection> history = new ArrayList<>();
                history.add(con);

                testNode(con.nodeID2,con.latency,history);

            }
        }




        return "";
    }


    @Override
    public void setLevel(int levelNr) {
        throw new UnsupportedOperationException();
    }




    String way = "";
    ArrayList<double[]> sets = new ArrayList<>();



    public void testNode(Node n, ArrayList<NodeConnection> history, double total_lat, int total_hashrate) {

        if(total_hashrate >= (allHashPower / 2)){


        }

        double gesLatency = 0;
        double gesHash = 0;

        for (NodeConnection con : n.conns) {



            if (!history.contains(n)) {
                gesLatency += con.latency;
                gesHash += con.nodeID1.hashRate;




                double[] set = new double[2];
                set[0] = con.latency;
                set[1] = con.nodeID1.hashRate;

                way += n.id + " ";
                usedNodes.add(n);
                sets.add(set);
                testNode(con.nodeID2, );
            }else{
                return;
            }

        }

    }

}