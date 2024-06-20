import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Button extends Actor {
    private GreenfootImage normalImage;
    private GreenfootImage hoverImage;
    
    public Button(String text) {
        normalImage = createRoundedImage(text, 24, Color.WHITE, new Color(255, 69, 0), 110, 50, 20);
        hoverImage = createRoundedImage(text, 24, new Color(255, 69, 0), Color.WHITE, 110, 50, 20);
        setImage(normalImage);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            MyWorld world = (MyWorld) getWorld();
            if (world instanceof Intro) {
                Greenfoot.setWorld(new Instructions());
            } else if (world instanceof Instructions) {
                Greenfoot.setWorld(new FirstLevelIntro());
            } else if (world instanceof FirstLevelIntro) {
                Greenfoot.setWorld(new FirstLevel());
            } else if (world instanceof SecondLevelIntro) {
                Greenfoot.setWorld(new SecondLevel(world.getScore()));
            } else if (world instanceof ThirdLevelIntro) {
                Greenfoot.setWorld(new ThirdLevel(world.getScore()));
            } else if (world instanceof FourthLevelIntro) {
                Greenfoot.setWorld(new FourthLevel(world.getScore()));
            }
        }
        
        if (Greenfoot.mouseMoved(this)) {
            setImage(hoverImage);
        } else if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setImage(normalImage);
        }
    }

    private GreenfootImage createRoundedImage(String text, int fontSize, Color textColor, Color bgColor, int width, int height, int arcSize) {
        GreenfootImage image = new GreenfootImage(width, height);

        image.setColor(bgColor);

        image.fillRect(arcSize / 2, 0, width - arcSize, height);
        image.fillRect(0, arcSize / 2, width, height - arcSize);

        image.fillOval(0, 0, arcSize, arcSize);
        image.fillOval(width - arcSize, 0, arcSize, arcSize);
        image.fillOval(0, height - arcSize, arcSize, arcSize);
        image.fillOval(width - arcSize, height - arcSize, arcSize, arcSize);

        GreenfootImage textImage = new GreenfootImage(text, fontSize, textColor, new Color(0, 0, 0, 0));
        textImage.setFont(new Font("Arial", false,false, fontSize));
        int textWidth = textImage.getWidth();
        int textHeight = textImage.getHeight();
        image.drawImage(textImage, (width - textWidth) / 2, (height - textHeight) / 2);

        
        return image;
    }
}
