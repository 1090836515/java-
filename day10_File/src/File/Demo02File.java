package File;

import java.io.File;
import java.io.FileFilter;

/**
 * FileFilter是一个接口，没有实现类，要自己实现
 */
public class Demo02File {
    public static void main(String[] args){
        File file = new File("F:\\流星9.07");
        getAllFile(file);
    }
    //递归打印指定路径下的多级文件
    public static void getAllFile(File file){
        //System.out.println(file);
        File[] files = file.listFiles(/*new FileFilter() {//过滤掉以.exe结尾的文件
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory()){
                    return true;
                }
                return pathname.getName().toLowerCase().endsWith(".exe");
            }
        }*/);
        for(File f:files){
            if(f.isDirectory()){
                getAllFile(f);
            }
            System.out.println(f);
        }
    }
}
