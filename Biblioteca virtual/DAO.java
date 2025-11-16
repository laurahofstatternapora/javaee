package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcatalogo?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "Projeto#2025";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Inserir livro.
	 *
	 * @param livro the livro
	 */
	public void inserirLivro(JavaBeans livro) {
		String create = "insert into item (nome, autor, sinopse, ano, genero) values(?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, livro.getNome());
			pst.setString(2, livro.getAutor());
			pst.setString(3, livro.getSinopse());
			pst.setString(4, livro.getAno());
			pst.setString(5, livro.getGenero());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar livros.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarLivros() {
		ArrayList<JavaBeans> livros = new ArrayList<>();
		String read = "select * from item order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String autor = rs.getString(3);
				String sinopse = rs.getString(4);
				String ano = rs.getString(5);
				String genero = rs.getString(6);
				livros.add(new JavaBeans(idcon, nome, autor, sinopse, ano, genero));
			}
			con.close();
			return livros;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	/**
	 * Selecionar livro.
	 *
	 * @param livro the livro
	 */
	public void selecionarLivro(JavaBeans livro) {
		String read2 = "select * from item where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, livro.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				livro.setIdcon(rs.getString(1));
				livro.setNome(rs.getString(2));
				livro.setAutor(rs.getString(3));
				livro.setSinopse(rs.getString(4));
				livro.setAno(rs.getString(5));
				livro.setGenero(rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Alterar livro.
	 *
	 * @param livro the livro
	 */
	public void alterarLivro(JavaBeans livro) {
		String create = "update item set nome=?,autor=?,sinopse=?,ano=?,genero=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, livro.getNome());
			pst.setString(2, livro.getAutor());
			pst.setString(3, livro.getSinopse());
			pst.setString(4, livro.getAno());
			pst.setString(5, livro.getGenero());
			pst.setString(6, livro.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deletar livro.
	 *
	 * @param livro the livro
	 */
	public void deletarLivro(JavaBeans livro) {
		String delete = "delete from item where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, livro.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

