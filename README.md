# verificador-cpf
Pequeno projeto da faculdade para validar CPF's

Descrição do programa:
---------------------
Criado uma API para validar número de CPF, mostrar se a resposta dessa requisição é válida ou não e caso o CPF esteja errado, informar os últimos
2 digitos corretos.

Tecnologias utilizadas:
-----------------------
Spring Boot 3.1 - Maven - Java 17 - Swagger/OpenApi
Dependências no Spring Boot: Lombok, Spring Web e Spring Boot DevTools
IDE: IntelliJ IDEA Community Edition 2022.3.1

Rodando o projeto:
------------------
* Após baixar o arquivo zip do projeto, descompactar o zip em uma pasta de sua preferência e abrir o projeto no IntelliJ(ou IDE de sua escolha);
* Com o arquivo aberto, vá até a pasta Java e dentro dessa pasta, percorra pelas pastas até chegar no executavel do projeto: java > sbcpfapi.verificadorcpf > main;
* Dentro do main, existe a classe VerificadorCpfApplication. Execute essa classe;
* Agora, abra o seu navegador e na barra de pesquisa digite: http://localhost:9090/api/cpf/ e abra também em outra guia http://localhost:9090/swagger-ui/index.html
* No link que você digitou "http://localhost:9090/api/cpf/" coloque um cpf na frente da ultima barra para validar um CPF, por exemplo: http://localhost:9090/api/cpf/46596632110 e aperte enter. Na tela irá aparecer o JSON da resposta da requisição.
* Já no swagger, irá ter a documentação da API e você também pode executar as validações por lá. Basta selecionar validador-cpf-controller > clicar no botão "Try it out" > inserir o cpf desejado no campo "cpf" e clicar no botão "Execute".

Feito por:
----------
Pedro Paulo Souza de Oliveira - Aluno 2° ano ADS




