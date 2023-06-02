import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class MyClass {
    
    
    public static void main(String args[]) {
        Set<String> validInputs = new HashSet<>();
        validInputs.add("Pawn");
        validInputs.add("King");
        validInputs.add("Queen");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your Chess piece :");
        String piece = (String)sc.nextLine(); //args[0]; 
        if(!validInputs.contains(piece)) {
            System.out.println("Invalid piece");
            return;
        }
        System.out.println("Please enter your Chess piece's Position :");
        String position = (String)sc.nextLine(); //args[1]; 
        boolean invalid = true;
        char row = 'Z';
        int col = 0;
        if(position.length() == 2) {
            row = position.charAt(0);
            if(row - 64 <=8) {
                col = position.charAt(1) - 48;
                if(col <= 8 && col > 0) {
                    invalid = false;
                }
            }
        }
        System.out.println(row+" :: "+col);
        if(invalid) {
            System.out.println("Invalid position");
            return;
        }
        if("Pawn".equals(piece)) {
            movePawn(row, col);
        } else if("King".equals(piece)) {
            moveKing(row-64, col);
        } else
            moveQueen(row-64, col);
    }
    
    public static void movePawn(char row, int column) {
        if(column != 8) {
            column++;
            System.out.println(row+""+column);
        } else {
            System.out.println("Invalid position");
        }
    }
    
    public static void moveKing(int row, int column) {
        int r = (row == 1)? row : row-1;
        int c = (column == 1)? column : column-1 ;
        System.out.println(row+" ## "+column);
        for(int i=r; i<= row+1 && i<=8; i++) {
            for(int j=c; j<=column+1 && j<=8; j++) {
                if(i != row || j != column)
                    System.out.print((char)(i+64)+""+j+" , ");
            }
        }
    }
    
    public static void moveQueen(int row, int column) {
        int d1Row = -1, d1Column = 1;
        int d2Row = 1, d2Column = -1;
        for(int i=1; i<=8; i++) {
            if(row != i)
            System.out.print((char)(i+64)+""+column+" , ");
            if(i-1 == row-column)
                d1Row = i;
        }
        for(int i=1; i<=8; i++) {
            if(column != i)
            System.out.print((char)(row+64)+""+i+" , ");
            if(1+i == row+column)
                d2Column = i;
        }
        while(d2Row < 9 && d2Column > 0 && d2Column <9) {
            if(row != d2Row || column != d2Column)
                System.out.print((char)(d2Row+64)+""+d2Column+" , ");
            d2Row++;
            d2Column--;
        }
        
        while(d1Row > 0 && d1Row < 9 && d1Column < 9) {
            if(row != d1Row || column != d1Column)
                System.out.print((char)(d1Row+64)+""+d1Column+" , ");
            d1Row++;
            d1Column++;
        }
    }
}
