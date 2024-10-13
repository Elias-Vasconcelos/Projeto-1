//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PessoaFisica joao = new PessoaFisica("joao","saoPaulo","brasil","solteiro","07/2004","123456789");
        PessoaJuridica DocesDoJoao = new PessoaJuridica("DocesDoJoao","SaoPulo","brasil","Docinhos","02/2024","12345678945614263");




        joao.exibeDados();
        DocesDoJoao.exibeDados();
    }
}