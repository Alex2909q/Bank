package app;

import java.util.Scanner;
import functions.Client;
import functions.*;
import javax.persistence.*;


public class App {
    public static void main( String[] args ) {
        try (BankF func = new BankF()) {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    String choice = showMenu(scanner);
                    switch (choice) {
                        case "1" -> addNewClientAndNewAccount(func, scanner);
                        case "2" -> addNewAccountToClient(func, scanner);
                        case "3" -> depositByCurrencyType(func, scanner);
                        case "4" -> Transaction(func, scanner);
                        case "5" -> func.totalCashOnAccount(getClientName(func, scanner));
                        case "6" -> addRates(func);
                        default -> {
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String showMenu(Scanner scanner) {
        System.out.println("1: add new client");
        System.out.println("2: add new bank account ");
        System.out.println("3: deposit found to account");
        System.out.println("4: transfer money");
        System.out.println("5: get cash in UAH");
        System.out.println("6: add currency rates");
        System.out.println("Input your choice:");
        return scanner.nextLine();
    }
    private static void addNewClientAndNewAccount(BankF func, Scanner scanner) {
        System.out.println("Enter client name:");
        String clientName = scanner.nextLine();
        Client client = new Client(clientName);
        func.addNewClient(client);
        System.out.println("Do you want open new bank account:?");
        String choice2 = scanner.nextLine();
        if (choice2.equalsIgnoreCase("N")) {
            return;
        }
        choseTypeOfBankAccount(func, scanner, client);
    }


    private static void choseTypeOfBankAccount(BankF func, Scanner scanner, Client client) {
        System.out.println("Chose currency :");
        System.out.println("1: USD");
        System.out.println("2: EUR");
        System.out.println("3: UAH");
        String currencyType = scanner.nextLine();
        switch (currencyType) {
            case "1" -> {
                System.out.println("Enter the sum");
                String amount = scanner.nextLine();
                func.addNewBankAccount(client, Currency.USD, Double.parseDouble(amount));
            }
            case "2" -> {
                System.out.println("Enter the sum");
                String amount = scanner.nextLine();
                func.addNewBankAccount(client, Currency.EUR, Double.parseDouble(amount));
            }
            case "3" -> {
                System.out.println("Enter the sum");
                String amount = scanner.nextLine();
                func.addNewBankAccount(client, Currency.UAH, Double.parseDouble(amount));
            }
        }
    }
    private static void addNewAccountToClient(BankF func, Scanner scanner) {
        Client client = getClientName(func, scanner);
        choseTypeOfBankAccount(func, scanner, client);
    }

    private static Client getClientName(BankF func, Scanner scanner) {
        System.out.println("Enter client name:");
        String clientName = scanner.nextLine();
        return func.getClientByName(clientName);
    }
    private static void depositByCurrencyType(BankF func, Scanner scanner) {
        Client client = getClientName(func, scanner);
        System.out.println("""
                1: UAH
                2: USD
                3: EUR
                Enter currency""");
        String currencyType = scanner.nextLine();
        System.out.println("Enter the sum:");
        String amount = scanner.nextLine();
        switch (currencyType) {
            case "1" -> func.deposit(client, Double.parseDouble(amount), Currency.UAH);
            case "2" -> func.deposit(client, Double.parseDouble(amount), Currency.USD);
            case "3" -> func.deposit(client, Double.parseDouble(amount), Currency.EUR);
        }
    }
    private static void Transaction(BankF func, Scanner scanner) {
        Client client = getClientName(func, scanner);
        System.out.println("From which account to which do tou want transfer?");
        System.out.println("From:");
        Account from = chooseCurrency(func, scanner, client);
        System.out.println("To:");
        Account to = chooseCurrency(func, scanner, client);
        System.out.println("Enter the amount:");
        String amount = scanner.nextLine();
        func.transaction(from, to, Double.parseDouble(amount),func.getCurrencyRates());
    }

    private static Account chooseCurrency(BankF func, Scanner scanner, Client client) {
        Account from = null;
        System.out.println("""
                1: UAH
                2: USD
                3: EUR""");
        String choiceFrom = scanner.nextLine();
        switch (choiceFrom) {
            case "1" -> from = func.getAccount(client, Currency.UAH);
            case "2" -> from = func.getAccount(client, Currency.USD);
            case "3" -> from = func.getAccount(client, Currency.EUR);
        }
        return from;
    }

    private static void addRates(BankF func) {
        func.addRates(Currency.UAH, 1.0);
        func.addRates(Currency.USD, 37.45);
        func.addRates(Currency.EUR, 40.3);
    }


    }



