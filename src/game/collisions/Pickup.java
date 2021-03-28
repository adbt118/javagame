package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.characters.fatman;

public class Pickup implements CollisionListener { private game.characters.fatman fatman;
public Pickup(fatman fatman){this.fatman = fatman;}
public void collide(CollisionEvent e) {
    if (e.getOtherBody() == this.fatman) { //if the collision is completed by fatman
        this.fatman.incrementVegCount(); //it will increase the score
        e.getReportingBody().destroy(); //and destroy "veg"
    }
}
}
