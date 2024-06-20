import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instructions extends MyWorld
{
    String[] types = {"paper", "organic"};
    public Instructions()
    {   
        super(650, 650, 1, 3, 1000,0); // setting initial values
        //showText("Level 1", getWidth() / 2, 50);
        //showText("Πατήστε Enter για να ξεκινήσετε", getWidth() / 2, 600);
        prepare();
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new FirstLevelIntro());
        }
    }
    
    private void prepare()
    {
        Message message = new Message("Πώς παίζεται:",new Font("Arial", false, false, 24),//Color.BLACK);
        new Color(255, 69, 0),60);
        addObject(message, getWidth() / 2, 50);
        
        Message instruction = new Message("Θέλεις να σώσεις το περιβάλλον;",new Font("Arial", false, false, 24),//Color.BLACK);
        Color.BLACK,24); //new Color(255, 69, 0
        addObject(instruction, getWidth() / 2, 115);
        
        Message text = new Message("""
        Παίξε και μάθε για την ανακύκλωση. Σύρε τα απορρίματα 
        στο σωστό κάδο και κέρδισε. Πρόσεχε! Κάθε λάθος μετράει!""", new Font("Arial", false, false, 24), new Color(65, 65, 79),24);
        addObject(text, getWidth() / 2, 160);
        
        Decoration paper_bin = new Decoration("recycle_bin_paper.png",100,150);
        addObject(paper_bin,150,300);
    
        Decoration b_arrow = new Decoration("blue_arrow.png",100,50);
        addObject(b_arrow,300,300);

        Decoration paper = new Decoration("papertrash.png",150,150);
        addObject(paper,500,300);
        
        Message instruction1 = new Message("+1 πόντος",new Font("Arial", false, false, 24),new Color(0, 112, 192),32);
        addObject(instruction1, 300, 250);
        
        
        Decoration organic_bin = new Decoration("recycle_bin_organic.png",100,150);
        addObject(organic_bin,150,475);
        
        Message instruction2 = new Message("-1 x ",new Font("Arial", false, false, 24),new Color(255, 0, 0),32);
        addObject(instruction2, 288, 425);
        
        Message instruction3 = new Message("-1 πόντος",new Font("Arial", false, false, 24),new Color(255, 0, 0),32);
        addObject(instruction3, 300, 525);
        
        Decoration g_arrow = new Decoration("grey_arrow.png",100,50);
        addObject(g_arrow,300,475);
        
        Decoration organic = new Decoration("papertrash.png",150,150);
        addObject(organic,500,475);
        
        Decoration heart = new Decoration("herz.png",30,30);
        addObject(heart,330,425);
        
        Button skipButton = new Button("Επόμενο");
        addObject(skipButton, getWidth() / 2, 600);
    }
}
