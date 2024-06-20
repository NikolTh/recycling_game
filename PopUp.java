import greenfoot.*; 

public class PopUp extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public PopUp(String text, int score)
    {
        makeImage(text, "Score: ", score);
    }
    
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255, 69, 0, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 218, 185, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);//new Color(255, 253, 231));
        image.drawString(title, WIDTH/4, 100);
        image.drawString(prefix + score, WIDTH/4, 200);
        setImage(image);
    }
}
