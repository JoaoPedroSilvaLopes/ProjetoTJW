## :pencil2: Fynance

## :file_folder: Sobre o projeto

<p align="justify">
  Este é o projeto final da cadeira de Tópicos em Java para Web. É pré-requisito do projeto que seja utilizado tecnologias java como spring boot e thymeleaf para a sua realização.
</p>

<p align="justify">
  Esse projeto se trata de uma aplicação web de gestão de pessoas e de departamentos, em que o usuário consiga realizar operações de create, read, update e delete nas entidades Pessoa e Departamento e navegação entre os arquivos HTML através de rotas.
</p>

## 💡 Rodando o Projeto

### Pre-requisitos

<p>Antes de tudo é necessário instalar: </p>

- Instalar o <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">Java 17</a>

- Instalar o <a href="https://www.eclipse.org/?gad_source=1&gclid=Cj0KCQiAyeWrBhDDARIsAGP1mWT8OyE9JRrfLxpoOrxF_frsyAh_1oW6grRf5whxhxr7308ZtaHxjEQaAlipEALw_wcB">Eclipse IDE</a>

* Clonando o respositório
  ```sh
  git clone https://github.com/JoaoPedroSilvaLopes/ProjetoTJW.git
  ```

* Dependencias utilizadas no projeto
  ```sh
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
  </dependency>
  <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>
  <dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
  ```

* Como abrir o projeto no eclipse
  ```sh
  File -> Import -> Maven -> Existing Maven Projects -> Procure o projeto clonado e o selecione
  ```

## 🖼️ Organização do projeto
  - **controller**: Pacote referente aos controllers do sistema;
  - **domain**: Pacote referente às entidades do sistema;
  - **repository**: Pacote referente aos repositórios do sistema;
  - **runner**: Pacote referente aos CommandLineRunner para popular o banco de dados;
  - **templates**: Pacote referente aos arquivos HTMLs;

## :desktop_computer: Principais tecnologias utilizadas no Projeto

- <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">Java 17</a>
- <a href="https://www.thymeleaf.org">Thymeleaf</a>
- <a href="https://spring.io/projects/spring-boot">SpringBoot</a>
- <a href="https://spring.io/guides/gs/validating-form-input/">Spring Validation</a>
- <a href="https://getbootstrap.com/docs/4.0/getting-started/introduction/">Bootstrap 4</a>
- <a href="http://www.h2database.com/html/quickstart.html">H2-Console</a>
