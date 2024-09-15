package com.example.roomdatabase.Model.DOA;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import com.example.roomdatabase.Model.Converter.DateConverter;
import com.example.roomdatabase.Model.Database.Salary;
import com.example.roomdatabase.Model.Database.SalaryEmployee;

import java.util.Date;
import java.util.List;

//ka3de aye maken aye class DOA 2aw entity 2aw aye maken enta btest5dem fe date bt3le2 bel room databse lezm lezm test5dem fe l converter fa b7ot notation taba3 l conerter 3ashn yefham eno l class fe date w fe 3mlyet ta7wel been dates



@Dao
@TypeConverters({DateConverter.class})
public interface SalaryDOA {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSalary(Salary salary);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateSalary(Salary salary);

    @Delete
    void deleteSalary(Salary salary);

    @Query("select * from Salary where empId=:emp_id order by date desc")
    LiveData<List<Salary>> getEmployeeSalaries(long emp_id);

    @Query("select * from salary where empId=:emp_id AND date>=:from AND date<=:to order by date desc")
    LiveData<List<Salary>> getEmployeeSalries(long emp_id, Date from,Date to);

    @Query("select * from salary where date>=:from AND date<=:to order by date desc")
    LiveData<List<Salary>> getEmployeeSalries( Date from,Date to);

    @Query("select sum(amount) from salary where empId=:emp_id")
    double getSalariesSum(long emp_id);

    @Query("SELECT SUM(amount) AS _salary, name AS _name \n" +
            "FROM employee_table \n" +
            "LEFT JOIN salary ON empId = emp_id \n" +
            "GROUP BY name")
    LiveData<List<SalaryEmployee>> getSalariesSum();
}
