package game.characters;

import city.cs.engine.*;
import game.Game;


public class fatman extends Walker {
    private Game game;
    //public FatmanController(Game game){
        //this.game = game;
    //}

    private static final Shape fatmanShape = new PolygonShape(
            -0.169f, 0.932f, -0.361f, -0.168f, -0.249f, -0.924f, 0.119f, -0.944f, 0.403f, 0.304f, -0.005f, 0.936f);

    private static final BodyImage image_left =
            new BodyImage("data/John_Fatman.png", 2f);//image update when walking left
    private static final BodyImage image_right =
            new BodyImage("data/John_FatmanR.png", 2f);//image update when walking right

    public static BodyImage getImageLeft() {
        return image_left;
    }//responds to the method when called from controller

    public static BodyImage getImageRight() {
        return image_right;
    }

    private int vegCount; //or score
    private int liveCount;

    public fatman(World world) {
        super(world, fatmanShape);
        addImage(image_left);
        vegCount = 0; //default score
        liveCount = 2;//default lives
    }

    public int getVegCount() {
        return vegCount;
    }// this methods returns the score when called for different purposes

    public void incrementVegCount() { //when pickup are made or collions happens with "veg", this method wil be called and will increase the score by 1
        vegCount++;
        System.out.println("Delicious!! Ring count = " + vegCount);
    }

    public int getLiveCount() {
        return liveCount;
    } //will return lives count when jumping to next level

    public void decrementLiveCount() {//if collision happen with "toxic", a life will be taken awau.
        liveCount--;
        System.out.println("NOT HEALTHY!! Lost life. Lives = " + liveCount);
    }

    {
        if (liveCount == 0) ;

        System.out.println(("YOU HAVE DIED, TRY AGAIN."));
    }

    public void updateFatman(fatman fatman) {
        game.getLevel().getFatman();
    }
    public void setLiveCount(int lc){
        liveCount = lc;
    } //this methods will set lives when loading a game
}

