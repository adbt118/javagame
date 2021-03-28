package others;

import city.cs.engine.*;

public class Portal extends DynamicBody {
    private static final Shape portalShape = new PolygonShape(-0.4f,2.29f, -1.14f,-2.11f, 0.95f,-2.13f, 1.19f,1.79f, 0.08f,2.33f);
    private static final BodyImage image =
            new BodyImage("data/portal.png", 5f);
    public Portal(World World) {
        super(World, portalShape);
        addImage(image);
    }
}
