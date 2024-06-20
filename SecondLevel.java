import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SecondLevel extends MyWorld
{
    String[] types = {"paper", "plastic", "organic"};
    private int score;
    public SecondLevel(int score)
    {   
        super(650, 650, 1, 3, 2500, score); // setting initial values
        this.score = score; // Αρχικοποίηση των score

        prepare();
    }
    
    public void act()
    {
        updateTime();
        incrementSpawnCounter();
        showText("Time: " + getTime() / 60, 50, 20); // display time in seconds
        updateScore(); // display score

        if (getSpawnCounter() >= 100) {
            spawnTrash(types);
            resetSpawnCounter();
        }

        endOfTime();
    }

    
    
    private void prepare()
    {
        // Add recycling bins
        addObject(new RecycleBin("paper"), 200, 550);
        addObject(new RecycleBin("plastic"), 320, 550);
        addObject(new RecycleBin("organic"), 440, 550);

        // Create score and lives counters
        createCounters();
    }
}
