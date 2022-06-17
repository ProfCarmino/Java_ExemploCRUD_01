package aplicacao;

import java.util.Date;
import Controller.ClienteDao;
import Janela.Login;
import Modelo.ClienteModel;

public class Main {
    public static void main(String[] args) throws Exception {
        Login Janela = new Login();
        Janela.setVisible(true);
        System.out.println("Nivel acesso: " + VarsGlobal.nivelAcesso);
        VarsGlobal.nivelAcesso = 14;
        System.out.println("Nivel acesso: " + VarsGlobal.nivelAcesso);
    }
}
