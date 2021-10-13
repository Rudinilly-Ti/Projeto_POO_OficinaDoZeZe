package Model.BO;

import java.util.List;
import Exceptions.*;
//
public interface BaseInterBO<VO>{
    public void inserir(VO entity) throws InsertException;
    public List<VO> buscarPorId(VO entity) throws FindException;
    public List<VO> listar() throws FindException;
    public void deletar(VO entity);
}
