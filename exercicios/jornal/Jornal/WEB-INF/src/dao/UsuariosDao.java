package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exceptions.GenericDAOException;
import interfaces.UsuariosDaoInterface;
import models.Usuarios;
import utils.DBConnection;

import java.util.List;
import java.util.ArrayList;

public class UsuariosDao implements UsuariosDaoInterface {
    private Connection conn;

    public UsuariosDao () {
        conn = DBConnection.getConnection();
    }

    @Override
    public List<Usuarios> showAll () throws GenericDAOException {
        List<Usuarios> usuarios = new ArrayList<Usuarios>();
        
        String sql = "SELECT * FROM USUARIOS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setNome(
                    rs.getString("nome")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new GenericDAOException("Error searching usuarios", e);
        }
        return usuarios;
    }
}