package com.example.roomdatabase.Model.Database;

public class SalaryEmployee {
    public String _name;
    public double _salary;

    public SalaryEmployee(String _name, double _salary) {
        this._salary = _salary;
        this._name = _name;
    }

    public SalaryEmployee(){

    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public double getSlary() {
        return _salary;
    }

    public void setSlary(double _salary) {
        this._salary = _salary;
    }
}
