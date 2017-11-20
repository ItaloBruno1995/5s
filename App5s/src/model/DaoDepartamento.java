package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import connection.SingleConnection;

public class DaoDepartamento {

	private Connection connection;
	int contador=0;
	double somatorio=0;
	double mediaGeral =0;

	public DaoDepartamento() {
		connection = SingleConnection.getConection();

	}
	
	
	
	// LISTAR DEPARTAMENTO DO USUARIO:
	public List<BeanDepartamento> listarDepartamento(String usuarioLogado, String nomeEmpresa){
		// LISTA DE OBJETOS:
		List<BeanDepartamento> listar = new ArrayList<BeanDepartamento>();	
		// USUARIO LOGADO:
		
		
		System.out.println("USUARIO LOGADO NA HORA DA LISTAR:"+usuarioLogado);
		System.out.println("NOME DA EMPRESA RECEBIDO PARA FAZER O SELECT :"+nomeEmpresa);
		
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from departamento where idUsuario=? and empresa=?");
			stmt.setString(1, usuarioLogado);
			stmt.setString(2, nomeEmpresa);
			ResultSet rs = stmt.executeQuery();
			
			
			// Enquanto tiver resultados Criar objeto e adicionar na lista:
						while (rs.next()) {
							// Para cada objeto seta os atributos:
							BeanDepartamento departamento = new BeanDepartamento();
							departamento.setId(rs.getInt("id"));
							departamento.setNome(rs.getString("nome"));
							departamento.setDataCriado(rs.getString("dataCriado"));
							departamento.setTotal(rs.getDouble("total"));
							
							// Adicionar os Objetos na lista
							contador= contador+1;

							listar.add(departamento);
							//CONTAR QUANTOS OBEJTOS EXITE NA LISTA	
							somatorio = somatorio+departamento.getTotal();
							
						
						}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//CALULO DE MEDIA GERAL:
		System.out.println("SOMATORIO: "+somatorio);
		System.out.println("CONTADOR: "+contador);
		mediaGeral= somatorio/contador;
		return listar;
	}
	
	
	
	public double retornarMediageral(){
		System.out.println("Media Geral:" +mediaGeral);
		return mediaGeral;
	}
	
	
	public void cadastroDepartamento(BeanDepartamento  departamento , String empresaSessao, String usuarioLogado){
		try {
			
			System.out.println("CHAMOU O DAO PARA CADASTRA DEPARTAMENTO");
			PreparedStatement stmt = connection.prepareStatement("insert into departamento(nome, dataCriado, idUsuario, total, empresa, seiri, seiton, seiso, seiketsu, shitsuke) value(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, departamento.getNome());
			stmt.setString(2, departamento.getDataCriado());
			stmt.setString(3, usuarioLogado);
			stmt.setDouble(4, 0);
			stmt.setString(5, empresaSessao);
			stmt.setDouble(6, 0);
			stmt.setDouble(7, 0);
			stmt.setDouble(8, 0);
			stmt.setDouble(9, 0);
			stmt.setDouble(10, 0);
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
	
	
	
	//****** ETAPA CADASTRO DEPARTAMENTO:
	
	public void cadastroNivel1(BeanDepartamento departamento, String usuarioLogado, String empresa){
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	

