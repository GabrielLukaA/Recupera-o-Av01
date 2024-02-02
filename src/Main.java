import java.util.Scanner;

public class Main {

    static Banco banco = new Banco();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            menu();
        } while (true);


    }

    private static void menu() {
        System.out.println("""
                Seja bem vindo!!
                                
                O que você deseja fazer?
                1 - Se cadastrar
                2 - Fazer login
                                
                """);
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> {
                cadastro();
            }
            case 2 -> {
                login();
            }
            case 0 -> System.exit(0);
            default -> {
                System.out.println("Insira novamente, número inválido!");
            }
        }
    }

    private static void login() {
        boolean logado = false;
        Pessoa pessoaLogada = null;
        do {
            System.out.println("Informe o seu cpf: ");
            long cpf = sc.nextLong();
            System.out.println("Informe a sua senha: ");
            String senha = sc.next();
            pessoaLogada = banco.login(cpf, senha);
            if (pessoaLogada != null) {
                logado = true;
            }
        } while (logado != true);
        telaInicial(pessoaLogada);

    }

    private static void telaInicial(Pessoa pessoa) {
        boolean logado = true;
        do {
            System.out.println("""
                    O que você deseja fazer?
                    1 - Cadastrar um pet
                    2 - Adotar/Trocar pet
                    3 - Remover um pet
                    4 - Brincar com pet
                    5 - Alimentar seu pet
                    6 - Dar água ao seu pet
                    7 - Levar pet para fazer necessidades
                    8 - Botar pet para dormir
                    9 - Acordar pet
                    10 - Limpar pet
                    11 - Avaliação do pet
                    12 - Remover Conta
                    13 - Logout
                    """);
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1 -> {
                    cadastrarPet(pessoa);
                }
                case 2 -> {
                    adotarPet(pessoa);
                }
                case 3 -> {
                    removerPet(pessoa);
                }
                case 4 -> {
                    brincar(pessoa);
                }
                case 5 -> {
                    alimentar(pessoa);
                }
                case 6 -> {
                    pessoa.darAguaParaPet();
                    System.out.println("Seu pet se hidratou.");
                }
                case 7 -> {
                    pessoa.levarPetParaFazerNecessidades();
                    System.out.println("Seu pet fez suas necessidades.");
                }
                case 8 -> {
                    pessoa.botaPetParaDormir();
                    System.out.println("Seu pet foi colocado para dormir");
                }
                case 9 -> {
                    pessoa.acordarPet();
                    System.out.println("Seu pet foi acordado");
                }
                case 10 -> {
                    pessoa.limparPet();
                    System.out.println("Seu pet foi limpo");
                }
                case 11 -> {
                    System.out.println("Veja seu pet:");
                    System.out.println(pessoa.avaliarPet());

                }

                case 12 -> {
                    banco.removerPessoa(pessoa);
                    logado = false;
                    System.out.println("Conta deletada com sucesso!");
                }


                case 13 -> {
                    logado = false;
                    System.out.println("Logout realizado com sucesso.");
                }

            }
        } while (logado);


    }

    private static void cadastrarPet(Pessoa pessoaLogada) {
        System.out.println("Apenas nos informe o nome do pet:");
        banco.cadastrarPet(new Pet(sc.next()));
    }

    private static void adotarPet(Pessoa pessoaLogada) {
        for (Pet pet : banco.getPets()) {
            System.out.println(pet);
            System.out.println("\n\n");
        }
        System.out.println("Informe o código do pet desejado: ");
        int escolhaPet = sc.nextInt();

        Pet pet = banco.procurarPet(escolhaPet);

        if (pet != null) {
            pessoaLogada.adotarPet(pet);
            System.out.println("Pet adotado com sucesso!");
        } else {
            System.out.println("Não existe um pet com esse código no sistema.");
        }

    }


    private static void removerPet(Pessoa pessoaLogada) {
        for (Pet pet : banco.getPets()) {
            System.out.println(pet);
            System.out.println("\n\n");
        }
        System.out.println("Informe o código do pet que deseja remover: ");
        int escolhaPet = sc.nextInt();

        Pet pet = banco.procurarPet(escolhaPet);

        if (pet != null) {
            banco.removerPet(pet);
            System.out.println("Pet removido com sucesso!");
        } else {
            System.out.println("Não existe um pet com esse código no sistema.");
        }

    }

    private static void alimentar(Pessoa pessoaLogada) {
        for (Alimento alimento : banco.getAlimentos()) {
            System.out.println(alimento.getCodigo() + " - " + alimento.getNome());
        }
        int escolha = sc.nextInt();
        switch (escolha) {
            case 1, 2, 3 -> {
                pessoaLogada.alimentarPet(banco.procurarAlimento(escolha));
                System.out.println("Seu pet foi alimentado");
            }
            default -> {
                System.out.println("Escolha uma opção válida por favor!");
            }
        }
    }

    private static void brincar(Pessoa pessoaLogada) {
        System.out.println("Escolha uma brincadeira: ");
        for (Brincadeira brincadeira : banco.getBrincadeiras()) {
            System.out.println(brincadeira.getCodigo() + " - " + brincadeira.getNome());
        }
        int escolha = sc.nextInt();
        switch (escolha) {
            case 1, 2, 3 -> {
                pessoaLogada.brincarComPet(banco.procurarBrincadeira(escolha));
                System.out.println("Seu pet se divertiu muito");
            }
            default -> {
                System.out.println("Escolha uma opção válida por favor!");
            }
        }
    }

    private static void cadastro() {

        System.out.println("Informe o seu cpf:");
        long cpf = sc.nextLong();
        System.out.println("Informe o seu nome:");
        String nome = sc.next();
        System.out.println("Informe a sua senha:");
        String senha = sc.next();

        Pessoa pessoa = banco.procurarPessoa(cpf);
        if (pessoa == null) {
            banco.cadastrarPessoa(new Pessoa(cpf, nome, senha));

        } else {
            System.out.println("Você já está cadastrado, faça login!");
        }


    }
}