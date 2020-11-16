import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 505;
    private static final int POS_X = 650;
    private static final int POS_Y = 270;

    private Settings settingWimdow;
    private GameMap gamwMap = new GameMap();

    MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(POS_X, POS_Y);
        setTitle("Игра Крестики-нолики");

        settingWimdow = new Settings(this);

        JButton btnStart = new JButton("Create new game");
        btnStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                settingWimdow.setVisible(true);
            }
        });
        JButton btnExitGame = new JButton("Close");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExitGame);

        add(panelBottom, BorderLayout.SOUTH);


        setResizable(false);
        setVisible(true);
    }
    void startNewGame(int mode, int fieldSiseX, int fieldSizeY, int winLength ){
        gamwMap.startNewGame(mode, fieldSiseX, fieldSizeY, winLength);
    }

}
