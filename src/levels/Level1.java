package levels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.*;
import game.collisions.Destroy;
import game.collisions.Pickup;
import org.jbox2d.common.Vec2;
import others.Toxic;
import others.Veg;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel /*implements ActionListener*/ {


    public Level1(Game game) {
        super(game);

        getPortal().setPosition(new Vec2(10, 3));
        getFatman().setPosition(new Vec2(-7, -5));
         getProfessor().setPosition(new Vec2(4,8));
        Shape shape = new BoxShape(11, 0.2f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -6.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(3, 0.2f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-25, 6.5f));

        // add another platform here
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(1, -5f));

        // professor  platform
        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(8, 0.5f));

        // add another platform here
        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(-2, -2f));

        // add another platform here
        Shape wallShape = new BoxShape(0.2f, 3f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        // add another platform here
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));


        for (int i = 0; i < 6; ++i) {
            Body Veg = new Veg(this);
            Veg.setPosition(new Vec2(1.2f * i - 6, 5));
            Veg.addCollisionListener(new Pickup(getFatman()));
        }
        //{
        // Body Toxic = new Toxic(this);
        //Toxic.setPosition(new Vec2(2, 10));
        //Toxic.addCollisionListener(new Destroy(getFatman()));
        //}
        {
            Body Toxic = new Toxic(this);
            Toxic.setPosition(new Vec2(3, -4));
            Toxic.addCollisionListener(new Destroy(getFatman()));
        }


    }
    /*@Override
    public void actionPerformed(ActionEvent ae) {
        //try {
            if (getProfessor().getpLiveCount() == 1) {
                Potion potion = new Potion(this);
                potion.setPosition(this.getProfessor().getPosition().add(new Vec2(10, 8)));
                Vec2 enemy = this.getProfessor().getPosition();
                Vec2 player = this.getFatman().getPosition();
                Vec2 v = player.sub(enemy);
                v.normalize();
                potion.setLinearVelocity(v.mul(10f));
                potion.setGravityScale(0);
                Potionlis collision = new Potionlis(potion, this, 2);
                potion.addCollisionListener(collision);
                if (this.getFatman().getLiveCount() == 0) ;
                { this.getFatman().removeAllCollisionListeners();
                this.getFatman().destroy();
                }
            }
        } //catch (NullPointerException e) {
        //}
    //}*/
        @Override
    public boolean isComplete() {
        if (getFatman().getVegCount() == 6)
            return true;
        else
            return false;

    }

    @Override
    public Image paintBackground() {
       Image background1 = new ImageIcon("data/mountain.gif").getImage();
        return background1;
    }

    @Override
    public String getLevelName() {
        return "Level1";
    }

    @Override
    public Vec2 getLinearVelocity() {
        return null;
    }
}





