package levels;

import game.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {
    /**
     *
     * @param level it will inizialize a level which then with the help of getlevel will determine if 1, 2, 3 r 4.
     * @param fileName the input of this will determinate the name of the file where the information about the saving will be stored.
     * @throws IOException
     */
    public static void Save(GameLevel level, String fileName)
            throws IOException {
        {
            boolean append = false;
            FileWriter writer = null;
            try {
                writer = new FileWriter(fileName, append);
                writer.write(level.getLevelName() + "," + level.getFatman().getVegCount() + "," + level.getFatman().getLiveCount() + "\n"); //all the information that willl be saved about the game
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }
    }
    public static GameLevel load(Game game, String filename)
            throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading" + filename + "...."); //if the file is readble
            fr = new FileReader(filename);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            Integer liveCount = Integer.parseInt(tokens[1]);

            ///refer to the levels
            GameLevel level = switch (name) {
                case "Level1" -> new Level1(game);
                case "Level2" -> new Level2(game);
                case "Level3" -> new Level3(game);
                case "Level4" -> new Level4(game);
                default -> null;
            };

            ///linking new levels to levels

            level.getFatman().setLiveCount(liveCount);


            return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }

        }


    }
}