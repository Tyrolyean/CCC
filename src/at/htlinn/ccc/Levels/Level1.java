package at.htlinn.ccc.Levels;

import at.htlinn.ccc.Tools;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.InternetHeaders;

import java.util.HashMap;
import java.util.Map;

public class Level1 extends Level
{
    @Override
    public String main(String[] input)
    {
        Map<String, Integer> nodes = new HashMap<>();

        int nodeNr = Integer.parseInt(input[0]);

        for(int i=1; i<nodeNr;i++)
        {
            String[] input_ = input[i].split(" ");
            nodes.put(input_[0], Integer.parseInt(input_[1]));
        }

        //Transform file input into useful output!

        return output;
    }

    @Override
    public void setLevel(int levelNr)
    {
        throw new UnsupportedOperationException();
    }
}