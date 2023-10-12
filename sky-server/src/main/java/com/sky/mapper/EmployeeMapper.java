package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    @AutoFill(OperationType.INSERT)
    @Insert("INSERT INTO sky_take_out.employee(name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user) " +
            "VALUES" +
            "(#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber},#{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Employee employee);

    @Select("select count(*) from employee where username = #{name}")
    int getUserCount(String name);


    Page<Employee> pageQuery(EmployeePageQueryDTO employeeDTO);

    @AutoFill(OperationType.UPDATE)
    int update(Employee employee);

    @Select("select * from employee where id = #{id}")
    Employee queryById(Long id);
}
