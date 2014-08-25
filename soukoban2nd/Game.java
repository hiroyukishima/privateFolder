import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
*ゲーム進行を司るクラス
*/

public class Game{

	private MapManager mapManager;
	private Player movablePlayer;
	//private Rule rule;

	private static Game instance;
	private char[][] initialMapArray;
	private int playerInitialPositionX;
	private int playerInitialPositionY;
	private int goalcounter = 0;

	/**
	*constractor
	*/
	private Game(){}
	private Game(String[] args){
		//初期マップ読み込みまでやらせよう
		mapManager = MapManager.getInstance(args);
		movablePlayer = Player.getInstance(args);
		//rule = Rule.getInstance()
	}

	public static Game getInstance(String[] args){
		instance = new Game(args);
		return instance;
	}
		

	public void start(){
		printStartUpScreen();
	}

	private void printStartUpScreen(){

		System.out.println("＿＿＿＿■■■＿＿＿＿＿＿＿＿＿■＿＿＿＿＿＿＿＿＿＿＿＿■■＿＿");
		System.out.println("＿＿＿■＿＿＿■＿＿＿＿＿■■■■■■■■■■＿＿＿■■■■■＿■＿＿");
		System.out.println("＿＿■＿■■■＿■＿＿＿＿■＿＿＿＿■＿＿＿＿＿＿＿＿■＿■＿■＿＿＿");
		System.out.println("■■＿＿＿＿＿＿＿■■＿＿■■■■■■■■■■＿■■■■■■■■■■■");
		System.out.println("＿＿■■■■■■■＿＿＿＿■＿■＿＿■＿＿■＿＿＿＿＿■＿■＿■＿＿＿");
		System.out.println("＿＿■＿＿＿＿＿■＿＿＿＿■＿■■■■■■■＿＿＿＿■＿＿■＿＿■＿＿");
		System.out.println("＿＿■■■■■■■＿＿＿＿■＿■＿＿■＿＿■＿＿■■■■■■■■■■■");
		System.out.println("＿＿■＿＿＿＿＿＿＿＿＿＿■＿■■■■■■■＿＿＿＿■＿＿■＿＿■＿＿");
		System.out.println("＿■＿■■■■■■＿＿＿＿■＿＿＿＿■＿＿＿＿＿＿＿■■■■■■■＿＿");
		System.out.println("■＿＿■＿＿＿＿■＿＿＿■＿■■■■■■■■■＿＿＿■＿＿■＿＿■＿＿");
		System.out.println("＿＿＿■■■■■■＿＿＿■＿＿＿＿＿■＿＿＿＿＿＿＿■■■■■■■＿＿");
		System.out.println("＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿");

		System.out.println("Please Enter Key... Game Start");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
	}

 
	


}