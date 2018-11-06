package uet.oop.bomberman.gui;

import uet.oop.bomberman.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Swing Frame chứa toàn bộ các component
 */
public class Frame extends JFrame {
	
	public GamePanel _gamepane;
	private JPanel _containerpane;
	private InfoPanel _infopanel;
	MenuBar menuBar ;

	Menu file ;
	Menu levels ;

	MenuItem replayItem ;
	MenuItem level1Item ;
	MenuItem level2Item ;
	MenuItem level3Item ;
	MenuItem level4Item ;
	MenuItem level5Item ;
	
	private Game _game;

	public Frame() {
		
		_containerpane = new JPanel(new BorderLayout());
		_gamepane = new GamePanel(this);
		_infopanel = new InfoPanel(_gamepane.getGame());

		MenuBar menuBar = new MenuBar();
		this.setMenuBar(menuBar);

		Menu file = new Menu("File");
		Menu levels = new Menu("Levels");

		MenuItem replayItem = new MenuItem("Replay");
		MenuItem level1Item = new MenuItem("Level 1");
		MenuItem level2Item = new MenuItem("Level 2");
		MenuItem level3Item = new MenuItem("Level 3");
		MenuItem level4Item = new MenuItem("Level 4");
		MenuItem level5Item = new MenuItem("Level 5");
		levels.add(level1Item);
		levels.add(level2Item);
		levels.add(level3Item);
		levels.add(level4Item);
		levels.add(level5Item);

		file.add(levels);
		file.add(replayItem);

		menuBar.add(file);

		_containerpane.add(_infopanel, BorderLayout.PAGE_START);
		_containerpane.add(_gamepane, BorderLayout.PAGE_END);
		
		_game = _gamepane.getGame();
		
		add(_containerpane);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);	
		
		_game.start();
	}
	
	public void setTime(int time) {
		_infopanel.setTime(time);
	}
	
	public void setPoints(int points) {
		_infopanel.setPoints(points);
	}
	
}
