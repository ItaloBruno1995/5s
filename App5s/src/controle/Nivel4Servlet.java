package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Nivel;

/**
 * Servlet implementation class Nivel4Servlet
 */
@WebServlet("/Nivel4Servlet")
public class Nivel4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Nivel4Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RECUPERAR SESSOES:
		HttpSession sessaoUsuario = request.getSession();
		String usuarioLogado = (String) sessaoUsuario.getAttribute("usuarioSessao");
		HttpSession sessaoEmpresa = request.getSession();
		String empresa = (String) sessaoEmpresa.getAttribute("empresaSessao");
		Nivel nivel = new Nivel();

		int d1 = 0;
		int d2 = 0;
		int d3 = 0;
		int d4 = 0;

		if (request.getParameter("nivel").equalsIgnoreCase("4")) {
			System.out.println("ENTROU NO NIVEL 02");

			if (request.getParameter("p1").equalsIgnoreCase("2")) {
				System.out.println("VALOR 2");
				if (request.getParameter("p1").equalsIgnoreCase("1")) {
					System.out.println(" VALOR 1");
					d1 = 0;

				} else
					d1 = 0;
			} else if (request.getParameter("p1").equalsIgnoreCase("3")) {
				System.out.println("VALOR 3");
				d1 = 10;
			} else if (request.getParameter("p1").equalsIgnoreCase("4")) {
				System.out.println("VALOR 4");
				d1 = 6;
			} else if (request.getParameter("p1").equalsIgnoreCase("5")) {
				System.out.println("VALOR 5");
				d1 = 8;
			}
		} else {
			// CASO TODOS NULOS RETORNAR PARA PAGINA NOVAMENTE
			RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/saude.jsp");
			visualizar.forward(request, response);
		}
		if (request.getParameter("p2").equalsIgnoreCase("1")) {
			d2 = 0;
		} else if (request.getParameter("p2").equalsIgnoreCase("2")) {
			d2 = 0;
		} else if (request.getParameter("p2").equalsIgnoreCase("3")) {
			d2 = 10;
		} else if (request.getParameter("p2").equalsIgnoreCase("4")) {
			d2 = 6;
		} else if (request.getParameter("p2").equalsIgnoreCase("5")) {
			d2 = 8;
		} else {
			// CASO TODOS NULOS RETORNAR PARA PAGINA NOVAMENTE
			RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/saude.jsp");
			visualizar.forward(request, response);
		}
		if (request.getParameter("p3").equalsIgnoreCase("1")) {
			d3 = 0;
		} else if (request.getParameter("p3").equalsIgnoreCase("2")) {
			d3 = 0;
		} else if (request.getParameter("p3").equalsIgnoreCase("3")) {
			d3 = 10;
		} else if (request.getParameter("p3").equalsIgnoreCase("4")) {
			d3 = 6;
		} else if (request.getParameter("p3").equalsIgnoreCase("5")) {
			d3 = 8;
		} else {
			// CASO TODOS NULOS RETORNAR PARA PAGINA NOVAMENTE
			RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/saude.jsp");
			visualizar.forward(request, response);
		}

		if (request.getParameter("p4").equalsIgnoreCase("1")) {
			d4 = 0;
		} else if (request.getParameter("p4").equalsIgnoreCase("2")) {
			d4 = 0;
		} else if (request.getParameter("p4").equalsIgnoreCase("3")) {
			d4 = 10;
		} else if (request.getParameter("p4").equalsIgnoreCase("4")) {
			d4 = 6;
		} else if (request.getParameter("p4").equalsIgnoreCase("5")) {
			d4 = 8;
		} else {
			// CASO TODOS NULOS RETORNAR PARA PAGINA NOVAMENTE
			RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/saude.jsp");
			visualizar.forward(request, response);
		}

		// ADICIONAR TRY CATH

		// ENVIO DOS DADOS:
System.out.println("VALOR D1"+d1+ " VALOR D2: "+d2+ " VALOR D3:"+d3+" VALOR D4:"+d4);
		nivel.saude(d1, d2, d3, d4, usuarioLogado, empresa);
		// REDIRECIONAMENTO PARA PROXIMO FORMULARIO:
		RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/socializacao.jsp");
		visualizar.forward(request, response);

		// SISTEMATIZACAO

	}

}
