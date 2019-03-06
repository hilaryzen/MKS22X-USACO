import java.util.*;
import java.io.*;

public class USACO {
  private static ArrayList<String> fileReader(String filename) {
    ArrayList<String> lines = new ArrayList<String>();
    try {
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      while (inf.hasNextLine()) {
        lines.add(inf.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Invalid file: " + filename);
    }
    return lines;
  }

  //Bronze Problem 12: Lake Making
  public static int bronze(String filename) {
    ArrayList<String> lines = fileReader(filename);
    System.out.println(lines);
    return 0;
  }

  public static int silver(String filename) {
    ArrayList<String> lines = fileReader(filename);
    return 0;
  }

  public static void main(String[] args) {
    bronze("makelake.1.in");
  }
}
