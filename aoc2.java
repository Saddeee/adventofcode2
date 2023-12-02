import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class aoc2 {

    public static void main(String[] args) {
        System.out.println(aoc2());
    }

    public static int aoc2() {
        int summa = 0;
        try {
            BufferedReader file = new BufferedReader(new FileReader("text.txt"));

            String line;
            int red = 12;
            int green = 13;
            int blue = 14;
            while ((line = file.readLine()) != null) {
                boolean rad = true;
                boolean gren = true;
                boolean blu = true;
                String[] games = line.split(":");
                String[] grops = games[1].split(";");
                for (String string : grops) {
                    String[] grops2 = string.split(",");
                    for (String color : grops2) {
                        color = color.trim();
                        String[] num = color.split(" ");
                        // System.out.println(color);
                        if (color.contains("red") && Integer.parseInt(num[0]) > red) {
                            System.out.println(num[0] + " röd");
                            rad = false;

                        } else if (color.contains("blue") && Integer.parseInt(num[0]) > blue) {
                            System.out.println(num[0] + " blå");
                            blu = false;

                        } else if (color.contains("green") && Integer.parseInt(num[0]) > green) {
                            System.out.println(num[0] + " grön");
                            gren = false;
                        }

                    }
                }
                if (rad && blu && gren && blu) {
                    summa += Integer.parseInt(String.valueOf(games[0].charAt(games[0].length() - 1)));
                }
            }
            file.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return summa;
    }
}
