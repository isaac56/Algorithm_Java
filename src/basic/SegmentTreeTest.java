package basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTreeTest {
    @Test
    void SegmentTreeTest(){
        int[] arr = new int[]{1,1,1,1,1};
        SegmentTree st = new SegmentTree(arr);
        st.update(0, st.arrLength-1, 1, 0, 1);
        st.update(0, st.arrLength-1, 1, 1, 2);
        st.update(0, st.arrLength-1, 1, 2, 3);
        st.update(0, st.arrLength-1, 1, 3, 4);
        st.update(0, st.arrLength-1, 1, 4, 5);
        Assertions.assertEquals(3,st.sum(0,st.arrLength-1,1,0,1));
        Assertions.assertEquals(5,st.sum(0,st.arrLength-1,1,1,2));
        Assertions.assertEquals(7,st.sum(0,st.arrLength-1,1,2,3));
        Assertions.assertEquals(9,st.sum(0,st.arrLength-1,1,3,4));
        Assertions.assertEquals(15,st.sum(0,st.arrLength-1,1,0,4));
    }
}