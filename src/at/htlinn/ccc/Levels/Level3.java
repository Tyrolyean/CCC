package at.htlinn.ccc.Levels;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Level3 extends Level {
    @Override
    public String main(String[] input) {
        Map<String, Double> nodes = new HashMap<>();
        Map<String, Double> pools = new HashMap<>();

        int nodeNr = Integer.parseInt(input[0]);
        int poolNr;

        ArrayList<String> poolIDs = new ArrayList<>();
        ArrayList<String> nodeIDs = new ArrayList<>();

        double allHashPower = 0;

        int i = 0;
        for (i = 1; i <= nodeNr; i++) {
            String[] input_ = input[i].split(" ");
            nodes.put(input_[0], Double.parseDouble(input_[1]));
            nodeIDs.add(input_[0]);
            allHashPower += Integer.parseInt(input_[1]);
        }

        poolNr = Integer.parseInt(input[i]);

        i++;

        int end = i + poolNr;

        while (i < end) {
            String[] in = input[i].split(" ");

            double hashPower = 0;
            for (int j = 1; j < in.length; j++) {
                hashPower += nodes.get(in[j]);
            }

            pools.put(in[0], hashPower);
            poolIDs.add(in[0]);

            i++;
        }

        ArrayList<NodeConnection> nodeConnections = new ArrayList<>();

        while(i < input.length)
        {
            String[] in = input[i].split(" ");
            nodeConnections.add(new NodeConnection(in[0], in[1], Double.parseDouble(in[2])));
        }

        return "";
    }


    @Override
    public void setLevel(int levelNr)
    {
        throw new UnsupportedOperationException();
    }
}