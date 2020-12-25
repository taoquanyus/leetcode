import java.util.LinkedList;

public class Solution {
    public String reformatNumber(String number){//用了两个stringBuffer，代码比较冗余
        int con=0;
        StringBuilder sb=new StringBuilder(10);
        StringBuilder sb2=new StringBuilder(10);
        for(int p=0;p<number.length();p++){
            if(number.charAt(p)!=' '&&number.charAt(p)!='-')
                sb.append(number.charAt(p));
        }
        while(con+4<sb.length()){
            sb2.append(sb.substring(con,con+3));
            sb2.append('-');
            con+=3;
        }
        if(sb.length()-con==4){
            sb2.append(sb.substring(con,con+2));
            sb2.append('-');
            sb2.append(sb.substring(con+2,con+4));
        }
        else if(sb.length()-con==3){
            sb2.append(sb.substring(con,con+3));
        }
        else if(sb.length()-con==2){
            sb2.append(sb.substring(con,con+2));
        }
        return sb2.toString();
    }
    public String reformatNumber2(String number){//用一个StringBuffer 更省空间
        int con=0;
        StringBuilder sb=new StringBuilder(10);
        for(int p=0;p<number.length();p++){//删除所有的非数字符号
            if(number.charAt(p)!=' '&&number.charAt(p)!='-')
                sb.append(number.charAt(p));
        }
        while(con+4<sb.length()) {//除了最后`sb.length()-con`个预留位不处理，其它都插入`‘-’`
            sb.insert(con+3,'-');
            con += 4;
        }
        //剩下的就是边界条件
        if(sb.length()-con==4){
            sb.insert(con+2,'-');
        }
        return sb.toString();
    }
}
