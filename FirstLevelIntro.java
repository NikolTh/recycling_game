import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FirstLevelIntro extends MyWorld
{
    String[] types = {"paper", "organic"};
    public FirstLevelIntro()
    {   
        super(650, 650, 1, 3, 1000,0); // setting initial values
        //showText("Level 1", getWidth() / 2, 50);
        //showText("Πατήστε Enter για να ξεκινήσετε", getWidth() / 2, 600);
        prepare();
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new FirstLevel());
        }
    }
    
    private void prepare()
    {
        Message message = new Message("Level 1",new Font("Arial", false, false, 24),//Color.BLACK);
        new Color(255, 69, 0),60);
        addObject(message, getWidth() / 2, 50);
        
        // Add recycling bins
        addObject(new RecycleBin("paper"), 150, 200);
        addObject(new RecycleBin("organic"), 150, 450);

        Decoration b_arrow = new Decoration("blue_arrow.png",100,50);
        addObject(b_arrow,300,200);

        Decoration paper = new Decoration("papertrash.png",200,200);
        addObject(paper,500,200);
        
        Message instruction = new Message("Drag",new Font("Arial", false, false, 24),new Color(255, 0, 0),42);
        Message instruction2 = new Message(" & ",new Font("Arial", false, false, 24),new Color(255, 87, 51),42);
        Message instruction3 = new Message("Drop",new Font("Arial", false, false, 24),new Color(255, 69, 0),42);
        //new Color(0, 112, 192),42);
        //addObject(instruction, 300, getHeight() / 2 - 50);
        //addObject(instruction2, 300, getHeight() / 2);
        //addObject(instruction3, 300, getHeight() / 2 + 50);

        Decoration g_arrow = new Decoration("grey_arrow.png",100,50);
        addObject(g_arrow,300,450);

        Decoration organic = new Decoration("organicwaste.png",200,200);
        addObject(organic,500,450);

        Button skipButton = new Button("Παίξε");
        addObject(skipButton, getWidth() / 2, 600);
    }
}
