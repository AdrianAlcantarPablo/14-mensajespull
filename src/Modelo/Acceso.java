package Modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.AbstractDocument.Content;
import BD.ConexionSingleton;

/**
 * 
 * @author Adrian
 *
 */

public final class Acceso extends JPanel {
	/**
	 * Interfaz donde se muestra la ventana de acceso a los usuarios para el chat
	 */
	private static Acceso acceso=new Acceso();
	private JPanel plMsg=new JPanel();
	private JList listaNombres=new JList();
	private JScrollPane scroll = new JScrollPane ( listaNombres );
	private DefaultListModel modelo = new DefaultListModel();
	private ConexionSingleton InC=ConexionSingleton.Conexion();
	private Connection con = InC.getConexion();
	private CRUD crud=new CRUD(null, null, null, null, 0,0,null);
	private ResultSet set;

	
	private Acceso(){
		super.setSize(500,300);
		super.setBackground(Color.BLUE);
		super.setLayout(null);
		scroll.setBounds(0, 0, 500	, 300);
		this.add(scroll);
		Panel();
	}
	
	public static Acceso getAcceso() {
		return acceso;
	}

	public static void setAcceso(Acceso acceso) {
		Acceso.acceso = acceso;
	}

	public JPanel getPlMsg() {
		return plMsg;
	}

	public void setPlMsg(JPanel plMsg) {
		this.plMsg = plMsg;
	}

	public JList getListaNombres() {
		return listaNombres;
	}

	public void setListaNombres(JList listaNombres) {
		this.listaNombres = listaNombres;
	}

	public DefaultListModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}

	
	public static Acceso accesoInstancia(){
		return acceso;
	}
	
	public  void Panel() {
		try {
			set=crud.mensajes();
			while(set.next()){
				modelo.addElement(set.getString("usuario")+"  "+set.getString("date"));
				modelo.addElement(set.getString("mensaje"));
				listaNombres.setModel(modelo);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
