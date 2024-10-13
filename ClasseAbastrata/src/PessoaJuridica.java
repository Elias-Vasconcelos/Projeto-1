public class PessoaJuridica extends Pessoa {
    private String nomeFantasia, cnpj, dataFundacao;


    public PessoaJuridica(String nome, String enderco, String PaisOrigem, String nomeFantasia, String dataFundacao, String cnpj) {
        super(nome, enderco, PaisOrigem);
        this.nomeFantasia = nomeFantasia;
        this.dataFundacao = dataFundacao;
        this.cnpj = cnpj;
    }

    @Override
    public void exibeDados() {
        super.exibeDados();
        System.out.println(this.nomeFantasia);
        System.out.println(this.cnpj);
        System.out.println(this.dataFundacao);
        System.out.println("---------------------------------------------");
        System.out.println(" ");
    }
}
