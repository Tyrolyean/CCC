package at.htlinn.ccc.Levels;

public class Level
{
    private Level l;

    public Level() {}
    public Level(int levelNr)
    {
        setLevel(levelNr);
    }

    public void setLevel(int levelNr)
    {
        if(levelNr > 0)
            switch (levelNr)
            {
                case 1: l = new Level1(); break;
                case 2: l = new Level2(); break;
                case 3: l = new Level3(); break;
                case 4: l = new Level4(); break;
                case 5: l = new Level5(); break;
            }
        else throw new IllegalArgumentException();
    }

    public String main(String[] input)
    {
        return l.main(input);
    }
}
