public class Pet {

    private static int geradorCodigo = 0;
    private int sede = 100;
    private int fome = 60;
    private int codigo;

    private String nome;
    private int vontadeBanheiro = 100;
    private int higiene = 100;
    private boolean acordado = true;
    private int energia = 100;
    private boolean vivo = true;
    private int diversao = 50;

    public Pet(String nome) {
        this.nome = nome;
        this.codigo = ++geradorCodigo;
    }

    private void regulaAtributos() {

        if (this.sede < 0) {
            this.sede = 0;
        } else if (this.sede > 100) {
            this.sede = 100;
        }

        if (this.higiene < 0) {
            this.higiene = 0;
        } else if (this.higiene > 100) {
            this.higiene = 100;
        }


        if (this.fome < 0) {
            this.fome = 0;
        } else if (this.fome > 100) {
            this.fome = 100;
        }


        if (this.energia < 0) {
            this.energia = 0;
        } else if (this.energia > 100) {
            this.energia = 100;
        }

        if (this.diversao < 0) {
            this.diversao = 0;
        } else if (this.diversao > 100) {
            this.diversao = 100;
        }
        if (this.vontadeBanheiro < 0) {
            this.vontadeBanheiro = 0;
        } else if (this.vontadeBanheiro > 100) {
            this.vontadeBanheiro = 100;
        }

    }

    private void vazou() {
        if (this.vontadeBanheiro == 0) {
            this.higiene = 0;
            this.vontadeBanheiro = 100;
        }
    }

    public void beberAgua() {
        this.sede += 50;
        this.vontadeBanheiro -= 25;
        regulaAtributos();
        vazou();

    }

    public void limpar() {
        this.higiene = 100;
    }

    public void fazerNecessidades() {
        this.vontadeBanheiro = 100;
        this.higiene -= 25;
        regulaAtributos();
    }

    public void brincar(Brincadeira brincadeira) {
        this.energia -= brincadeira.getCansaco();
        this.diversao += brincadeira.getDivertimento();
        this.fome -= brincadeira.getFome();
        this.sede -= brincadeira.getSede();
        this.higiene -= brincadeira.getSujeira();
        regulaAtributos();
        morrer();

    }

    public void dormir() {
        this.energia += 25;
        this.acordado = false;
        regulaAtributos();
    }

    private void morrer() {
        if (this.sede == 0 || this.fome == 0 || this.energia == 0) {
            this.vivo = false;
        }
    }

    public void acordar() {
        this.energia += 25;
        regulaAtributos();
        this.acordado = true;
    }

    public void comer(Alimento alimento) {
        //Perguntar sobre como funciona a nutrição do bicho, mais ou menos???
        this.fome += alimento.getNutricao();
        this.vontadeBanheiro -= (alimento.getNutricao() / 2);
        regulaAtributos();
        vazou();

    }

    @Override
    public String toString() {

        String vivo;
        String acordado;

        if (this.vivo) {
            vivo = "Sim";
        } else {
            vivo = "Não";
        }

        if (this.acordado) {
            acordado = "Sim";
        } else {
            acordado = "Não";
        }

        return
                "Código: "+this.codigo+"\n"+
                "Nome: " + this.nome + "\n" +
                        "Vivo: " + vivo + "\n" +
                        "Acordado: " + acordado + "\n" +
                        "Sede: " + this.sede + "\n" +
                        "Fome: " + this.fome + "\n" +
                        "Energia: " + this.energia + "\n" +
                        "Diversão: " + this.diversao + "\n" +
                        "Higiene: " + this.higiene + "\n" +
                        "Vontade de ir ao banheiro: " + this.vontadeBanheiro
                ;
    }

    public int getCodigo() {
        return codigo;
    }
}
