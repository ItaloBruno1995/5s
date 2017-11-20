package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;

public class Nivel {
	double media1 = 0;
	double media2 = 0;
	double media3 = 0;
	double media4 = 0;
	double media5 = 0;
	double s1 = 0;
	String usuario =null;
	String empresa = null;
	

	private Connection connection;

	public Nivel() {

		connection = SingleConnection.getConection();
	}

	public void seletividade(int d1, int d2, int d3, String usuarioLogado, String empresa) {
		int somatorio = 0;

		somatorio = d1 + d2 + d3;
		media1 = somatorio / 3;
		System.out.println("MEDIA SELETIVIDADE NO METODO: " + media1);

		// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update departamento set seiri = ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, media1);
			stmt.setString(2, usuarioLogado);
			stmt.setString(3, empresa);
			stmt.execute();
			System.out.println("PASSOU PARA REGISTRAR OS PONTOS");
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	// SISTEMATIZAÇÃO

	public void sistematizacao(int d1, int d2, int d3, String usuarioLogado, String empresa) {
		int somatorio = 0;

		somatorio = d1 + d2 + d3;
		media2 = somatorio / 3;
		System.out.println("MEDIA Sistematizacao NO METODO: " + media2);

		// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update departamento set seiton = ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, media2);
			stmt.setString(2, usuarioLogado);
			stmt.setString(3, empresa);
			stmt.execute();
			System.out.println("PASSOU PARA REGISTRAR OS PONTOS");
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	// SEM SUJEIRA:

	public void semSujeira(int d1, int d2, int d3, String usuarioLogado, String empresa) {
		int somatorio = 0;

		somatorio = d1 + d2 + d3;
		media3 = somatorio / 3;
		System.out.println("MEDIA SEM SUJEIRA NO METODO: " + media3);

		// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update departamento set seiso = ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, media3);
			stmt.setString(2, usuarioLogado);
			stmt.setString(3, empresa);
			stmt.execute();
			System.out.println("PASSOU PARA REGISTRAR OS PONTOS");
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	// SAUDE:

	public void saude(int d1, int d2, int d3, int d4, String usuarioLogado, String empresa) {
		int somatorio = 0;

		somatorio = d1 + d2 + d3 + d4;
		media4 = somatorio / 4;
		System.out.println("MEDIA SAUDE NO METODO: " + media4);

		// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update departamento set seiketsu = ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, media4);
			stmt.setString(2, usuarioLogado);
			stmt.setString(3, empresa);
			stmt.execute();
			System.out.println("PASSOU PARA REGISTRAR OS PONTOS");
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	// SEM SOCIALIZAÇÃO:

	public void socializacao(int d1, int d2, int d3, String usuarioLogado, String empresa) {
		int somatorio = 0;

		somatorio = d1 + d2 + d3;
		media5 = somatorio / 3;
		System.out.println("MEDIA SEM SOCIALIZACAO NO METODO: " + media5);

		// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update departamento set shitsuke = ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, media5);
			stmt.setString(2, usuarioLogado);
			stmt.setString(3, empresa);
			stmt.execute();
			System.out.println("PASSOU PARA REGISTRAR OS PONTOS");
			totalDepartamento(usuarioLogado, empresa);// TOTAL GERAL
														// DEPARTAMENTO
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	// METODO PARA REGISTAR MEDIA TOTAL

	public void totalDepartamento(String usuarioLogado, String empresa) {

		double somatorio = 0;
		double mediaGeral = 0;

		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from  departamento where idUsuario =? and  empresa =? ");
			stmt.setString(1, usuarioLogado);
			stmt.setString(2, empresa);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				double s1 = Double.parseDouble(rs.getString("seiri"));
				double s2 = Double.parseDouble(rs.getString("seiton"));
				double s3 = Double.parseDouble(rs.getString("seiso"));
				double s4 = Double.parseDouble(rs.getString("seiketsu"));
				double s5 = Double.parseDouble(rs.getString("shitsuke"));
				somatorio = s1 + s2 + s3 + s4 + s5;
			}
			System.out.println(" MEDIA GERAL ATUALIZADA " + somatorio);
			mediaGeral = somatorio / 5;
			System.out.println("PASSOU em MEDIA GERAL DAO");
			gravarMedia(mediaGeral, usuarioLogado, empresa);
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}// ATULAIZAR MEDIA NO BANCO DE DADOS

	public void gravarMedia(double mediaGeral, String usuarioLogado, String empresa) {
  this.usuario=usuarioLogado;
  this.empresa = empresa;
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("update departamento set total= ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, mediaGeral);
			stmt.setString(2, usuarioLogado);
			stmt.setString(3, empresa);
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
	
	
	
	// LISTAR RESULTADO DEPARTAMENTO :
		public List<BeanResultado> listarResultado(String usuarioLogado, String nomeEmpresa, String departamento){
			// LISTA DE OBJETOS:
			List<BeanResultado> listar = new ArrayList<BeanResultado>();	
			// USUARIO LOGADO:
			
			
			System.out.println("USUARIO LOGADO NA HORA DA LISTAR:"+usuarioLogado);
			System.out.println("NOME DA EMPRESA RECEBIDO PARA FAZER O SELECT :"+nomeEmpresa);
			System.out.println("NOME D0 DEPARTAMENTO PARA FAZER O SELECT: "+departamento);
			
			try {
				PreparedStatement stmt = connection.prepareStatement("select * from departamento where  empresa=? and nome =? and idUsuario =?");
				stmt.setString(1, nomeEmpresa);
				stmt.setString(2, departamento );
				stmt.setString(3, usuarioLogado);

				ResultSet rs = stmt.executeQuery();
				
				
				// Enquanto tiver resultados Criar objeto e adicionar na lista:
							while (rs.next()) {
								// Para cada objeto seta os atributos:
								BeanResultado resultado = new BeanResultado();
							resultado.setS1((rs.getDouble("seiri")));
							resultado.setS2((rs.getDouble("seiton")));
							resultado.setS3((rs.getDouble("seiso")));
							resultado.setS4((rs.getDouble("seiketsu")));
							resultado.setS5((rs.getDouble("shitsuke")));
							System.out.println("passou no laço");


								
								// Adicionar os Objetos na lista
								

								listar.add(resultado);
								//CONTAR QUANTOS OBEJTOS EXITE NA LISTA		
							
							}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listar;
		}
		
	
	
	
	
	
	
	

}
