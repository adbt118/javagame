package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Game;
import others.Portal;
import levels.GameLevel;

public class portalEncounter implements CollisionListener {

    private GameLevel level;
    private Game game;

    public portalEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //if fatman collided with portal and the
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof Portal
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}
