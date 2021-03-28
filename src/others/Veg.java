package others;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class Veg extends DynamicBody {
    private static final Shape vegshape = new PolygonShape(-0.219f,-0.262f, 0.229f,-0.253f, 0.217f,0.193f, -0.167f,0.218f, -0.262f,0.018f);
    private static final BodyImage vegImage =
            new BodyImage("data/veg.png",0.7f);

    public Veg(World world) {
        super (world,vegshape);
        addImage(vegImage);
    }
}
