package br.com.alura.consultaUsuario.excecoes;

public class ErroConsultaGitHubException extends RuntimeException {
    public ErroConsultaGitHubException(String message) {
        super(message);
    }
}
