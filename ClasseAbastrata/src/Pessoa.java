 public abstract class Pessoa {
   private String nome, enderco, PaisOrigem;

   public Pessoa( String nome, String enderco,String PaisOrigem  ){
       this.nome = nome;
       this.enderco = enderco;
       this.PaisOrigem = PaisOrigem;
   }
     public void exibeDados(){
         System.out.println(this.nome);
         System.out.println(this.enderco);
         System.out.println(this.PaisOrigem);
     }
 }
