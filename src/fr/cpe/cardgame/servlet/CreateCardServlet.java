package fr.cpe.cardgame.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.util.PSQLException;

import fr.cpe.cardgame.controler.CardDao;
import fr.cpe.cardgame.model.CardBean;

@WebServlet("/create")
public class CreateCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CardDao dao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getDao();
		this.getServletContext().getRequestDispatcher("/WEB-INF/create.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getDao();
		CardBean card = new CardBean(req.getParameter("name"), req.getParameter("description"),
				req.getParameter("family"), Integer.parseInt(req.getParameter("hp")),
				Integer.parseInt(req.getParameter("hp")), Integer.parseInt(req.getParameter("hp")),
				Integer.parseInt(req.getParameter("hp")), req.getParameter("image-url"));
		try {			
			this.dao.addCard(card);
			resp.sendRedirect("./list");
		} catch (PSQLException ex) {
			this.doGet(req, resp);
		}
	}

	public void getDao() {
		if (this.getServletContext().getAttribute("DAO") != null) {
			this.dao = (CardDao) this.getServletContext().getAttribute("DAO");
		} else {
			this.dao = new CardDao();
			this.getServletContext().setAttribute("DAO", this.dao);
		}
	}
}
