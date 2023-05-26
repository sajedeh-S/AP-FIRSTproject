import java.util.*;

public class Move{
	Scanner scan=new Scanner(System.in);
    private Gameboard board;
	String p1,p2;//players' names
	static int player=1;//which palyer should play now
	int i1,i2,j1,j2;
	private boolean win;//check if any player won 	
	Log log;
	private int stage;

	//contructor
	public Move(Gameboard board,String p1,String p2,Log log){		
		//set the game
		setLog(log);
		setBoard(board);
		setPlayersNames(p1,p2);
		//start game
		setWin(false);
		Scan();
	}
	void setLog(Log log){
		this.log=log;
	}
	void setBoard(Gameboard board){
		this.board=board;
		log.writeln("\nstage "+stage++);
		board.gamepieces();
		board.printBoard();
	}
	
	public void setPlayersNames(String p1,String p2){
		this.p1=p1;
		this.p2=p2;
	}
	
	private void setWin(boolean win){
		this.win=win;
		if(win){//announce the winner
			log.writeln(thePlayer()+" WON!");
			System.out.println(thePlayer()+" WON!");
		}
	}
	
	public boolean getWin(){
		specialCase();//if special case happens, game is over
		return win;
	}
	
	//current player's name
	String thePlayer(){
		return player==1?p1:p2;
	}
	
	
	//scan the move from player
	public void Scan(){
		while(!getWin()){
			
			log.write("stage "+stage++ +" : \n"+thePlayer());
			System.out.println(thePlayer()+"  Enter the coordinates of a piece:");
			//current coordinates of the piece
			i1=scan.nextInt();
			j1=scan.nextInt();
			//check if coordinates are not out of bound
			if(i1>board.getRows() || j1>board.getColumns() || --i1<0||--j1<0){
				invalid();
				continue;
			}
			
			System.out.println(thePlayer()+"  Enter the destination coordinates.");
			//destinatoin coordinates
			i2=scan.nextInt();
			j2=scan.nextInt();
			//check if coordinates are not out of bound
			if(i2>board.getRows() || j2>board.getColumns() || --i2<0||--j2<0){
				invalid();
				continue;
			}

			int piece=board.gameboard[i1][j1];
			//check if the right player is playing and piece exists
			if(piece%10!=player || piece==0){
				System.out.println("check 3");
				invalid();
			}
			
			//changing the piece coordinates
			else  changeState(piece);
		}
	}
	
	//changing the piece coordinates
	void changeState(int piece){
		log.write(" moved ");
		//check if the move is valid
		//if move is invalid, back to scan
		if(!check(piece)){
			invalid();
			return;
		}
		
		//save move 
		log.writeln("\nfrom\n"+(i1+1)+"  "+(j1+1)+"\nto\n"+(i2+1)+"  "+(j2+1));

		int nxt=board.gameboard[i2][j2];//next coordinates of piece

		//move the piece
		board.gameboard[i1][j1]=0;
		board.gameboard[i2][j2]=piece;
		board.printBoard();


		//if piece destination is the other king we have a winner
		if(nxt/10==1){
			setWin(true);
			return;
		}

		//go to next player
		player=++player%2==0?2 : 1;
	}
	
	//check if the move is valid
	boolean check(int piece){
		//check if player is moving a right piece and piece exists in that cell
		if(board.gameboard[i2][j2]%10==player || board.gameboard[i1][j1]!=piece){
			System.out.println("check 1");
			return false;
		}
		
		//check if player is moving the piece according to the game rules
		int tmp=piece/10;
		if(tmp==2){//"H" knight: moves L
			if(Math.abs(j1-j2)==1 && Math.abs(i2-i1)==2){
				log.write("H"+player);
				return true;
			}
			if(Math.abs(j1-j2)==2 && Math.abs(i2-i1)==1){
				log.write("H"+player);
				return true;
			}
		}
		if(tmp==3){//"E" bishop:  diagonally without any restrictions
			if(Math.abs(j2-j1)==Math.abs(i1-i2)){
				log.write("E"+player);
				return true;
			}
		}
		if(tmp==4){//"S" : moves 1 unit in any direction
			if(Math.abs(i2-i1)<=1 && Math.abs(j2-j1)<=1){
				log.write("S"+player);
				return true;
			}
		}
		System.out.println("check 2");
		return false;
	}
	
	
	//this is a case that only the king of current player left and movement is impossible
	boolean specialCase(){
		
		//count number of pieces for each player
		int cnt1=0,cnt2=0;
		for(int i=0;i<board.getRows();i++)
		for(int j=0;j<board.getColumns();j++){
			if(board.gameboard[i][j]%10==1)cnt1++;
			if(board.gameboard[i][j]%10==2)cnt2++;
		}
		//if player1 can't move player2 wins
		if(cnt1==1 && player==1){
			System.out.println("no move is available for "+thePlayer());
			log.writeln("no move is available for "+thePlayer());
			player=2;
			setWin(true);
			return true;
		}
		
		//if player2 can't move player1 wins
		if(cnt2<2 && player==2){
			System.out.println("no move is available for "+thePlayer());
			log.writeln("no move is available for "+thePlayer());
			player=1;
			setWin(true);
			return true;
		}
		return false;
	}
	
	//tell the player that move is invalid
	void invalid(){
		System.out.println("\ninvalid request! "+thePlayer()+" try again please.\n");
	}
	

}