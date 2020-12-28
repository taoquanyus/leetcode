import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> hashtable=new HashMap<>();
        for(String str:strs){
            char[] temp= str.toCharArray();
            Arrays.sort(temp);//Arrays.sort(int[])不能用来初始化
            String key=new String(temp);
//            String key=temp.toString();//这两个转化出来的结果不同,因为数组toString的结果是地址
            if(!hashtable.containsKey(key)){
                hashtable.put(key,new ArrayList<String>());
            }
            hashtable.get(key).add(str);
        }
        return new ArrayList<List<String>>(hashtable.values());//hashtable.values()表示哈希表的值集合
    }
}
