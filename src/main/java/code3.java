
public class code3 {

    public static void main(String[] args) {
        String s = "abcdcdefgh";
        int len = s.length();
        String t=null;
        int max =0;
        t= String.valueOf(s.charAt(0));
        for(int i =1;i<len;i++)
        {
            if(t.contains((String.valueOf(s.charAt(i))))){
              int j = t.indexOf(s.charAt(i));
              if(max<t.length()){
                  max=t.length();
              }
              t="";
              for(int k =j+1;k<=i;k++){
                    t = t+String.valueOf(t.charAt(k));
                }
            }else{
            t = t + s.charAt(i);
           }
        }
        System.out.println(max);
    }
}
