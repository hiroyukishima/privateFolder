/**
*rule class
*/
public class Rule{

		int turnCount = 0;
		int whatToCheck_x = 0;
		int whatToCheck_y = 0;		

	public void gameStart(Map map, Player player1){
		
      	int playerInput = 0;

      	Boolean isGameClear = false;
      	while(!isGameClear){
      		map.printMap(map.mapHistoryArray.get(turnCount));
      		System.out.println("プレイヤーの座標" + player1.playerPosition_x + "," + player1.playerPosition_y); 
      		playerInput = player1.getPlayerInput();
      		map.nextMapArray = changeMap(playerInput, map, player1);
      		//goalCounterはグローバル変数にして、changeMap内でかえてしまうか
      		//readableか分からないけど。
      		//だとするとこの時点でgoalCounterが更新されている
      		if(map.goalCounter == map.goalNumber){
      			isGameClear = true;
      		}
      		map.mapHistoryArray.add(map.nextMapArray);
      
  
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
	
	public char[][] changeMap(int playerInput, Map map, Player player1){
		
		char[][] nextMapArray = map.mapHistoryArray.get(turnCount);
		//System.out.println("ユーザー入力:" + playerInput);
		char check = checkTheObject(playerInput, map, player1);
		System.out.println("object:" + check);
		switch(check){
			case ' ':
				nextMapArray[player1.playerPosition_x][player1.playerPosition_y] = map.initialMapArray[player1.playerPosition_x][player1.playerPosition_y];
				nextMapArray[whatToCheck_x][whatToCheck_y] = 'p';
				turnCount++;
				break;
			default:
				break;

		}

		return nextMapArray;

	}
	public char checkTheObject(int playerInput, Map map, Player player1){
		switch(playerInput){
			case Player.RIGHT:
				whatToCheck_x = player1.playerPosition_x + 1;
				whatToCheck_y = player1.playerPosition_y;
				break;
			case Player.LEFT:
				whatToCheck_x = player1.playerPosition_x - 1;
				whatToCheck_y = player1.playerPosition_y;
				break;
			case Player.UP:
				whatToCheck_x = player1.playerPosition_x;
				whatToCheck_y = player1.playerPosition_y -1;
				break;
			case Player.DOWN:
				whatToCheck_x = player1.playerPosition_x;
				whatToCheck_y = player1.playerPosition_y + 1;
				break;
			default:
				break;


		}
		System.out.println("whatToCheck_x = " + whatToCheck_x);
		System.out.println("whatToCheck_y = " + whatToCheck_y);

		return map.initialMapArray[whatToCheck_x][whatToCheck_y];
		
	}
	
}