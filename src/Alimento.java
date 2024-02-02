public class Alimento {
    private String nome;
    private static int geradorCodigo = 0;
    private int nutricao;
    private int codigo;

    public Alimento(String nome, int nutricao) {
        this.nome = nome;
        this.nutricao = nutricao;
        this.codigo = ++geradorCodigo;
    }


    public int getNutricao() {
        return nutricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
