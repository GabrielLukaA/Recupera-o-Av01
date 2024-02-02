public class Pessoa {
    private String senha;
    private Pet pet;
    private String nome;
    private long cpf;


    public boolean temPet(){
        if (this.pet!=null){
            return true;
        } else {
            return false;
        }
    }

    public Pessoa(long cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public void limparPet() {
        if (temPet()){
            this.pet.limpar();
        }

    }

    public void botaPetParaDormir() {
        if (temPet()){
            this.pet.dormir();
        }

    }

    public void acordarPet() {
        if (temPet()){
            this.pet.acordar();
        }

    }

    public void darAguaParaPet() {
        if (temPet()){
            this.pet.beberAgua();
        }
    }

    public String avaliarPet() {
        if (this.pet != null) {
            return this.pet.toString();
        }
        return "Sem pet";
    }

    public String getSenha() {
        return senha;
    }

    public long getCpf() {
        return cpf;
    }

    public void adotarPet(Pet pet) {
    this.pet = pet;
    }

    public void alimentarPet(Alimento alimento) {
        if (temPet()){
            this.pet.comer(alimento);
        }

    }

    public void levarPetParaFazerNecessidades() {
        if (temPet()){
            this.pet.fazerNecessidades();
        }


    }

    public void brincarComPet(Brincadeira brincadeira) {
        if (temPet()){
            this.pet.brincar(brincadeira);
        }

    }

    @Override
    public String toString() {
        return
                "CPF: " + this.cpf + "\n" +
                "Nome: " + this.nome + "\n" +
                "Pet: " + this.pet;
    }
}
