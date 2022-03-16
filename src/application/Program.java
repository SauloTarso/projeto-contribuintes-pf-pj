package application;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Contribuinte> listaContribuinte = new ArrayList<>();

        System.out.print("Entre com o número de contribuintes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do contribuinte #" + i);
            System.out.print("Pessoa física ou jurídica (f/j)? ");
            char resp = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Renda anual: ");
            double rendaAnual = sc.nextDouble();
            if (resp == 'f') {
                System.out.print("Gasto com saúde: ");
                double gastoSaude = sc.nextDouble();
                listaContribuinte.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
            } else {
                System.out.print("Número de funcionários: ");
                int numeroFunc = sc.nextInt();
                listaContribuinte.add(new PessoaJuridica(nome, rendaAnual, numeroFunc));
            }
        }
        System.out.println();
        System.out.println("Contribuições:");
        for (Contribuinte cont : listaContribuinte) {
            System.out.println("Nome: " + cont.getNome() + ": $ " + String.format("%.2f", cont.imposto()));
        }

        System.out.println();
        double soma = 0.0;
        for (Contribuinte cont : listaContribuinte) {
            soma += cont.imposto();
        }

        System.out.println("Total de impostos: $ " + String.format("%.2f", soma));

    }
}
