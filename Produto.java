public class Produto {
    
    private int Id;
    private String Nome;
    private String Preco;
    private String Tipo;
    private String Descricao;
    
   public Produto(){
        this.Id = 0;
        this.Nome = "";
        this.Preco = "";
        this.Descricao = "";
        this.Tipo = "";
    }  

    public Produto(int Id, String Nome, String Preco, String Tipo, String Descricao){ 
        this.Id = Id;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Tipo = Tipo;
        this.Descricao = Descricao;
    } 

   
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
    
    public void exibirProduto() { 
        System.out.println("\nID: " + Id);
        System.out.println("Nome: " + Nome);
        System.out.println("Tipo: " + Tipo);
        System.out.println("Descrição: " + Descricao);
        System.out.println("Preço: R$" + Preco);
    }
}
