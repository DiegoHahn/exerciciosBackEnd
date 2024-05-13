package satc.exercicio7.dto;

//eu sempre uso o jakarta ao invés do hibernate
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class TransacaoDTO {
    @NotBlank(message = "Nome do recebedor é obrigatório.")
    private String recebedor;

    @NotBlank(message = "Nome do pagador é obrigatório.")
    private String pagador;

    @Positive(message = "Quantidade deve ser maior que 0.")
    private Double quantidade;

    // Getters e Setters
    public String getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(String recebedor) {
        this.recebedor = recebedor;
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}