package escritorio;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import entities.Usuario;

public class frame extends JFrame implements ActionListener{
	public JLabel texto1,texto2;
	public JTextField nomU, pin;
	public JButton uno, dos, tres, cuatro, cinco, ac;
	public double numero;
	public String resultado;
	
	static ArrayList<Usuario> usuarios= new ArrayList<>();
	public static void main(String[] args) {
		int cont=0;
		boolean correcto=false;
		cargaUsuarios();
		frame aplicacion = new frame();
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (cont!=3 & correcto!=true) {
			if (correcto==false) {
			cont++;
			System.out.println(cont);
			}else {correcto=true;}
			if (correcto==false) {
				JOptionPane.showMessageDialog( null, "Llegó al límite de ingreso de usuarios incorrectos. El programa se cerrará" );
				System.exit(0);}
		}
	}
		
	public static void cargaUsuarios() {
		Usuario user1=new Usuario();
		user1.setName("Nahuel Buschittari");
		user1.setPin("42769846");
		usuarios.add(user1);
		Usuario user2=new Usuario();
		user2.setName("José Paradela");
		user2.setPin("30164725");
		usuarios.add(user2);
		Usuario user3=new Usuario();
		user3.setName("Federico Pérez");
		user3.setPin("44332123");
		usuarios.add(user3);
		for (Usuario u : usuarios) {
			u.mostrarDatos();
	}
	}
	
	public frame(){
		super("Banco UTN");
		Container contenedor = getContentPane();
		contenedor.setLayout(new GridLayout(3,2));
		JLabel texto1 = new JLabel("Ingrese su usuario",SwingConstants.LEFT);
		contenedor.add(texto1);
		nomU = new JTextField();
		contenedor.add(nomU);
		JLabel texto2 = new JLabel("Ingrese su Contraseña",SwingConstants.LEFT);
		contenedor.add(texto2);
		pin = new JTextField();
		contenedor.add(pin);
		ac= new JButton ("Aceptar");
		contenedor.add(ac);
		ac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
					if (validarUsuario()==false) {
						JOptionPane.showMessageDialog( null, "Usuario incorrecto" );
						nomU.setText("");
						pin.setText("");
						}
				}
			}
		);
		setSize(400,250);
		setVisible(true);
		}
	
	public boolean validarUsuario() {
		boolean band=false;
		if(nomU.getText().equals("")) {
			JOptionPane.showMessageDialog( this, "Por favor llene todos los campos" );
		}else {
			for (Usuario usuario : usuarios) {
				System.out.println("¿"+usuario.getName()+"="+nomU.getText()+"?");
				if (usuario.getName().equals(nomU.getText())) {band=true;}
			}
		}
		return band;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==uno){
				numero=1;
			}
			
	if(e.getSource()==dos){
			try
			{
				numero = Double.parseDouble(nomU.getText());
				if(numero>=0) 
				{
					nomU.setText("Positivo");
				}	
				else
				{
					nomU.setText("Negativo");
				}
			
			
			}
		
			catch(NumberFormatException e1)
			{
				JOptionPane.showMessageDialog(this, "Error de formato", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(ArithmeticException e2)
			{
				JOptionPane.showMessageDialog(this, "Error Aritmético", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(NullPointerException e3)
			{
				JOptionPane.showMessageDialog(this, "Ingresá algo", "Error", JOptionPane.ERROR_MESSAGE);
			}
	
		}
		if(e.getSource()==tres)
			{
			nomU.setText("");
			nomU.setText("");
			}
		if(e.getSource()==cinco)
			{
			System.exit(0);
			}
	}

}

/*uno= new JButton ("Consulta Saldo");
contenedor.add(uno);
dos= new JButton ("Transferencia entre cuentas");
contenedor.add(dos);
tres= new JButton ("Extraccion");
contenedor.add(tres);
cuatro= new JButton("Depósito");
contenedor.add(cuatro);
cinco= new JButton ("Salir");
contenedor.add(cinco);
uno.addActionListener(this);
dos.addActionListener(this);
tres.addActionListener(this);
cuatro.addActionListener(this);
cinco.addActionListener(this);
*/