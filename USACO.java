import java.util.*;
import java.io.*;

public class USACO {
  //Takes in filename and returns an ArrayList containing all the lines
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
    //System.out.println(lines);
    String[] line = lines[0].split(" ");
    int[][] field = new int[line[0]][line[1]];
    return 0;
  }

  private static void stomp(int[][] field, int row, int col, int depth) {
    int max = 0;
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (field[row + i][col + j] > max) {
          max = field[row + i][col + j];
        }
      }
    }
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (field[row + i][col + j] > max - depth) {
          field[row + i][col + j] = max - depth;
        }
      }
    }
  }

  public static int silver(String filename) {
    ArrayList<String> lines = fileReader(filename);
    return 0;
  }

  public static void main(String[] args) {
    bronze("makelake.2.in");
  }
}
