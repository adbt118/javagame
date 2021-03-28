package levels;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.*;
import game.collisions.Destroy;
import game.collisions.Pickup;
import org.jbox2d.common.Vec2;
import others.Toxic;
import others.Veg;

import javax.swing.*;
import java.awt.*;

public class Level2  extends GameLevel{
    public MyView Level2;

    public Level2(Game game){

        super(game);

        getPortal().setPosition(new Vec2(-10, -5));
        getProfessor().setPosition(new Vec2(-6,8));
        getFatman().setPosition(new Vec2(-7, -5));

        //we're setting up Pickup here though we could
        //also add it to the GameLevel class

        Shape shape = new BoxShape(11, 0.2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -6.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(3, 0.2f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(2, 4f));

        // add another platform here
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(4, -4f));


        // professor  platform
        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(5, 0.5f));

        // add another platform here
        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(-4, 5f));

        // add another platform here
        Shape wallShape = new BoxShape(0.2f, 3f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        // add another platform here
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));


        //create some pickups (books)
        for (int i = 0; i < 8; ++i) {
            Body Veg = new Veg(this);
            Veg.setPosition(new Vec2(2 * i - 4, 10));
            Veg.addCollisionListener(new Pickup(getFatman()));
        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(2, 10));
            Toxic.addCollisionListener(new Destroy(getFatman()));

        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(8, 8));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }


    }
    @Override
    public boolean isComplete() {
        if (getFatman().getVegCount() == 8)
            return true;
        else
            return false;
    }
    public MyView getLevel2(){return Level2;}
    public void setLevel2(MyView Level2){this.Level2= Level2;}


    @Override
    public Image paintBackground() {
        Image background1 = new ImageIcon("data/background1.gif").getImage();
        return background1;
    }
    @Override
    public String getLevelName() {
        return "Level2";
    }

    @Override
    public Vec2 getLinearVelocity() {
        return null;
    }
}
