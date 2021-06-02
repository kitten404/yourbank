# yourbank

1 - ir até a pasta lombook e clicar duas vezes no lombook.jar, terminar a instalação, é bem simples, se caso precisar consultar um material -> https://receitasdecodigo.com.br/java/instalar-o-plugin-do-lombok-no-eclipse

2 - Ir no eclipse, baixar o spring boot no market place  - https://bgasparotto.com/pt/instalar-o-spring-tool-suite-no-eclipse

3 - Ir em file -> import -> existing maven projects -> browse -> selecionar a pasta do projeto finish

4 - verificar se o projeto se auto configurou a jre library como javaSE11, caso nao:
   4.1 - ir no project explorer, botao direito no projeto -> properties -> java build path -> Modulepath -> Add Library -> Jre system library -> next -> alternate jre ->         installed jre add -> Standard VM -> Directory -> selecionar javaSe11 -> finish
   4.2 - em properties -> java build path -> Modulepath -> Add Library -> Jre system library -> next -> alternate jre : escolha jdk16.01

5 - Clean no projeto 

6 - Window -> show view -> boot dashboard, o projeto vai aparecer na aba boot dashboard 

7 - Rodar o projeto - se encontra na porta 8080, caso queira alternar a porta colocar isso no properties com a porta desejada: server.port=8096

# Ressalva

Estou usando o H2 como banco de dados pra simplificar a vida, vc consegue acessá-lo ao subir o projeto em http://localhost:8080/h2-console

As classes de request, domain e entity do dataprovider não estão totalmente cobertas pelos testes pelo fato de estar sendo usado o lombok, essa biblioteca acaba gerando uns metódos própios e o teste unitário não os cobre. 

A collection do postman está disponibilizada em uma pasta deste projeto, basta somente importá-lo.



