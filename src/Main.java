package src;

import src.domain.Endereco;
import src.domain.Pet;
import src.domain.SexoPet;
import src.domain.TipoPet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    static Scanner terminalInput = new Scanner(System.in);

    public static void showMainMenu() {
        System.out.println("========================== Sistema de Adoção de Pets ==========================");
        System.out.println("[1] - Cadastrar novo pet.");
        System.out.println("[2] - Atualizar dados de um pet.");
        System.out.println("[3] - Deletar um pet cadastrado.");
        System.out.println("[4] - Listar todos os pets cadastrados.");
        System.out.println("[5] - Listar pets por algum critério (idade, nome, raça).");
        System.out.println("[6] - Sair.");

        System.out.println("\n");
        System.out.print("Digite o número da opção desejada: ");
    }

    public static Pet saveNewPet() {

        terminalInput.nextLine();

        int index = 0;
        String nome = "";
        TipoPet tipo = null;
        SexoPet sexo = null;
        Endereco endereco = null;
        double idade = 0.0;
        double peso = 0.0;
        String raca = "";

        final String NAO_INFORMADO = "NÃO INFORMADO";


        try {
            File file = new File("src/assets/formulario.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());

                switch (index) {
                    case 0:
                        System.out.print("Digite o nome e sobrenome: ");
                        while (true) {
                            try {
                                Pattern pattern = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
                                nome = terminalInput.nextLine();
                                if (nome.isBlank()) {
                                    nome = NAO_INFORMADO;
                                    break;
                                }
                                if (nome.split(" ").length != 2) {
                                    throw new IllegalArgumentException("Deve ser informado (apenas) o nome e sobrenome. Digite novamente: ");
                                }
                                if (pattern.matcher(nome).find()) {
                                    throw new IllegalArgumentException("O nome deve conter apenas letras e espaços. Digite novamente: ");
                                }
                                break;
                            } catch (IllegalArgumentException error) {
                                System.out.print(error.getMessage());
                            }
                        }
                        break;
                    case 1:
                        System.out.println("[1] - Cachorro");
                        System.out.println("[2] - Gato");

                        while (true) {
                            try {
                                String userInput = terminalInput.nextLine();
                                if (userInput.isBlank()) {
                                    tipo = TipoPet.NAO_INFORMADO;
                                    break;
                                }
                                int input = Integer.parseInt(userInput);
                                tipo = switch (input) {
                                    case 1 -> TipoPet.CACHORRO;
                                    case 2 -> TipoPet.GATO;
                                    default ->
                                            throw new IllegalArgumentException("Opção inválida. Por favor, digite: \n [1] - Cachorro \n [2] - Gato. ");
                                };
                                break;
                            } catch (NumberFormatException error) {
                                System.out.println("Opção inválida. Por favor, digite 1 ou 2.");
                                System.out.println("[1] - Cachorro");
                                System.out.println("[2] - Gato");
                            } catch (IllegalArgumentException error) {
                                System.out.print(error.getMessage());
                            }
                        }
                        break;
                    case 2:
                        System.out.println("[1] - Macho");
                        System.out.println("[2] - Fêmea");

                        while (true) {
                            try {
                                int input = Integer.parseInt(terminalInput.nextLine());
                                sexo = switch (input) {
                                    case 1 -> SexoPet.MACHO;
                                    case 2 -> SexoPet.FEMEA;
                                    default ->
                                            throw new IllegalArgumentException("Opção inválida. Por favor, digite: \n [1] - Macho \n [2] - Fêmea. ");
                                };
                                break;
                            } catch (NumberFormatException error) {
                                System.out.println("Opção inválida. Por favor, digite 1 ou 2: ");
                                System.out.println("[1] - Macho");
                                System.out.println("[2] - Fêmea");
                            } catch (IllegalArgumentException error) {
                                System.out.print(error.getMessage());
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Digite o nome da cidade: ");
                        String cidade = terminalInput.nextLine();
                        System.out.print("Digite o nome da rua: ");
                        String rua = terminalInput.nextLine();
                        System.out.print("Digite o número da casa: ");
                        String numeroCasa = terminalInput.nextLine();

                        while (true) {
                            try {
                                int numero = Integer.parseInt(numeroCasa);
                                endereco = new Endereco(numero, rua, cidade);
                                break;
                            } catch (NumberFormatException error) {
                                System.out.print("Por favor, digite um número inteiro válido para o número da casa: ");
                                numeroCasa = terminalInput.nextLine();
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Digite a idade: ");
                        while (true) {
                            try {
                                String userInput = terminalInput.nextLine();
                                idade = Double.parseDouble(terminalInput.nextLine().replace(",", "."));
                                if (idade < 0 || idade > 20) {
                                    throw new IllegalArgumentException("Idade deve estar entre 0 e 20 anos. Digite novamente: ");
                                }
                                break;
                            } catch (NumberFormatException error) {
                                System.out.print("Por favor, digite um número inteiro válido: ");
                            } catch (IllegalArgumentException error) {
                                System.out.print(error.getMessage());
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Digite o peso: ");
                        while (true) {
                            try {
                                peso = Double.parseDouble(terminalInput.nextLine().replace(",", "."));
                                if (peso < 0.5 || peso > 60) {
                                    throw new IllegalArgumentException("Peso deve estar entre 0.5 e 60 kg. Digite novamente: ");
                                }
                                break;
                            } catch (NumberFormatException error) {
                                System.out.print("Por favor, digite um número válido: ");
                            } catch (IllegalArgumentException error) {
                                System.out.print(error.getMessage());
                            }
                        }
                        break;
                    case 6:
                        System.out.print("Digite a raça: ");
                        Pattern pattern = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
                        while (true) {
                            try {
                                raca = terminalInput.nextLine();
                                if (pattern.matcher(raca).find()) {
                                    throw new IllegalArgumentException("A raça deve conter apenas letras e espaços. Digite novamente: ");
                                }
                                break;
                            } catch (IllegalArgumentException error) {
                                System.out.print(error.getMessage());
                            }
                        }
                        break;
                }
                index++;
            }
        } catch (FileNotFoundException error) {
            System.out.println("Arquivo de formulário não encontrado.");
        }

        return new Pet(nome, tipo, sexo, endereco, idade, peso, raca);
    }

    public static Pet handleUserInput(int userInput) {
        switch (userInput) {
            case 1:
                return saveNewPet();
            case 2:
                System.out.println("Atualizar dados de um pet.");
                break;
            case 3:
                System.out.println("Deletar um pet cadastrado.");
                break;
            case 4:
                System.out.println("Listar todos os pets cadastrados.");
                break;
            case 5:
                System.out.println("Listar pets por algum critério (idade, nome, raça).");
                break;
            case 6:
                System.out.println("Sair.");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        return null;
    }

    public static void main(String[] args) {

        Pet pet = null;

        int userInput = 0;
        boolean isValidInput = false;

        do {
            showMainMenu();
            try {
                userInput = terminalInput.nextInt();
                isValidInput = true;
            } catch (InputMismatchException error) {
                System.out.println("Entrada inválida. Por favor, digite um número entre 1 e 6.");
                terminalInput.next();
            }
        } while (!isValidInput || userInput < 1 || userInput > 6);

        pet = handleUserInput(userInput);
        pet.showDetails();

    }
}
