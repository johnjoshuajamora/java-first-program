package com.h2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;

public class Finance {
    private static final Map<String, String> commandsToUsage = new HashMap<>();

    static {
        commandsToUsage.put("bestLoanRates", "usage: bestLoanRates");
        commandsToUsage.put("savingsCalculator", "usage: savingsCalculator <credits separated by ','> <debits separated by ','>");
        commandsToUsage.put("mortgageCalculator", "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>");
    }

    private static boolean validateCommandArguments(String[] args) {
        switch (args[0]) {
            case "bestLoanRates":
                return args.length == 1;
            case "savingsCalculator":
                return args.length == 3;
            case "mortgageCalculator":
                return args.length == 4;
            default:
                return false;
        }
    }

    private static void executeCommand(String command, String[] arguments) {
        switch(command) {
            case "bestLoanRates":
                System.out.println("Finding best loan rates ...");
                BestLoanRates.main(arguments);
                return;
            case "savingsCalculator":
                System.out.println("Finding your net savings ...");
                SavingsCalculator.main(arguments);
                return;
            case "mortgageCalculator":
                System.out.println("Finding your monthly payment ...");
                MortgageCalculator.main(arguments);
                return;
            default:
                return;
        }
    }

    public static void main(String[] args) {
        String command = args[0];

        if (!commandsToUsage.containsKey(command)) {
            System.out.println(command + ": command not found");
            return;
        }

        boolean isValidCommand = validateCommandArguments(args);

        if (!isValidCommand) {
            System.out.println(commandsToUsage.get(command));
            return;
        }

        executeCommand(command, Arrays.copyOfRange(args, 1, args.length));
    }
}
