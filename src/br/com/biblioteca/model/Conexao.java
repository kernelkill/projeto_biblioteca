/* 
    *Document   : Conexao
    *Created on : Apr 24, 2016
    *Author     : Joabe Kachorroski
*/
package br.com.biblioteca.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String driver = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/biblioteca";
	private static final String usuario = "postgres";
	private static final String senha = "postgres";
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(URL, usuario, senha);
			} catch (Exception error) {
				error.printStackTrace();
			}
		}
		return connection;
	}
}
