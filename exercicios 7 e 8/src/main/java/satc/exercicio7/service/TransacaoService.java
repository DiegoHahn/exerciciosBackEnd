package satc.exercicio7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import satc.exercicio7.model.Cliente;
import satc.exercicio7.model.Transacao;

@Service
public class TransacaoService {
    @Autowired
    private ClienteService clienteService;

    public Transacao realizarTransacao(Transacao transacao) {
        String recebedor = transacao.getRecebedor();
        String pagador = transacao.getPagador();
        Double quantidade = transacao.getQuantidade();

        Cliente clienteRecebedor = clienteService.getCliente(recebedor);
        Cliente clientePagador = clienteService.getCliente(pagador);

        if (clienteRecebedor != null && clientePagador != null && clientePagador.getSaldo() >= quantidade) {
            clienteService.atualizarSaldo(recebedor, clienteRecebedor.getSaldo() + quantidade);
            clienteService.atualizarSaldo(pagador, clientePagador.getSaldo() - quantidade);
            return transacao;
        } else {
            return null; // Retorno quando a transação é inválida
        }
    }
}