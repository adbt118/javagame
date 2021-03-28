package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.characters.fatman;

public class Destroy implements CollisionListener {
    private game.characters.fatman fatman;

    public Destroy(fatman fatman) {
        this.fatman = fatman;
    }

    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == this.fatman) {//if fatman is the body colliding
            this.fatman.decrementLiveCount();//it will take a life away
            if (fatman.getLiveCount() == 0) {//if none left,
                fatman.destroy();//the player will be destroyed
            }
            e.getReportingBody().destroy();

        }
    }
}