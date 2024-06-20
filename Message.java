import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Message extends Actor
{
    private GreenfootImage messageImage;

    public Message(String text, Font font, Color color, int fontsize) {
        messageImage = new GreenfootImage(text, fontsize, color, new Color(0, 0, 0, 0));
        messageImage.setFont(font);
        setImage(messageImage);
    }

    public void act() {
        // Μπορείτε να προσθέσετε οποιαδήποτε κίνηση ή κινούμενο γραφικό θέλετε εδώ
    }
}
