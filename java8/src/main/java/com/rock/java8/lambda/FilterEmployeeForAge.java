package com.rock.java8.lambda;

import com.rock.model.Employee;

/**
 * Created by 何湘红[499233529@qq.com] on 2017/8/12 0012.
 */
public class FilterEmployeeForAge implements MyPredicate<Employee> {
    @Override
    public boolean filter(Employee employee) {
        return employee.getAge()<=35;
    }
}
