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
import model.DaoUsuario;
import ultil.enviarEmail;

/**
 * Servlet implementation class RecuperarSenhaServlet
 */
@WebServlet("/RecuperarSenhaServlet")
public class RecuperarSenhaServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarSenhaServlet() {
        super();
    	
        // TODO Auto-generated constructor stub
        
     
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BeanUsuario usuario = new BeanUsuario();
	DaoUsuario daousuario = new  DaoUsuario();
	String UsuarioLogado= request.getParameter("email");
	
	try {
		//VALIDAR EMAIL:
		if (daousuario.validarEmail(UsuarioLogado)) {
			//COLOCAR USUARIO NA SESSAO:
			
			HttpSession sessaoUsuario = request.getSession();
		 sessaoUsuario.setAttribute("usuarioSessao", UsuarioLogado);
			
			//GERAR CODIGO E MANDAR VIA EMAIL:
			daousuario.gravarCodigo(UsuarioLogado);
						
			RequestDispatcher visualizar = request.getRequestDispatcher("inserircodigo.jsp");
			request.setAttribute("usuarioLogado", UsuarioLogado);
			
			
			visualizar.forward(request, response);
			System.out.println("passou aqui REDIRECIONAMENTO REDIRECIONAMENTO");
			
			
			
		}else{
			//REDIRECIONAR PARA MESMA PAGINA:
			
			request.setAttribute("validarEmail", "Email Invalido!");
			
			RequestDispatcher visualizar = request.getRequestDispatcher("esqueceusenha.jsp");
			request.setAttribute("usuarioLogado", UsuarioLogado);
			
			
			visualizar.forward(request, response);
			System.out.println("passou aqui REDIRECIONAMENTO REDIRECIONAMENTO");
			
		}
		
		
		
				
		
	} catch (Exception e) {
		// REDIRECIONAR PARA PAGINA DE ERRO:
		
		
		
	}
	
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
