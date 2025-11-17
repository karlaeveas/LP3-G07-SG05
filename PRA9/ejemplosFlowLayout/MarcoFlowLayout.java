package ejemplosFlowLayout;

//Fig. 12.39: MarcoFlowLayout.java
//FlowLayout permite que los componentes fluyan a través de varias líneas.

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoFlowLayout extends JFrame {

 private final JButton botonJButtonIzquierda; // botón para alineación izquierda
 private final JButton botonJButtonCentro;    // botón para alineación centro
 private final JButton botonJButtonDerecha;   // botón para alineación derecha

 private final FlowLayout esquema;            // objeto esquema
 private final Container contenedor;          // contenedor para establecer el esquema

 // establece la GUI y registra los componentes de escucha de botones
 public MarcoFlowLayout() {

     super("Demostración de FlowLayout Espino/Ramos");

     esquema = new FlowLayout();
     contenedor = getContentPane(); // obtiene contenedor
     setLayout(esquema);

     // Botón Izquierda
     botonJButtonIzquierda = new JButton("Izquierda");
     add(botonJButtonIzquierda);
     botonJButtonIzquierda.addActionListener(
         new ActionListener() { // clase interna anónima
             @Override
             public void actionPerformed(ActionEvent evento) {
                 esquema.setAlignment(FlowLayout.LEFT);
                 esquema.layoutContainer(contenedor); // realinea componentes
             }
         }
     );

     // Botón Centro
     botonJButtonCentro = new JButton("Centro");
     add(botonJButtonCentro);
     botonJButtonCentro.addActionListener(
         new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evento) {
                 esquema.setAlignment(FlowLayout.CENTER);
                 esquema.layoutContainer(contenedor);
             }
         }
     );

     // Botón Derecha
     botonJButtonDerecha = new JButton("Derecha");
     add(botonJButtonDerecha);
     botonJButtonDerecha.addActionListener(
         new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evento) {
                 esquema.setAlignment(FlowLayout.RIGHT);
                 esquema.layoutContainer(contenedor);
             }
         }
     );
 } // fin del constructor

} // fin de la clase MarcoFlowLayout
