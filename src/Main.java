package src;

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
        String endereco = "";
        int idade = 0;
        double peso = 0.0;
        String raca = "";


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
                                if (nome.split(" ").length < 2) {
                                    throw new IllegalArgumentException("Deve ser informado o nome e sobrenome.");
                                }
                                if (pattern.matcher(nome).find()) {
                                    throw new IllegalArgumentException("O nome deve conter apenas letras e espaços.");
                                }
                                break;
                            }
                            catch (IllegalArgumentException error) {
                                System.out.print("Por favor, digite um nome completo (nome e sobrenome) válido (Sem caracters especiais): ");
                            }
                        }
                        break;
                    case 1:
                        System.out.println("[1] - Cachorro");
                        System.out.println("[2] - Gato");

                        while (true) {
                            try {
                                int input = Integer.parseInt(terminalInput.nextLine());
                                switch (input) {
                                    case 1:
                                        tipo = TipoPet.CACHORRO;
                                        break;
                                    case 2:
                                        tipo = TipoPet.GATO;
                                        break;
                                    default:
                                        throw new NumberFormatException("Opção inválida. Por favor, digite 1 ou 2.");
                                }
                                break;
                            } catch (IllegalArgumentException error) {
                                System.out.print(error.getMessage());
                            }
                            break;
                        }
                        break;
                    case 2:
                        System.out.println("[1] - Macho");
                        System.out.println("[2] - Fêmea");

                        String userInput = terminalInput.nextLine();

                        while (true){
                            try {
                                int input = Integer.parseInt(userInput);
                                switch (input) {
                                    case 1:
                                        sexo = SexoPet.MACHO;
                                        break;
                                    case 2:
                                        sexo = SexoPet.FEMEA;
                                        break;
                                    default:
                                        throw new NumberFormatException("Opção inválida. Por favor, digite 1 ou 2.");
                                }
                            }
                            catch (NumberFormatException error) {
                                System.out.print(error.getMessage());
                            }
                            break;
                        }
                        break;
                    case 3:
                        System.out.print("Digite o endereço: ");
                        endereco = terminalInput.nextLine();
                        break;
                    case 4:
                        System.out.print("Digite a idade: ");
                        while (true) {
                            try {
                                idade = Integer.parseInt(terminalInput.nextLine());
                                break;
                            } catch (NumberFormatException error) {
                                System.out.print("Por favor, digite um número inteiro válido: ");
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Digite o peso: ");
                        while (true) {
                            try {
                                peso = Double.parseDouble(terminalInput.nextLine());
                                break;
                            } catch (NumberFormatException error) {
                                System.out.print("Por favor, digite um número válido: ");
                            }
                        }
                        break;
                    case 6:
                        System.out.print("Digite a raça: ");
                        raca = terminalInput.nextLine();
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

    }
}
