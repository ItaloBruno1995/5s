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

@WebServlet("/Nivel3Servlet")
public class Nivel3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Nivel3Servlet() {
		super();

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

		// RECUPERAR PARAMENTROS:
		// VALIDAR NIVEIS :
		// SELETIVIDADE:
		if (request.getParameter("nivel").equalsIgnoreCase("3")) {
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
			RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/semsujeira.jsp");
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
			RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/semsujeira.jsp");
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
			RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/semsujeira.jsp");
			visualizar.forward(request, response);
		}

		// ADICIONAR TRY CATH

		// ENVIO DOS DADOS:
		nivel.semSujeira(d1, d2, d3, usuarioLogado, empresa);
		// REDIRECIONAMENTO PARA PROXIMO FORMULARIO:
		RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/semsujeira.jsp");
		visualizar.forward(request, response);

		// SISTEMATIZACAO

	}

}
