import greenfoot.*; 

public class Intro extends MyWorld
{
    
    
    public Intro()
    {    
        super(650, 650, 1,0,0,0);
        //showText("Πατήστε Enter για συνέχεια", getWidth() / 2, 600);
        
        prepare();
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Instructions());
        }
        
        //showMessage("Πατήστε Enter για συνέχεια", new Color(83, 109, 254));
    }
    
    public void prepare(){
        //Message message = new Message("Πατήστε Enter για συνέχεια",new Font("Arial", false, false, 24),//Color.BLACK);
        //new Color(27, 94, 32));
        //addObject(message, getWidth() / 2, 600);
        Button skipButton = new Button("Ξεκίνα");
        addObject(skipButton, getWidth() / 2, 600);

        
        // Add recycling bins
        addObject(new RecycleBin("paper"), 80, 450);
        addObject(new RecycleBin("plastic"), 200, 450);
        addObject(new RecycleBin("glass"), 320, 450);
        addObject(new RecycleBin("metal"), 440, 450);
        addObject(new RecycleBin("organic"), 560, 450);

    }
}