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
 * Servlet implementation class CadastarDepartamentoServlet
 */
@WebServlet("/CadastarDepartamentoServlet")
public class CadastarDepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CadastarDepartamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" ENTROU NO DO POST PARA CADASTRA DEPARTAMENTO");
		//RECUPERANDO SESSÃO DE USUARIO E EMPRESA
		HttpSession sessaoUsuario = request.getSession();
		String usuarioLogado = (String) sessaoUsuario.getAttribute("usuarioSessao");
		HttpSession sessaoEmpresa= request.getSession();
		String empresa = (String) sessaoEmpresa.getAttribute("empresaSessao");
		
		//RECEBENDO PARAMENTRO:
		BeanDepartamento departamento = new BeanDepartamento();
		DaoDepartamento daoDepartamento = new DaoDepartamento();
		String acao = request.getParameter("acao");
		System.out.println(" ACAO RECEBIDA PARA DEPARTAMENTO: "+acao);
		System.out.println("USUARIO LOGADO PRA CADASTRA DEPARTAMENTO: "+usuarioLogado);
		
	departamento.setDataCriado(request.getParameter("data"));
	departamento.setNome(request.getParameter("nome"));
	
		
		if(acao.equalsIgnoreCase("cadastrar")){
			daoDepartamento.cadastroDepartamento(departamento, empresa, usuarioLogado);
			
			System.out.println("ENTROU AQUI NA IF DE CADASTRO DE DEPARTAMENTO");
			//REDIRECIONAR PARA SEGUNDA ETAPA : NIVEL 01:
			RequestDispatcher visualizar = request.getRequestDispatcher("autenticacao/seletividade.jsp");
			visualizar.forward(request, response);
			
			
			
		}
		
		
	}

}
