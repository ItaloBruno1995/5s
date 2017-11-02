package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BeanUsuario;
import model.DaoDepartamento;
import model.DaoEmpresa;
import model.DaoUsuario;

/**
 * Servlet implementation class cadastroUsuarioServlet
 */
@WebServlet("/cadastroUsuarioServlet")
public class cadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastroUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BeanUsuario usuario = new BeanUsuario();
		DaoUsuario daousuario = new DaoUsuario();
		DaoDepartamento daodepartamentos = new DaoDepartamento();
		try {
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setDataNascimento(request.getParameter("dataNascimento"));
		String usuarioLogado = usuario.getEmail();
		
		HttpSession sessaousuario = request.getSession();
		
		sessaousuario.setAttribute("sesssaousuario", usuarioLogado);
		
		daousuario.cadastroUsuario(usuario);
		
		//REDIRECIONAR PARA TELA DE LISTAR EMPRESAS(PRINCIPAL)
		
		DaoEmpresa daoempresa = new DaoEmpresa();
		RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/telaPrincipal1.jsp");
		//VAI NA REQUEST LISTAR EMPRESA:
		
		request.setAttribute("empresas", daoempresa.listarEnmpresa(usuarioLogado));
		
		visualizar.forward(request, response);
		System.out.println("passou aqui REDIRECIONAMENTO");




		
		
		} catch (Exception e) {
			// REDIRECIONAR PARA TELA DE ERRO!
		}
			
		}
		
		
	

}
