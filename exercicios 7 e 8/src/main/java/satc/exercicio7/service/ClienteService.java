package satc.exercicio7.service;

import org.springframework.stereotype.Service;
import satc.exercicio7.model.Cliente;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {
    private final Map<String, Cliente> clientes = new HashMap<>();

    public ClienteService() {
        clientes.put("Diego Hahn", new Cliente("Diego Hahn", 20000.0, "coxinha123"));
        clientes.put("Stephani", new Cliente("Stephani", 4000.0, "adminadmin"));
    }

    public Cliente getCliente(String nome) {
        return clientes.get(nome);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getNome(), cliente);
    }

    public void atualizarSaldo(String nome, Double novoSaldo) {
        Cliente cliente = clientes.get(nome);
        if (cliente != null) {
            cliente.setSaldo(novoSaldo);
        }
    }
}