import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println(dnaToRna("GRUT"));
        System.out.println(makeUpperCase("hUqmIqNkO"));
        System.out.println(rps("paper", "rock"));
        System.out.println(greet("danish"));
        System.out.println(switchItUp(7));
        System.out.println(updateLight("green"));
        System.out.println(Arrays.toString(humanYearsCatYearsDogYears(12)));
        System.out.println(toJadenCase("once upon a time in america"));
    }

    public static String dnaToRna(String dna) {
        String text = dna.replaceAll("\\s", "").toUpperCase();
        String rna = text.replaceAll("T", "U");

        return rna;  // Do your magic!
    }

    public static String makeUpperCase(String str){
        return str.toUpperCase();
    }

    public static String rps(String p1, String p2) {
        String player1 = p1.toLowerCase();
        String player2 = p2.toLowerCase();

        if (player1.length() == player2.length()) {
            return "draw";
        }

        if ((player1.equals("rock") && player2.equals("scissors")) ||
                (player1.equals("scissors") && player2.equals("paper")) ||
                (player1.equals("paper") && player2.equals("rock"))) {
            return "player1 wins";
        } else {
            return "player2 wins";
        }
    }

    public static String greet(String language){
        Map<String, String> db = new HashMap<>() {{
            put("english", "Welcome");
            put("czech", "Vitejte");
            put("danish", "Velkomst");
            put("dutch", "Welkom");
            put("estonian", "Tere tulemast");
            put("finnish", "Tervetuloa");
            put("flemish", "Welgekomen");
            put("french", "Bienvenue");
            put("german", "Willkommen");
            put("irish", "Failte");
            put("italian", "Benvenuto");
            put("latvian", "Gaidits");
            put("lithuanian", "Laukiamas");
            put("polish", "Witamy");
            put("spanish", "Bienvenido");
            put("swedish", "Valkommen");
            put("welsh", "Croeso");
        }};

        String input = language.toLowerCase();
        String greet = db.get(input);

        if (greet == null) {
            greet = db.get("english");
        }

        return greet;

        // Smarter Solution
        //return db.getOrDefault(language, db.get("english"));
    }

    public static String switchItUp(int number) {
        Map<Integer, String> db = new HashMap<>();
        db.put(0, "Zero");
        db.put(1, "One");
        db.put(2, "Two");
        db.put(3, "Three");
        db.put(4, "Four");
        db.put(5, "Five");
        db.put(6, "Six");
        db.put(7, "Seven");
        db.put(8, "Eight");
        db.put(9, "Nine");

        return db.get(number);
    }

    public static String updateLight(String current) {
        Map<String, String> tl = new HashMap<>();
        tl.put("green", "yellow");
        tl.put("yellow", "red");
        tl.put("red", "green");
        return tl.get(current);
    }

    public static int[] humanYearsCatYearsDogYears(final int humanYears) {

        int catYears;
        int dogYears;

        if (humanYears == 1) {
            catYears = 15;
            dogYears = 15;
        } else if (humanYears == 2) {
            catYears = 15 + 9;
            dogYears = 15 + 9;
        } else {
            catYears = 15 + 9 + (humanYears - 2) * 4;
            dogYears = 15 + 9 + (humanYears - 2) * 5;
        }

        return new int[]{humanYears, catYears, dogYears};
    }

    public static String toJadenCase(String phrase) {

        String[] text = phrase.split(" ");

        StringBuilder result = new StringBuilder();

        for (String t : text) {
            String temp = t.substring(0, 1).toUpperCase() + t.substring(1);
            result.append(temp).append(" ");
        }
        
        return result.toString().trim();

        // Smart ass solution
        //return Arrays.stream(phrase.split(" "))
        //        .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
        //        .collect(Collectors.joining(" "));

        //return WordUtils.capitalize(phrase);
    }
}