package tech.codifyy.dao;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.sql.Connection;

public class ChecarSenha {
    Connection connection = null;

    public ChecarSenha(Connection connection) {
        this.connection = connection;
    }

    public Boolean verificar(JSONPObject json) {
        
        return null;
    }
}
