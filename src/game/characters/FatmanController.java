package game.characters;

import city.cs.engine.SoundClip;
import game.Game;
import levels.GameLevel;
import levels.GameSaverLoader;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class FatmanController extends KeyAdapter {
    private static final float Jumping_speed = 9;
    private static final float Walking_speed = 5;
    private Game game;


    public FatmanController(Game game) {
/**
 * @param jumpSound it will create and contain an input whihc in this case is a sound and allow it to be played when called
 *
 */
        this.game = game;
    }
    private SoundClip jumpSound;

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) {//(Q= quit)
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // w = jump
            Vec2 v = game.getLevel().getFatman().getLinearVelocity();//getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {
                game.getLevel().getFatman().jump(Jumping_speed);
                jumpSound.play();// a sound will be played when jumping
            }
        } else if (code == KeyEvent.VK_A) {
            game.getLevel().getFatman().startWalking(-Walking_speed);
            game.getLevel().getFatman().removeAllImages();//removes the images if was walking opposite way
            game.getLevel().getFatman().addImage(fatman.getImageLeft()); //walking left and add mirrored image of player
        } else if (code == KeyEvent.VK_D) {
            game.getLevel().getFatman().startWalking(Walking_speed);
            game.getLevel().getFatman().removeAllImages();//removes the images if was walking opposite way
            game.getLevel().getFatman().addImage(fatman.getImageRight()); //walking right
        }
        else if (code == KeyEvent.VK_S) {
            try { GameSaverLoader.Save(game.getLevel(), "data/save.txt");// will allow to save data about the current level etc in to the data file.
            } catch (IOException ioException) {
                ioException.printStackTrace();}

            { System.out.println("Save"); //if successfully done, it will print such.
            }
        }
        else if (code == KeyEvent.VK_L){ // l = load
            try {
                GameLevel level = GameSaverLoader.load(game,"data/save.txt");// it will extract the file saved and read it in order to jump to the right level if needed or update score etc.
                 game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("Load");//if successfully done, it will print such.
        }
        try {
            jumpSound = new SoundClip("data/jumpsounds.wav"); //jumping sounds
        } catch (UnsupportedAudioFileException| IOException| LineUnavailableException b) {
            System.out.println(b);
        }


    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) { //allows the plyer to stop asap when walking left
            game.getLevel().getFatman().stopWalking();
        } else if (code == KeyEvent.VK_D) {
            game.getLevel().getFatman().stopWalking();//allows the plyer to stop asap when walking right
        }
    }
     public void updateFatman(fatman fatman){game.getLevel().getFatman();}

    }


