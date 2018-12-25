package nure.itkn.malyk.usermanagement.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;

import nure.itkn.malyk.usermanagement.User;
import nure.itkn.malyk.usermanagement.db.DaoFactory;
import nure.itkn.malyk.usermanagement.db.DatabaseException;

public class DetailsServlet extends HttpServlet {
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("okButton") != null) {
			doOk(req, resp);
		} else if (req.getParameter("cancelButton") != null) {
			doCancel(req, resp);
		} else {
			showPage(req, resp);
		}
	}

	protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/details.jsp").forward(req, resp);
	}

	private void doCancel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("browse");
	}
	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doOk(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("browse");
	}
}
