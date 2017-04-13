import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void sortTest() {
        Main main = new Main();
        Map<String, Integer> map = new HashMap<>();
        map.put("3",3);
        map.put("5",5);
        map.put("1",1);
        map.put("2",2);
        map.put("4",4);
        map = main.sortByValue(map, 2);
        Map<String, Integer> mapResult = new HashMap<>();
        mapResult.put("5",5);
        mapResult.put("4",4);
        assertEquals(mapResult, map);
    }

    @Test
    public void findWordTest(){
        Main main = new Main();
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("a",1);
        expectedMap.put("b",2);
        expectedMap.put("c",3);
        List<String> list = Arrays.asList("A.b c,b C C,");
        Stream<String> str = list.stream();
        Map<String, Integer> map = new HashMap<>();
        main.findWordCount(map, str);
        assertEquals(expectedMap,map);

    }


}
