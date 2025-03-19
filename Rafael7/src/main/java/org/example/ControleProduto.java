package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleProduto {
    private final List<Produto> produtos = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void cadastrarProduto() {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();


        if (buscarProdutoPorCodigo(codigo) != null) {
            System.out.println("Erro: Código já cadastrado!");
            return;
        }

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        produtos.add(new Produto(codigo, nome, preco));
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void buscarProduto() {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto != null) {
            System.out.println("\nProduto encontrado:\n" + produto);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
}
