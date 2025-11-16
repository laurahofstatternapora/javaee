package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The livro. */
	JavaBeans livro = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			livros(request, response);
		} else if (action.equals("/insert")) {
			adicionarLivro(request, response);
		} else if (action.equals("/select")) {
			listarLivro(request, response);
		} else if (action.equals("/update")) {
			editarLivro(request, response);
		} else if (action.equals("/delete")) {
			removerLivro(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Livros.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void livros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarLivros();
		request.setAttribute("livros", lista);
		RequestDispatcher rd = request.getRequestDispatcher("catalogo.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar livro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		livro.setNome(request.getParameter("nome"));
		livro.setAutor(request.getParameter("autor"));
		livro.setSinopse(request.getParameter("sinopse"));
		livro.setAno(request.getParameter("ano"));
		livro.setGenero(request.getParameter("genero"));
		dao.inserirLivro(livro);
		response.sendRedirect("main");
	}

/**
 * Listar livro.
 *
 * @param request the request
 * @param response the response
 * @throws ServletException the servlet exception
 * @throws IOException Signals that an I/O exception has occurred.
 */
	protected void listarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		livro.setIdcon(idcon);
		dao.selecionarLivro(livro);
		request.setAttribute("idcon", livro.getIdcon());
		request.setAttribute("nome", livro.getNome());
		request.setAttribute("autor", livro.getAutor());
		request.setAttribute("sinopse", livro.getSinopse());
		request.setAttribute("ano", livro.getAno());
		request.setAttribute("genero", livro.getGenero());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar livro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		livro.setIdcon(request.getParameter("idcon"));
		livro.setNome(request.getParameter("nome"));
		livro.setAutor(request.getParameter("autor"));
		livro.setSinopse(request.getParameter("sinopse"));
		livro.setAno(request.getParameter("ano"));
		livro.setGenero(request.getParameter("genero"));
		dao.alterarLivro(livro);
		response.sendRedirect("main");
	}

	/**
	 * Remover livro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		livro.setIdcon(idcon);
		dao.deletarLivro(livro);
		response.sendRedirect("main");
	}
}

