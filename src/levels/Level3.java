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

public class Level3  extends GameLevel{
    public MyView Level3;

    public Level3(Game game){
        super(game);

        //we still need to set the positions of the student
        getFatman().setPosition(new Vec2(8, -6));
        //and professor
        getProfessor().setPosition(new Vec2(4,8));
        Shape shape = new BoxShape(11, 0.2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -6.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(3, 0.2f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(4.5f, 0.5f));

        // add another platform here
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(3, -5f));

        // professor  platform
        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(-8, 0.5f));

        // add another platform here
        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(-2, -2f));
        // add another platform here
        StaticBody platform5 = new StaticBody(this, platform1Shape);
        platform5.setPosition(new Vec2(11,4f));

        // add another platform here
        Shape wallShape = new BoxShape(0.2f, 3f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        // add another platform here
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));

        //create some pickups (vegs)
        for (int i = 0; i < 10; ++i) {
            Body Veg = new Veg(this);
            Veg.setPosition(new Vec2(-1 * i - 1, 10));
            Veg.addCollisionListener(new Pickup(getFatman()));
        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(2, 10));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(3, -4));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(3, -1));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(1, -7));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }
        Body Toxic = new Toxic(this);
        Toxic.setPosition(new Vec2(1, -3));
        Toxic.addCollisionListener(new Destroy(getFatman()));


    }
    @Override
    public boolean isComplete() {
        if (getFatman().getVegCount() > 2)
            return true;
        else
            return false;
    }
    public MyView getLevel3(){return Level3;}
    public void setLevel3(MyView Level3){this.Level3 = Level3;}

    @Override
    public Image paintBackground() {
        Image background3 = new ImageIcon("data/background3.jpg").getImage();
        return background3;
    }
    @Override
    public String getLevelName() {
        return ("Level3");


    }

    @Override
    public Vec2 getLinearVelocity() {
        return null;
    }
}