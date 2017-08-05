package com.rock.java8;

import com.rock.java8.model.UserInfo;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println("java8");

        UserInfo userInfo = new UserInfo();
        userInfo.setName("rock");
        userInfo.setAge(30);

        Optional<UserInfo> user = Optional.ofNullable(userInfo);
        System.out.println(user.map(p->p.getName()).orElse("no set name"));
        userInfo.setName(null);
        System.out.println(user.map(p->p.getName()).orElse("no set name"));
    }
}
