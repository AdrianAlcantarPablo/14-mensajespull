package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * 
 * @author Adrian
 *
 */

public final class ConexionSingleton {
	
	/**
	 * Clase para realizar la conexion de la aplicacion con la base de datos
	 * Base de datos agenda
	 * usuario root
	 * contraseña no tiene
	 */
	private static final ConexionSingleton con=new ConexionSingleton();
	private  String user="root";
	private  String url="jdbc:mysql://localhost/agenda";
	private  String pass="";
	
	private Connection conexion;
	
	private ConexionSingleton(){
		try {
			conexion= DriverManager.getConnection(url,user,pass);
			System.out.print("Conexion ");	
			
		} catch (SQLException e) {
			System.err.print("Error : "+e);
		}
	}
	
	public static ConexionSingleton Conexion(){
		return con;
	}
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
}
