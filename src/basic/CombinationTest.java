package basic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationTest {
    @Test
    void test(){
        Combination c = new Combination();
        List<int[]> pickers = c.getCombination(10,3);
        for(int[] pick : pickers){
            for(int e : pick){
                System.out.print(e);
            }
            System.out.println();
        }
    }
}
