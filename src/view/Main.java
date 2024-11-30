package view;

import model.Categoria;
import model.Item;
import model.Produto;
import model.Venda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Venda venda = new Venda();

        Scanner scanner = new Scanner(System.in);
        while (true){

            System.out.println("Menu de vendas");

            System.out.println("1. Adicionar");
            System.out.println("2. Remover");
            System.out.println("3. Valor total");
            System.out.println("4. Listar itens");
            System.out.println("5. Finalizar compra");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: {

                    System.out.println("\n=== Adicionar Item ===");
                    System.out.println("Informe o código do item");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Informe a descrição");
                    String descricao = scanner.nextLine();

                    System.out.println("Informe o preço");
                    double preco = scanner.nextDouble();

                    System.out.println("Selecione a categoria:");
                    System.out.println("1. ALIMENTICIA");
                    System.out.println("2. HIGIENE");
                    System.out.println("3. LIMPEZA");
                    System.out.println("4. HORTIFRUTI");
                    System.out.println("5. PADARIA");

                    int categoriaIndex = scanner.nextInt()-1;
                    scanner.nextLine();
                    Categoria categoria = Categoria.values()[categoriaIndex];

                    System.out.println("Informe a quantidade");
                    double quantidade = scanner.nextDouble();

                    Produto produto = new Produto(codigo, descricao, preco, categoria);
                    Item item = new Item(codigo, produto, quantidade);
                    venda.adicionarItem(item);

                    System.out.println("Item adicionado com sucesso");
                }
                break;

                case 2:  {
                    System.out.println("\n=== Remover Item ===");
                    System.out.print("Código do item a remover: ");
                    int codigoRemover = scanner.nextInt();

                    boolean encontrado = false;
                    for (int i = 0; i < venda.getItens().length; i++) {
                        if (venda.getItens()[i].getCodigo() == codigoRemover) {
                            Item[] itensAtualizados = new Item[venda.getItens().length - 1];
                            int index = 0;
                            for (int j = 0; j < venda.getItens().length; j++) {
                                if (venda.getItens()[j].getCodigo() != codigoRemover) {
                                    itensAtualizados[index++] = venda.getItens()[j];
                                }
                            }
                            venda = new Venda();
                            for (Item item : itensAtualizados) {
                                venda.adicionarItem(item);
                            }
                            encontrado = true;
                            System.out.println("Item removido com sucesso!");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Item não encontrado!");
                    }
                }
                break;


                case 3: {
                    System.out.printf("\nTotal da venda: R$%.2f%n", venda.getTotal());
                }
                break;

                case 4: {
                    System.out.println("\n=== Itens da Venda ===");
                    for (Item item : venda.getItens()) {
                        System.out.printf("Código: %d | Produto: %s | Quantidade: %.2f | Subtotal: R$%.2f%n",
                                item.getCodigo(),
                                item.getProduto().getDescricao(),
                                item.getQuantidade(),
                                item.getSubtotal());
                    }
                }
                break;

                case 5: {
                    System.out.printf("\nVenda finalizada com total de R$%.2f%n", venda.getTotal());
                    System.exit(0);
                }
                break;

                case 6 : {
                        System.out.println("Saindo do sistema. Até logo!");
                        System.exit(0);
                    }

                    break;
                default : System.out.println("Opção inválida. Tente novamente.");
            }

                }

            }


        };


