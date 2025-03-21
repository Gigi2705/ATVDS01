import java.util.Scanner;
import java.util.ArrayList;


public class Main{
    public static void main(String[] args ) {

        Scanner scanner = new Scanner(System.in);
        ArrayList <Produto> listaProdutos = new ArrayList<>();
        int op;
        do{
            System.out.println("\n MENU ");
            System.out.println("1 - Criar um produto");
            System.out.println("2 - Alterar dados de um produto");
            System.out.println("3 - Excluir um produto");
            System.out.println("4 - Listar todos os produtos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
         op = scanner.nextInt();
         scanner.nextLine();
        switch (op) {
            case 1:
         
            System.out.print("Digite o ID do produto:");
            int ID = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o nome do produto:");
            String Nome = scanner.nextLine();

            System.out.print("Digite o preço do produto: ");
            String Preco = scanner.nextLine();

            System.out.print("Digite o tipo do produto: ");
            String Tipo = scanner.nextLine();

            System.out.print("Digite a descrição do produto: ");
            String Descricao = scanner.nextLine();
            
            Produto novoProduto = new Produto(ID, Nome, Preco, Tipo, Descricao);

            listaProdutos.add(novoProduto);

            System.out.println("Produto cadastrado com sucesso!");

            System.out.println("\nPressione Enter para voltar ao menu...");
            scanner.nextLine(); 
            break;
        
            case 2:
            if (listaProdutos.isEmpty()) { 
                System.out.print("Não há nenhum produto");
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }

            System.out.print("Digite O ID do produto");
            int IdBuscador = scanner.nextInt();
            scanner.nextLine();

            Produto produtoEncontrado = null;
            for(Produto P : listaProdutos){ 
                if (P.getId() == IdBuscador) {
                    produtoEncontrado = P; 
                    break;
                }
            }

            if (produtoEncontrado == null) {
               System.out.print("Produto não encontrado!");  
               break;
            }

            System.out.print("Produto Encontrado!!");
            produtoEncontrado.exibirProduto(); 

            System.out.print("\nNovo nome (ou pressione ENTER para manter): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                produtoEncontrado.setNome(novoNome);
            }
    
            System.out.print("Novo preço (ou pressione ENTER para manter): ");
            String novoPreco = scanner.nextLine();
            if (!novoPreco.isEmpty()) {
                produtoEncontrado.setPreço(novoPreco);
            }
    
            System.out.print("Novo tipo (ou pressione ENTER para manter): ");
            String novoTipo = scanner.nextLine();
            if (!novoTipo.isEmpty()) {
                produtoEncontrado.setTipo(novoTipo);
            }
    
            System.out.print("Nova descrição (ou pressione ENTER para manter): ");
            String novaDescricao = scanner.nextLine();
            if (!novaDescricao.isEmpty()) {
                produtoEncontrado.setDescricao(novaDescricao);
            }
    
            System.out.println("Produto atualizado com sucesso!");

            System.out.println("\nPressione Enter para voltar ao menu...");
            scanner.nextLine();
            break;

            case 3:
            if (listaProdutos.isEmpty()) {  
                System.out.print("Não há nenhum produto");
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }

            System.out.print("Digite o ID do produto que você quer excluir:");
            IdBuscador = scanner.nextInt();
            produtoEncontrado = null;
            for(Produto P : listaProdutos){ 
                if (P.getId() == IdBuscador) {
                    produtoEncontrado = P;
                    break;
                }
            }

            if (produtoEncontrado == null) {
               System.out.print("Produto não encontrado!"); 
               break;
            }

            System.out.print("Produto Encontrado!!");
            produtoEncontrado.exibirProduto(); 

            System.out.print("Você tem certeza que quer excluir esse produto? (Aperte Enter para confirmar ou qualquer tecla para cancelar)");

            
            scanner.nextLine();  
            String confirmacao = scanner.nextLine();  

            if (confirmacao.isEmpty()) {  
                listaProdutos.remove(produtoEncontrado);
                System.out.print("Produto excluído com sucesso!!");
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();  
            break;
            } else {
                System.out.print("Operação Cancelada!");
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
            break;
            }

            case 4:
            if (listaProdutos.isEmpty()) {
                System.out.print("Não há nenhum produto"); 
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }

            System.out.println("\n=== Lista de Produtos ===");
            for(Produto p:listaProdutos){ 
                p.exibirProduto();
            }

            System.out.println("\nPressione Enter para voltar ao menu...");
            scanner.nextLine();
            break;

            case 5:
                System.out.println("Saindo...."); 
                break;

            default:
            System.out.println("Opção inválida! Tente novamente.");
        }

    } while(op != 5); 
        scanner.close(); 
    }
}