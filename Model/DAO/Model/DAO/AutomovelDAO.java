package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.VO.AutomovelVO;

public class AutomovelDAO extends BaseDAO{
    
    // ----- Inserir ------
    public void inserir(AutomovelVO carro){
        Connection conn = getConnection();
        String sql = "insert into Automovel (Marca, Cor, Placa, Ano, Quilometragem, ID) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ptst;

        try{
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getMarca());
            ptst.setString(2, carro.getCor());
            ptst.setString(3, carro.getPlaca());
            ptst.setInt(4, carro.getAno());
            ptst.setDouble(5, carro.getQuilometragem());
            ptst.setLong(6, carro.getCliente().getId());
            ptst.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    
    // ----- Remover -------
    public void removerById(AutomovelVO carro){
        Connection conn = getConnection();
        String sql = "delete from Automovel where id = ?";
        PreparedStatement ptst;

        try{
            ptst = conn.prepareStatement(sql);
            ptst.setLong(1, carro.getCliente().getId());
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
        List<AutomovelVO> carros = new ArrayList<AutomovelVO>();
        AutomovelVO car = new AutomovelVO();

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                car.setMarca(rs.getString("Marca"));
                car.setCor(rs.getString("Cor"));
                car.setPlaca(rs.getString("Placa"));
                car.setAno(rs.getInt("Ano"));
                car.setQuilometragem(rs.getDouble("Quilometragem"));
                car.getCliente().setId(rs.getLong("ID"));
                carros.add(car);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return carros;
    }

    // Editar
    public void editarMarca(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set marca = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getMarca());
            ptst.setLong(2, carro.getCliente().getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarCor(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set cor = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getCor());
            ptst.setLong(2, carro.getCliente().getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarPlaca(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set placa = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getPlaca());
            ptst.setLong(2, carro.getCliente().getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarAno(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set ano = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setInt(1, carro.getAno());
            ptst.setLong(2, carro.getCliente().getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarQuilometragem(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set quilometragem = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setDouble(1, carro.getQuilometragem());
            ptst.setLong(2, carro.getCliente().getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarNome(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set nome = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getCliente().getNome());
            ptst.setLong(2, carro.getCliente().getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarEndereco(AutomovelVO carro){

        Connection conn = getConnection();
        String sql = "update from Automovel set endereco = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getCliente().getEndereco());
            ptst.setLong(2, carro.getCliente().getId());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
