package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import BD.ConexionSingleton;
/**
 * 
 * @author Adrian
 *
 */

public  class CRUD {
	ConexionSingleton InC=ConexionSingleton.Conexion();
	Connection con = InC.getConexion();
	private 	Statement statement;
	private ResultSet res;
	private String sql;
	private String msg;
	private String nick;
	private String nom;
	private  String app;
	private String pass;
	private int ide;
	private int id;
	private String mensajes;
	
	/**
	 * Asignacion de variables  para crear, obtener, actualizar y borrar
	 * @param nick
	 * @param nom
	 * @param app
	 * @param pass
	 * @param ide
	 * @param id
	 * @param msg
	 */
	public CRUD(String nick, String nom, String app, String pass, int ide, int id,String msg){
		this.id=id;
		this.ide=ide;
		this.nick=nick;
		this.nom=nom;
		this.app=app;
		this.pass=pass;
		this.mensajes=msg;
		
	}

	/**
	 * Modificacion de registros existentes en la base de datos
	 * @return
	 */
	public String Update() {
			try {
				
				if(getIde()==1){
					statement = con.createStatement();
					sql=String.format("INSERT INTO contacto  VALUES (null, ' %s' , ' %s',' %s' ,' %s' )", 
																																		getNick(),
																																		getNom(),
																																		getApp(),
																																		getPass());	
					System.out.println(sql);
					statement.executeUpdate(sql);
					statement.close();
				//	con.close();
				}
				
				if(getIde()==2){
					Statement statement=con.createStatement();
					String sql=String.format("update contacto set nick= '%s' , nom=' %s', app= '%s', pass= '%s'  where id=%d",  
																			getNick(),
																			getNom(),
																			getApp(),
																			getPass(),
																			getId());
					System.out.println(sql);
					statement.executeUpdate(sql);
					statement.close();
			          con.close();
				}
				
				if(getIde()==3){
					statement = con.createStatement();
					sql=String.format("INSERT INTO mensajes  VALUES (null, ' %s' , now() ,' %s' )", 
																																		getMensajes(),
																																		getNick());	
					System.out.println(sql);
					statement.executeUpdate(sql);
					statement.close();
					//con.close();
				}
				
		        msg="Operación Exitosa";
			} catch (SQLException e) {
				msg="Lo sentimos ocurrio en la operación";
			}
			return msg;
				  	
	}
	
	
	public String getMensajes() {
		return mensajes;
	}


	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}

	/**
	 * Consulta de registros existentes en la base de datos
	 * @return
	 * @throws SQLException
	 */
	public ResultSet consulta() throws SQLException{

			Statement statement=con.createStatement();
			String sql=String.format("select COUNT(nick), nick  from contacto where nick= ' %s'  and pass=' %s' ",getNick(), getPass());
			System.out.println(sql);
		return res= statement.executeQuery(sql);
	}
	
	public ResultSet mensajes() throws SQLException{
		Statement statement=con.createStatement();
		String sql=String.format("select * from mensajes");
		return res= statement.executeQuery(sql);
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIde() {
		return ide;
	}

	public void setIde(int ide) {
		this.ide = ide;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
