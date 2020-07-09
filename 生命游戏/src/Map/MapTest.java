package Map;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Cell.Cell;

public class MapTest {
	private static Map map=new Map();
	private static Cell [][]cell=new Cell[16][16];
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cell=Map.initial();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		;
	}

	@Test
	public void testGetLiving() {
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(1);
			}
		}
		Map.getLiving(cell);
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				if(i>0&&i<15&&j>0&&j<15) 
					assertEquals(8,cell[i][j].getLiving());            
				else if((i==0||i==15)&&(j>0&&j<15)||(j==0||j==15)&&(i>0&&i<15)) //特殊情况：边界
					assertEquals(5,cell[i][j].getLiving()); 
				else 
					assertEquals(3,cell[i][j].getLiving());
			}
		}
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(0);
			}
		}
		Map.getLiving(cell);
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				assertEquals(0,cell[i][j].getLiving());
			}
		}
	}

	@Test
	public void testUpdate() {
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(1);
			}
		}
		Map.getLiving(cell);
		assertEquals(4,Map.update(cell));
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(0);
			}
		}
		Map.getLiving(cell);
		assertEquals(256,Map.update(cell));
	}

}

