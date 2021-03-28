package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import game.characters.FatmanController;
import levels.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.IOException;

/**
 * A world with some bodies.
 */
public class Game {

    //private final SoundClip gameMusic;
    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel level;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;
    private FatmanController controller;
    private SoundClip gameMusic;
    private city.cs.engine.World World;
    private GameSaverLoader gameSaverLoader;

    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        level = new Level1(this);


        // make a view
        view = new MyView(level, level.getFatman(),1050, 600);
        view.setWorld(level);
        view.setZoom(40);
        view.setBack(level.paintBackground());

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);
        controller = new FatmanController(this);
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));


        //view.addMouseListener(new MouseHandler(world.view));

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Level");
        frame.add(view);
        //UserView wideView = new UserView(level,100,100);
        //wideView.setZoom(3);
       // frame.add(wideView,BorderLayout.SOUTH);

        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.mainpanel, BorderLayout.NORTH);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);
        //keyboardfocus
        frame.requestFocus();
        //keyboard
        //controller
        frame.addKeyListener(controller);
        //((Level1)level).updateFatman(level.getFatman());

        // uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(level, 500, 500);
        try {
            gameMusic = new SoundClip("data/file_example_WAV_1MG.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException| LineUnavailableException e){
            System.out.println(e);
        }

        // start our game world simulation!
        level.start();
    }


    public void pause(){
        level.stop();

    }
    public void restart(){
        level.start();
    }

    public GameLevel getLevel() {
        return this.level;
    }
    public void reset(){
        level.stop();
        level = new Level1(this);
        view.setWorld(level);
        view.setBack(level.paintBackground());
        view.setZoom(40);
        controller = new FatmanController(this);
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));
        level.start();

    }
    //public void saveButton(){
       // ;
    //}
    public void setLevel(GameLevel level){
        this.level.stop();
        this.level = level;
        view.setWorld(this.level);
        view.setBack(level.paintBackground());
        view.setZoom(40);
        controller = new FatmanController(this);
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));
        this.level.start();
    }



    public void goToNextLevel() {
        /**
         * @return
         */

        if (level instanceof Level1) {
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(40);
            view.setBack(level.paintBackground());
            ((Level2)level).setLevel2(view);
            //change the controller to control the
            controller.updateFatman(level.getFatman());
            ((Level2)level).getLevel2().setFatman(level.getFatman());
            //UserView wideView = new  UserView(new Level2(this),100,100);
            //wideView.setZoom(3);
            //view.add(wideView,BorderLayout.SOUTH);
            //start the simulation in the new level
            controller = new FatmanController(this);
            // new level starts
            level.start();
        } else if (level instanceof Level2) {
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(40);
            view.setBack(level.paintBackground());
            ((Level3)level).setLevel3(view);
            //change the controller to control the player in this level
            controller.updateFatman(level.getFatman());
            ((Level3)level).getLevel3().setFatman(level.getFatman());
            //UserView wideView = new UserView(new Level3(this),100,100);
            //wideView.setZoom(3);
            //view.add(wideView,BorderLayout.SOUTH);
            controller = new FatmanController(this);
            level.start();
        }
        else if (level instanceof Level3) {
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            view.setWorld(level);
            view.setZoom(40);
            ((Level4) level).setLevel4(view);
            view.setBack(level.paintBackground());
            //change the controller to control the player in this level
            controller.updateFatman(level.getFatman());
            //UserView wideView = new UserView(level, 100, 100);
            //wideView.setZoom(3);
            //view.add(wideView, BorderLayout.SOUTH);
            controller = new FatmanController(this);
            level.start();
        }
        else if (level instanceof Level4){
            level.stop();
            System.out.println("Game complete.");
            System.exit(0);
        }
    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {

        new Game();
    }
    public void setWorld(World world){this.World = world;}
    public World getWorld(){return World;}



}
