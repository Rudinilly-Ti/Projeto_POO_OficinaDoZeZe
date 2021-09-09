package Model.DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import Model.VO.*;

public class Teste {
    public static void main(String[] args) {
        BaseDAO dao = new BaseDAO();
        System.out.println(dao.getConnection());   

        System.out.println(dao.getConnection());
        OrcamentoDAO orcDao = new OrcamentoDAO();
        OrcamentoVO orcVo = new OrcamentoVO();
        List<PecaVO> pecas = new ArrayList<PecaVO>();
        List<ServicoVO> servicos = new ArrayList<ServicoVO>();

        PecaVO pvo = new PecaVO();
        pvo.setId(new Long(1));
        PecaVO pvo1 = new PecaVO();
        pvo1.setId(new Long(2));
        PecaVO pvo2 = new PecaVO();
        pvo2.setId(new Long(3));
        PecaVO pvo3 = new PecaVO();
        pvo3.setId(new Long(4));
        
        ServicoVO svo = new ServicoVO();
        svo.setId(new Long(2));
        ServicoVO svo1 = new ServicoVO();
        svo1.setId(new Long(6));

        pecas.add(pvo);
        pecas.add(pvo1);
        pecas.add(pvo2);
        pecas.add(pvo3);
        
        servicos.add(svo);
        servicos.add(svo1);

        Calendar dataIni = Calendar.getInstance();
        dataIni.set(Calendar.DAY_OF_MONTH, 19);
        dataIni.set(Calendar.MONTH, 2);
        dataIni.set(Calendar.YEAR, 2021);

        Calendar dataFim = Calendar.getInstance();
        dataFim.set(Calendar.DAY_OF_MONTH, 13);
        dataFim.set(Calendar.MONTH, 4);
        dataFim.set(Calendar.YEAR, 2021);

        orcVo.setId(new Long(1));
        orcVo.setPeca(pecas);
        orcVo.setServico(servicos);
        orcVo.getCliente().setId(new Long(2));
        orcVo.getCarro().setId(new Long(4));
        orcVo.setValor(162.90);
        orcVo.setDataInicio(dataIni);
        orcVo.setDataFim(dataFim);

        orcDao.editarByDataFinal(orcVo);
    }
}
