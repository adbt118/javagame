package others;

import city.cs.engine.*;

public class Toxic extends DynamicBody {
    private static final Shape toxicshape = new PolygonShape(-0.08f,0.215f, -0.175f,-0.032f, -0.128f,-0.217f, 0.079f,-0.227f, 0.204f,0.017f, 0.04f,0.222f);
    private static final BodyImage toxicImage =
            new BodyImage("data/toxic.png",0.6f);

    public Toxic(World world) {
        super (world,toxicshape);
        addImage(toxicImage);
    }
}