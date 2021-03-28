package levels;

import city.cs.engine.World;
import game.*;
import game.characters.fatman;
import game.characters.professor;
import game.collisions.Destroy;
import game.collisions.Pickup;
import game.collisions.ProEncounter;
import game.collisions.portalEncounter;
import org.jbox2d.common.Vec2;
import others.Portal;

import java.awt.*;

public abstract class GameLevel extends World {
    /**
     *
     */
    private game.characters.fatman fatman;
    private game.characters.professor professor;
    private others.Portal Portal;

    public  GameLevel (Game game){

        fatman = new fatman(this);
        professor = new professor(this);
        Portal = new Portal(this);
//listed all the ecounter that could happen
        portalEncounter encounter = new portalEncounter(this, game);
        ProEncounter encounter2 = new ProEncounter(this,game);
        // all the different collision
        fatman.addCollisionListener(encounter);
        fatman.addCollisionListener(new Pickup(this.fatman));
        fatman.addCollisionListener(new Destroy(this.fatman));
        fatman.addCollisionListener(new ProEncounter(this.fatman));
    }
    //these methods are created to then be called when necessary in different levels
    public fatman getFatman(){
        return fatman;
    }
    public Portal getPortal(){return Portal;}
    public professor getProfessor(){
        return professor;
    }
    public abstract boolean isComplete();
    public abstract Image paintBackground();
    public abstract String getLevelName();

    public abstract Vec2 getLinearVelocity();
}
