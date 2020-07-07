/**
 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 **/
public class code9_S {

    public static void main(String[] args) {
        int a = 12521;
        System.out.println(isPalindrome4(a));
    }


    /**
      思想：数字反转
     如果是负数，直接返回false；如果<=0,将整数反转，比较反转后的数据是否与原数据相等;  代码同code7_S
     缺点：会存在整数溢出问题。
     */

    public static boolean isPalindrome(int x) {
        int p;
        int t = x;
        int rev=0;
        if(x<0) return false;

        while(x!=0){
            p = x % 10;   //获取末尾数
            x = x / 10;  //去掉末尾数剩余的数据

            rev = rev * 10 + p;   //反转后的数据
        }
        if(rev == t)
           return true;
        else
            return false;
    }

    /**
     * 思想：反转一半
     *
    */
    public static boolean isPalindrome2(int x) {
        int revs=0;
        Boolean flag=false;
        //x为负数；或者x的末尾为0时，一定不是回文数
        if(x<0||x%10==0&&x!=0) return false;

        //当原始数字小于或等于反转后的数字时，就意味着已经处理了一半位数的数字了。
        while(x>revs){
            revs = revs * 10 + x % 10;
            x = x / 10;
        }
        /**
         当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
         例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
          由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
         **/
        if(revs==x||revs/10==x){
            flag=true;
        }
        return flag;
    }

    /**
     *
     **/
    public static boolean isPalindrome3(int x){

        String s = String.valueOf(x);
        for(int i =0;i<s.length()/2;i++){
//            if(s.charAt(i)==(s.charAt(s.length()-1-i))){
//                continue;
//            }else{
//                return false;
//               }

            if(s.charAt(i)!=(s.charAt(s.length()-1-i)))
                return false;
        }
       return true;
    }

    public static boolean isPalindrome4(int x){

        String s = String.valueOf(x);
        int i=0;
        int j = s.length()-1;
        for (;i<j;i++,j--) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
        }
       return true;
    }
}
