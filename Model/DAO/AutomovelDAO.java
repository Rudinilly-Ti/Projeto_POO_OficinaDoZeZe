package Model.DAO;
import Model.VO.AutomovelVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.DAO.BaseDAO;

public class AutomovelDAO extends BaseDAO{
    
    // ----- Inserir ------
    public void inserir(AutomvelVO carro){
        Connection conn = getConnection();
        String sql = "insert into Automovel (cor, placa, ano, quilometragem, nome, enderecom cpf) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ptst;

        try{
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.setCor());
            ptst.setString(2, carro.setPlaca());
            ptst.setInt(3, carro.setAno());
            ptst.setDouble(4, carro.setQuilometragem());
            ptst.setString(5, carro.cliente.setNome());
            ptst.setString(6, carro.cliente.setEndereco());
            ptst.setString(7, carro.cliente.setCPF());
            ptst.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    // ----- Remover -------
    public void removerByCpf(AutomovelVO carro){
        Connection conn = getConnection();
        String sql = "delete from Automovel where cpf = ?";
        PreparedStatement ptst;

        try{
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.cliente.setCPF());
            ptst.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    // ---- listar ----
    public List<AutomovelVO> listar(){

        Connection conn = getConnection();
        String sql = "select * from Automovel";
        Statement st;
        ResultSet rs;
        List<AutomvelVO> carros = new ArrayList<AutomovelVO>();
        AutomovelVO car = new AutomovelVO();

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                car.setCor(rs.getString("Cor"));
                car.setPlaca(rs.getString("Placa"));
                car.setAno(rs.getInt("Ano"));
                car.setQuilometragem(rs.getDouble("Quilometragem"));
                car.cliente.setNome(rs.getString("Nome"));
                car.cliente.setEndereco(rs.getString("Endereco"));
                car.cliente.setCPF(rs.getString("CPF"));
                carros.add(car);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return carros;
    }

    // Editar
    public void editarCor(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set cor = ? where cpf = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getCor());
            ptst.setString(2, carro.cliente.getCPF());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void editarPlaca(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set placa = ? where cpf = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getPlaca());
            ptst.setString(2, carro.cliente.getCPF());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    public void editarAno(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set ano = ? where cpf = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setInt(1, carro.getAno());
            ptst.setString(2, carro.cliente.getCPF());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void editarQuilometragem(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set quilometragem = ? where cpf = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setDouble(1, carro.getQuilometragem());
            ptst.setString(2, carro.cliente.getCPF());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    public void editarNome(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set nome = ? where cpf = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.cliente.getNome());
            ptst.setString(2, carro.cliente.getCPF());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    public void editarEndereco(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set endereco = ? where cpf = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.cliente.getEndereco());
            ptst.setString(2, carro.cliente.getCPF());
            ptst.executeUpdate();
        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
