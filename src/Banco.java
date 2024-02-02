import java.util.ArrayList;

public class Banco {

    public Banco() {
        alimentos.add(new Alimento("Ração", 30));
        alimentos.add(new Alimento("Cenoura", 20));
        alimentos.add(new Alimento("Osso", 10));
        brincadeiras.add(new Brincadeira("Sair para passear",20,5, 20, 5, 25));
        brincadeiras.add(new Brincadeira("Truques de inteligência",40,10, 5, 0, 10));
        brincadeiras.add(new Brincadeira("Brincar de pegar bolinha",30,5, 50, 5, 25));
    }

    private static ArrayList<Alimento> alimentos = new ArrayList<>();
    private static ArrayList<Brincadeira> brincadeiras = new ArrayList<>();
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static ArrayList<Pet> pets = new ArrayList<>();

    public void removerPessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

    public void removerPet(Pet pet) {
        pets.remove(pet);
    }

    public void cadastrarPet(Pet pet) {
        pets.add(pet);
    }

    public Alimento procurarAlimento(int codigo) {
        for (Alimento alimento : alimentos) {
            if (alimento.getCodigo() == codigo) {
                return alimento;
            }
        }
        return null;
    }

    public Pessoa login(long cpf, String senha) {
        if (pessoas.size() != 0) {
            for (Pessoa pessoa : pessoas) {
                if (pessoa.getCpf() == cpf && pessoa.getSenha().equals(senha)) {
                    return pessoa;
                }
            }
        }
        return null;
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public Brincadeira procurarBrincadeira(int codigo) {
        for (Brincadeira brincadeira : brincadeiras) {
            if (brincadeira.getCodigo() == codigo) {
                return brincadeira;
            }
        }
        return null;
    }

    public Pet procurarPet(int codigo) {
        if (pets.size() != 0) {
            for (Pet pet : pets) {
                if (pet.getCodigo() == codigo) {
                    return pet;
                }
            }
        }
        return null;
    }

    public Pessoa procurarPessoa(long cpf) {
        if(pessoas.size()!=0){
            for (Pessoa pessoa : pessoas) {
                if (pessoa.getCpf() == cpf) {
                    return pessoa;
                }
            }
        }
        return null;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public  ArrayList<Brincadeira> getBrincadeiras() {
        return brincadeiras;
    }


    public ArrayList<Pet> getPets() {
        return pets;
    }
}
