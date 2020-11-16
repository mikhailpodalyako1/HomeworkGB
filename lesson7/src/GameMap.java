import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;


    GameMap() {
        setBackground(Color.BLACK);


    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.println("mode = " + mode + "\n fieldSizeX = " + fieldSizeX + "\n fieldSizeY = " + fieldSizeY + "\n winLength = " + winLength);
    }

}
