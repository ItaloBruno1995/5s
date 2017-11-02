package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BeanEmpresa;
import model.DaoDepartamento;
import model.DaoEmpresa;

/**
 * Servlet implementation class CadastrarEmpresaServlet
 */
@WebServlet("/CadastrarEmpresaServlet")
public class CadastrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeanEmpresa empresa = new BeanEmpresa();
		DaoEmpresa daoempresa = new DaoEmpresa();
		 //ATENÇÃO:
		
		
		empresa.setNome(request.getParameter("nome"));
		empresa.setTelefone(request.getParameter("telefone"));
		HttpSession sessaoUsuario = request.getSession();
		String usuarioLogado= (String) sessaoUsuario.getAttribute("usuarioSessao");
		System.out.println("Usuario logado para Cadstrar Empresa: "+usuarioLogado);
		
		try {
			
			
			
			daoempresa.cadastraEmpresa(empresa, usuarioLogado);
			//CRIAR SESSÃO  PARA EMPRESA:
			HttpSession sessaoEmpresa = request.getSession();
			sessaoUsuario.setAttribute("sessaoEmpresa", empresa.getNome());
			String sessapEmpresa =  (String) sessaoUsuario.getAttribute("sessaoEmpresa");
			
			
			// REDIRECIONAR PARA PAGINA DE ACESSO:
			RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/telaPrincipal1.jsp");
			//VAI NA REQUEST LISTAR DEPARTAMENTO:
			DaoDepartamento daoPepartamento = new DaoDepartamento();
			
			//VAI NA REQUEST LISTAR EMPRESA:
			DaoEmpresa emoresa = new DaoEmpresa();
			request.setAttribute("empresas", daoempresa.listarEnmpresa(usuarioLogado));
			
			visualizar.forward(request, response);
			System.out.println("passou aqui REDIRECIONAMENTO");
			
		} catch (Exception e) {
			// PAGINA  DE ERRO:
		}
		
	}

}
