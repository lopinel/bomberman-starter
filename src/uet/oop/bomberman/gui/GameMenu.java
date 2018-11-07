package uet.oop.bomberman.gui;

import uet.oop.bomberman.Board;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameMenu extends MenuBar {

    private Board _board;
    private Menu file ;
    private Menu levels ;

    private MenuItem pauseItem ;
    private MenuItem[] levelItems;
    private MenuItem level1Item ;
    private MenuItem level2Item ;
    private MenuItem level3Item ;
    private MenuItem level4Item ;
    private MenuItem level5Item ;

    public GameMenu(Board board){

        _board = board;
        Menu file = new Menu("File");
        Menu levels = new Menu("Levels");

        pauseItem = new MenuItem("Pause");

        levelItems = new MenuItem[5];
        for(int i = 0; i<5; i++){
            int j = i+1;
            levelItems[i] = new MenuItem("Level " + j);
            levels.add(levelItems[i]);

            if(i>0)
                levelItems[i].setEnabled(false);
        }

        levelItems[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _board.loadLevel(1);
            }
        });
        levelItems[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _board.loadLevel(2);
            }
        });
        levelItems[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _board.loadLevel(3);
            }
        });
        levelItems[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _board.loadLevel(4);
            }
        });
        levelItems[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _board.loadLevel(5);
            }
        });
        pauseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _board.setShow(3);
            }
        });


        file.add(pauseItem);
        file.add(levels);

        this.add(file);
    }
    public void update(){
        for(int i=0; i<5; i++){
            if((i+1) <= _board.get_currentLevel()){
                levelItems[i].setEnabled(true);
            }
        }
    }
}
