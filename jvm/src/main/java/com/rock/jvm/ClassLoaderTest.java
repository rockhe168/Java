package com.rock.jvm;

/**
 * @author: xhhe
 * @Date: xhhe on 2018/5/9.
 * @Description:
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println("类加载器............................Start");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
        System.out.println("----------------------------------------------------");


        System.out.println("类加载..............................Start");
        ClassLoader classLoader = HelloWorld.class.getClassLoader();
        System.out.println(classLoader);

        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        classLoader.loadClass("com.rock.jvm.UserInfo");

        //使用---->Class.forName()来加载类，默认会执行初始化块
        Class.forName("com.rock.jvm.UserInfo");

        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        //Class.forName("com.rock.jvm.UserInfo", false, classLoader);

        /**
         * Class.forName()和ClassLoader.loadClass()区别
         Class.forName()：将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块；
         ClassLoader.loadClass()：只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
         Class.forName(name,initialize,loader)带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象 。
         */

        System.out.println("----------------------------------------------------");

    }


}
