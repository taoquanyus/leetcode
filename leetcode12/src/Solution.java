public class Solution {
    public String intToRoman(int num){
        //我的答案，代码臃肿，且不好维护，应当使用贪心算法
        StringBuilder sb=new StringBuilder();
        int a=num%10;
        num/=10;
        int b=num%10;
        num/=10;
        int c=num%10;
        num/=10;
        int d=num%10;
        switch (a){
            case 0:sb.insert(0,"");break;
            case 1:sb.insert(0,"I");break;
            case 2:sb.insert(0,"II");break;
            case 3:sb.insert(0,"III");break;
            case 4:sb.insert(0,"IV");break;
            case 5:sb.insert(0,"V");break;
            case 6:sb.insert(0,"VI");break;
            case 7:sb.insert(0,"VII");break;
            case 8:sb.insert(0,"VIII");break;
            case 9:sb.insert(0,"IX");break;
        }
        switch (b){
            case 0:sb.insert(0,"");break;
            case 1:sb.insert(0,"X");break;
            case 2:sb.insert(0,"XX");break;
            case 3:sb.insert(0,"XXX");break;
            case 4:sb.insert(0,"XL");break;
            case 5:sb.insert(0,"L");break;
            case 6:sb.insert(0,"LX");break;
            case 7:sb.insert(0,"LXX");break;
            case 8:sb.insert(0,"LXXX");break;
            case 9:sb.insert(0,"XC");break;
        }
        switch (c){
            case 0:sb.insert(0,"");break;
            case 1:sb.insert(0,"C");break;
            case 2:sb.insert(0,"CC");break;
            case 3:sb.insert(0,"CCC");break;
            case 4:sb.insert(0,"CD");break;
            case 5:sb.insert(0,"D");break;
            case 6:sb.insert(0,"DC");break;
            case 7:sb.insert(0,"DCC");break;
            case 8:sb.insert(0,"DCCC");break;
            case 9:sb.insert(0,"CM");break;
        }
        switch (d){
            case 0:sb.insert(0,"");break;
            case 1:sb.insert(0,"M");break;
            case 2:sb.insert(0,"MM");break;
            case 3:sb.insert(0,"MMM");break;
        }
        return sb.toString();
    }
    //贪心算法
    public String intToRoman2(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<values.length&&num>0;++i){
            while(num>=values[i]){
                sb.append(symbols[i]);
                num-=values[i];
            }
        }
        return sb.toString();
    }
}
