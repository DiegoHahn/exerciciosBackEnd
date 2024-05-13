package satc.exercicio7.mapper;

import satc.exercicio7.dto.TransacaoDTO;
import satc.exercicio7.model.Transacao;

public class TransacaoMapper {
    public static TransacaoDTO toDTO(Transacao transacao) {
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        transacaoDTO.setRecebedor(transacao.getRecebedor());
        transacaoDTO.setPagador(transacao.getPagador());
        transacaoDTO.setQuantidade(transacao.getQuantidade());
        return transacaoDTO;
    }

    public static Transacao toEntity(TransacaoDTO transacaoDTO) {
        return new Transacao(transacaoDTO.getRecebedor(), transacaoDTO.getPagador(), transacaoDTO.getQuantidade());
    }
}
