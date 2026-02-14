import java.util.Scanner;
import model.*;


public class CadastroPOO {

    public static void main(String[] args) {

        // Procedimento 1
        /*
        try {
            
            System.out.println("Dados de Pessoa Fisica Armazenados.");
            System.out.println("Dados de Pessoa Fisica Recuperados.");

            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "Ana", "11111111111", 25));
            repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));
            repo1.persistir("pessoasFisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoasFisicas.dat");

            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
            }
            
            System.out.println("Dados de Pessoa Juridica Armazenados.");
            System.out.println("Dados de Pessoa Juridica Recuperados.");

            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1, "XPTO Sales", "33333333333333"));
            repo3.inserir(new PessoaJuridica(2, "XPTO Solutions", "44444444444444"));
            repo3.persistir("pessoasJuridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoasJuridicas.dat");

            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        */
        
        
        // Procedimento 2
        
                Scanner sc = new Scanner(System.in);

        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao;

        do {
            System.out.println("\n================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("================");


            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1: // INCLUIR
                    System.out.print("F - Fisica | J - Juridica: \n");
                    String tipo = sc.nextLine();

                    if (tipo.equalsIgnoreCase("F")) {

                        System.out.print("Digite o id da pessoa: \n");
                        int id = sc.nextInt();
                        sc.nextLine();
                        
                        System.out.print("Insira os dados...\n");

                        System.out.print("Nome: \n");
                        String nome = sc.nextLine();

                        System.out.print("CPF: \n");
                        String cpf = sc.nextLine();

                        System.out.print("Idade: \n");
                        int idade = sc.nextInt();

                        repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));

                    } else {

                        System.out.print("Digite o id da pessoa: \n");
                        int id = sc.nextInt();
                        sc.nextLine();
                        
                        System.out.print("Insira os dados...\n");

                        System.out.print("Nome: \n");
                        String nome = sc.nextLine();

                        System.out.print("CNPJ: \n");
                        String cnpj = sc.nextLine();

                        repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                    }

                    break;

                case 2: // ALTERAR
                    System.out.print("F - Fisica | J - Juridica: \n");
                    tipo = sc.nextLine();

                    System.out.print("ID: ");
                    int idAlt = sc.nextInt();
                    sc.nextLine();

                    if (tipo.equalsIgnoreCase("F")) {

                        PessoaFisica pf = repoFisica.obter(idAlt);

                        if (pf != null) {
                            pf.exibir();

                            System.out.print("Novo Nome: \n");
                            String nome = sc.nextLine();

                            System.out.print("Novo CPF: \n");
                            String cpf = sc.nextLine();

                            System.out.print("Nova Idade: \n");
                            int idade = sc.nextInt();

                            repoFisica.alterar(new PessoaFisica(idAlt, nome, cpf, idade));
                        }

                    } else {

                        PessoaJuridica pj = repoJuridica.obter(idAlt);

                        if (pj != null) {
                            pj.exibir();

                            System.out.print("Novo Nome: \n");
                            String nome = sc.nextLine();

                            System.out.print("Novo CNPJ: \n");
                            String cnpj = sc.nextLine();

                            repoJuridica.alterar(new PessoaJuridica(idAlt, nome, cnpj));
                        }
                    }

                    break;

                case 3: // EXCLUIR
                    System.out.print("F - Fisica | J - Juridica: \n");
                    tipo = sc.nextLine();

                    System.out.print("ID: ");
                    int idExc = sc.nextInt();

                    if (tipo.equalsIgnoreCase("F")) {
                        repoFisica.excluir(idExc);
                    } else {
                        repoJuridica.excluir(idExc);
                    }

                    break;

                case 4: // OBTER POR ID
                    System.out.print("F - Física | J - Jurídica: \n");
                    tipo = sc.nextLine();

                    System.out.print("ID: \n");
                    int idOb = sc.nextInt();

                    if (tipo.equalsIgnoreCase("F")) {
                        PessoaFisica pf = repoFisica.obter(idOb);
                        if (pf != null) pf.exibir();
                    } else {
                        PessoaJuridica pj = repoJuridica.obter(idOb);
                        if (pj != null) pj.exibir();
                    }

                    break;

                case 5: // OBTER TODOS
                    System.out.print("F - Fisica | J - Juridica: \n");
                    tipo = sc.nextLine();

                    if (tipo.equalsIgnoreCase("F")) {
                        for (PessoaFisica pf : repoFisica.obterTodos()) {
                            pf.exibir();
                        }
                    } else {
                        for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                            pj.exibir();
                        }
                    }

                    break;

                case 6: // SALVAR
                    System.out.print("Prefixo do arquivo: \n");
                    String prefixo = sc.nextLine();

                    try {
                        repoFisica.persistir(prefixo + ".fisica.bin");
                        repoJuridica.persistir(prefixo + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar: " + e.getMessage());
                    }

                    break;

                case 7: // RECUPERAR
                    System.out.print("Prefixo do arquivo: \n");
                    prefixo = sc.nextLine();

                    try {
                        repoFisica.recuperar(prefixo + ".fisica.bin");
                        repoJuridica.recuperar(prefixo + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar: " + e.getMessage());
                    }

                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opçao invalida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
