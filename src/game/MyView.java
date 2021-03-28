package game;

import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import city.cs.engine.World;
import game.characters.fatman;


import java.awt.*;


public class MyView extends UserView {

     fatman fatman;
    private Image background;
    private Color color;
    public Image back;
    public MyView(World w, game.characters.fatman fatman, int width, int height) {
        super(w, width, height);
        this.fatman = fatman;
        //background = new ImageIcon("data/mountain.gif").getImage();
    }
    public void setBack(Image background){
        this.back = background;
    }

    @Override
    protected void paintBackground(Graphics2D g) { //this will allow to have different backgroud throughout the levels

        g.drawImage(back, 0, 0, this);
    }

    @Override
   protected void paintForeground(Graphics2D g){ //it will dispaly the information on the game and not only on the console
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial",Font.BOLD,20));
       g.drawString("score:" + fatman.getVegCount(),10,15);
        g.drawString("lives:" + fatman.getLiveCount(),10, 30);



    }
    public void setFatman(fatman fatman){this.fatman = fatman;}
    public fatman getFatman(){return fatman;}
    public void setColor(Color color){
        this.color= color;
    }
    public void setBackground(Image background){this.back= background;}
    private SoundClip jumpSound;


}
