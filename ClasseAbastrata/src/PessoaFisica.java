public class PessoaFisica extends Pessoa {

    private String cpf, dataDeNascimento, estadoCivil;

    public PessoaFisica(String nome, String enderco, String PaisOrigem, String estadoCivil, String dataDeNascimento, String cpf) {
        super(nome, enderco, PaisOrigem);
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    @Override
    public void exibeDados() {
        super.exibeDados();
        System.out.println(this.cpf);
        System.out.println(this.dataDeNascimento);
        System.out.println(this.estadoCivil);
        System.out.println("---------------------------------------------");
        System.out.println(" ");
    }
}
