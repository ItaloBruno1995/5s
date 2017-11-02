package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BeanDepartamento;
import model.DaoDepartamento;

/**
 * Servlet implementation class CadastroDepartamentoServlet
 */
@WebServlet("/CadastroDepartamentoServlet")
public class CadastroDepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CadastroDepartamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String empresa = request.getParameter("empresa");
	
		System.out.println("ACAO RECEBIDA: "+acao );
		System.out.println("EMPRESA RECEBIDA: "+empresa );

		HttpSession sessaoUsuario = request.getSession();
		
		String usuarioLogado = (String) sessaoUsuario.getAttribute("usuarioSessao");
		System.out.println("USUARIO LOGADO PRA LISTAR DEPARTAMENTO: "+empresa );
		
		//COLOCAR EMPRESA NA SESS�O:
		
		
		
		if(acao.equalsIgnoreCase("visualizar")){
			HttpSession sessaoEmpresa= request.getSession();
			sessaoEmpresa.setAttribute("empresaSessao", empresa);

			
		
		//COLOCAR EMPRESA NA SESSAO  E MOSTAR LISTA DE DEPARTAMENTO 
		RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/telaPrincipal.jsp");
		//VAI NA REQUEST LISTAR DEPARTAMENTO:
		DaoDepartamento daoPepartamento = new DaoDepartamento();
	
		request.setAttribute("departamentos", daoPepartamento.listarDepartamento(usuarioLogado, empresa));

		//VAI NA REQUEST O CALCULO DA MEDIA:
		request.setAttribute("mediaGeral", daoPepartamento.retornarMediageral());
		visualizar.forward(request, response);
		System.out.println("passou aqui REDIRECIONAMENTO");
		
		
	}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessaoUsuario = request.getSession();
		HttpSession sessaoEmpresa = request.getSession();
		
		BeanDepartamento departamento = new BeanDepartamento();
		DaoDepartamento daodepartamento = new DaoDepartamento();
		//RECEBENDO PARAMETROS:usuarioSessao
		
		departamento.setDataCriado(request.getParameter("data"));
		departamento.setNome(request.getParameter("nome"));
		String usuarioSessao = (String) sessaoUsuario.getAttribute("usuarioSessao");
		//COLOCAR EMPRESA NA SESS�O:
		String empresaSessao= (String) sessaoEmpresa.getAttribute("sessaoEmpresa");
		
		System.out.println("EMPRESA NA SESS�O: "+empresaSessao);
		try {
			
			daodepartamento.cadastroDepartamento(departamento, empresaSessao, usuarioSessao);
			
			//REDIRECIONAR PARA TELA DE QUESTIONARIO:
			
			
		} catch (Exception e) {
			// PAGINA DE ERRO:
			
		}
		
		
	}

}
