# ATVDS01

## Produto 

public class Produto {
    
    private int Id;
    private String Nome;
    private String Preco;
    private String Tipo;
    private String Descricao;
  //Nessa primeira parte eu defini meus 5 atributos e fiz o encapsulamento deles
    
   public Produto(){
        this.Id = 0;
        this.Nome = "";
        this.Preco = "";
        this.Descricao = "";
        this.Tipo = "";
    }  
 
  //Aqui é um construtor padrão (sem parâmetros), e tambem descobri que o ID por ser uma variavel inteira vazia ela recebe o valor de 0

    public Produto(int Id, String Nome, String Preco, String Tipo, String Descricao){ 
        this.Id = Id;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Tipo = Tipo;
        this.Descricao = Descricao;
    } 
  //Construtor Completo
  //Fiz só dois metodos construtores, porque não sei o que colocar no outro
  
    public int getId(){
        return Id;
    }

    public String getNome(){
        return Nome;
    }

    public String getTipo(){
        return Tipo;
    }

    public String getDescricao(){
        return Descricao;
    }

    public String getPreco(){
        return Preco;
    }
  // Definindo retorno com o get, como estes objetos estão privados, eles precisam ser acessados com o get 

    public void setId(int Id){
        this.Id = Id;
    }

    public void setNome(String Nome){
        this.Nome = Nome;
    }

    public void setTipo(String Tipo){
        this.Tipo = Tipo;
    }

    public void setDescricao(String Descricao){
        this.Descricao = Descricao;
    }

    public void setPreço(String Preco){
        this.Preco = Preco;
    }
  //O set serve para colocar um valor nos atributos
    
    public void exibirProduto() { 
        System.out.println("\nID: " + Id);
        System.out.println("Nome: " + Nome);
        System.out.println("Tipo: " + Tipo);
        System.out.println("Descrição: " + Descricao);
        System.out.println("Preço: R$" + Preco);
    }
}
//Essa é funçao que vai mostrar la no teminal quando for mostrar o produto que foi criado

## Main

import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args ) {
        
        //Definindo scanner para o usuário poder digitar
        
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
            //Vai criar o produto com meus 5 atributos
            
            Produto novoProduto = new Produto(ID, Nome, Preco, Tipo, Descricao);

            listaProdutos.add(novoProduto);

            System.out.println("Produto cadastrado com sucesso!");

            System.out.println("\nPressione Enter para voltar ao menu...");
            scanner.nextLine(); 
            break;
            //Faz com que o produto fique "salvo", pois sem essa parte o produto nao ficaria "salvo" e os outros cases daria que nao tem nenhum produto
            
            case 2:
            if (listaProdutos.isEmpty()) { 
                System.out.print("Não há nenhum produto");
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }
            //Aqui vai verificar se a lista está vazia e se estiver vai falar que nao tem nenhum produto

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
          //Essa parte vai ser digitado um id de algum produto, e vai procurar se existe

            if (produtoEncontrado == null) {
               System.out.print("Produto não encontrado!");  
               break;
            }
            //Se nao encontrar vamos ter essa mensagem e voltara ao menu

            System.out.print("Produto Encontrado!!");
            produtoEncontrado.exibirProduto(); 
            //Vai exibir o produto para o usuario ver se é o produto correto

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
            //Mas caso encontre havera a opçao de alterar os dados ou manter

            case 3:
            if (listaProdutos.isEmpty()) {  
                System.out.print("Não há nenhum produto");
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                break;
            }
          //Verifica se a lista esta vazia, caso esteja vai mostrar a mensagem de que nao tem nenhum produto

            System.out.print("Digite o ID do produto que você quer excluir:");
            IdBuscador = scanner.nextInt();
            produtoEncontrado = null;
            for(Produto P : listaProdutos){ 
                if (P.getId() == IdBuscador) {
                    produtoEncontrado = P;
                    break;
                }
            //Vai procurar o ID do produto
            }

            if (produtoEncontrado == null) {
               System.out.print("Produto não encontrado!"); 
               break;
            }
          //Se ele nao o produto achar aparecera essa mensagem

            System.out.print("Produto Encontrado!!");
            produtoEncontrado.exibirProduto(); 

            System.out.print("Você tem certeza que quer excluir esse produto? (Aperte Enter para confirmar ou qualquer tecla para cancelar)");
            //Se achar o produto o usuario tera a opçao de dar ENTER e confirmar a exclusão, mas caso ele aperte qualquer outra tecla vai ser cancelada

            
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
          //Vai verificar se a lista esta vazia, caso esteja ira mostrar que nao tem produto nenhum

            System.out.println("\n=== Lista de Produtos ===");
            for(Produto p:listaProdutos){ 
                p.exibirProduto();
            }
          //Vai mostrar todos os produtos da lista

            System.out.println("\nPressione Enter para voltar ao menu...");
            scanner.nextLine();
            break;

            case 5:
                System.out.println("Saindo...."); 
                break;

            default:
            System.out.println("Opção inválida! Tente novamente.");
        }
        //Caso o usuario tente digitar outra opção

    } while(op != 5); //Aqui o while vai repetir o menu ate ser digitado 5, que ai sim vai ocorrer a saida
        scanner.close(); 
    }
}

