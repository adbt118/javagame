package game.characters;

import city.cs.engine.*;

public class professor extends Walker {
    private static final Shape professorShape = new PolygonShape(
            -0.66f,1.59f, -0.96f,-1.9f, 0.14f,-1.87f, 0.61f,1.06f, -0.43f,1.59f);

    private static final BodyImage image =
            new BodyImage("data/prof1.png", 5f);

    private int pliveCount;

    public professor(World world) {
        super(world, professorShape);
        addImage(image);
        pliveCount = 1;
    }
    public int getpLiveCount() {
        return pliveCount;
    }
}
