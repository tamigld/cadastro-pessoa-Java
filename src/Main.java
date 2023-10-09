import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        PessoaFisica metodosPf = new PessoaFisica();
        ArrayList<PessoaFisica> listaPf = new ArrayList<>();

        System.out.println("Bem-vindo ao sistema de cadastro de Pessosa Físicas e Jurídicas");

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do{
            System.out.println("Escolha uma opção: \n 1 - Pessoa Física \n 2- Pessoa Jurídica \n 0 - Sair ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    int opcaoPf;

                    do{
                        System.out.println("Escolha uma opção: \n 1 - Cadastrar Pessoa Física \n 2- Listar Pessoa Física \n 0 - Voltar ao menu anterior ");
                        opcaoPf = scanner.nextInt();

                        switch (opcaoPf){
                            case 1:
                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco novoEnderecoPf = new Endereco();

                                System.out.print("Digite o nome da pessoa física que deseja cadastrar: ");
                                novaPf.nome = scanner.next();

                                System.out.print("Digite o CPF: ");
                                novaPf.cpf =  scanner.next();

                                System.out.print("Digite o rendimento mensal (apenas números): ");
                                novaPf.rendimento = scanner.nextInt();

                                System.out.print("Digite o ano de nascimento (DD/MM/AA): ");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                              formatação de data
                                Period periodo = Period.between(date, LocalDate.now());
//                              período entre a data informada e data atual

                                novaPf.dataNasc = date;

                                if (periodo.getYears() >= 18){
                                    System.out.println("A pessoa é maior de idade.");
                                } else {
                                    System.out.println("A pessoa é menor de idade. \n Voltando ao menu anterior...");
                                    break;
                                }

                                System.out.print("Digite o logradouro: ");
                                novoEnderecoPf.logradouro = scanner.next();

                                System.out.print("Digite o número: ");
                                novoEnderecoPf.numero = scanner.next();

                                System.out.print("O endereço informado é comercial? \n Digite S para SIM \n N para NÃO \n");
                                String endCom;
                                endCom = scanner.next();

                                if(endCom.equals("S")){
                                    novoEnderecoPf.endComercial = true;
                                } else {
                                    novoEnderecoPf.endComercial = false;
                                }

                                novaPf.endereco = novoEnderecoPf;

                                listaPf.add(novaPf);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;

                            case 2:
                                if(!listaPf.isEmpty()){
                                    for(PessoaFisica cadaPf : listaPf){
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Endereço: " + cadaPf.endereco.logradouro + "," + cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento: " + cadaPf.dataNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Rendimento: " + cadaPf.rendimento);
                                        System.out.println("Imposto a ser pago: " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("Lista vazia.\n Voltando ao menu anterior.");
                                }

                                System.out.println("Fim da lista.");
                                break;

                            case 0:
                                System.out.println("Voltando ao menu anterior.");
                                break;

                            default:
                                System.out.println("Opção inválida. \n Insira uma opção VÁLIDA.");
                                break;
                        }
                    } while (opcaoPf != 0);

                case 2:
                    break;

                case 0:
                    System.out.println("Obrigado por utilizar o nosso sistema!");
                    break;

                default:
                    System.out.println("Opção inválida. \n Insira uma opção VÁLIDA.");
                    break;
            }
        } while (opcao != 0);
    }
}