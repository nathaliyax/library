package org.example.biblioteca.DTO;
import lombok.Getter;
import org.example.biblioteca.entity.CarteiraB;
import java.util.Date;

@Getter
public class CarteiraResponseDTO {
    private long numCarteira;
    private Date dataEmis;
    private Boolean isValid;

    public CarteiraResponseDTO(CarteiraB carteira) {
        this.numCarteira = carteira.getNumCarteira();
        this.dataEmis = carteira.getDataEmis();
        this.isValid = carteira.getIsValid();
    }
}
