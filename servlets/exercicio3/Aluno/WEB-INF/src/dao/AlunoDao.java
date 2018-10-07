package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Aluno;
import interfaces.AlunoDaoInterface;
import utils.DBConnection;
import exceptions.GenericDAOException;

public class AlunoDao implements AlunoDaoInterface {
    private Connection conn;

    public AlunoDao () {
        conn = DBConnection.getConnection();
    }

    @Override
    public List<Aluno> showAll () throws GenericDAOException {
        List<Aluno> alunos = new ArrayList<Aluno>();
        
        String sql = "SELECT * FROM ALUNOS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno foundAluno = new Aluno();
                foundAluno.setId(
                    rs.getLong("ID")
                );
                foundAluno.setRa(
                    rs.getString("RA")
                );
                foundAluno.setNome(
                    rs.getString("NOME")
                );
                foundAluno.setIdade(
                    rs.getInt("IDADE")
                );
                foundAluno.setSexo(
                    rs.getString("SEXO")
                );
                alunos.add(foundAluno);
            }
        } catch (SQLException e) {
            throw new GenericDAOException("Error searching alunos", e);
        }
        return alunos;
    }

    @Override
    public Aluno search (long id) throws GenericDAOException {
        Aluno foundAluno = null;

        String sql = "SELECT * FROM ALUNOS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                foundAluno = new Aluno();
                foundAluno.setId(
                    rs.getLong("ID")
                );
                foundAluno.setRa(
                    rs.getString("RA")
                );
                foundAluno.setNome(
                    rs.getString("NOME")
                );
                foundAluno.setIdade(
                    rs.getInt("IDADE")
                );
                foundAluno.setSexo(
                    rs.getString("SEXO")
                );
            }
        } catch (SQLException e) {
            throw new GenericDAOException("Error searching aluno " + id, e);
        }
        return foundAluno;
    }

    @Override
    public void create (Aluno aluno) throws GenericDAOException {
        String sql = "INSERT INTO ALUNOS (ID, RA, NOME, IDADE, SEXO) VALUES " +
                     "(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, aluno.getId());
            stmt.setString(2, aluno.getRa());
            stmt.setString(3, aluno.getNome());
            stmt.setInt(4, aluno.getIdade());
            stmt.setString(5, aluno.getSexo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException("Error creating alunos", e);
        }
    }

    @Override
    public void update (Aluno aluno) throws GenericDAOException {
        String sql = "UPDATE ALUNOS SET ID = ?, RA = ?, NOME = ?, IDADE = ?, SEXO = ? " +
                     "WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, aluno.getId());
            stmt.setString(2, aluno.getRa());
            stmt.setString(3, aluno.getNome());
            stmt.setInt(4, aluno.getIdade());
            stmt.setString(5, aluno.getSexo());
            stmt.setLong(6, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException("Error updating alunos", e);
        }
    }

    @Override
    public void delete (long id) throws GenericDAOException {
        String sql = "DELETE FROM ALUNOS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GenericDAOException("Error deleting alunos", e);
        }
    }
}