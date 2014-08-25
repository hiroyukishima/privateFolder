/**
*オブジェクト指向による倉庫番
* @version 2.0
* @author Hiroyuki shima
*/
import java.util.ArrayList;

public class Soukoban{
	public static void main(String[] args){
		Game game = Game.getInstance(args);
		game.start();
		
	}
}