import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FourthLevelIntro extends MyWorld
{
    String[] types = {"paper", "plastic", "organic"};
    private int score;
    public FourthLevelIntro(int score)
    {   
        super(650, 650, 1, 3, 1000, score); // setting initial values
        this.score = score; // Α�?χικοποίηση των score

        //showText("Level 4", getWidth() / 2, 100);
        //showText("Πατήστε Enter για συνέχεια", getWidth() / 2, 500);
        
        prepare();
    }
    
    public void act()
        {
            if (Greenfoot.isKeyDown("enter")) {
                Greenfoot.setWorld(new FourthLevel(getScore()));
            }
        }
    
    private void prepare()
    {
        Message message = new Message("Level 4",new Font("Arial", false, false, 24),//Color.BLACK);
        new Color(255, 69, 0),60);
        addObject(message, getWidth() / 2, 100);
        
        addObject(new RecycleBin("metal"), 150, 325);
        
        
        Decoration o_arrow = new Decoration("orange_arrow.png",100,50);
        addObject(o_arrow,300,325);
        
        Decoration metal = new Decoration("metaltrash.png",200,150);
        addObject(metal,500,325);
        
        
        Button skipButton = new Button("Παίξε");
        addObject(skipButton, getWidth() / 2, 500);
        
    }
}
