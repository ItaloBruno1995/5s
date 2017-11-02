package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;

public class Nivel {
	double mediaSistem = 0;
	double mediaSeiri = 0;

	private Connection connection;

	public Nivel() {
	
		connection = SingleConnection.getConection();
	}

	public void seletividade(int d1, int d2, int d3, String usuarioLogado, String empresa) {
		int somatorio = 0;

		somatorio = d1 + d2 + d3;
		mediaSeiri = somatorio / 3;
		System.out.println("MEDIA SELETIVIDADE NO METODO: " + mediaSeiri);

		// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update departamento set seiri = ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, mediaSeiri);
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
		mediaSistem = somatorio / 3;
		System.out.println("MEDIA Sistematizacao NO METODO: " + mediaSistem);

		// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update departamento set seiton = ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, mediaSistem);
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
		mediaSistem = somatorio / 3;
		System.out.println("MEDIA SEM SUJEIRA NO METODO: " + mediaSistem);

		// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update departamento set seiso = ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, mediaSistem);
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
		mediaSistem = somatorio / 4;
		System.out.println("MEDIA SAUDE NO METODO: " + mediaSistem);

		// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update departamento set seiketsu = ? where idUsuario =? and  empresa =? ");
			stmt.setDouble(1, mediaSistem);
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
			mediaSistem = somatorio / 3;
			System.out.println("MEDIA SEM SOCIALIZACAO NO METODO: " + mediaSistem);

			// REGISTAR(UPDATE) A MEDIA NA COLUNA REFERNTE:
			try {
				PreparedStatement stmt = connection
						.prepareStatement("update departamento set shitsuke = ? where idUsuario =? and  empresa =? ");
				stmt.setDouble(1, mediaSistem);
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
	
	// METODO PARA REGISTAR MEDIA TOTAL

}
