package br.com.alura.consultaUsuario.principais;

import br.com.alura.consultaUsuario.excecoes.ErroConsultaGitHubException;
import br.com.alura.consultaUsuario.modelos.Usuario;
import br.com.alura.consultaUsuario.modelos.UsuarioTemp;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Qual usuário deseja consultar: ");
        String usuario = URLEncoder.encode(scanner.next(), StandardCharsets.UTF_8);
        String endereco = "https://api.github.com/users/" + usuario;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            if (response.statusCode() == 404) {
                throw new ErroConsultaGitHubException("O usuário consultado não foi encontrado no Github.");
            }

            Gson gson = new Gson().newBuilder().setLenient().create();
            UsuarioTemp usuarioTemp = gson.fromJson(json, UsuarioTemp.class);
            System.out.println(usuarioTemp);

            Usuario usuarioEncontrado = new Usuario(usuarioTemp);
            System.out.println(usuarioEncontrado);
        } catch (IOException | InterruptedException e) {
            System.out.println("Opss... Ocorreu um erro ao rodar a API do Github.");
        } catch (ErroConsultaGitHubException e) {
            System.out.println(e.getMessage());
        }
    }
}
