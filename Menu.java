import java.util.Scanner;
public class Menu {
    Scanner scan=new Scanner(System.in);
    //Print Menu.
    private void printmenu(){
        System.out.println("     Welcome to the chess-like");
        System.out.println("     Please choose an option");
        System.out.println("1) New Game");
        System.out.println("2) Game Hint");
        System.out.println("3) Developers Information");
        System.out.println("0) Exit");
    }
    //Select Menu Options.
    public void selectmenu(){
       int selection=scan.nextInt();
        switch (selection){
            case 1: {
                System.out.println("Player 1, What's your name? :) ");
				scan.nextLine();
				String p1=scan.nextLine();
                System.out.println("Player 2, What's your name? :) ");
				String p2=scan.nextLine();
                int rows,columns;
                System.out.print("Please enter rows(Please enter an odd number bigger than 5): ");
                rows=scan.nextInt();
                System.out.print("Please enter columns(Please enter an odd number bigger than 5): ");
                columns=scan.nextInt();
				Log log=new Log();
				log.writeln("player 1: "+p1);
				log.writeln("player 2: "+p2);
                Gameboard gameboard=new Gameboard(rows,columns,log);
                Move game=new Move(gameboard,p1.toUpperCase(),p2.toUpperCase(),log);
				
				System.out.println("Do you want to keep your gameLog? (y/n)");	
				scan.nextLine();
				String s=scan.nextLine();
				if(s.equalsIgnoreCase("y") && log.file.exists())
					System.out.println("your GameLog saved in "+log.file.getAbsolutePath()+"\n\n");
				else log.delete();
                System.out.println();
                System.out.println("                     We hope you enjoy this game.");
                System.out.println("You can use the following communication channels to communicate with developers.");
                System.out.println("           Erfan Fakoor                             Sajedeh Sepehrnia");
                System.out.println("E-mail: e.f.simorgh@gmai.com                     E-mail:wsawniaw@gmail.com");
                System.out.println();
				break;
            }
            case 2: {
                System.out.println("In this game we have 4 types of piece:");
                System.out.println("\"O\"piece: You can't move this piece, but this piece is your most important piece!");
                System.out.println("Protect it well.");
                System.out.println("If this piece is out of the game, you lose.");
                System.out.println();
                System.out.println("\"E\" piece: You can move this piece diagonally without any restrictions.");
                System.out.println();
                System.out.println("\"H\" piece: This is the chess horse. We do not know how he got into this game;)");
                System.out.println();
                System.out.println("\"S\" piece: You can move this piece by 1 unit in any direction.");
                System.out.println();
                System.out.println("                     Attention!");
                System.out.println("You need to use the coordinates of the table to move the pieces.");
                System.out.println();
                System.out.println("Press any integer to continue");
                   int back = scan.nextInt();
                   printmenu();
                   selectmenu();
                }
            case 3:{
                System.out.println("You can use the following communication channels to communicate with developers.");
                System.out.println("           Erfan Fakoor                             Sajedeh Sepehrnia");
                System.out.println("E-mail: e.f.simorgh@gmai.com                    E-mail:wsawniaw@gmail.com");
                System.out.println();
                System.out.println("Press any integer to continue");
                int back = scan.nextInt();
                printmenu();
                selectmenu();
            }
            case 0:{
                break;
            }
            }
    }

    public static void main(String[] args){
    Menu menu=new Menu();
    menu.printmenu();
    menu.selectmenu();
    }
}
