package Strings;

public class StringMethod2 {
    public static void main(String[] args) {
        String str = "Mr. Shahrukh khan";
        String str1 = "www.lpu.co.in";
        System.out.println(str.startsWith("Sh"));
        System.out.println(str.endsWith("khan"));
        System.out.println(str.charAt(5));
        for(int i = 0; i<str.length();i++){
            System.out.print(str.charAt(i));
        }  
        System.out.println(str1.indexOf('.'));
        System.out.println(str1.indexOf('.',7 ));
        System.out.println(str1.lastIndexOf("co"));
        System.out.println(str1.lastIndexOf('w',1 ));
    }
}
