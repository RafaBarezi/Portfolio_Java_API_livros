package principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrincipalAPI {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.print("Por favor, digite o nome de um livro:");
        String busca = leitura.nextLine();
        Dados meuLivro = null;

        String endereco = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + busca;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder().create();

        LivroGoogle livroGoogle = gson.fromJson(json, LivroGoogle.class);

        if (livroGoogle.items != null && !livroGoogle.items.isEmpty()) {
            meuLivro = new Dados(livroGoogle.items.get(0));
            System.out.println(meuLivro);
        } else {
            System.out.println("Nenhum livro foi encontrado!");
        }

        try (FileWriter escrita = new FileWriter("livros.txt", true)) { // 'true' pra não apagar o que já tá no arquivo
            escrita.write(meuLivro.toString());
            escrita.write("\n------------------------------\n"); // separa entradas
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }
}
