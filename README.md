#### README - Document Solutions QA TEST ####

---
#### Finalidade ####

* Aplicação para executar os testes funcionais ou de sistemas da aplicação web **automationpractice** (site utilizado 
para testes)
* Versão: 0.0

---
#### Como executar ####

1.0 Baixar o projeto:
```
$ git clone git@github.com:mpocin/documentsolutions_qatest.git
```
2.0 Configurar projeto:

2.1 Via linha de comando:
```
$ ./gradlew cleanEclipse eclipse OU ./gradlew cleanIdea idea
```
2.2 Via IDE (Eclipse OU Idea):
- Importar projeto

3.0 Executar o projeto:

3.1 Via linha de comando:
```
$ ./gradlew -PactiveProfiles=test functionalTest
```
3.2 Via IDE (Eclipse OU Idea):
- Buildar o projeto

---
* __OBS.__: É necessário que a versão do [Firefox](https://www.mozilla.org/en-US/firefox/new) seja maior que __55__ OU 
a versão do [Chrome](https://www.google.com/chrome/browser/desktop/index.html) seja maior que __59__.

---
#### Como Contribuir ####

* Criar uma branch a partir da master
```
$ git checkout -b [NOMEDABRANCH]
```
* Codificar e testar
* Criar pull request
