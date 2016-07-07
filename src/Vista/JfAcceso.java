package Vista;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import Modelo.Acceso;
import Modelo.CRUD;

/**
 * 
 * @author Adrian
 *
 */

public final class JfAcceso extends JFrame implements ActionListener {
	/**
	 * Creacion de las intrfaces que se utilizaran en el sistema
	 * Asignacion de nombres a los objetos
	 */
	private static JfAcceso acceso=new JfAcceso();
	private 	Acceso instanciaUser=Acceso.accesoInstancia();
	private CRUD create;
	private ResultSet set;
	private JLabel lblmsg=new JLabel("Registrate y comporte ");
	private JLabel lbltit=new JLabel("Mensajes");
	private JLabel lblAc=new JLabel("ACCESO");  
	private JLabel lblNick=new JLabel("NICK");
	private JLabel lblPass=new JLabel("Password");
	private JLabel lblReg=new JLabel("REGISTRO");
	private JLabel lblNickR=new JLabel("NICK");
	private JLabel lblNom=new JLabel("Nombre");
	private JLabel lblApp=new JLabel("Apellido");
	private JLabel lblPassR=new JLabel("Password"); 
	private JLabel lblAlerta=new JLabel();
	private ImageIcon image=new ImageIcon("../14-MensajesPull/src/img/logo.png");
	private JLabel logo =new JLabel(image);
	
	private JTextField txtNick=new JTextField();
	private JPasswordField txtPass=new JPasswordField();
	private JTextField txtNickR=new JTextField();
	private JTextField txtNom=new JTextField();
	private JTextField txtApp=new JTextField();
	private JPasswordField txtPassR=new JPasswordField();
	private JTextArea txtaMsg=new JTextArea();
	private JScrollPane scroll = new JScrollPane ( txtaMsg );
	
	private JButton btnEntrar=new JButton("Entrar");
	private JButton btnRegistrar=new JButton("Registrar");
	private JButton btnEnviar=new JButton("Enviar");
	private JButton btnSalir=new JButton("Salir");
	
	
	
	private JPanel panelMsg=new JPanel();
	private JPanel panelAcceso=new JPanel();
	private JPanel panelRegistro=new JPanel();
	private JPanel panelMensaje=new JPanel();
	private JPanel panelEnvios=new JPanel();
	private Container c = getContentPane();
	
	
	public static JfAcceso getAcceso() {
		return acceso;
	}

	public static void setAcceso(JfAcceso acceso) {
		JfAcceso.acceso = acceso;
	}

	private JfAcceso(){
		super.setTitle("Mensajes Pull");
		super.setSize(900,500);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Controladores();
	}
	
	public static JfAcceso instanciaframe(){
		return acceso;
	}
	
	public void Controladores(){
		/**
		 * Posiciones de los objetos dentro de los frames correspondientes
		 */
		c.setLayout(null);
		panelAcceso.setLayout(null);
		panelRegistro.setLayout(null);
		panelMensaje.setLayout(null);
		panelEnvios.setLayout(null);
		
		panelAcceso.setBounds(20, 20, 270, 180);
		panelAcceso.setBackground(Color.WHITE);
		panelRegistro.setBounds(20, 200, 270, 220);
		panelMensaje.setBounds(330, 60, 500, 300);
		logo.setBounds(30	, 30, 300, 300);
		panelMensaje.add(logo);
		//panelMensaje.setBackground(Color.CYAN);
		panelEnvios.setBounds(330, 365, 500, 80);
		//panelEnvios.setBackground(Color.WHITE );
		lblmsg.setBounds(500, 20, 300, 50);
		btnSalir.setBounds(750, 30, 100, 20);
		btnSalir.setVisible(false);
		
		lblAc.setBounds(100, 20, 300, 50);
		lblNick.setBounds(30, 70, 80, 20);
		txtNick.setBounds(110, 70, 110, 20);
		lblPass.setBounds(30, 100, 80, 20);
		txtPass.setBounds(110, 100, 110, 20);
		btnEntrar.setBounds(110, 140, 80, 20);
		 
		
		panelAcceso.add(lblAc);
		panelAcceso.add(lblNick);
		panelAcceso.add(txtNick);		
		panelAcceso.add(lblPass);
		panelAcceso.add(txtPass);
		panelAcceso.add(btnEntrar);
		
		lblNickR.setBounds(30, 30, 80, 20);
		
		lblReg.setBounds(100, 20, 300, 50);
		lblNickR.setBounds(30, 70, 80, 20);
		txtNickR.setBounds(110, 70, 110, 20);
		lblNom.setBounds(30, 100, 80, 20);
		txtNom.setBounds(110, 100, 110, 20);
		lblApp.setBounds(30, 130, 80, 20);
		txtApp.setBounds(110, 130, 110, 20);
		lblPassR.setBounds(30, 160, 80, 20);
		txtPassR.setBounds(110, 160, 110, 20);
		btnRegistrar.setBounds(110, 190, 100, 20);
		lblAlerta.setBounds(30, 430, 200, 20);
		
		panelRegistro.add(lblReg);
		panelRegistro.add(lblNickR);
		panelRegistro.add(lblNom);
		panelRegistro.add(lblApp);
		panelRegistro.add(lblPassR);
		panelRegistro.add(txtNickR);
		panelRegistro.add(txtNom);
		panelRegistro.add(txtApp);
		panelRegistro.add(txtPassR);
		panelRegistro.add(btnRegistrar);
		
		scroll.setBounds(0, 0, 400, 80);
		btnEnviar.setBounds(400, 0, 100, 80);

		panelEnvios.add(scroll);
		panelEnvios.add(btnEnviar);
		panelEnvios.setVisible(false);
		
		c.add(lblmsg);
		c.add(btnSalir);
		c.add(lblAlerta);
		c.add(panelAcceso);
		c.add(panelRegistro);
		c.add(panelMensaje);
		c.add(panelEnvios);
		
		
		btnRegistrar.addActionListener(this);
		btnEntrar.addActionListener(this);
		btnEnviar.addActionListener(this);
		btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object btn=e.getSource();

/**
 * Registrarse
 */
			if(btn.equals(btnRegistrar)){
				create= new CRUD(txtNickR.getText(),
														txtNom.getText(),
														txtApp.getText(),
														txtPassR.getText(), 
														1, 0,null);
					lblAlerta.setText(create.Update());
					limpiar();
			}
/**
 * fin de registro
 */
			
/**
 * Entrar a mensajes pull
 */
			if(btn.equals(btnEntrar)){
				lblAlerta.setText("");
				create= new CRUD(txtNick.getText(),null,null,txtPass.getText(), 0, 0,null);
				
				try {
					set= create.consulta();
					 set.next();
					 limpiar();
					if(set.getString(1).equals("0")){
						lblAlerta.setText("Lo sentimos el usuario no existe");
						
					}else{
							panelAcceso.setVisible(false);
							panelRegistro.setVisible(false);
							logo.setVisible(false);
							btnSalir.setVisible(true);
							lblmsg.setText(set.getString(2));
							creaPanel();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
/**
 * fin de mensajes pull
 */
			
/**
 * Enviar mensajes pull
 */
			if(btn.equals(btnEnviar)){
				create= new CRUD(lblmsg.getText(), null, null, null, 3, 0, txtaMsg.getText());
				lblAlerta.setText(create.Update());
				txtaMsg.setText(null);
			}
/**
 * fin de mensajes pull			
 */
		
/**
 * Boton salir
 */
			if(btn.equals(btnSalir)){
				panelMensaje.removeAll();
				panelMensaje.repaint();
				logo.setVisible(true);
				panelMensaje.add(logo);
				panelEnvios.setVisible(false);
				panelAcceso.setVisible(true);
				panelRegistro.setVisible(true);
				btnSalir.setVisible(false);
				lblmsg.setText("Registrate y comienza");
			}
/**
 * fin 
 */
	}
	public void creaPanel(){
		
		panelMensaje.add( instanciaUser.getAcceso());
		panelEnvios.setVisible(true);
		super.setSize(905,505);
	}
	
	public void limpiar(){
		txtNick.setText(null);
		txtNickR.setText(null);
		txtPass.setText(null);
		txtPassR.setText(null);
		txtNom.setText(null);
		txtApp.setText(null);
		
	}
}
