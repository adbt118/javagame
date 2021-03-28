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

public class Level4  extends GameLevel{
    public MyView Level4;

    public Level4(Game game){
        super(game);

        getPortal().setPosition(new Vec2(10, 0));
        getFatman().setPosition(new Vec2(8, -6));
        Shape shape = new BoxShape(11, 0.2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -6.5f));

        Shape platform1Shape = new BoxShape(3, 0.2f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(9.5f, 3.5f));

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
        platform5.setPosition(new Vec2(-2, 4.5f));

        // add another platform here
        StaticBody platform6 = new StaticBody(this, platform1Shape);
        platform6.setPosition(new Vec2(10, 7.5f));

        // add another platform here
        Shape wallShape = new BoxShape(0.2f, 3f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        // add another platform here
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));

        //create some pickups (vegs)
        for (int i = 0; i < 14; ++i) {
            Body Veg = new Veg(this);
            Veg.setPosition(new Vec2(1.2f * i - 6, 5));
            Veg.addCollisionListener(new Pickup(getFatman()));
        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(2, 10));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }
        {
         Body Toxic = new Toxic(this);
         Toxic.setPosition(new Vec2(8, 10));
        Toxic.addCollisionListener(new Destroy(getFatman()));
        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(3, -4));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(5, -1));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(6, 7));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }
        Body Toxic = new Toxic(this);
        Toxic.setPosition(new Vec2(5, -3));
        Toxic.addCollisionListener(new Destroy(getFatman()));
    }

    {
        Body Toxic = new Toxic(this);
        Toxic.setPosition(new Vec2(-15, 17));
        Toxic.addCollisionListener(new Destroy(getFatman()));
    }
    {
        Body Toxic = new Toxic(this);
        Toxic.setPosition(new Vec2(-6, 12));
        Toxic.addCollisionListener(new Destroy(getFatman()));
    }
    {
        Body Toxic = new Toxic(this);
        Toxic.setPosition(new Vec2(-10, 9));
        Toxic.addCollisionListener(new Destroy(getFatman()));
    }



    @Override
    public boolean isComplete() {
        if (getFatman().getVegCount() == 12)
            return true;
        else
            return false;
    }
    public MyView getLevel4(){return Level4;}
    public void setLevel4(MyView Level4){this.Level4 = Level4;}

    @Override
    public Image paintBackground() {
        Image background4 = new ImageIcon("data/background1.jpg").getImage();
        return background4;
    }
    @Override
    public String getLevelName() {
        return "Level4";
    }

    @Override
    public Vec2 getLinearVelocity() {
        return null;
    }


}