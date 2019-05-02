/* 

*/
package final_cameron;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author pc
 */
public class Final_cameron {
   
    /**
     * @param args the command line arguments
     */
    public static String main(String[] args) {
      long startTime= System.currentTimeMillis();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = keyboard.next();
        System.out.println("Would you like an explanation?");
        String yes = keyboard.next();
        if (yes.equals("Y") || yes.equals("y") || yes.equals("yes") || yes.equals("Yes")) {return "Controls";}
        boolean start = false;
        System.out.println("Hello, " + name + ", are you ready to begin your adventure? (Y/N)");
        yes = keyboard.next();
        if (yes.equals("Y") || yes.equals("y") || yes.equals("yes") || yes.equals("Yes")) { start = true;}
        while (!start){
            System.out.println("WHAT?! I don't believe I caught that, let me ask again.");
            System.out.println( "So, are you ready to begin your adventure? (Y/N)");
            yes = keyboard.next();
            if (yes.equals("Y") || yes.equals("y") || yes.equals("yes") || yes.equals("Yes")) { start = true;}
        }
        String[][] map = createMap();
        int row = 2;
        int col = 2;
        boolean finished = false;
        while (!finished){
            System.out.println("Where do you want to go?");
            String direction = keyboard.next();
            switch(direction)
            {
                case "north": 
                    if (checkValid(map, row-1, col)){
                        row-=1; 
                        //System.out.println(roomDescription(map[row][col]));
                    }else{
                        System.out.println("You ran into a strudy wall.");
                    }
                    break;
                case "south":
                    if (checkValid(map, row+1, col)){
                        row+=1; 
                        //System.out.println(roomDescription(map[row][col]));
                    }else{
                        System.out.println("You ran into a strudy wall.");
                    }
                    break;
                case "east":
                    if (checkValid(map, row, col+1)){
                        col+=1; 
                        //System.out.println(roomDescription(map[row][col]));
                    }else{
                        System.out.println("You ran into a strudy wall.");
                    }
                    break;
                case "west":
                    if (checkValid(map, row, col-1)){
                        col-=1; 
                       // System.out.println(roomDescription(map[row][col]));
                    }else{
                        System.out.println("You ran into a strudy wall.");
                    }
                    break;
                case "look":
                    System.out.println(roomDescription(map[row][col]));
                    if (map[row][col].equals("orb")){
                       map[row][col]= "room";
                   }else if (map[row][col].equals("triangle")){
                       map[row][col]= "room";
                   }else if (map[row][col].equals("box")){
                       map[row][col]= "room";
                   }
                    break;
                default:
                    System.out.println("You heard a little voice in your head telling you where to go, but you didn't understand it.");

            }
           
            if (row==2 && col==2){
                if (map[1][3].equals("room") && map[3][1].equals("room") && map[3][3].equals("room")){
                   finished = true;
                }
            }
        }
        long elapsedTime = System.currentTimeMillis()-startTime;
        long seconds = elapsedTime/1000;
        long secondsDisplay = seconds%60;
        long minutes = seconds/60;
        Writer writer = null;

try {
    writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("filename.txt"), "utf-8"));
    writer.write("Something");
} catch (IOException ex) {
    // Report
} finally {
   try {writer.close();} catch (Exception ex) {/*ignore*/}
}
        System.out.println("GG no re, fam " + minutes+" minutes and " + secondsDisplay+" seconds");
    } 
    public static String roomDescription(String room){
        switch(room){
            case "loud":
                return "You walk into a room with a humming so loud it is hard to concentrate.";
                
            case "room":
                return "Just a plain room... Better move on.";
            
            case "orb":
                return "You find a glowing green orb in the center of a room.\nIt must have some value so you take it.";
            case "small":
                return "A room with low ceilings and small furniture.\nPerhaps it was made for small people?";
            case "center":
                return "There is an stone slab with inscriptions at the center of the large room\nUpon further inspection the slab reads\n\"Bring the three objects to this room and you shall escape the dungeon\" ";
            case "triangle":
                return "There is a red glowing triangle at the center of the room\n(technically it is a tertrahedron, but who cares?)\nProbably useful, so you take it.";
            case "large":
                return "This is a fairly large room with large furniture.\nWhen did you climb the beanstalk?";
            case "box":
                return "There is a blue glowing box in the center of the room.\nYou take it, but you aren't sure why.";
            default: 
                return "Uhhhhhhhhh... did it work yet mom?";
        }
    }
    public static boolean checkValid(String[][] map, int row, int col){
       if (map[row][col].equals("wall")){
           return false;
       }else{ return true;}
    }
    public static String[][] createMap(){
        String[][] map = {
            {"wall", "wall","wall", "wall", "wall"},
            {"wall", "loud","room", "orb", "wall"},
            {"wall", "small","center", "room", "wall"},
            {"wall", "triangle","large", "box","wall"},
            {"wall", "wall","wall", "wall", "wall"}
        };
        return map;
    }
}
