package view;

import java.awt.Dimension;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
  MyPanel mainPanel;

  public MyFrame() {
    super("App");

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    Dimension minDimension = new Dimension(600, 600);
    setMinimumSize(minDimension);

    mainPanel = new MyPanel();

    setContentPane(mainPanel);

    pack();
  }

  public MyPanel getMainPanel() {
    return mainPanel;
  }
}
