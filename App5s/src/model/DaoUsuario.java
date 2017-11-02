package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import connection.SingleConnection;
import ultil.JavaMailApp;
import ultil.enviarEmail;

public class DaoUsuario {
	private Connection connection;

	public DaoUsuario() {
		// CONSTRUTOR
		connection = SingleConnection.getConection();
	}

	public boolean login(BeanUsuario usuario) throws Exception {

		PreparedStatement stmt = connection.prepareStatement("select * from usuario where email=? and senha=?");
		stmt.setString(1, usuario.email);
		stmt.setString(2, usuario.senha);
		ResultSet rs = stmt.executeQuery();
		System.out.println("Passou no DAO");
		if (rs.next()) {
			// DEU CERTO:
			return true;
		} else {
			// DEU ERRO:
			return false;
		}
	}
	
	
	public int codigoSeguraca(){
		Random radom =  new Random();
		int numeroTmp = 0;
        for(int i=0;i<10; i++) {
            numeroTmp=radom.nextInt(20000);
            System.out.println(">"+numeroTmp);
	}
        return numeroTmp;
      
        
	}
	
	
	//VALIDAR EMAIL:
	
	public boolean validarEmail(String usuarioLogado) throws Exception {

		PreparedStatement stmt = connection.prepareStatement("select * from usuario where email=?");
		stmt.setString(1, usuarioLogado);
		ResultSet rs = stmt.executeQuery();
		System.out.println("Passou EM VALIADAR EMAIL:");
		if (rs.next()) {
			// DEU CERTO:
			System.out.println("EMAIL VALIDO");
			return true;
		
		} else {
			// DEU ERRO:
			System.out.println("EMAIL INVALIDO");
			return false;
		}
	}
	
	
	
	//INSERIR O CODIGO NO BANCO DE DADOS
	public void gravarCodigo(String usuarioLogado){
		
		int numeroGerado = codigoSeguraca();
		try {
			PreparedStatement stmt = connection.prepareStatement("insert into seguranca(codigo, email) value(?,?)");
			stmt.setInt(1, numeroGerado);
			stmt.setString(2, usuarioLogado);
			stmt.execute();
			connection.commit();
			
			
			System.out.println("passou em GRAVAR CODIGO");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//MANDAR NUMERO GERADO PARA SERVLET
			
			
		}
		System.out.println("VALOR FINAL DO CODIGO DO USUARIO  :"+numeroGerado);
		//ENVIAR EMAIL
	enviarEmail.enviarGmail(usuarioLogado, numeroGerado);
	
	}
	
	//CHAMAR METODO JAVAMAIL 
	
		
		
	
	
	
	
	
	
	
	
	
	
	//VERIFICAR SE O CODIGO PERTENCE AO USUARIO
public boolean validarCodigo(int codigoInformado)  throws Exception{
		
		PreparedStatement stmt = connection.prepareStatement("select * from seguranca where codigo=?");
		stmt.setInt(1, codigoInformado);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			// DEU CERTO:
			return true;
		}else{
			// DEU ERRO:
			return false;
		}
		
	}



   public void salvarNovaSenha(String usuarioLogado, String novaSenha){
	   System.out.println("Nova seha que chegou aqui "+novaSenha);
	   try {
		PreparedStatement stmt = connection.prepareStatement("update usuario set senha = ? where email = ?");
		stmt.setString(1, novaSenha);
		stmt.setString(2, usuarioLogado);
		stmt.execute();
		System.out.println("passou aqui no dao nova senha");
		connection.commit();
		
	} catch (SQLException e) {
		e.printStackTrace();
		try {
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	   
   }
   
   
   
   
   public void cadastroUsuario(BeanUsuario usuario){
		 try {
			PreparedStatement stmt = connection.prepareStatement("insert into usuario(email, nome, dataNascimento, senha) value(?,?,?,?)");
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getDataNascimento());
			stmt.setString(4, usuario.getSenha());
			stmt.execute();
			System.out.println("Passou CADASTRO DE USUARIO DAO!");
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		 
   }
   
   
   
   
	
}
	
	
	

