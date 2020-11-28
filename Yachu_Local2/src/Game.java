import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

interface Screen{
	Dimension ScreenSize = new Dimension(400, 400);
	void BackRender();
	void FrontRender();
	void OpenScreen();
}

public class Game{
	
	public static void main(String[] args) {
		Screen NewGame = new MainScreen();
		NewGame.OpenScreen();
	}
}