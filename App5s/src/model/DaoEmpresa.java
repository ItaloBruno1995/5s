package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;

public class DaoEmpresa {
	private Connection connection;
	
	public DaoEmpresa() {
		connection= SingleConnection.getConection();
	}
	
	public void cadastraEmpresa(BeanEmpresa  empresa , String usuarioLogado){
		try {
			PreparedStatement stmt = connection.prepareStatement("insert into empresa(nome, telefone, usuario, media) value(?,?,?,?)");
			stmt.setString(1, empresa.getNome());
			stmt.setString(2, empresa.getTelefone());
			stmt.setString(3, usuarioLogado);
			stmt.setDouble(4, 0);
			stmt.execute();
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
	
	
	
	
	
	
	// LISTAR DEPARTAMENTO DO USUARIO:
		public List<BeanEmpresa> listarEnmpresa(String usuarioLogado){
			// LISTA DE OBJETOS:
			List<BeanEmpresa> listar = new ArrayList<BeanEmpresa>();	
			// USUARIO LOGADO:
			
			
			System.out.println("USUARIO LOGADO NA HORA DA LISTAR:"+usuarioLogado);
			
			try {
				PreparedStatement stmt = connection.prepareStatement("select * from empresa where usuario=?");
				stmt.setString(1, usuarioLogado);
				ResultSet rs = stmt.executeQuery();
				System.out.println("USUARIO LOGADO PARA LISTAR  EMPRESA : "+usuarioLogado);
				
				// Enquanto tiver resultados Criar objeto e adicionar na lista:
							while (rs.next()) {
								// Para cada objeto seta os atributos:
								BeanEmpresa empresa = new BeanEmpresa();
								empresa.setNome(rs.getString("nome"));
								empresa.setTelefone(rs.getString("telefone"));
								
								//Adicionar Objeto na Lista:
								listar.add(empresa);	
								
							
							}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return listar;
		}
	
	
	
	
	
	
}
