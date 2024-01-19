package controller;

import model.GestoreVettore;
import view.MyFrame;
import view.MyPanel;

public class MainController implements Runnable{

  private MyFrame appFrame;
  private GestoreVettore gestoreVettore;

  public MainController() {
    appFrame = new MyFrame();
    gestoreVettore = new GestoreVettore();

    MyPanel mainPanel = appFrame.getMainPanel();
    gestoreVettore.subscribe(mainPanel.getListener());
    mainPanel.subscribe(gestoreVettore.getListener());
  }

  @Override
  public void run() {
    appFrame.setVisible(true);
  }

}
