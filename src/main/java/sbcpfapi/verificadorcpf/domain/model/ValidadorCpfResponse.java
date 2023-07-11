package sbcpfapi.verificadorcpf.domain.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(of={"cpf"})
public class ValidadorCpfResponse {

    private final String cpf;
    private String status;
    private boolean valid;

    private String digits;

    public ValidadorCpfResponse(String cpf){
        this.cpf = cpf;
    }

    public void setCpf(String cpf) {
    }
}
