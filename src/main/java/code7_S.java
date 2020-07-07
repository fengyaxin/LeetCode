/**
 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:
 输入: 123
 输出: 321

 示例 2:
 输入: -123
 输出: -321

 PS:假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 **/
public class code7_S {

    public static void main(String[] args) {
         int n = -1230;
        System.out.println(reverse(n));
    }

    public static int reverse(int x) {
         int p;
         int rev = 0;
         while(x!=0) {
             p = x % 10;
             x = x / 10;

             /**
              判断溢出，不可写成  rev*10>Integer.MAX_VALUE;  若rev*10溢出，会导致结果计算错误，但是并不报错
              */

             if(rev>Integer.MAX_VALUE/10||rev==Integer.MAX_VALUE/10&& p>7) return 0;
             if(rev<Integer.MIN_VALUE/10||rev==Integer.MIN_VALUE/10&&p <-8) return 0;

             rev = rev * 10 + p;
         }
         return rev;
    }

}
