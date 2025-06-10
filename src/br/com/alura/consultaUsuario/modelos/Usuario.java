package br.com.alura.consultaUsuario.modelos;

public class Usuario {
    private final String nome;
    private final String nomeDeUsuario;
    private final String localizacao;
    private final String email;
    private final String bio;
    private final int seguidores;
    private final int seguindo;

    public Usuario(UsuarioTemp template) {
        this.nome = template.name();
        this.nomeDeUsuario = template.login();
        this.localizacao = template.location();
        this.email = template.email();
        this.bio = template.bio();
        this.seguidores = Integer.parseInt(template.followers());
        this.seguindo = Integer.parseInt(template.following());
    }

    @Override
    public String toString() {
        return "Nome: {" + nome + "} Nome de Usuário: {" + nomeDeUsuario + "} Localização: {" + localizacao + "} Email: {" + email + "} Bio: {" + bio + "} Seguidores: {" + seguidores + "} Seguindo: {" + seguindo + "}";
    }
}
