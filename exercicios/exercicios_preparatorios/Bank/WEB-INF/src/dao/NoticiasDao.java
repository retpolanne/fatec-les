package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exceptions.GenericDAOException;
import interfaces.NoticiasDaoInterface;
import models.Noticias;
import utils.DBConnection;

import java.util.List;
import java.util.ArrayList;

public class NoticiasDao implements NoticiasDaoInterface {
    private Connection conn;

    public NoticiasDao () {
        conn = DBConnection.getConnection();
    }

    @Override
    public List<Noticias> showAll () throws GenericDAOException {
        List<Noticias> noticias = new ArrayList<Noticias>();
        
        String sql = "SELECT * FROM NOTICIAS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Noticias noticia = new Noticias();
                noticia.setTitulo(
                    rs.getString("Titulo")
                );
                noticias.add(noticia);
            }
        } catch (SQLException e) {
            throw new GenericDAOException("Error searching noticias", e);
        }
        return noticias;
    }
}