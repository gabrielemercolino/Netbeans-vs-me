package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class GestoreVettore{
  public static final String VECTOR_CHANGED_EVENT = "vce";

  private PropertyChangeSupport support;
  private PropertyChangeListener listener;
  private List<Integer> vettore;

  public GestoreVettore() {
    vettore = new ArrayList<>();
    support = new PropertyChangeSupport(this);
    listener = new Listener();
  }

  public void aggiungi(int valore){
    vettore.add(valore);
    support.firePropertyChange(VECTOR_CHANGED_EVENT, null, vettore);
  }

  public List<Integer> getVettore() {
    return vettore;
  }

  public void subscribe(PropertyChangeListener subscriber){
    support.addPropertyChangeListener(subscriber);
  }

  public PropertyChangeListener getListener() {
    return listener;
  }

  private class Listener implements PropertyChangeListener{
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      if (evt.getNewValue() instanceof Integer valore){
        aggiungi(valore);
      }
    }
  }
}
