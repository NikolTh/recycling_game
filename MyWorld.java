import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class MyWorld extends World
{
    private int score;
    private int time;
    private int spawnCounter;
    private int lives;
    //public Text scoreLabel;
    private List<Lives> livesList;
    private GreenfootImage messageImage;
    public GreenfootSound backgroundMusic;
    
    public MyWorld(int width, int height, int cellSize, int initialLives, int initialTime, int score)
    {    
        super(width, height, cellSize); 
        time = initialTime; // game duration in frames
        spawnCounter = 0;
        lives = initialLives;
        livesList = new ArrayList<>();
        this.score=score;
        backgroundMusic = new GreenfootSound("main.mp3");
    }
    public void endOfTime(){
        if (getTime() <= 0 && this instanceof FirstLevel) {
            Greenfoot.playSound("level-up.mp3");
            Greenfoot.setWorld(new SecondLevelIntro(getScore()));
        }
        else if (getTime() <= 0 && this instanceof SecondLevel) {
            Greenfoot.playSound("level-up.mp3");
            Greenfoot.setWorld(new ThirdLevelIntro(getScore()));
        }
        else if (getTime() <= 0 && this instanceof ThirdLevel) {
            Greenfoot.playSound("level-up.mp3");
            Greenfoot.setWorld(new FourthLevelIntro(getScore()));
        }
       
    }
    public void started()
    {
        backgroundMusic.playLoop();
    }
    
    public void stopped()
    {
        backgroundMusic.stop();
    }
    public void increaseScore()
    {
        score++;
        updateScore();
    }

    public void decreaseScore()
    {
        score--;
        updateScore();
    }
    
    public void updateScore() {
        showText("Score: " + score, 150, 20);
        //scoreLabel.setText("Score: " + score);
    }

    public void loseLife()
    {
        if (lives > 1) {
            lives--;
            removeObject(livesList.remove(livesList.size() - 1));
            Greenfoot.playSound("au.wav"); // Optional failure sound
        } else {
            gameOver();
        }
    }

    public void gameOver()
    {
        Message message = new Message("""
        Game Over!
        Score: """ + " " + score,new Font("Arial", false, false, 24),Color.RED,42);
        addObject(message, getWidth() / 2, 300);
        Greenfoot.playSound("game-over.mp3");
        Greenfoot.delay(60);
        //Greenfoot.delay(120); // Delay to show the message for a short time
        //removeObject(message);
        //showText("Game Over! Score: " + score, getWidth() / 2, getHeight() / 2);
        Greenfoot.setWorld(new Intro());
        
        //Greenfoot.stop();
    }

    public void winMessage()
    {
        PopUp winner = new PopUp("You won!!",score);
        addObject(winner, getWidth() / 2, getHeight() / 2);
        Greenfoot.delay(250);
        return;
    }
    
    public void createCounters()
    {
        //scoreLabel = new Text("Score: " + score);
        //addObject(scoreLabel, 150, 20);

        // Add lives images
        for (int i = 0; i < lives; i++) {
            Lives life = new Lives();
            livesList.add(life);
            addObject(life, 520 + (i * 40), 30);
        }
    }

    public void spawnTrash(String[] types)
    {
        
        int index = Greenfoot.getRandomNumber(types.length);
        Trash trash = new Trash(types[index]);
        addObject(trash, Greenfoot.getRandomNumber(getWidth()), 0);
    }

    public int getLives()
    {
        return lives;
    }

    public void updateTime() {
        time--;
    }

    public int getTime() {
        return time;
    }

    public int getSpawnCounter() {
        return spawnCounter;
    }

    public void resetSpawnCounter() {
        spawnCounter = 0;
    }

    public void incrementSpawnCounter() {
        spawnCounter+=1;
    }
    
    public int getScore()
    {
        return score;
    }
    
    /*public  void showMessage(String text, Color color) {
        messageImage = new GreenfootImage(text, 24, color, Color.BLACK);
        messageImage.setFont(new Font("Arial", false, false, 24));
        setImage(messageImage);
        addObject(message, getWidth() / 2, getHeight() / 2);
        Greenfoot.delay(120); // Delay to show the message for a short time
        removeObject(message);
    }*/
    
    public void showMessage(String text, Color color) {
        Message message = new Message(text,new Font("Arial", false, false, 24),color,24);
        addObject(message, getWidth() / 2, getHeight() / 2);
        Greenfoot.delay(120); // Delay to show the message for a short time
        removeObject(message);
    }
}
