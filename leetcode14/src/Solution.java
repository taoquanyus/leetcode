public class Solution {
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0) return "";//注意数组为空和数组长度为0不是一个东西，已经在笔记上详细记录了
        char[] ch=strs[0].toCharArray();
        int samenumber=strs[0].length();
        for(String str:strs){
            samenumber=Math.min(samenumber,str.length());
            for(int i=0;i<samenumber;++i){
                if(str.charAt(i)!=ch[i]) samenumber=i;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<samenumber;++i){
            sb.append(ch[i]);
        }
        if(samenumber==0) return "";
        return sb.toString();
    }
}
