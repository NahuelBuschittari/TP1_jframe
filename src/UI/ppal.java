
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


/**
 * Programa de ejemplo de BorderLayout, FlowLayout y BoxLayout.
 * El programa es un Applet, pero también dispone de método main() para ejecutarlo como
 * aplicación independiente.
 *
 * @author Chuidiang
 */
public class ppal extends JApplet
{
    private static final long serialVersionUID = -5807365968277501395L;

    /** 
     * Panel en la parte superior del BorderLayout. Este panel lleva un FlowLayout.  
     */
    private JPanel panelSuperior;

    /** 
     * Panel en la parte inferior del BorderLayout. Este panel lleva un FlowLayout.  
     */
    private JPanel panelInferior;

    /** 
     * Panel en la parte izquierda del BorderLayout. Este panel lleva un BoxLayout.  
     */
    private JPanel panelIzquierdo;

    /** 
     * Panel en la parte derecha del BorderLayout. Este panel lleva un BoxLayout.  
     */
    private JPanel panelDerecho;

    /**
     * main para ejecutar como aplicación independiente.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args)
    {
        ppal prueba=new ppal();
	prueba.visualizaVentana();
    }

    /**
     * Crea un nuevo objeto PruebaBorderLayout.
     * Crea un JFrame, lo rellena con los paneles y lo visualiza.
     */
    public void visualizaVentana()
    {
        JFrame v = new JFrame("Prueba BorderLayout");
        construyeTodo(v.getContentPane());
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Método start del Applet.
     */
    public void start()
    {
        construyeTodo(this);
    }

    /**
     * Crea los paneles y los mete en el contenedor que se le pasa.
     *
     * @param contenedor Contenedor en el que meter los paneles.
     */
    private void construyeTodo(Container contenedor)
    {
        construyePanelInferior();
        construyePanelSuperior();
        construyePanelIzquierdo();
        construyePanelDerecho();
        
        // Se construye el panel central.
        JScrollPane scroll = new JScrollPane(new JTextArea());
        contenedor.setLayout(new BorderLayout());
        
        // Se añaden todos los paneles.
        contenedor.add(scroll, BorderLayout.CENTER);
        contenedor.add(panelSuperior, BorderLayout.NORTH);
        contenedor.add(panelInferior, BorderLayout.SOUTH);
        contenedor.add(panelIzquierdo, BorderLayout.WEST);
        contenedor.add(panelDerecho, BorderLayout.EAST);
    }

    /**
     * Construye el panel superior metiéndole cinco botones.
     * Pone un FlowLayout en el panel superior, con los botones ajustados al lado
     * izquierdo. Pinta el panel de cyan.
     */
    private void construyePanelSuperior()
    {
        panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.setBackground(Color.cyan);
        panelSuperior.add(new JButton("Sup.1"));
        panelSuperior.add(new JButton("Sup.2"));
        panelSuperior.add(new JButton("Sup.3"));
        panelSuperior.add(new JButton("Sup.4"));
    }

    /**
     * Construye el panel inferior, metiendo una etiqueta, una caja de texto y un boton.
     * Pone un FlowLayuout y pinta el panel de amarillo.
     */
    private void construyePanelInferior()
    {
        panelInferior = new JPanel(new FlowLayout());
        panelInferior.setBackground(Color.yellow);
        panelInferior.add(new JLabel("Pon texto"));
        panelInferior.add(new JTextField(25));
        panelInferior.add(new JButton("Listo"));
    }

    /**
     * Construye el panel izquierdo, poniendo tres botones.
     * Pone un BoxLayout vertical, para poner los tres botones en columna.
     * Pinta el panel de rojo.
     */
    private void construyePanelIzquierdo()
    {
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(
            new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(Color.red);
        panelIzquierdo.add(new JButton("1"));
        panelIzquierdo.add(new JButton("2"));
        panelIzquierdo.add(new JButton("3"));
    }

    /**
     * Construye el panel derecho poniendo cuatro botones en columna.
     * Pone un BoxLayout para poner los cuatro botones en columna.
     * Pinta el panel de verde.
     */
    private void construyePanelDerecho()
    {
        panelDerecho = new JPanel();
        panelDerecho.setBackground(Color.green);
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.add(new JButton("A"));
        panelDerecho.add(new JButton("B"));
        panelDerecho.add(new JButton("C"));
        panelDerecho.add(new JButton("D"));
    }
}