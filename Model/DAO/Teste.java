package Model.DAO;

import java.util.ArrayList;
import java.util.List;
import Model.VO.*;

public class Teste {
    public static void main(String[] args) {
        BaseDAO dao = new BaseDAO();
        System.out.println(dao.getConnection()); 
    }
}
