package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.VO.AutomovelVO;

public class AutomovelDAO extends BaseDAO<AutomovelVO>{
    
    // ----- Inserir ------
    public void inserir(AutomovelVO carro){ // OK
        Connection conn = getConnection();
        String sql = "insert into Automovel (Marca, Cor, Placa, Ano, Quilometragem, id_cliente) values (?, ?, ?, ?, ?, ?)";
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
    public void removerById(AutomovelVO carro){ // OK
        Connection conn = getConnection();
        String sql = "delete from Automovel where id = ?";
        PreparedStatement ptst;

        try{
            ptst = conn.prepareStatement(sql);
            ptst.setLong(1, carro.getID());
            ptst.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    // public void removerByIdCliente(AutomovelVO carro){ // OK
    //     Connection conn = getConnection();
    //     String sql = "delete from Automovel where id_cliente = ?";
    //     PreparedStatement ptst;

    //     try{
    //         ptst = conn.prepareStatement(sql);
    //         ptst.setLong(1, carro.getCliente().getId());
    //         ptst.executeUpdate();
    //     } catch(SQLException e){
    //         e.printStackTrace();
    //     }
    // }

    // ---- listar ----
    public ResultSet listar(){ // OK

        Connection conn = getConnection();
        String sql = "select * from Automovel";
        Statement st;
        ResultSet rs = null;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);

        } catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findByMarca(AutomovelVO vo){ // OK

        conn = getConnection();
        String sql = "select * from Automovel where marca = ?";
        PreparedStatement pdst;
        ResultSet rs;
        <AutomovelVO> carros = new ArrayList<AutomovelVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getMarca());
            rs = pdst.executeQuery();
            while(rs.next()){
            	if(rs.getString("marca") != null){
                    AutomovelVO car = new AutomovelVO();
                    car.setMarca(rs.getString("Marca"));
                    car.setCor(rs.getString("Cor"));
                    car.setPlaca(rs.getString("Placa"));
                    car.setAno(rs.getInt("Ano"));
                    car.setQuilometragem(rs.getDouble("Quilometragem"));
                    car.getCliente().setId(rs.getLong("id_cliente"));
                    car.setID(rs.getLong("ID"));
                    carros.add(car);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return carros;
    }

    public ResultSet findByCor(AutomovelVO vo){ // OK

        conn = getConnection();
        String sql = "select * from Automovel where cor = ?";
        PreparedStatement pdst;
        ResultSet rs;
        <AutomovelVO> carros = new ArrayList<AutomovelVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getCor());
            rs = pdst.executeQuery();
            while(rs.next()){
            	if(rs.getString("cor") != null){
                    AutomovelVO car = new AutomovelVO();
                    car.setMarca(rs.getString("Marca"));
                    car.setCor(rs.getString("Cor"));
                    car.setPlaca(rs.getString("Placa"));
                    car.setAno(rs.getInt("Ano"));
                    car.setQuilometragem(rs.getDouble("Quilometragem"));
                    car.getCliente().setId(rs.getLong("id_cliente"));
                    car.setID(rs.getLong("ID"));
                    carros.add(car);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return carros;
    }

    public ResultSet findByPlaca(AutomovelVO vo){ // OK

        conn = getConnection();
        String sql = "select * from Automovel where placa = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<AutomovelVO> carros = new ArrayList<AutomovelVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setString(1, vo.getPlaca());
            rs = pdst.executeQuery();
            while(rs.next()){
            	if(rs.getString("placa") != null){
                    AutomovelVO car = new AutomovelVO();
                    car.setMarca(rs.getString("Marca"));
                    car.setCor(rs.getString("Cor"));
                    car.setPlaca(rs.getString("Placa"));
                    car.setAno(rs.getInt("Ano"));
                    car.setQuilometragem(rs.getDouble("Quilometragem"));
                    car.getCliente().setId(rs.getLong("id_cliente"));
                    car.setID(rs.getLong("ID"));
                    carros.add(car);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return carros;
    }

    public ResultSet findByAno(AutomovelVO vo){ // OK

        conn = getConnection();
        String sql = "select * from Automovel where ano = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<AutomovelVO> carros = new ArrayList<AutomovelVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setInt(1, vo.getAno());
            rs = pdst.executeQuery();
            while(rs.next()){
                AutomovelVO car = new AutomovelVO();
                car.setMarca(rs.getString("Marca"));
                car.setCor(rs.getString("Cor"));
                car.setPlaca(rs.getString("Placa"));
                car.setAno(rs.getInt("Ano"));
                car.setQuilometragem(rs.getDouble("Quilometragem"));
                car.getCliente().setId(rs.getLong("id_cliente"));
                car.setID(rs.getLong("ID"));
                carros.add(car);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return carros;
    }

    public ResultSet findByQuilometragem(AutomovelVO vo){ // OK

        conn = getConnection();
        String sql = "select * from Automovel where quilometragem = ?";
        PreparedStatement pdst;
        ResultSet rs;
        List<AutomovelVO> carros = new ArrayList<AutomovelVO>();
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setDouble(1, vo.getQuilometragem());
            rs = pdst.executeQuery();
            while(rs.next()){
                AutomovelVO car = new AutomovelVO();
                car.setMarca(rs.getString("Marca"));
                car.setCor(rs.getString("Cor"));
                car.setPlaca(rs.getString("Placa"));
                car.setAno(rs.getInt("Ano"));
                car.setQuilometragem(rs.getDouble("Quilometragem"));
                car.getCliente().setId(rs.getLong("id_cliente"));
                car.setID(rs.getLong("ID"));
                carros.add(car);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return carros;
    }

    public ResultSet findById(AutomovelVO vo){ // OK

        conn = getConnection();
        String sql = "select * from Automovel where id = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getID());
            rs = pdst.executeQuery();
           
        } catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet findByClienteId(AutomovelVO vo){ // OK

        conn = getConnection();
        String sql = "select * from Automovel where id_cliente = ?";
        PreparedStatement pdst;
        ResultSet rs = null;
        try {
            pdst = conn.prepareStatement(sql);
            pdst.setLong(1, vo.getCliente().getId());
            rs = pdst.executeQuery();
           
        } catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    // Editar
    public void editarMarca(AutomovelVO carro){ // OK

        Connection conn = getConnection();
        String sql = "update Automovel set marca = ? where id = ?";
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

    public void editarCor(AutomovelVO carro){ // OK

        Connection conn = getConnection();
        String sql = "update Automovel set cor = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getCor());
            ptst.setLong(2, carro.getID());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarPlaca(AutomovelVO carro){ // OK

        Connection conn = getConnection();
        String sql = "update Automovel set placa = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setString(1, carro.getPlaca());
            ptst.setLong(2, carro.getID());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarAno(AutomovelVO carro){ // OK

        Connection conn = getConnection();
        String sql = "update Automovel set ano = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setInt(1, carro.getAno());
            ptst.setLong(2, carro.getID());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarQuilometragem(AutomovelVO carro){ // OK

        Connection conn = getConnection();
        String sql = "update Automovel set quilometragem = ? where id = ?";
        PreparedStatement ptst;

        try {
            ptst = conn.prepareStatement(sql);
            ptst.setDouble(1, carro.getQuilometragem());
            ptst.setLong(2, carro.getID());
            ptst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void editarClienteId(AutomovelVO carro) {
    	Connection conn = getConnection();
    	String sql = "update Automovel set id_cliente = ? where id = ?";
    	PreparedStatement ptst;
    	try {
    		ptst = conn.prepareStatement(sql);
            ptst.setLong(1, carro.getCliente().getId());
            ptst.setLong(2, carro.getID());
            ptst.executeUpdate();
    	} catch(SQLException e){
    		 e.printStackTrace();
    	}
    }
}
