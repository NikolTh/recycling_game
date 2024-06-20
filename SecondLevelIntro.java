import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SecondLevelIntro extends MyWorld
{
    String[] types = {"paper", "plastic", "organic"};
    private int score;
    public SecondLevelIntro(int score)
    {   
        super(650, 650, 1, 3, 1000, score); // setting initial values
        this.score = score; // Αρχικοποίηση των score
        
        //showText("Level 2", getWidth() / 2, 100);

        //showText("Πατήστε Enter για συνέχεια", getWidth() / 2, 500);
        
        prepare();
    }
    
    public void act()
        {
            if (Greenfoot.isKeyDown("enter")) {
                Greenfoot.setWorld(new SecondLevel(getScore()));
            }
        }
    
    private void prepare()
    {

        Message message = new Message("Level 2",new Font("Arial", false, false, 24),//Color.BLACK);
        new Color(255, 69, 0),60);
        addObject(message, getWidth() / 2, 100);
        
        addObject(new RecycleBin("plastic"), 150, 325);

        Decoration y_arrow = new Decoration("yellow_arrow.png",100,50);
        addObject(y_arrow,300,325);

        Decoration plastic = new Decoration("plastictrash.png",200,200);
        addObject(plastic,500,325);

        Button skipButton = new Button("Παίξε");
        addObject(skipButton, getWidth() / 2, 500);
    }
}
