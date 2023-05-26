import java.util.Scanner;
public class Gameboard {
    private static int rows;
    private static int columns;
    public static int[][] gameboard;
	private Log log;
    //seters
    public static void setRows(int rows) {
        Gameboard.rows = rows;
    }
    public static void setColumns(int columns) {
        Gameboard.columns = columns;
    }
    public void setLog(Log log) {
        this.log = log;
		log.writeln("number of rows: "+rows);
		log.writeln("number of columns: "+columns);
    }
    //geters
	public Log getLog(){
		return log;
	}
    public static int getRows() {
        return rows;
    }
    public static int getColumns() {
        return columns;
    }
    public Gameboard(int rows,int columns,Log log){
        setRows(rows);
        setColumns(columns);
		setLog(log);
            gameboard = new int[rows][columns];//Form The Gameboard.
    }
    public void gamepieces(){
        //Set Gamepieces.
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++) {
                    if (i == 0 && j == columns / 2 ) gameboard[i][j] = 11;
                    else if (i == rows - 1 && j == columns / 2 ) gameboard[i][j] = 12;
                    else if (i==0 && (j== columns/2-1|| j==columns/2+1) )gameboard[i][j]=21;
                    else if(i==rows-1&& (j== columns/2-1 || j==columns/2+1) )gameboard[i][j]=22;
                    else if(i==0 && (j== columns/2-2 || j==columns/2+2))gameboard[i][j]=31;
                    else if(i==rows-1 && (j== columns/2-2 || j==columns/2+2))gameboard[i][j]=32;
                    else if(i==1 && j<=columns/2+2 && j>=columns/2-2)gameboard[i][j]=41;
                    else if(i==rows-2 && j<=columns/2+2 && j>=columns/2-2)gameboard[i][j]=42;
            }
        }
    }
    public void printBoard() {
        //Print Gameboard.
		System.out.println();
		log.writeln(" ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                switch (gameboard[i][j]) {
                    case 0: {
                        System.out.print("[  ]");
						log.write("[  ]");
                        break;
                    }
                    case 11: {
                        System.out.print("[O1]");
						log.write("[O1]");
                        break;
                    }
                    case 12: {
                        System.out.print("[O2]");
						log.write("[O2]");
                        break;
                    }
                    case 21: {
                        System.out.print("[H1]");
						log.write("[H1]");
                        break;
                    }
                    case 22: {
                        System.out.print("[H2]");
						log.write("[H2]");
                        break;
                    }
                    case 31: {
                        System.out.print("[E1]");
						log.write("[E1]");
                        break;
                    }
                    case 32: {
                        System.out.print("[E2]");
						log.write("[E2]");
                        break;
                    }
                    case 41: {
                        System.out.print("[S1]");
						log.write("[S1]");
                        break;
                    }
                    case 42: {
                        System.out.print("[S2]");
                        log.write("[S2]");
						break;
                    }
                }
            }
            System.out.println();
			log.writeln(" ");
        }
        System.out.println();
		log.writeln(" ");
    }

}
