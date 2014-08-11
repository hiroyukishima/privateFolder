/**
*倉庫番のプレイヤークラス
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.lang.String;
import java.util.ArrayList;

public class Player{
	public static final int LEFT = 0;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	public static final int CANCEL = 4;
	public static final int UNDO = 5;


	//public int[][] playerPosition;
	public ArrayList<Integer> playerPosition_x = new ArrayList<Integer>();
	public ArrayList<Integer> playerPosition_y = new ArrayList<Integer>();

	public int getPlayerInput(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("次の動作を入力して下さい");
		
		//プレイヤーの選択した手
		int hand = 0;
		
		Boolean isHand = false;
		String inputStr = "";
		while(!isHand){
			try{
			
				inputStr = br.readLine();
				//System.out.println(inputStr);
				if(inputStr != null){
					for(int i = 0; i < inputStr.length(); i++){
						if(inputStr.charAt(i) == '!'){
							return CANCEL;
						}
					}

					hand = inputStr.charAt(0);
				}

				

				switch(hand){
					case 'a': 
						return Player.LEFT;//0
					case 'w':
						return Player.UP; //1
					case 's':
						return Player.DOWN;//2
					case 'd':
						return Player.RIGHT;//3
					case 'u':
						return Player.UNDO;//5
					default:
						return Player.CANCEL;//4
				}

			
			}catch(IOException ex){
				System.out.println("入力が正しくありません。再入力して下さい");
			}catch(NumberFormatException ex){
				System.out.println("入力が正しくありません。再入力して下さい");
			}
		}
		return Player.CANCEL;
	}
	public void setPlayerPosition(int x, int y){
		playerPosition_x.add(x);
		playerPosition_y.add(y);
	}

}