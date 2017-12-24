package com.rock.java8.lambda;

import com.rock.model.Employee;
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
    public void test(){
        System.out.println("获取公司中年龄小于 35 的员工信息--->");
        //获取公司中年龄小于 35 的员工信息
        List<Employee> list =filterEmployeeAge(employeeList);
        for (Employee emp : list) {
            System.out.println(emp);
        }
        System.out.println("获取公司中工资大于 5000 的员工信息--->");
        //获取公司中工资大于 5000 的员工信息
        List<Employee> list2 =filterEmployeeSalary(employeeList);
        for (Employee emp : list2) {
            System.out.println(emp);
        }
    }


    public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp){
        List<Employee> list = new ArrayList<>();
        for (Employee emp : emps) {
            if(mp.filter(emp)){
                list.add(emp);
            }
        }
        return list;
    }

    //优化方式一：策略设计模式
    @Test
    public void test1(){
        List<Employee> list = filterEmployee(this.employeeList, new FilterEmployeeForAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println("------------------------------------------");

        List<Employee> list2 = filterEmployee(this.employeeList, new FilterEmployeeForSalary());
        for (Employee employee : list2) {
            System.out.println(employee);
        }
    }


    //优化方式二：匿名内部类
    @Test
    public void test2(){
        List<Employee> list = filterEmployee(this.employeeList, new MyPredicate<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getAge() <= 30;
            }
        });
        for (Employee emp : list){
            System.out.println(emp);
        }
        System.out.println("------------------------------------------");

        List<Employee> list2 = filterEmployee(this.employeeList, new MyPredicate<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getAge() >= 5000;
            }
        });
        for (Employee emp : list2){
            System.out.println(emp);
        }
    }

    //优化方式三：Lambda 表达式
    @Test
    public void test3(){
        List list = filterEmployee(this.employeeList,(e)->e.getAge()<=35);
        list.forEach(System.out::println);
        System.out.println("------------------------------------------");
        List list2 =filterEmployee(this.employeeList,(e)->e.getSalary()>=5000);
        list2.forEach(System.out::println);
    }

    //优化方式四：Stream API
    @Test
    public void test4(){
        this.employeeList.stream()
                .filter(p->p.getAge() <= 30)
                .forEach(System.out::println);
        System.out.println("------------------------------------------");

        this.employeeList.stream().filter(p->p.getSalary()>=5000).forEach(System.out::println);
    }

}
