package game;

import levels.GameLevel;
import levels.GameSaverLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel {
    private Game game;
    private GameSaverLoader gameSaverLoader;
    private JButton restartButton;
    private JButton pauseButton;
    public JPanel mainpanel;
    private JButton resetButton;
    private JButton saveButton;
    private JButton loadButton;

    public ControlPanel(Game game) {

        this.game = game;
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.reset();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameLevel level = GameSaverLoader.load(game,"data/save.txt");// it will extract the file saved and read it in order to jump to the right level if needed or update score etc.
                    game.setLevel(level);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("Load");//if successfully done, it will print such.
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try { GameSaverLoader.Save(game.getLevel(), "data/save.txt");// will allow to save data about the current level etc in to the data file.
                } catch (IOException ioException) {
                    ioException.printStackTrace();}

                { System.out.println("Save"); //if successfully done, it will print such.
                }
            }

        });

    }
}


