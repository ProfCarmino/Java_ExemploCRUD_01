/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Conexao.ConnectionFactory;
import Modelo.LoginModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author profj
 */
public class LoginDao {
    public void logar(LoginModel login) {
        String sql = "SELECT * FROM USUARIO WHERE USERNAME='" + login.getUsername()+"'";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            //System.out.println("rset " + rset.next());
            if(rset.next()){
                String senha; 
                senha = rset.getString("senha"); 
                if(senha.equals(login.getSenha()) ){
                    System.out.println("senha correta");
                } else {
                    System.out.println("senha incorreta");
                }
            }
            while (rset.next()) {
                login.setSenha(rset.getString("username") );
                login.setSenha(rset.getString("senha") );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
