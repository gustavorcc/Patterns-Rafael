package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto(scanner, produtos);
                    break;

                case 2:
                    buscarProduto(scanner, produtos);
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void cadastrarProduto(Scanner scanner, List<Produto> produtos) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();


        if (buscarProdutoPeloCodigo(produtos, codigo) != null) {
            System.out.println("Erro: Código de produto já cadastrado!");
            return;
        }

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        produtos.add(new Produto(codigo, nome, preco));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void buscarProduto(Scanner scanner, List<Produto> produtos) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        Produto produto = buscarProdutoPeloCodigo(produtos, codigo);
        if (produto != null) {
            System.out.println("\nProduto foi encontrado com sucesso:\n" + produto);
        } else {
            System.out.println("Produto não foi encontrado.");
        }
    }

    private static Produto buscarProdutoPeloCodigo(List<Produto> produtos, int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
}
