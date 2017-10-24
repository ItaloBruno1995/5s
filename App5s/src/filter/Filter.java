package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import connection.SingleConnection;

@WebFilter(urlPatterns={"/*"})
public class Filter implements javax.servlet.Filter {
	private static Connection conection;
	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		try{
			arg2.doFilter(arg0, arg1);
			conection.commit();
			}catch(Exception ex){}		
		try {
				conection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		conection = SingleConnection.getConection();

    }

}


	
	
	
	
	

	


