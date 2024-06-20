import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FourthLevel extends MyWorld
{
    String[] types = {"paper", "plastic", "glass", "metal", "organic"};
    private int score;
    
    public FourthLevel(int score)
    {   
        super(650, 650, 1, 3, 4500,score); // setting initial values
        this.score = score; // Αρχικοποίηση των score
        prepare();
    }
    
    public void act()
    {
        updateTime();
        incrementSpawnCounter();
        showText("Time: " + getTime() / 60, 50, 20); // display time in seconds
        updateScore(); // display score

        if (getSpawnCounter() >= 80) {
            spawnTrash(types);
            resetSpawnCounter();
        }

        if (getTime() <= 0) {
            Greenfoot.playSound("success.mp3");
            winMessage();
            Greenfoot.setWorld(new Intro());
        }
    }

    private void prepare()
    {
        // Add recycling bins
        addObject(new RecycleBin("paper"), 80, 550);
        addObject(new RecycleBin("plastic"), 200, 550);
        addObject(new RecycleBin("glass"), 320, 550);
        addObject(new RecycleBin("metal"), 440, 550);
        addObject(new RecycleBin("organic"), 560, 550);

        // Create score and lives counters
        createCounters();
    }
}
