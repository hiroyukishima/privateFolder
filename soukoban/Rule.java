/**
*rule class
*/
import java.util.Arrays;
import java.lang.Object;

public class Rule{

		static int turnCount = 0;
		int whatToCheck_x = 0;
		int whatToCheck_y = 0;
		static int goalCounter = 0;		

	public void gameStart(Map map, Player player1){
		
      	int playerInput = 0;

      	Boolean isGameClear = false;
      	while(!isGameClear){
			System.out.println("turnCount:" + turnCount);
			System.out.println("goalCounter:" + goalCounter);
			map.printMap(map.mapHistoryArray.get(turnCount));
	 		//System.out.println("プレイヤーの座標" + player1.playerPosition_x.get(turnCount) + "," + player1.playerPosition_y.get(turnCount)); 
			playerInput = player1.getPlayerInput();
		
			if(playerInput == Player.UNDO){
				System.out.println("あんどうー");
				map.mapHistoryArray.remove(turnCount);
				player1.playerPosition_x.remove(turnCount);
				player1.playerPosition_y.remove(turnCount);
				turnCount--;
			}else{
			Boolean ifChange = changeMap(playerInput, map, player1);
			//goalCounterはグローバル変数にして、changeMap内でかえてしまうか
			//readableか分からないけど。
			//だとするとこの時点でgoalCounterが更新されている
				if(ifChange){
					map.mapHistoryArray.add(map.nextMapArray);
					turnCount++;
				}
			}
			if(goalCounter == map.goalNumber){
				System.out.println("おめ");
      			isGameClear = true;
    	  	}
      
  
      	}

	}

	
	/*
	public void setNextMove(int playerInput){
		switch(playerInput){
				case Player.UP:
				case LEFT:
				case DOWN:
				case RIGHT:
					map.movePlayer(nextAciton);
					turnCount++;
					clear = map.checkIfGoal(map.mapHistoryArray.get(turnCount));
					break;
				case UNDO:
						map.undo();
						turnCount--;
						break;
					}
				case INIT:
						map.init();
						turnCount = 0;
						break;
				case CANCEL:
					break;
			}


	}
	*/
	
	public boolean changeMap(int playerInput, Map map, Player player1){

		 map.nextMapArray = new char[map.mapHistoryArray.get(turnCount).length][];
		char[][] tempMapArray = map.mapHistoryArray.get(turnCount);
		for(int i = 0; i < tempMapArray.length; i++){
			map.nextMapArray[i] = tempMapArray[i].clone();
		}
		map.nextMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] = map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)];
		/*
		for(int i = 0; i < tempMapArray.length; i++){
			for(int j = 0; j< tempMapArray.length; j++){
				if(nextMapArray[j][i] == 'p'){
					nextMapArray[j][i] = ' ';
					System.out.println("チェンジ" + j + "," + i);
				}
			}
		}
		*/

		//nextMapArray = Arrays.copyOf(map.mapHistoryArray.get(turnCount), map.mapHistoryArray.get(turnCount).length);
		//System.out.println("ユーザー入力:" + playerInput);
		char check = checkTheObject(playerInput, map, player1);
		System.out.println("object:" + check);
		//System.out.println("(2,3)" + nextMapArray[3][2]);
		switch(check){
			case ' ':
			case '.':
				map.nextMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] = map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)];
				if(map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] == 'p' || map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] == 'o'){
					map.nextMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] = ' ';
				}

				map.nextMapArray[whatToCheck_y][whatToCheck_x] = 'p';
				player1.playerPosition_x.add(whatToCheck_x);
				player1.playerPosition_y.add(whatToCheck_y);

				System.out.println("p = " + map.nextMapArray[whatToCheck_y][whatToCheck_x]);
				return true;
			case 'o':
				int checkX = 0;
				int checkY = 0;
				switch(playerInput){
					case Player.RIGHT:
						checkX = player1.playerPosition_x.get(turnCount) + 2;
						checkY = player1.playerPosition_y.get(turnCount);
						break;
					case Player.LEFT:
						checkX = player1.playerPosition_x.get(turnCount) - 2;
						checkY = player1.playerPosition_y.get(turnCount);
						break;
					case Player.UP:
						checkX = player1.playerPosition_x.get(turnCount);
						checkY = player1.playerPosition_y.get(turnCount) - 2;
						break;
					case Player.DOWN:
						checkX = player1.playerPosition_x.get(turnCount);
						checkY = player1.playerPosition_y.get(turnCount) + 2;
						break;
				}
				System.out.println("チェック対象" + "'" + map.nextMapArray[checkY][checkX] + "'");
				char content = map.nextMapArray[checkY][checkX];
					switch(content){
						case ' ':
							map.nextMapArray[checkY][checkX] = 'o';
							map.nextMapArray[whatToCheck_y][whatToCheck_x] = 'p';
							map.nextMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] = map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)];
							if(map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] == 'p' || map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] == 'o'){
								map.nextMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] = ' ';
							}

							player1.playerPosition_x.add(whatToCheck_x);
							player1.playerPosition_y.add(whatToCheck_y);
							if(map.initialMapArray[whatToCheck_y][whatToCheck_x] == '.'){
								goalCounter--;
							}
							return true;
						case '.':
							goalCounter++;
							map.nextMapArray[checkY][checkX] = 'o';
							map.nextMapArray[whatToCheck_y][whatToCheck_x] = 'p';
							map.nextMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] = map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)];
							if(map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] == 'p' || map.initialMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] == 'o'){
								map.nextMapArray[player1.playerPosition_y.get(turnCount)][player1.playerPosition_x.get(turnCount)] = ' ';
							}

							player1.playerPosition_x.add(whatToCheck_x);
							player1.playerPosition_y.add(whatToCheck_y);
							if(map.initialMapArray[whatToCheck_y][whatToCheck_x] == '.'){
								goalCounter--;
							}
							
							System.out.println("goalCounter:" + goalCounter);
							return true;
							
						

						case '#':
							break;
					}

			case '#':
				return false;
			default:
				return false;
			

		}


	}
	public char checkTheObject(int playerInput, Map map, Player player1){

		switch(playerInput){
			case Player.RIGHT:
				whatToCheck_x = player1.playerPosition_x.get(turnCount) + 1;
				whatToCheck_y = player1.playerPosition_y.get(turnCount);
				break;
			case Player.LEFT:
				whatToCheck_x = player1.playerPosition_x.get(turnCount) - 1;
				whatToCheck_y = player1.playerPosition_y.get(turnCount);
				break;
			case Player.UP:
				whatToCheck_x = player1.playerPosition_x.get(turnCount);
				whatToCheck_y = player1.playerPosition_y.get(turnCount) -1;
				break;
			case Player.DOWN:
				whatToCheck_x = player1.playerPosition_x.get(turnCount);
				whatToCheck_y = player1.playerPosition_y.get(turnCount) + 1;
				break;
			case Player.CANCEL:
				break;
			case Player.UNDO:
				break;
			default:
				break;


		}
		char object = map.mapHistoryArray.get(turnCount)[whatToCheck_y][whatToCheck_x];
		if(object == 'p'){
			object = map.initialMapArray[whatToCheck_y][whatToCheck_x];
		}
		System.out.println("whatToCheck_x = " + whatToCheck_x);
		System.out.println("whatToCheck_y = " + whatToCheck_y);

		return object;
		
	}
	
}