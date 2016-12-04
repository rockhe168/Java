package com.rock;

import com.rock.database.Constraints;
import com.rock.database.DBTable;
import com.rock.database.SQLInteger;
import com.rock.database.SQLString;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhhe on 2016/11/30.
 */
public class TableCreator {

    public static void handler() throws ClassNotFoundException {
        //获取指定目录下的java类
         String path = System.getProperty("user.dir");
         path = path+ "\\annotations\\src\\main\\java\\com\\rock\\model\\";
         System.out.println(path);

         File file = new File(path);
         String[] fileList = file.list();


         //遍历实体
         for (String className:fileList)
         {
             System.out.println(className);
             Class<?> cl = Class.forName("com.rock.model.Member");
             DBTable dbTable = cl.getAnnotation(DBTable.class);
             if(dbTable == null)
             {
                 System.out.println("No DBTable annotations in class " + className);
                 continue;
             }
             //表名
             String tableName = dbTable.name();
             if(tableName.length() <1)
             {
                 tableName = "t_"+cl.getName().toLowerCase();
             }

             //获取所有的字段
             List<String> columnList =new ArrayList<String>();

             for (Field field:cl.getDeclaredFields())
             {
                 String columnName = null;
                 Annotation[] anns = field.getDeclaredAnnotations();
                 if(anns.length < 1)
                     continue; // Not a db table column
                 if(anns[0] instanceof SQLInteger) {
                     SQLInteger sInt = (SQLInteger) anns[0];
                     // Use field name if name not specified
                     if(sInt.name().length() < 1)
                         columnName = field.getName().toUpperCase();
                     else
                         columnName = sInt.name();
                     columnList.add(columnName + " INT" + getConstraints(sInt.constraints()));
                 }
                 if(anns[0] instanceof SQLString) {
                     SQLString sString = (SQLString) anns[0];
                     // Use field name if name not specified.
                     if(sString.name().length() < 1)
                         columnName = field.getName().toUpperCase();
                     else
                         columnName = sString.name();
                     columnList.add(columnName + " VARCHAR(" + sString.length() + ")" + getConstraints(sString.constraints()));
                 }
             }

             //生成sql
             StringBuilder createCommand = new StringBuilder(
                     "CREATE TABLE " + tableName + "(");
             for(String columnDef : columnList)
                 createCommand.append("\n    " + columnDef + ",");
             // Remove trailing comma
             String tableCreate = createCommand.substring(
                     0, createCommand.length() - 1) + ");";
             System.out.println("Table Creation SQL for " +
                     className + " is :\n" + tableCreate);
         }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if(!con.allowNull())
            constraints += " NOT NULL";
        if(con.primaryKey())
            constraints += " PRIMARY KEY";
        if(con.unique())
            constraints += " UNIQUE";
        return constraints;
    }

}
