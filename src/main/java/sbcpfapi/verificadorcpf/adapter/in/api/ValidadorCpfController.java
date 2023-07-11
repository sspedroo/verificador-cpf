package sbcpfapi.verificadorcpf.adapter.in.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbcpfapi.verificadorcpf.domain.model.ValidadorCpfResponse;
import sbcpfapi.verificadorcpf.domain.service.ValidadorCpfService;

@RestController
@RequestMapping("/api/cpf")
public class ValidadorCpfController {

    @Autowired
    private ValidadorCpfService validarCpf;

    @GetMapping(value = {"/{cpf}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValidadorCpfResponse> validate(@PathVariable("cpf") String cpf){
        ValidadorCpfResponse response = validarCpf.validar(cpf);

        if(response.isValid()){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    /*@GetMapping("/{cpf}")
    public String Hello(@PathVariable("cpf") String cpf){
        final String message = String.format("Hello, %s.", cpf);
        return message;
    }*/

}
