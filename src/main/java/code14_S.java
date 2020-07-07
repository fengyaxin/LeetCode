/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 **/
public class code14_S {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "fl", "floght"};
        System.out.println(longestCommonPrefix2(strs));
    }

    public static String longestCommonPrefix1(String[] strs) {
        int count = strs.length;
        String prefix = strs[0];
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < len && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str1.substring(0, i);

    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }

        int length = strs[0].length();

        for(int i =0;i<length;i++){
            char c = strs[0].charAt(i);
              for(int j =1;j<strs.length;j++){
                  if(i==strs[j].length()||strs[j].charAt(i)!=c){
                      return strs[0].substring(0,i);
                  }
              }
        }
        return strs[0];
    }

}
