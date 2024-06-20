import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ThirdLevel extends MyWorld
{
    String[] types = {"paper", "plastic", "glass", "organic"};
    private int score;
    
    public ThirdLevel(int score)
    {   
        super(650, 650, 1, 3, 3500, score); // setting initial values
        this.score = score; // Αρχικοποίηση των score

        prepare();
    }
    
    public void act()
    {
        updateTime();
        incrementSpawnCounter();
        showText("Time: " + getTime() / 60, 50, 20); // display time in seconds
        updateScore(); // display score

        if (getSpawnCounter() >= 90) {
            spawnTrash(types);
            resetSpawnCounter();
        }

        endOfTime();
    }

    
    
    private void prepare()
    {
        // Add recycling bins
        addObject(new RecycleBin("paper"), 140, 550);
        addObject(new RecycleBin("plastic"), 260, 550);
        addObject(new RecycleBin("glass"), 380, 550);
        addObject(new RecycleBin("organic"), 500, 550);

        // Create score and lives counters
        createCounters();
    }
}
