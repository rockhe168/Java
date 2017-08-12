package com.rock.java8.lambda;

import com.rock.java8.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 何湘红[499233529@qq.com] on 2017/8/12 0012.
 */
public class TestLambda1 {

    //需求：获取公司中年龄小于 35 的员工信息

    List<Employee> employeeList = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //需求：获取公司中年龄小于 35 的员工信息
    public List<Employee> filterEmployeeAge(List<Employee> emps){
        List<Employee> list = new ArrayList<>();

        for (Employee emp : emps) {
            if(emp.getAge() <= 35){
                list.add(emp);
            }
        }

        return list;
    }

    //需求：获取公司中工资大于 5000 的员工信息
    public List<Employee> filterEmployeeSalary(List<Employee> emps){
        List<Employee> list = new ArrayList<>();

        for (Employee emp : emps) {
            if(emp.getSalary() >= 5000){
                list.add(emp);
            }
        }

        return list;
    }

    @Test
    public void test1(){
        List<Employee> list =filterEmployeeAge(employeeList);
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }



}
