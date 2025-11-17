package ejemplosGridLayout;

//Fig. 12.43: MarcoGridLayout.java
//GridLayout que contiene seis botones.

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoGridLayout extends JFrame implements ActionListener {

 private final JButton[] botones; // arreglo de botones
 private static final String[] nombres = {
         "uno", "dos", "tres", "cuatro", "cinco", "seis"
 };

 private boolean alternar = true;     // alterna entre dos esquemas
 private Container contenedor;        // contenedor del marco
 private GridLayout cuadricula1;      // primer GridLayout
 private GridLayout cuadricula2;      // segundo GridLayout

 // constructor sin argumentos
 public MarcoGridLayout() {

     super("Demostración de GridLayout  Espino/Ramos");

     cuadricula1 = new GridLayout(2, 3, 5, 5); // 2 filas, 3 columnas, espacios de 5 px
     cuadricula2 = new GridLayout(3, 2);       // 3 filas, 2 columnas, sin espacios

     contenedor = getContentPane();
     setLayout(cuadricula1);

     botones = new JButton[nombres.length];

     for (int i = 0; i < nombres.length; i++) {
         botones[i] = new JButton(nombres[i]);
         botones[i].addActionListener(this);  // registra listener
         add(botones[i]);                     // agrega botón al JFrame
     }
 }

 // maneja eventos de los botones, alternando entre los dos esquemas
 @Override
 public void actionPerformed(ActionEvent evento) {

     if (alternar)
         contenedor.setLayout(cuadricula2);
     else
         contenedor.setLayout(cuadricula1);

     alternar = !alternar;

     contenedor.validate(); // redistribuye el contenedor
 }
} // fin de la clase MarcoGridLayout
