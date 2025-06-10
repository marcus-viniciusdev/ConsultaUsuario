# Consulta de Usuário do GitHub

Este projeto Java permite consultar informações públicas de um usuário do GitHub por meio da API pública do GitHub. O sistema utiliza HttpClient para realizar requisições HTTP e a biblioteca Gson para desserialização de JSON.
## 🚀 Funcionalidades
* Solicita ao usuário o nome de um usuário do GitHub.
* Realiza uma requisição GET à API do GitHub.
* Exibe os dados principais do usuário consultado.
* Trata exceções, como usuário não encontrado ou erro na conexão com a API.

## 🛠️ Tecnologias utilizadas
* Java 11+
* java.net.http.HttpClient
* Gson para parse de JSON
* API pública do GitHub

## 📁 Estrutura do Projeto
```
br/com/alura/consultaUsuario/
│
├── excecoes/
│   └── ErroConsultaGitHubException.java  // Exceção personalizada para usuário não encontrado
│
├── modelos/
│   ├── Usuario.java        // Classe que representa o usuário final com dados convertidos
│   └── UsuarioTemp.java    // Classe modelo usada para receber os dados diretamente da API (presume-se ser um record)
│
└── principais/
    └── Main.java           // Classe principal com lógica de entrada, chamada HTTP, parse de JSON e exibição
```
## 📦 Como executar o projeto

Clone o repositório:

```
git clone https://github.com/marcus-viniciusdev/ConsultaUsuario.git
cd ConsultaUsuario
```

Compile o projeto:
Certifique-se de estar usando Java 11 ou superior.

    javac -cp ".;caminho/gson.jar" br/com/alura/consultaUsuario/**/*.java

Execute o programa:

    java -cp ".;caminho/gson.jar" br.com.alura.consultaUsuario.principais.Main

Digite um nome de usuário do GitHub quando solicitado.
Exemplo:

    Qual usuário deseja consultar: octocat

## ✅ Exemplo de saída

Qual usuário deseja consultar: octocat

Nome: {The Octocat} Nome de Usuário: {octocat} Localização: {San Francisco} Email: {null} Bio: {GitHub's official mascot} Seguidores: {8420} Seguindo: {9}

## ⚠️ Tratamento de Erros

    Se o usuário não for encontrado (404), uma exceção ErroConsultaGitHubException é lançada com uma mensagem apropriada.

    Outras exceções de I/O ou interrupção também são tratadas com mensagens amigáveis ao usuário.

## 🧩 Observação

O código espera que exista uma classe chamada UsuarioTemp, presumivelmente implementada como um record para capturar os campos JSON diretamente. Um exemplo de implementação seria:

public record UsuarioTemp(String name, String login, String location, String email, String bio, String followers, String following) {}

## 📄 Licença

Este projeto é apenas para fins educacionais e segue a licença MIT. Sinta-se à vontade para adaptar e utilizar como desejar.
