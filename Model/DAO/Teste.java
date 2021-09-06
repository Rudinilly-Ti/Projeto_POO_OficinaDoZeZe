package Model.DAO;
import Model.VO.AutomovelVO;

public class Teste {
    public static void main(String[] args) {
        BaseDAO dao = new BaseDAO();
        System.out.println(dao.getConnection());  
    }
}
