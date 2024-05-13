package satc.exercicio7.mapper;

import satc.exercicio7.dto.ClienteDTO;
import satc.exercicio7.model.Cliente;

public class ClienteMapper {
    public static ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setSaldo(cliente.getSaldo());
        return clienteDTO;
    }

    public static Cliente toEntity(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getNome(), clienteDTO.getSaldo(), null);
    }
}