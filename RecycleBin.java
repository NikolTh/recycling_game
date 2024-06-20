import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RecycleBin extends Actor
{
    private String acceptedType;
    private GreenfootImage closedImage;
    private GreenfootImage openImage;
    
    public RecycleBin(String acceptedType) {
        this.acceptedType = acceptedType;
        setImageBasedOnType();
    }

    private void setImageBasedOnType() {
        switch (acceptedType) {
            case "paper":
                closedImage = new GreenfootImage("recycle_bin_paper.png");
                openImage = new GreenfootImage("recycle_bin_paper2.png");
                break;
            case "plastic":
                closedImage = new GreenfootImage("recycle_bin_plastic.png");
                openImage = new GreenfootImage("recycle_bin_plastic2.png");
                break;
            case "glass":
                closedImage = new GreenfootImage("recycle_bin_glass.png");
                openImage = new GreenfootImage("recycle_bin_glass2.png");
                break;
            case "metal":
                closedImage = new GreenfootImage("recycle_bin_metal.png");
                openImage = new GreenfootImage("recycle_bin_metal2.png");
                break;
            default:
                closedImage = new GreenfootImage("recycle_bin_organic.png");
                openImage = new GreenfootImage("recycle_bin_organic2.png");
                break;
        }
        setImage(closedImage);
    }
    
    public void act() {
        checkForTrash();
    }

    private void checkForTrash() {
        Trash trash = (Trash) getOneIntersectingObject(Trash.class);
        MyWorld world = (MyWorld) getWorld();
        String correctBin="";
        String trashType="";
        if (trash != null && trash.getType().equals(acceptedType) && !trash.isChecked()) {
            trash.setChecked(true);
            world.increaseScore();
            setImage(openImage);
            getWorld().removeObject(trash);
            Greenfoot.playSound("correct.mp3"); // Optional success sound
            Greenfoot.delay(3);
        } else if (trash != null && !trash.isChecked()) {
            world.decreaseScore();
            world.loseLife();
            trash.setChecked(true);
            getWorld().removeObject(trash);
            
            if (trash.getType()=="paper"){
                trashType="χαρτί";
                correctBin="μπλε";
            }
            else if (trash.getType()=="plastic"){
                trashType="πλαστικό";
                correctBin="κίτρινο";
            }
            else if (trash.getType()=="glass"){
                trashType="γυαλί";
                correctBin="πράσινο";
            }
            else if (trash.getType()=="metal"){
                trashType="μέταλλο";
                correctBin="πορτοκαλί";
            }
            else if (trash.getType()=="organic"){
                trashType="οργανικό";
                correctBin="γκρι";
            }
            world.showMessage("Το υλικό αυτό είναι " + trashType + 
            " δεν μπαίνει σε αυτόν τον κάδο.\nΠρέπει να πάει στον " + correctBin + " κάδο", new Color(255, 128, 128));
            
        }
        
        setImage(closedImage);
    }
    
    
}
