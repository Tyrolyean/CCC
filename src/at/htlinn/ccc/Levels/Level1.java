package at.htlinn.ccc.Levels;

import at.htlinn.ccc.Tools;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.InternetHeaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Level1 extends Level
{
    @Override
    public String main(String[] input)
    {
        Map<String, Integer> nodes = new HashMap<>();
        Map<String, Integer> pools = new HashMap<>();

        int nodeNr = Integer.parseInt(input[0]);
        int poolNr;

        ArrayList<String> poolIDs = new ArrayList<>();

        int allHashPower = 0;

        int i=0;
        for(i=1; i<=nodeNr;i++)
        {
            String[] input_ = input[i].split(" ");
            nodes.put(input_[0], Integer.parseInt(input_[1]));
            allHashPower += Integer.parseInt(input_[1]);
        }

        poolNr = Integer.parseInt(input[i]);

        i++;

        int end = i+poolNr;

        while(i<end)
        {
            String[] in = input[i].split(" ");

            int hashPower = 0;
            for(int j=1;j<in.length;j++)
            {
                hashPower += nodes.get(in[j]);
            }

            pools.put(in[0], hashPower);
            poolIDs.add(in[0]);

            i++;
        }

        String output = Integer.toString(allHashPower) +" ";

        for(i=0;i<pools.size();i++)
        {
            output += poolIDs.get(i) + " " + pools.get(poolIDs.get(i)) + " ";
        }

        return output;
    }

    @Override
    public void setLevel(int levelNr)
    {
        throw new UnsupportedOperationException();
    }
}