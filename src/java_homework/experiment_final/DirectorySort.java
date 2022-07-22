package java_homework.experiment_final;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 风之诗
 * @version 1.0
 * 比较字符串大小：先比较字符串的长度，若长度相同，再根据字符串的字典顺序比较
 */
public class DirectorySort {
    public static void main(String[] args) throws IOException {
        //设置一个自适应变化长度的字符串数组
        final ArrayList<String> strings = new ArrayList<>();

        //打开文件输入流
        Scanner scanner = new Scanner(new FileInputStream("e:\\test.txt"), StandardCharsets.UTF_8);

        //从文件中通过文件输入流获取所有的字符串
        while (scanner.hasNextLine()){
            String elmt = scanner.nextLine();
            strings.add(elmt);
        }

        //将字符串动态数组的值赋给数组
        String[] s=new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            s[i]= strings.get(i);
        }

        //字符串排序
        sort(s);

        //将排序后的字符串数组更新到文件中
        final FileOutputStream fileOutputStream = new FileOutputStream("e:test.txt");
        for (int i = 0; i <s.length ; i++) {
            fileOutputStream.write(s[i].getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write('\n');
        }
    }

    //字符串排序
    public static void sort(String[] s){
        boolean isprime;
        String temp=null;
        for (int i = 0; i <s.length-1; i++) {
            isprime=false;
            //冒泡排序
            for (int j = 0; j < s.length-1-i; j++) {
                //比较长度,前一项长度大于后一项交换
                if(lengthSort(s[j],s[j+1])>0){
                    temp=s[j];
                    s[j]=s[j+1];
                    s[j+1]=temp;
                    isprime=true;
                }else if(lengthSort(s[j],s[j+1])==0){
                    //长度相同，比较字典顺序，字典顺序大的和字典顺序小的交换
                    if(booksSort(s[j],s[j+1])>0){
                        temp=s[j];
                        s[j]=s[j+1];
                        s[j+1]=temp;
                        isprime=true;
                    }
                }
            }
            if(!isprime){
                break;
            }
        }
    }

    //根据长度比较大小
    public static int lengthSort(String first,String second){
        return first.length()-second.length();
    }

    //根据字典顺序比较大小
    public static int booksSort(String first,String second){
        final char[] chars1 = first.toCharArray();
        final char[] chars2 = second.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i]!=chars2[i]){
                return chars1[i]-chars2[i];
            }
        }
        return 0;
    }
}

