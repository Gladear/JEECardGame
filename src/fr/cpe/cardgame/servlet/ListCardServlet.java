package fr.cpe.cardgame.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cpe.cardgame.controler.CardDao;
import fr.cpe.cardgame.model.CardBean;

@WebServlet("/list")
public class ListCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CardDao dao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getDao();
		List<CardBean> list = this.dao.getCards();
		req.setAttribute("cards", list);
		this.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
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
