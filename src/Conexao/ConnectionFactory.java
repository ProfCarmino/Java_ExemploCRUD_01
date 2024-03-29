/*
* Este é um arquivo que constroe as conexões 
* para serem utilizadas no sistema
*/
package Conexao;
import java.sql.*;
public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD="";
    private static final String DATABASE_URL = "jdbc:mysql://192.168.0.161:3306/loja";
    public static Connection createConnectionToMySQL() throws Exception{
        Class.forName ("com.mysql.cj.jdbc.Driver");//("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }
    /*
    **********************************************************
    * este trecho é utilizado para o teste inicial da conexão 
    * porém pode ser retirado após o teste 
    * para retornar bastar desfazer o comentário 
    **********************************************************
    */
    
    /*
    public static void main(String[] args) throws Exception {
        Connection con = createConnectionToMySQL();
        if(con!= null){
            System.out.println("Conexão obtida");
            con.close();
        }
    }
    */
    
}
