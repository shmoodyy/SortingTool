import java.util.EnumSet;
import java.util.Scanner;

public class Main {

    enum Alphabets {
        A, B, E, O, T, U, L, I
    }

    EnumSet<Alphabets> enumSet;

    public static void main(String[] args) {
        Main object = new Main();

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine().trim();

        // Change Code below this line
        switch (string) {
            case "setOfVowels" ->  object.enumSet = EnumSet.of(Alphabets.A, Alphabets.E, Alphabets.I, Alphabets.O, Alphabets.U);
            case "setOfConsonants" ->  object.enumSet = EnumSet.of(Alphabets.B, Alphabets.L, Alphabets.T);
            case "containsAOnly" ->  object.enumSet = EnumSet.of(Alphabets.A);
            case "empty" ->  object.enumSet = EnumSet.noneOf(Alphabets.class);
            case "exceptT-A-E" ->  object.enumSet = EnumSet.complementOf(EnumSet.of(Alphabets.T, Alphabets.A, Alphabets.E));
            default ->  System.out.println("ERROR");
        }
        System.out.println(object.enumSet);
        // Change the code above this line
    }
}