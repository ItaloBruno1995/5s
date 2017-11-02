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
 * Servlet implementation class loginUsuarioServlet
 */
@WebServlet("/loginUsuarioServlet")
public class loginUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loginUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeanUsuario usuario = new BeanUsuario();
		DaoUsuario daoUsuario = new DaoUsuario();
		DaoEmpresa daoempresa = new DaoEmpresa();
		//	RECEBENDO PARAMETROS:
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
	System.out.println("passou na servlet");
	System.out.println("Email recebido: "+usuario.getEmail());
		//CHAMADA DE PARAMETROS:
		try {
			if(daoUsuario.login(usuario)){
				System.out.println("ENTROU NO IF");
			//COLOCAR USUARIO NA SESSAO:
				HttpSession sessaoUsuario = request.getSession();
				sessaoUsuario.setAttribute("usuarioSessao", usuario.getEmail());
				String usuarioLogado =  (String) sessaoUsuario.getAttribute("usuarioSessao");
				// REDIRECIONAR PARA PAGINA DE ACESSO:
				RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/telaPrincipal1.jsp");
				//VAI NA REQUEST LISTAR EMPRESA:
				DaoEmpresa emoresa = new DaoEmpresa();
				request.setAttribute("empresas", daoempresa.listarEnmpresa(usuarioLogado));
				
				visualizar.forward(request, response);
				System.out.println("passou aqui REDIRECIONAMENTO");
				
				

			}else{
				request.setAttribute("status", "LOGIN OU SENHA INVALIDO!");
				// REDIRECIONAR PARA PAGINA DE LOGIN:
				RequestDispatcher despatcher = request.getRequestDispatcher("index.jsp");
				despatcher.forward(request, response);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ENTROU NO ERRO!");
			request.setAttribute("status", "Login Invalido");
			// ERRO INTERNO DO SERVIDOR
			// REDIRECIONAR PARA PAGINA DE LOGIN:
			RequestDispatcher despatcher = request.getRequestDispatcher("index.jsp");
			despatcher.forward(request, response);
			
			
		}
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
