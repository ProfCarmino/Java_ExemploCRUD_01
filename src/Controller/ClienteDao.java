package Controller;

import java.sql.*;
import Conexao.ConnectionFactory;
import Modelo.ClienteModel;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    /*
    * CRUD ==
    * Create, Read, Updade, Delete
    */
    public void save(ClienteModel cliente) throws Exception {
        String sql = "INSERT INTO CLIENTE(nome, endereco, datacadastro) VALUES(?, ?, ? )";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEndereco());
            pstm.setDate(3, new Date(cliente.getDataCadastro().getTime()));
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void load(ClienteModel cliente) {
        String sql = "SELECT * FROM CLIENTE WHERE IDCLIENTE=" + cliente.getIdCliente();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while (rset.next()) {
                cliente.setNome(rset.getString("nome"));
                cliente.setEndereco(rset.getString("endereco"));
                cliente.setDataCadastro(rset.getDate("datacadastro"));
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

    public void delete(int IdCliente) throws Exception {
        String sql = "DELETE FROM CLIENTE WHERE IDCLIENTE = " + IdCliente;
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(ClienteModel cliente) throws Exception {
        String sql = "UPDATE CLIENTE SET nome=?,endereco=? WHERE IdCliente = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEndereco());
            //pstm.setDate(3, new Date(cliente.getDataCadastro().getTime()));
            pstm.setInt(3, cliente.getIdCliente());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ClienteModel> getClientes() {
        String sql = "SELECT * FROM CLIENTE";
        List<ClienteModel> clientes = new ArrayList<ClienteModel>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while (rset.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setIdCliente(rset.getInt("idcliente"));
                cliente.setNome(rset.getString("nome"));
                cliente.setEndereco(rset.getString("endereco"));
                cliente.setDataCadastro(rset.getDate("datacadastro"));
                clientes.add(cliente);
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
        return clientes;
    }
}
