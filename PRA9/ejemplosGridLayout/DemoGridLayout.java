package ejemplosGridLayout;

//Fig. 12.44: DemoGridLayout.java
//Prueba de MarcoGridLayout.

import javax.swing.JFrame;

public class DemoGridLayout {

 public static void main(String[] args) {

     MarcoGridLayout marcoGridLayout = new MarcoGridLayout();
     marcoGridLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoGridLayout.setSize(300, 200);
     marcoGridLayout.setVisible(true);

 }
} // fin de la clase DemoGridLayout

