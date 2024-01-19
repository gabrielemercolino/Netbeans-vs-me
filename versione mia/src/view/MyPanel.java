package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class MyPanel extends JPanel{
  public static final String ADDED_NEW_VALUE_EVENT = "anve";

  private int minimo;
  private PropertyChangeSupport support;
  private PropertyChangeListener listener;

  private GridBagConstraints constraints;

  private JLabel addLabel, minimumLabel; 
  private JTextField addTextField, minimumTextField;
  private JButton addButton, minimumButton;

  public MyPanel() {
    super();
    support = new PropertyChangeSupport(this);
    listener = new Listener();
    constraints = new GridBagConstraints();

    setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

    setLayout(new GridBagLayout());

    addLabel = new JLabel("Aggiungi numeri");
    addLabel.setHorizontalAlignment(SwingConstants.CENTER);
    addLabel.setFont(new Font("Tahoma", 0, 24));
    minimumLabel = new JLabel("Minimo");
    minimumLabel.setHorizontalAlignment(SwingConstants.CENTER);
    minimumLabel.setFont(new Font("Tahoma", 0, 24));

    addTextField = new JTextField();
    addTextField.setHorizontalAlignment(SwingConstants.CENTER);
    addTextField.setFont(new Font("Tahoma", 0, 48));
    minimumTextField = new JTextField();
    minimumTextField.setHorizontalAlignment(SwingConstants.CENTER);
    minimumTextField.setFont(new Font("Tahoma", 0, 48));

    addButton = new JButton("Aggiungi");
    addButton.addActionListener(this::handleInputButton);
    addButton.setHorizontalAlignment(SwingConstants.CENTER);
    addButton.setFont(new Font("Tahoma", 0, 24));
    minimumButton = new JButton("Calcola minimo");
    minimumButton.addActionListener(this::handleMinimumButton);
    minimumButton.setHorizontalAlignment(SwingConstants.CENTER);
    minimumButton.setFont(new Font("Tahoma", 0, 24));

    positionElement(0, 0, addLabel);
    positionElement(0, 1, minimumLabel);

    positionElement(1, 0, addTextField, 25, 0);
    positionElement(1, 1, minimumTextField, 25, 0);

    positionElement(2, 0, addButton, 25, 60);
    positionElement(2, 1, minimumButton, 25, 60);

  }

  private void handleInputButton(ActionEvent evt){
    try {
      String maybeNumber = addTextField.getText();
      Integer number = Integer.parseInt(maybeNumber);
      support.firePropertyChange(ADDED_NEW_VALUE_EVENT, null, number);
      showUserMessage(addLabel, "Numero aggiunto", "Aggiungi numeri", 2000);
    } catch (NumberFormatException e) {
      showUserMessage(addLabel, "Aggiungi solo numeri", "Aggiungi numeri", 2000);
    } finally{
      addTextField.setText("");
    }
  }

  private void showUserMessage(JLabel component, String message, String resetMessage, int delay){
    component.setText(message);
    Timer timer = new Timer(delay, ev -> component.setText(resetMessage));
    timer.setRepeats(false);
    timer.start();
  }

  private void handleMinimumButton(ActionEvent e){
    minimumTextField.setText("" + minimo);
  }

  private void positionElement(int row, int column, JComponent component){
    this.positionElement(row, column, component, 0, 0);
  }

  private void positionElement(int row, int column, JComponent component, int paddingX, int paddingY){
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridy = row;
    constraints.gridx = column;
    constraints.weightx = 1.0;
    constraints.weighty = 1.0;
    constraints.insets = new Insets(paddingY, paddingX, paddingY, paddingX);
    constraints.anchor = GridBagConstraints.CENTER;

    this.add(component, constraints);
  }

  public void subscribe(PropertyChangeListener subscriber){
    support.addPropertyChangeListener(subscriber);
  }

  public PropertyChangeListener getListener() {
    return listener;
  }

  public void setMinimo(int minimo){
    this.minimo = minimo;
  }

  private class Listener implements PropertyChangeListener{
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      if (evt.getNewValue() instanceof List vettore){
        @SuppressWarnings("unchecked")
        int min = Collections.min((List<Integer>) vettore);
        setMinimo(min);
      }
    }
    
  }
}
