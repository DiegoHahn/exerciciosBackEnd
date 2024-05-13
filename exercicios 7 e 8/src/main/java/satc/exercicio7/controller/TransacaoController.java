package satc.exercicio7.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import satc.exercicio7.dto.TransacaoDTO;
import satc.exercicio7.mapper.TransacaoMapper;
import satc.exercicio7.model.Transacao;
import satc.exercicio7.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDTO> realizarTransacao(@Valid @RequestBody TransacaoDTO transacaoDTO) {
        Transacao transacao = TransacaoMapper.toEntity(transacaoDTO);
        Transacao transacaoRealizada = transacaoService.realizarTransacao(transacao);
        if (transacaoRealizada != null) {
            return new ResponseEntity<>(TransacaoMapper.toDTO(transacaoRealizada), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}