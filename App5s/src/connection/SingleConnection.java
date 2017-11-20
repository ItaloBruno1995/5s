package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	
	
	private static String banco="jdbc:mysql://node147779-app5s.jelasticlw.com.br/5s?autoReconnect=true";
	private static String senha="EPQbpg00564";
	private static String use="root";
	private static Connection connection = null;
	
	
	static{
		conectar();
		
	}
	
	public SingleConnection(){
		conectar();
	}
	
	
	private static  void conectar(){
		try{
			if(connection==null){
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection(banco, use, senha);
				connection.setAutoCommit(false);		
			}	
		}catch (Exception e) {
			throw new RuntimeException("ERRO AO CONECTAR COM BANCO DE DADOS");
		}
		
	}
	
	
	
	public static Connection getConection(){
		
		return connection;
	}
	
	
}

	

