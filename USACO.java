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

    //Creates an integer array to store the field
    String[] line = lines.get(0).split(" ");
    int[][] field = new int[Integer.parseInt(line[0])][Integer.parseInt(line[1])];
    int finalElevation = Integer.parseInt(line[2]);
    lines.remove(0);
    for (int i = 0; i < field.length; i++) {
      line = lines.get(0).split(" ");
      for (int j = 0; j < field[0].length; j++) {
        field[i][j] = Integer.parseInt(line[j]);
      }
      //Removes lines so that the ArrayList only contains stomp instructions
      lines.remove(0);
    }
    //System.out.println(Arrays.toString(field));

    //Goes through all given stomp instructions in file
    for (int i = 0; i < lines.size(); i++) {
      line = lines.get(i).split(" ");
      stomp(field, Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
      //System.out.println(Arrays.toString(field));
    }

    //For each square, subtract from finalElevation and add to total
    int total = 0;
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[i].length; j++) {
        if (field[i][j] < finalElevation) {
          total += finalElevation - field[i][j];
        }
      }
    }
    return total * 72 * 72;
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

    //Creates a char array to store the field
    String[] line = lines.get(0).split(" ");
    char[][] field = new char[Integer.parseInt(line[0])][Integer.parseInt(line[1])];
    int steps = Integer.parseInt(line[2]);
    lines.remove(0);
    //Filling array
    String l;
    for (int i = 0; i < field.length; i++) {
      l = lines.get(0);
      for (int j = 0; j < field[0].length; j++) {
        field[i][j] = l.charAt(j);
      }
      //Removes lines so that the ArrayList only contains stomp instructions
      lines.remove(0);
    }
    System.out.println(Arrays.deepToString(field));
    //Storing coordinates
    line = lines.get(0).split(" ");
    int startR = Integer.parseInt(line[0]) - 1;
    int startC = Integer.parseInt(line[1]) - 1;
    int endR = Integer.parseInt(line[2]) - 1;
    int endC = Integer.parseInt(line[3]) - 1;

    return 0;
  }

  public static void main(String[] args) {
    /*
    String[] bronzeFiles = {"makelake.1.in", "makelake.2.in", "makelake.3.in", "makelake.4.in", "makelake.5.in"};
    int[] bronzeAns = {342144, 102762432, 1058992704, 753121152, 1028282688};
    for (int i = 0; i < 5; i++) {
      if (bronze(bronzeFiles[i]) == bronzeAns[i]) {
        System.out.println("Bronze test " + (i + 1) + " passed");
      }
    }
    */

    silver("ctravel.1.in");
  }
}
