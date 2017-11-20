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
 * Servlet implementation class MostraDadosServlet
 */
@WebServlet("/MostraDadosServlet")
public class MostraDadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraDadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departamento = request.getParameter("departamento");
		Nivel nivel = new Nivel();
		
		System.out.println("ENTROU EM DADOS DE DEPARTAMENTO");
		System.out.println(" DEPARTAMENTO PEGO: "+departamento);
		HttpSession sessaoUsuario = request.getSession();
		String usuarioLogado = (String) sessaoUsuario.getAttribute("usuarioSessao");
		
		HttpSession sessaoEmpresa= request.getSession();
		String empresa = (String) sessaoEmpresa.getAttribute("empresaSessao");
		
		RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/resultado.jsp");
		request.setAttribute("resultado", nivel.listarResultado(usuarioLogado,empresa,departamento));
		visualizar.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
