package sbcpfapi.verificadorcpf.domain.service;

import org.springframework.stereotype.Service;
import sbcpfapi.verificadorcpf.domain.model.ValidadorCpfResponse;

@Service
public class ValidadorCpfService {
    public ValidadorCpfResponse validar(String cpf){
        ValidadorCpfResponse response = new ValidadorCpfResponse(cpf);

        int contador = 10;
        int primeiroDigitoValidado = 0;
        int segundoDigitoValidado = 0;
        //String a = cpf.substring(0,1);
        //05300191167
        //int b = Integer.parseInt(a);
        int somaDigito1 = 0;
        int somaDigito2 = 0;
        somaDigito1 = percorrerCpf(cpf, contador);
        somaDigito1 = calculaResto(somaDigito1);
        primeiroDigitoValidado = validarDigito(somaDigito1);

        contador = 11;

        somaDigito2 = percorrerCpf(cpf, contador);
        somaDigito2 += (primeiroDigitoValidado * 2);
        somaDigito2 = calculaResto(somaDigito2);
        segundoDigitoValidado = validarDigito(somaDigito2);

        boolean valid = (primeiroDigitoValidado == Integer.parseInt(cpf.substring(9,10))) && (segundoDigitoValidado ==
                Integer.parseInt(cpf.substring(10,11)));
        response.setValid(valid);
        response.setStatus(valid ? "CPF válido" : "CPF inválido");
        if (!valid){
            response.setDigits(String.valueOf(primeiroDigitoValidado) + segundoDigitoValidado);
        }

//        System.out.println(primeiroDigitoValidado);
//        System.out.println(segundoDigitoValidado);

        /*for(int i = 0; i < 9; i++){
            String numeroAtualDoCpf = cpf.substring(i,i+1);
            int transformStringToNumber = Integer.parseInt(numeroAtualDoCpf);
            somaDigito1 += transformStringToNumber * contador;
            contador--;
        }
        //int resultadoCpf = somaDigito1 / 11;
        int restoResultadoCpf = somaDigito1 % 11;
        if(restoResultadoCpf < 2){
            primeiroDigitoValidado = 0;
        } else {
            primeiroDigitoValidado = 11 - restoResultadoCpf;
        }

        contador = 11;
        int somaDigito2 = 0;
        for(int i = 0; i < 9; i++){
            String numeroAtualDoCpf = cpf.substring(i,i+1);
            int transformStringToNumber = Integer.parseInt(numeroAtualDoCpf);
            somaDigito2 += transformStringToNumber * contador;
            contador--;
        }
        somaDigito2 += (primeiroDigitoValidado * contador);
        int restoResultadoCpf2 = somaDigito2 % 11;
        if(restoResultadoCpf2 < 2){
            segundoDigitoValidado = 0;
        } else {
            segundoDigitoValidado = 11 - restoResultadoCpf2;
        }*/

        return response;
    }
    public int percorrerCpf(String cpf, int contador){
        int soma=0;
        for(int i = 0; i < 9; i++){
            String numeroAtualDoCpf = cpf.substring(i,i+1);
            int transformStringToNumber = Integer.parseInt(numeroAtualDoCpf);
            soma += transformStringToNumber * contador;
            contador--;
        }
        return soma;
    };

    public int calculaResto(int numero){
        int resto = numero % 11;
        return resto;
    }

    public int validarDigito(int restoCpf){
        int digito = 0;
        if(restoCpf < 2){
            digito = 0;
        } else {
            digito = 11 - restoCpf;
        }
        return digito;
    };

}
 /*public static void main(String[] args) {
        new ValidadorCpfService().validar("");
    }*/