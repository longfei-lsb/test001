package com.lsb.test;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FileTest {

    /**
     * File(String pathname)
     */
    @Test
    public void createByPathname() {
        File file = new File("/Users/edz/workspace/test001.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
    }

    /**
     * File(File parent, String child);
     */
    @Test
    public void createByFileAndChild() {
        File parent = new File("/Users/edz/workspace/");
        String child = "/test002.txt";
        File file = new File(parent, child);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
    }

    /**
     * File(String parent, String child)
     */
    @Test
    public void createByParentAndChild() {
        String parent = "/Users/edz/workspace/";
        String child = "/test003.txt";
        File file = new File(parent, child);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
    }

    /**
     * File(URI uri) :路径(file: URI)
     */
    @Test
    public void createByUri() throws URISyntaxException {
        URI uri = new URI("file:/Users/edz/workspace/test004.txt");
        File file = new File(uri);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
    }

    /**
     * File(URI uri) :路径(file: URI)
     */
    @Test
    public void testMethod() throws IOException {
        File file = new File("/Users/edz/workspace/test004.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("执行删除：" + file.delete());// 删除
        System.out.println("执行创建：" + file.createNewFile());// 创建

        System.out.println("是否存在：" + file.exists());
        System.out.println("是否为绝对路径：" + file.isAbsolute());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("路径：" + file.getPath());
        System.out.println("名字：" + file.getName());
        System.out.println("父路径：" + file.getParent());
        System.out.println("可读性：" + file.canRead());
        System.out.println("可写性：" + file.canWrite());
        System.out.println("是否为目录：" + file.isDirectory());
        System.out.println("是否为文件：" + file.isFile());
        System.out.println("最近修改时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));
        System.out.println("目录大小：" + file.length());
        System.out.println("自定义修改时间"+file.setLastModified(new Date().getTime()));
        System.out.println("最近修改时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));
        System.out.println("设置文件只读："+file.setReadOnly());
        System.out.println();
        File parentFile = file.getParentFile();
        System.out.println("父对象（该对象会输出父路径）：" + parentFile);
        System.out.println("父目录包含的文件名的字符串数组：" + Arrays.toString(parentFile.list()));// [test004.xml, test002.txt, test003.txt, test001.txt, test004.txt]
        System.out.println("父目录包含的文件的数组：" + Arrays.toString(parentFile.listFiles()));// [/Users/edz/workspace/test004.xml, /Users/edz/workspace/test002.txt, /Users/edz/workspace/test003.txt, /Users/edz/workspace/test001.txt, /Users/edz/workspace/test004.txt]
        file.deleteOnExit();// 在虚拟机终止时，请求删除此抽象路径名表示的文件或目录。
    }

    /**
     * 根据FilenameFilter过滤目录文件
     * <p>
     * public String[] list(FilenameFilter filter)  [true：add ，false：abandon]
     * 返回由包含在目录中的文件和目录的名称所组成的字符串数组，这一目录是通过满足指定过滤器的抽象路径名来表示的。
     */
    @Test
    public void testGetFileNamesByFileNameFilter() throws IOException {
        File fileDir = new File("/Users/edz/workspace");
        if (fileDir.exists()) {
            System.out.println(fileDir);
            /*
                    法1
             */
            // 返回符合条件的文件名字符串
            String[] list = fileDir.list((dir, name) -> {
                System.out.println(dir);
                //String的 endsWith(String str)方法  筛选出以str结尾的字符串
                return name.endsWith(".txt") ? true : false;
            });
            /*
                    法2
             */
//            String[] list = fileDir.list(new FilenameFilter() {
//                public boolean accept(File dir, String name) {
//                    System.out.println(dir);
//                    //String的 endsWith(String str)方法  筛选出以str结尾的字符串
//                    return name.endsWith(".txt") ? true : false;
//                }
//            });
            System.out.println("过滤前：" + Arrays.toString(fileDir.list()));
            System.out.println("过滤后：" + Arrays.toString(list));

        }
    }

    /**
     * 根据FileFilter过滤目录文件
     * <p>
     * public File[] listFiles(FileFilter filter)  [true：add ，false：abandon]
     * 返回表示此抽象路径名所表示目录中的文件和目录的抽象路径名数组，这些路径名满足特定过滤器。
     */
    @Test
    public void testGetFilesByFileNameFilter() throws IOException {
        File fileDir = new File("/Users/edz/workspace");
        if (fileDir.exists()) {
            System.out.println(fileDir); // 返回绝对路径
            // 返回符合条件的文件名字符串
            File[] files = fileDir.listFiles(pathname -> {
//                    System.out.println(pathname);// 包括目录本身路径
                return pathname.isFile() && pathname.getName().endsWith(".xml");
            });
            System.out.println("过滤前：" + Arrays.toString(fileDir.listFiles()));
            System.out.println("过滤后：" + Arrays.toString(files));
        }
    }

    /**
     * 创建目录
     * ps：修改文件后：原来的路径虽然代表的文件不存在了，但打印输出原路径不变，需要再获取到修改后的路径，代表修改后的文件
     *
     * @throws IOException
     */
    @Test
    public void createDir() throws IOException {
        File fileDir = new File("/Users/edz/workspace/test/test001");
        if (!fileDir.exists()) {
//            fileDir.mkdir(); // 创建目录
            boolean mkdirs = fileDir.mkdirs();// 多级创建
            System.out.println(mkdirs);
            System.out.println(fileDir);
        }

        File newFileDir = new File("/Users/edz/workspace/test/test002");
        boolean b = fileDir.renameTo(newFileDir);
        System.out.println(b);
        //重新命名后，但打印原路径
        System.out.println("目录/文件重新命名后file：" + fileDir); // 虽然test001已经不存在，但仍为原路径
        //打印修改后的路径
        System.out.println("目录/文件重新命名后newFile：" + newFileDir); // 虽然test001已经不存在，但仍为原路径
    }
    /**
     * 创建新文件：给定前缀、后缀、目录名
     *
     *
     */
    @Test
    public void createByFileTemplate() throws IOException {
        File file = new File("/Users/edz/workspace/");
        //删除指定前缀的文件（lambda）
        File[] files = file.listFiles(pathname -> pathname.isFile() && pathname.getName().startsWith("lsb-"));
        for (int i = 0; i < files.length; i++) {
            files[i].delete();
        }
        for (int i = 0; i < 3; i++) {
            File.createTempFile("lsb-",".xml",file);
        }
        System.out.println(Arrays.toString(file.list()));
    }
    /**
     * 创建新文件：给定前缀、后缀、目录名
     *
     *
     */
    @Test
    public void testCatalog() throws IOException {
        System.out.println("--等待完成--");
    }

}
