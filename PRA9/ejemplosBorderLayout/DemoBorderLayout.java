package ejemplosBorderLayout;

//Fig. 12.42: DemoBorderLayout.java
//Prueba de MarcoBorderLayout.

import javax.swing.JFrame;

public class DemoBorderLayout {

 public static void main(String[] args) {

     MarcoBorderLayout marcoBorderLayout = new MarcoBorderLayout();
     marcoBorderLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoBorderLayout.setSize(300, 200);
     marcoBorderLayout.setVisible(true);

 }
} // fin de la clase DemoBorderLayout

