package Principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Filme;

import java.util.ArrayList;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Star Wars", 1977);
       // meuFilme.setNome("Star Wars");
        //meuFilme.setAnoDeLancamento(1977);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(7);
        meuFilme.avalia(8);
        meuFilme.avalia(3);

        System.out.println(meuFilme.obtemMedia());
        System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacoes());

        Serie friends = new Serie("Friends", 1994);
       // friends.setNome("Friends");
        friends.setTemporadas(10);
        friends.setEpisodiosPorTemporada(24);
        friends.setMinutosPorEpisodio(20);
        //System.out.println("Duração para maratonar Friends: " + friends.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar", 2009);
        //outroFilme.setNome("Avatar");
        //outroFilme.setAnoDeLancamento(2009);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.incluir(meuFilme);
        calculadora.incluir(outroFilme);
        calculadora.incluir(friends);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(friends);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        Filme maisUmFilme = new Filme("Matrix", 1999);
        maisUmFilme.setDuracaoEmMinutos(136);
        //maisUmFilme.setAnoDeLancamento(1999);
        maisUmFilme.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(maisUmFilme);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("\nTamanho da lista: " + listaDeFilmes.size());
        System.out.println("\nPrimeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);



    }
}



























