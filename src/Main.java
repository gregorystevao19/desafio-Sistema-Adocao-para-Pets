package src;

import src.domain.Pet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    public static void saveNewPet(Pet pet) {

        int index = 0;
        String nome = "";
        String tipo = "";
        String sexo = "";
        String endereço = "";
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
                        nome = terminalInput.nextLine();
                        terminalInput.next();
                        break;
                    case 1:
                        tipo = terminalInput.nextLine();
                        terminalInput.next();
                        break;
                    case 2:
                        sexo = terminalInput.nextLine();
                        terminalInput.next();
                        break;
                    case 3:
                        endereço = terminalInput.nextLine();
                        terminalInput.next();
                        break;
                    case 4:
                        idade = terminalInput.nextInt();
                        terminalInput.next();
                        break;
                    case 5:
                        peso = terminalInput.nextDouble();
                        terminalInput.next();
                        break;
                    case 6:
                        raca = terminalInput.nextLine();
                        terminalInput.next();
                        break;
                }
                index++;
            }
        } catch (FileNotFoundException error) {
            System.out.println("Arquivo de formulário não encontrado.");
        }

        pet = new Pet(nome, tipo, sexo, endereço, idade, peso, raca);
    }

    public static void handleUserInput(int userInput, Pet pet) {
        switch (userInput) {
            case 1:
                saveNewPet(pet);
                break;
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
    }

    public static void main(String[] args) {

        int userInput = 0;
        Pet pet = null;
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

        handleUserInput(userInput, pet);
        System.out.println(pet.getPeso());

    }
}
