# Desafio Desenvolvedor Full Stack

## O que você vai precisar

	JDK 1.8 or later
	Maven 3.2+
	
## Executar a aplicação

    mvn spring-boot:run
    
## Como calcular os representantes

  - Acessar a aplicação em http://localhost:8080
  - Após a execução da aplicação, é só clicar no botão "Atribuir Representantes" na tela home. 
  - Sistema executará os cálculos para atribuição dos representantes para as lojas.
	
## Regras de Atribuição de Representantes

  - Primeiro é verificado se o Representante é o único da região da Loja. Nesse caso, ele é atribuído
  - Caso tenha mais que um representante na região, avalia qual dos dois possui menor número de lojas.
  - Caso tenha o mesmo número de lojas, atribui o que possui a menor distância.
	
## Opções de Tecnologia

  - Spring Boot (https://spring.io/projects/spring-boot)
    - JQuery / Javascript
    - Tiles (https://attic.apache.org/projects/tiles.html)
    - Foundation (https://foundation.zurb.com/)
  - Embedded HSQLDB
  - Embedded Tomcat
  - Liquibase (https://www.liquibase.org/)

## Considerações

  - Temos testes unitários. execute eles com "mvn test"
  - No caso de uma loja estar no raio de mais de um representante, a analise de número de lojas e distância atribui a loja ao representante mais adequado.
  - Foram adicionados alguns logs como rastreamento de cálculo
  - Temos algumas funcionalidades como edição das latitudes e longitudes, e alteração manual de atribuiçào caso seja de intresse.


