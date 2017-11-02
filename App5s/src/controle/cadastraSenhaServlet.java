package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.StringParser;

import model.DaoUsuario;

/**
 * Servlet implementation class cadastraSenhaServlet
 */
@WebServlet("/cadastraSenhaServlet")
public class cadastraSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public cadastraSenhaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// VALIADAR CODIGO (CAST):
		int  codigoInformado = Integer.parseInt(request.getParameter("codigo"));
		
		DaoUsuario daoUsuario = new DaoUsuario();
		try {
			// CODIGO VALIDO:
			if(daoUsuario.validarCodigo(codigoInformado)){
				// REDIRECIONAR PARA PAGINA DE CADASTRO DE SENHA
				RequestDispatcher visualizar = request.getRequestDispatcher("novasenha.jsp");
					System.out.println("mandou para cadastra nova senha");
				visualizar.forward(request, response);
				System.out.println("passou aqui REDIRECIONAMENTO REDIRECIONAMENTO");
				
				
				
			}else{
				// REDIRECIONAR PARA MESMA PAGINA
				RequestDispatcher visualizar = request.getRequestDispatcher("inserircodigo.jsp");
					System.out.println("mandoupara mesma pagina inserir codigo");
					request.setAttribute("validarCodigo", "Codigo Invalido");
				visualizar.forward(request, response);
			
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RECEBENDO PARAMENTROS:
	String novaSenha=	request.getParameter("novasenha");
	
	
	
	//RECEBENDO USUARIO DA SESSÃO:
	HttpSession sessaoUsuario = request.getSession();
	String usuarioLogado = (String) sessaoUsuario.getAttribute("usuarioSessao");
	System.out.println("Usuario Logado para Cadastra nova senha: "+usuarioLogado);
	//CADASTRA NOVA SENHA
		DaoUsuario daoUsuario = new DaoUsuario();
	
		try {
			
			daoUsuario.salvarNovaSenha(usuarioLogado, novaSenha);
			
			
			RequestDispatcher visualizar = request.getRequestDispatcher("index.jsp");
			//*******DESTRUIR  A SESSÃO:
			sessaoUsuario.invalidate();
			
			visualizar.forward(request, response);
			
			//*****REDIRECIONAR PARA PAGINA DE SUCESSO:
			
		} catch (Exception e) {
			// PAGINA DE ERRO:
		}
		
		
		
		
	}

}
