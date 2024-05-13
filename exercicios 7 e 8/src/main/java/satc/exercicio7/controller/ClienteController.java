package satc.exercicio7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import satc.exercicio7.dto.ClienteDTO;
import satc.exercicio7.mapper.ClienteMapper;
import satc.exercicio7.model.Cliente;
import satc.exercicio7.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{nome}")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable String nome) {
        Cliente cliente = clienteService.getCliente(nome);
        if (cliente != null) {
            return new ResponseEntity<>(ClienteMapper.toDTO(cliente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}