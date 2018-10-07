package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Jogo;
import interfaces.JogosDaoInterface;
import utils.DBConnection;
import exceptions.GenericDAOException;

public class JogosDao implements JogosDaoInterface {
    private Connection conn;

    public JogosDao () {
        conn = DBConnection.getConnection();
    }

    @Override
    public Jogo search (String nome) throws GenericDAOException {
        Jogo foundJogo = null;

        String sql = "SELECT * FROM JOGOS WHERE NOME = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                foundJogo = new Jogo();
                foundJogo.setNome(
                    rs.getString("NOME")
                );
                foundJogo.setDificuldade(
                    rs.getString("DIFICULDADE")
                );
            }
        } catch (SQLException e) {
            throw new GenericDAOException("Error searching jogo " + nome + " " + e);
        }
        return foundJogo;
    }

    @Override
    public void create (Jogo jogo) throws GenericDAOException {
        String sql = "INSERT INTO JOGOS (NOME, DIFICULDADE) VALUES (?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getDificuldade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException("Error creating jogo", e);
        }
    }
}