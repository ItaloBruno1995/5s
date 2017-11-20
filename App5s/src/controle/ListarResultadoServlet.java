package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BeanResultado;
import model.Nivel;

/**
 * Servlet implementation class ListarResultadoServlet
 */
@WebServlet("/ListarResultadoServlet")
public class ListarResultadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListarResultadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BeanResultado  resultado = new BeanResultado();
		Nivel  nivel = new Nivel();
		
		//RECUPERANDO SESSÃO DE USUARIO E EMPRESA
				HttpSession sessaoUsuario = request.getSession();
				String usuarioLogado = (String) sessaoUsuario.getAttribute("usuarioSessao");
				
				HttpSession sessaoEmpresa= request.getSession();
				String empresa = (String) sessaoEmpresa.getAttribute("empresaSessao");
				
				HttpSession sessaoDepartamento = request.getSession();
				String departamento = (String) sessaoDepartamento.getAttribute("sessaoDepartamento");
		
		System.out.println("departamento que enviou para resulatdo " + departamento);
		System.out.println("empresa que enviou pra resultado "+empresa);
		System.out.println("Usuario que enviou para resulatdo "+usuarioLogado);
		
		
		
		RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/resultado.jsp");
		request.setAttribute("resultado", nivel.listarResultado(usuarioLogado,empresa,departamento));
		visualizar.forward(request, response);
		System.out.println("REDIRECIONAMENTO para tela de resultados ");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
