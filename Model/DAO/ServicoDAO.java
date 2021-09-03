package Model.DAO;
import Model.VO.ServicoVO;
import Model.DAO.BaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ServicoDAO extends BaseDAO{
    
    // ----- Inserir ------
    public void inserir(ServicoVO servico){

        Connection conn = getConnection();
        String sql = "insert into Servico (nome, preco, id) values (?, ?, ?)";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, servico.setNome());
            ptst.setDouble(2, servico.setPreco());
            ptst.setLong(3, servico.setId());
            ptst.execute();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    // ---- Remover -----
    public void removerById(ServicoVO servico){

        Connection conn = getConnection();
        String sql = "delete from Servico where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, servico.getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void removerByName(ServicoVO servico){
        
        Connection conn = getConnection();
        String sql = "delete from Servico where nome = ?";
        PreparedStatement ptst;

        try{
            
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, servico.getNome());
            ptst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removerByPrice(ServicoVO servico){

        Connection conn = getConnection();
        String sql = "delete from Servico where preco = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setDouble(1, servico.getPreco());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    // ----- Listar ------
    public List<ServicoVO> listar(){
        Connection conn = getConnection();
        String sql = "select * from Servico";
        Statement st;
        ResultSet rs;
        List<ServicoVO> servicos = new ArrayList<ServicoVO>();
        ServicoVO service = new ServicoVO();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                service.setNome(rs.getString("Nome"));
                service.setPreco(rs.getDouble("Preco"));
                service.setId(rs.getLong("Id"));
                servicos.add(service);
            }
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return servicos;
    }

    // ------ editar -------
    public void editarNomeById(ServicoVO servico){

        Connection conn = getConnection();
        String sql = "update from Servico set nome = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setNome(1, servico.getNome());
            ptst.setLong(2, servico.getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    
    public void editarPrecoById(ServicoVO servico){
        
        Connection conn = getConnection();
        String sql = "update from Servico set preco = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setDouble(1, servico.getPreco());
            ptst.setLong(2, servico.getId());
            ptst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void editarIdByNome(ServicoVO servico){
    
        Connection conn = getConnection();
        String sql = "update from Servico set id = ? where nome = ?";
        PreparedStatement ptst;

        try{
            ptst = conn.prepareStatement(sql);
            ptst.setLong(1, servico.getId());
            ptst.setString(2, servico.getNome());
            ptst.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
