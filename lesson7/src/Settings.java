import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win size is: ";

    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFielSize;

    private MainWindow mainWindow;

    Settings(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH/2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT/2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Settings new game");
        setLayout(new GridLayout(10, 1));

        addGameModeSetup();
        addFieldMapControl();

        JButton btnPlay = new JButton("Play new game");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlayGameClick();
            }
        });
        add(btnPlay);
        setVisible(false);

    }

    private void addGameModeSetup(){
        add(new JLabel("Choose game mode"));
        humVSAI = new JRadioButton("Human vs AI", true);
        humVShum = new JRadioButton("Human vs Human");

        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        add(humVSAI);
        add(humVShum);
    }
    private void addFieldMapControl(){
        JLabel labelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        slideFielSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
               slideFielSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            int curentValue = slideFielSize.getValue();
            labelFieldSize.setText(FIELD_SIZE_PREFIX+curentValue);
            slideWinLen.setMaximum(curentValue);
            }
        });

        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });

        add(new JLabel("Choose field map size"));
        add(labelFieldSize);
        add(slideFielSize);
        add(new JLabel("Choose win length"));
        add(labelWinLength);
        add(slideWinLen);
    }
    private void btnPlayGameClick(){
        int gameMode;
        if (humVSAI.isSelected()){
            gameMode = GameMap.MODE_HVA;

        } else if (humVShum.isSelected()) {
            gameMode = GameMap.MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode");
        }
        int field = slideFielSize.getValue();
        int winLength = slideWinLen.getValue();



    }
}
