/**
*マップクラス
*/
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;

public class Map{
      /*
      public static final int mapWidth = 8;
      public static final int mapHeight = 9;
      public static final int goalNumber = 0;
      */

	public static char[][] initialMapArray;
	public static ArrayList<char[][]> mapHistoryArray;
	public static int goalNumber = 0;
	public static int goalCounter = 0;
	public static char[][] nextMapArray;
	//拡張性を考えるとstaticな訳が無い。インスタンスとのやり取りを調べる（下巻？）

	public Map(){
		initialMapArray = new char[9][9];
		mapHistoryArray = new ArrayList<char[][]>();
	}
     /*
      public static void main(String[] args){
      	
      	initialMapArray = new char[9][9];
      	initialMapArray = inputMap(args);

      	mapHistoryArray = new ArrayList<char[][]>();
      	mapHistoryArray.add(initialMapArray);
      
      	printMap(mapHistoryArray.get(0));
            
    
      }
      */
      /*
      public void showMap(int turnCount){

      }
      
      public void getMapSize(){

            mapWidth = inputMapWidth;
            mapHeight = inputMapHeight;
      }

      public void setMapArraySize(){
            tempMapArray = new char[mapWidth][mapHeight];
      }
      */
	public static char[][] inputMap(String[] args, Player player1){
		if(args.length != 1){
 			System.out.println("使用法： Soukoban ファイル");
			System.exit(0);
		}

            String filename = args[0];
            char[][] _initialMapArray;
            _initialMapArray = new char[9][9];
            int lineCounter = 0;

            try{
                  BufferedReader reader = new BufferedReader(new FileReader(filename));
                  String line;
                 
                  while((line = reader.readLine()) != null){
                        for(int i = 0; i < line.length(); i++){
                            _initialMapArray[lineCounter][i] = line.charAt(i);
                            if(line.charAt(i) == '.'){
                              System.out.println(lineCounter + "," +  i);
                            	goalNumber++;
                              }
                              if(line.charAt(i) == 'p'){
                              	player1.playerPosition_x = i;
                              	player1.playerPosition_y = lineCounter;
                              }

                        }
                        lineCounter++;
                  
                  }
            } catch (FileNotFoundException e) {
            	System.out.println(filename + "が見つからない");
            } catch (IOException e) {
           		System.out.println(e);
            }

            return _initialMapArray;
    }

    public static void printMap(char[][] mapArray){
    	for(int i = 0; i<8; i++){
            	//System.out.print("startLine" + i);
                  for(int j = 0; j<9; j++){
                  		//if(initialMapArray[i][j] == '.');
                  			//goalNumber++;
                  		
                        System.out.print(mapArray[i][j]);
                  }
                    System.out.println("");
      }
                  
            
            System.out.println("goalNumber = " + goalNumber);

    }
      

}
