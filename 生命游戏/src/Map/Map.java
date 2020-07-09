package Map;

import java.util.Random;

import Cell.Cell;

public class Map {
    final static public int x=16;
    final static public int y=16;
    public static Cell [][]initial() {
    	Cell [][]cell=new Cell[x][y];
    	for(int i=0;i<x;i++) {
    		for(int j=0;j<y;j++) {
    			cell[i][j]=new Cell();
    			Random random=new Random();
    			cell[i][j].setStatus(random.nextInt(2));
    		}
    	}
    	return cell;
    }   
    public static void getLiving(Cell [][]cell){          //细胞周围活细胞数目
    	for(int i=0;i<x;i++) {
    		for(int j=0;j<y;j++) {
    			int living=0;
    			if(i>0&&j>0) living+=cell[i-1][j-1].getStatus();
    			if(i>0) living+=cell[i-1][j].getStatus();
    			if(j>0) living+=cell[i][j-1].getStatus();
    			if(i<x-1&&j<x-1) living+=cell[i+1][j+1].getStatus();
    			if(i<x-1) living+=cell[i+1][j].getStatus();
    			if(j<x-1) living+=cell[i][j+1].getStatus();
    			if(i<x-1&&j>0) living+=cell[i+1][j-1].getStatus();
    			if(i>0&&j<x-1) living+=cell[i-1][j+1].getStatus();
    			cell[i][j].setLiving(living);
    		}
    	}
    }
    public static int update(Cell [][]cell){           //数据更新
    	int count=0;
    	for(int i=0;i<x;i++) {
    		for(int j=0;j<y;j++) {
    			int status=cell[i][j].getStatus();
    			cell[i][j].UpdateStatus();
    			if(status==cell[i][j].getStatus()) count++;
    		}
    	}
    	return count;
    }
    public static void printMap(Cell [][]cell) {       //地图信息
    	for(int i=0;i<x;i++) {
    		for(int j=0;j<y;j++) {
    			System.out.print(cell[i][j].getStatus()+" ");
    		}
    		System.out.println();
    	}
    }

}

