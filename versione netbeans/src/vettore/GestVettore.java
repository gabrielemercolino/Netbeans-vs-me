
package vettore;

import javax.swing.JOptionPane;

public class GestVettore {
    private int i;
    private int[] array;
    
    public GestVettore(int lunghezza){        
       array =new int[lunghezza];
       i=-1;
        
    }
    
    public void inserisci(int number){
        i++;
        array [i]=number;
        System.out.println(array[i]);
    }
    public String minimo(){
        if (i==-1){            
        return"vuoto";            
        }else{            
        int minore=array[0];
        for (int j=1; j<i;j++) {
            if (minore > array[j]){
                minore=array[j];
            }           
        }  
        String risposta=String.valueOf(minore);
            System.out.println(minore);
        return risposta;
        }
      
    }}
