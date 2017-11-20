package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DaoEmpresa;

/**
 * Servlet implementation class TelaInicialServlet
 */
@WebServlet("/TelaInicialServlet")
public class TelaInicialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TelaInicialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoEmpresa daoempresa = new DaoEmpresa();
		
		HttpSession sessaoUsuario = request.getSession();
		String usuarioLogado = (String) sessaoUsuario.getAttribute("usuarioSessao");
		
		RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/telaPrincipal1.jsp");
		//VAI NA REQUEST LISTAR EMPRESA:
		request.setAttribute("empresas", daoempresa.listarEnmpresa(usuarioLogado));
		
		visualizar.forward(request, response);
		System.out.println("passou aqui REDIRECIONAMENTO");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
