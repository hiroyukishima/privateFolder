import java.util.ArrayList;

public class Player{
	private static Player instance;

	public ArrayList<Integer> playerPositionX = new ArrayList<Integer>();
	public ArrayList<Integer> playerPositionY = new ArrayList<Integer>();

	private Player(){
		
	}
	
	private Player(String[] args){

	}

	public static Player getInstance(String[] args){
		instance = new Player(args);
		return instance;

	}
}