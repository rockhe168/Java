package com.rock.model;

import com.rock.database.Constraints;
import com.rock.database.DBTable;
import com.rock.database.SQLInteger;
import com.rock.database.SQLString;

/**
 * Created by xhhe on 2016/11/30.
 */

@DBTable(name = "t_member")
public class Member {

    @SQLInteger(name = "Id",constraints = @Constraints(primaryKey = true))
    int memberId;
    @SQLInteger
    int age;
    @SQLString(name = "userName")
    String name;
    String remark;

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }

    public int getMemberId()
    {
        return this.memberId;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return  this.age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getRemark()
    {
        return  this.remark;
    }
}
