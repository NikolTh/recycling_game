import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ThirdLevelIntro extends MyWorld
{
    String[] types = {"paper", "plastic", "organic"};
    private int score;
    public ThirdLevelIntro(int score)
    {   
        super(650, 650, 1, 3, 3000, score); // setting initial values
        this.score = score; // Α�?χικοποίηση των score

        //showText("Level 3", getWidth() / 2, 100);
        //showText("Πατήστε Enter για συνέχεια", getWidth() / 2, 500);
        
        prepare();
    }
    
    public void act()
        {
            if (Greenfoot.isKeyDown("enter")) {
                Greenfoot.setWorld(new ThirdLevel(getScore()));
            }
        }
    
    private void prepare()
    {
        Message message = new Message("Level 3",new Font("Arial", false, false, 24),//Color.BLACK);
        new Color(255, 69, 0),60);
        addObject(message, getWidth() / 2, 100);
        
        addObject(new RecycleBin("glass"), 150, 325);
        
        
        Decoration g_arrow = new Decoration("green_arrow.png",100,50);
        addObject(g_arrow,300,325);
        
        Decoration glass = new Decoration("glasstrash.png",100,100);
        addObject(glass,500,325);
        
        
        Button skipButton = new Button("Παίξε");
        addObject(skipButton, getWidth() / 2, 500);

    }
}
