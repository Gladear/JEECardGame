package fr.cpe.cardgame.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cpe.cardgame.controler.PoneyDao;
import fr.cpe.cardgame.model.PoneyBean;

@WebServlet("/list")
public class RedirectListServlet extends HttpServlet {
	private static final String LPONEY = "lponey";
	private static final long serialVersionUID = 1L;
	private PoneyDao dao;
       
    public RedirectListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getDao();
		List<PoneyBean> listPoney=this.dao.getPoneyList();
		
		request.getSession().setAttribute(LPONEY, listPoney);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/displayList.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//DO NOTHING
	}
	
	public void getDao(){
		if(this.getServletContext().getAttribute("DAO")!=null){
			this.dao=(PoneyDao)this.getServletContext().getAttribute("DAO");
		}else{
			this.dao=new PoneyDao();
			this.getServletContext().setAttribute("DAO",this.dao);
		}
	}

}
