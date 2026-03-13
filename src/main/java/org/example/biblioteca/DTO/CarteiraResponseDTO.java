package org.example.biblioteca.DTO;
import lombok.Getter;
import org.example.biblioteca.entity.CarteiraBiblioteca;
import java.util.Date;

@Getter
public class CarteiraResponseDTO {
    private long numeroCarteira;
    private Date dataEmissao;
    private Boolean isValid;

    public CarteiraResponseDTO(CarteiraBiblioteca carteira) {
        this.numeroCarteira = carteira.getNumeroCarteira();
        this.dataEmissao = carteira.getDataEmissao();
        this.isValid = carteira.getIsValid();
    }
}
