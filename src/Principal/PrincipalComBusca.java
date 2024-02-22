package Principal;


import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

            while (!busca.equalsIgnoreCase("sair")) {


                System.out.println("Digite o nome do filme para busca: ");
                busca = leitura.nextLine();

                if (busca.equalsIgnoreCase("sair")) {
                    break;
                }

                //API Key do site OMDB
                String key = "d906b254";                    //.replace para juntar as palavras pesquisadas separadas na URL
                String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + key;
                //Conexão HTTP
                try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                //System.out.println(response.body());
                //Resposta do que foi requisitado na String json
                String json = response.body();
                //imprimindo o json requisitado
                System.out.println(json);

                //conversao para iniciar a leitura do record em up cammel case

                // Titulo meuTitulo = gson.fromJson(json, Titulo.class);
                //System.out.println(meuTitulo);


                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                //conversao do titulo


                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("titulo convertido");
                System.out.println(meuTitulo);

                /*FileWriter escrever = new FileWriter("filmes.txt");
                escrever.write(meuTitulo.toString());
                escrever.close();*/

                titulos.add(meuTitulo);

            } catch(NumberFormatException e){
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            }
             catch(IllegalArgumentException e){
                System.out.println("Ocorreu um erro de argumento na busca, verifique o endereço");
            }
             catch(ErroDeConversaoDeAnoException e){
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titulos);

        FileWriter escrever = new FileWriter("filmes.json");
        escrever.write(gson.toJson(titulos));
        escrever.close();

        System.out.println("\n O Programa finalizou corretamente! ");


    }
}






















