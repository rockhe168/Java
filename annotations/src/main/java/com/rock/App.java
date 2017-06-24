package com.rock;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!---------->" );

        try {

            TableCreator.handler();

        }catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public  static  int add(int x,int y)
    {
        int result = x+y;
        return result;
    }
}
