package saveandload;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static String filePath = "C:\\Users\\07\\java之斗兽棋\\1.txt";
    private static PlayerColor recordPlayer = PlayerColor.BLUE;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static Chessboard now = null;
    private static Vector<Node> nodes = new Vector<>();
    private static String nowOwner = null;


    public static void recordFile(){
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(String.valueOf(recordPlayer) + "\n");
            for(int i = 0;i < 9;i++){
                for(int j = 0;j < 7;j++){
                    ChessboardPoint a = new ChessboardPoint(i,j);
                    if(recordChess(a) != null){
                        String record = recordChess(a)[0] + " " + recordChess(a)[1] + " " + recordChess(a)[2] + " " + recordChess(a)[3];
                        bw.write(record + "\n");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Vector<Node> loadGame(){
        try {
            br = new BufferedReader(new FileReader(filePath));
            nowOwner = br.readLine();
            String line = "";
            while((line = br.readLine()) != null){
                String[] sta = line.split(" ");
                Node node = new Node(Integer.parseInt(sta[0]),Integer.parseInt(sta[1]),Integer.parseInt(sta[2]),sta[3].charAt(0));
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return nodes;
    }

    public static void setRecordPlayer(PlayerColor recordPlayer) {
        Recorder.recordPlayer = recordPlayer;
    }

    public static void setNow(Chessboard now) {
        Recorder.now = now;
    }

    public static char[] recordChess(ChessboardPoint point){
        if(now.getChessPieceAt(point) != null){
            char[] chessStatics = new char[4];
            chessStatics[0] = (char)(point.getRow() + 48);
            chessStatics[1] = (char)(point.getCol() + 48);
            chessStatics[2] = (char)(now.getChessPieceAt(point).getRank(now.getChessPieceAt(point).getName()) + 48);
            chessStatics[3] = now.getChessPieceAt(point).getOwner2(now.getChessPieceAt(point).getOwner());
            return chessStatics;
        }
        return null;
    }

}
