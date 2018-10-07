package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Dificuldade;
import interfaces.DificuldadesDaoInterface;
import utils.DBConnection;
import exceptions.GenericDAOException;

public class DificuldadesDao implements DificuldadesDaoInterface {
    private Connection conn;

    public DificuldadesDao () {
        conn = DBConnection.getConnection();
    }

    @Override
    public List<Dificuldade> showAll () throws GenericDAOException {
        List<Dificuldade> difs = new ArrayList<Dificuldade>();
        
        String sql = "SELECT * FROM DIFICULDADE";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Dificuldade foundDif = new Dificuldade();
                foundDif.setDificuldade(
                    rs.getString("DIFICULDADE")
                );
                difs.add(foundDif);
            }
        } catch (SQLException e) {
            throw new GenericDAOException("Error searching dificuldades", e);
        }
        return difs;
    }
}