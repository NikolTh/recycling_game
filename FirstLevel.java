import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FirstLevel extends MyWorld
{
    String[] types = {"paper", "organic"};
    public FirstLevel()
    {   
        super(650, 650, 1, 3, 1500,0); // setting initial values
        prepare();
    }
    
    public void act()
    {
        updateTime();
        incrementSpawnCounter();
        showText("Time: " + getTime() / 60, 50, 20); // display time in seconds
        updateScore();

        if (getSpawnCounter() >= 110) {
            spawnTrash(types);
            resetSpawnCounter();
        }

        endOfTime();
    }

    
    private void prepare()
    {
        // Add recycling bins
        addObject(new RecycleBin("paper"), 200, 550);
        addObject(new RecycleBin("organic"), 440, 550);

        // Create score and lives counters
        createCounters();
    }
}