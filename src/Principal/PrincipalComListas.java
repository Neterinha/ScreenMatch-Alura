package Principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("Star Wars", 1977);
        meuFilme.avalia(10);
        Filme outroFilme = new Filme("Avatar", 2009);
        outroFilme.avalia(6);
        Filme maisUmFilme = new Filme("Matrix", 1999);
        maisUmFilme.avalia(9);
        Serie friends = new Serie("Friends", 1994);
        friends.avalia(10);


        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(maisUmFilme);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(friends);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
                // variavel filme já está declarada e a verificação já foi feita.
                //Filme filme = (Filme) item;
                // System.out.println("Classificação: " + filme.getClassificacao());
            }
        }


        System.out.println(lista);
        Collections.sort(lista);
        System.out.println("Lista depois da Ordenação");
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("ordenando por ano");
        System.out.println(lista);

    }
}
















