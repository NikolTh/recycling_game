import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class Trash extends Actor
{
    private String type;
    private boolean isDragged = false;
    private boolean checked = false; 
    private int fallSpeed = 2;
    private static final String[] paperImages = {"papers.png", "paper.png", "newspaper.png", "paper1.png", 
        "paper2.png", "paper3.png", "paper4.png", "paper5.png", "paper6.png"};
    private static final String[] plasticImages = {"pbottle.png", "plastic.png", "plastic2.png", "plastic3.png", "plastic4.png", "plastic5.png",
    "plastic6.png", "plastic7.png", "plastic8.png", "plastic9.png"};
    private static final String[] glassImages = {"tbottle.png", "bglasses.png", "glass2.png"};
    private static final String[] metalImages = {"fcan.png", "can.png", "metal3.png", "can2.png", "can3.png"};
    private static final String[] organicImages = {"banana.png", "apple.png", "bone.png", "fish.png", "chips-1.png", 
        "pizza_cheese.png","carrot.png"};
    private Random random = new Random();
    
    public Trash(String type) {
        this.type = type;
        setImageBasedOnType();
    }

    private void setImageBasedOnType() {
        String[] images = null;

        switch (type) {
            case "paper":
                images = paperImages;
                break;
            case "plastic":
                images = plasticImages;
                break;
            case "glass":
                images = glassImages;
                break;
            case "metal":
                images = metalImages;
                break;
            case "organic":
                images = organicImages;
                break;
        }
        if (images != null && images.length > 0) {
            int index = random.nextInt(images.length);
            GreenfootImage image = new GreenfootImage(images[index]);
            image.scale(50, 50); // Resize the image to 50x50 pixels
            setImage(image);
        }
    }

    public String getType() {
        return type;
    }
    
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    public boolean isChecked() {
        return checked;
    }
    
    public void act()
    {
        if (!isDragged) {
            setLocation(getX(), getY() + fallSpeed);
            if (getY() >= getWorld().getHeight()) {
                getWorld().removeObject(this);
            }
        }

        checkMouse();
    }

    private void checkMouse()
    {
        if (Greenfoot.mousePressed(this)) {
            isDragged = true;
        }

        if (isDragged && Greenfoot.mouseDragged(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }

        if (isDragged && Greenfoot.mouseDragEnded(this)) {
            isDragged = false;
        }
    }
}