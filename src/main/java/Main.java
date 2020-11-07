import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;

        do
        {
            try
            {
                userInput = getUserInput(scanner);

                moduloUserInput(userInput);
                String doContinue = askForContinuation(scanner);

                if (doContinue.equalsIgnoreCase("n"))
                {
                    break;
                }

                if (doContinue.equalsIgnoreCase("y"))
                {
                    continue;
                }

                validateInput(scanner, doContinue);
            }
            catch (InputMismatchException exc)
            {
                System.out.println("Wrong input");
            }
        } while (true);
    }

    private static void validateInput(Scanner scanner, String doContinue)
    {
        if (!doContinue.equalsIgnoreCase("y") ||
                doContinue.isBlank() ||
                !doContinue.equalsIgnoreCase("n") ||
                scanner.hasNextInt())
        {
            System.out.println("Wrong input");
        }
    }

    private static String askForContinuation(Scanner scanner)
    {
        System.out.println("Continue? y/n");
        return scanner.next().strip();
    }

    private static int getUserInput(Scanner scanner)
    {
        int userInput;
        System.out.print("Input:");
        userInput = scanner.nextInt();

        return userInput;
    }

    private static void moduloUserInput(int userInput)
    {
        if ((userInput % 3 == 0) && userInput % 5 == 0)
        {
            System.out.println("FizzBuzz");
        }

        else if (userInput % 3 > 0 && userInput % 5 == 0)
        {
            System.out.println("Buzz");
        }

        else if (userInput % 3 == 0)
        {
            System.out.println("Fizz");
        }

        else
        {
            System.out.println("None");
        }
    }
}
