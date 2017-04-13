import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) throws IOException{
        if (Files.exists(FileSystems.getDefault().getPath(args[0]))) {
            Stream<String> str = Files.lines(Paths.get(args[0]), StandardCharsets.UTF_8);
            Map<String, Integer> map = new TreeMap<>();
            map = findWordCount(map, str);
	        map = sortByValue(map, Integer.valueOf(args[1]));
	        map.forEach((k,v)->System.out.println(k + "=" + v));
        } else System.out.println("File doesn't exists");
    }

    static Map<String, Integer> findWordCount(Map<String, Integer> map, Stream<String> str){
        for (String temp : str.collect(Collectors.toList())) {
	            String[] line = temp.split("\\.|\\,|\\s");
	            for(String word : line){
	               word = word.toLowerCase();
	               if (word.length()>0){
	                   Integer count = map.get(word);
	                   map.put(word, (count == null) ? 1 : count + 1);
                   }
                }
        }
        return map;
    }

    static Map<String, Integer> sortByValue(Map<String, Integer> map, int limit){
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        list.sort(((o1, o2) -> -(o1.getValue()-o2.getValue())));
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for(int i = 0; i < limit; i++){
            result.put(list.get(i).getKey(), list.get(i).getValue());
        }
        return result;
    }
}
