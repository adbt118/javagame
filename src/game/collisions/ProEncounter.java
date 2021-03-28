package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Game;
import game.characters.fatman;
import game.characters.professor;
import levels.GameLevel;

public class ProEncounter implements CollisionListener {

    private GameLevel level;
    private Game game;
    private game.characters.fatman fatman;
    public ProEncounter(GameLevel level, Game game){
        this.fatman = fatman;
        this.level = level;
        this.game = game;
    }

    public ProEncounter(fatman fatman) {this.fatman =fatman;
    }


    @Override
    public void collide(CollisionEvent e) {
        //if fatman collided with professor
        // the body will be destroyed ( -2 lives)
        if (e.getOtherBody() instanceof professor){
            fatman.destroy();
            System.out.println("You have died!!");
        }

    }
}


