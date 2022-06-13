package aplicacao;

import java.util.Date;
import Controller.ClienteDao;
import Janela.ClienteJanela;
import Modelo.ClienteModel;

public class Main {
    public static void main(String[] args) throws Exception {
        ClienteJanela Janela = new ClienteJanela();
        Janela.setVisible(true);
    }
}
