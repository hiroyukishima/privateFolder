/**
*オブジェクト指向による倉庫番
*/
import java.util.ArrayList;


public class Soukoban{
	public static void main(String[] args){
		Rule rule = new Rule();
		Map map = new Map();
		Player player1 = new Player();

		//rule.startGame(hiro);
		map.initialMapArray = map.inputMap(args, player1);
		map.mapHistoryArray.add(map.initialMapArray);

      	//System.out.println("プレイヤーの座標" + player1.playerPosition_x + "," + player1.playerPosition_y); 

		
		rule.gameStart(map, player1);
	}
}