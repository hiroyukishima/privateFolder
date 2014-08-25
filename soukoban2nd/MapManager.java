import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class MapManager{
	private static MapManager instance;
    private char[][] initialMapArray;
	
	private MapManager(){
		
	}
	
	private MapManager(String[] args){
		 System.out.println("map input end.");
		initialMapArray = inputMap(args);
				
	}

	public static MapManager getInstance(String[] args){
		instance = new MapManager(args);
		return instance;

	}

	public static char[][] inputMap(String[] args){
		//もしmapが正しく指定していなかったらプログラムを終了
    if(args.length != 1){
 			System.out.println("使用法： Soukoban mapファイル名");
			System.exit(0);
		}
            String filename = args[0];
            char[][] _initialMapArray;
            //_initialMapArray = new char[9][9];
            //mapファイルの行数を読み込み
            int lineLength = 0;
            int maxLength = 0;

            try{
            	BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
            	while((line = reader.readLine()) != null){
					lineLength++;
					if (line.length() < maxLength){
						maxLength = line.length();
					}
				}
				_initialMapArray = new char[lineLength][maxLength];
                int lineCounter = 0;
				while((line = reader.readLine()) != null){
						for(int i = 0; i < line.length(); i++){
							_initialMapArray[lineCounter][i] = line.charAt(i);
							if(line.charAt(i) == '.'){
								//goalNumber++;
							}
                              //プレイヤーを見つけたらその画像を記録
                              if(line.charAt(i) == 'p'){
                              	//player1.playerPositionX.add(i);
                              	//player1.playerPositionY.add(lineCounter);
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
    /*
    private getMapSize(String[] args){
    	if(args.length != 1){
 			System.out.println("使用法： Soukoban mapファイル名");
			System.exit(0);
		}
            String filename = args[0];

            try{
                  BufferedReader reader = new BufferedReader(new FileReader(filename));
                  String line;
            
            
			while((line = reader.readLine()) != null){
				lineLength++;
				if (line.length() < maxLength){
					maxLength = line.length();
				}
				 

			}

    }
    */


}