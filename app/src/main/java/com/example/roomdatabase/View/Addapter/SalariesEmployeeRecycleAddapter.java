package com.example.roomdatabase.View.Addapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.R;
import com.example.roomdatabase.Model.Database.SalaryEmployee;
import com.example.roomdatabase.ViewModel.MyViewModel;
import com.example.roomdatabase.databinding.CostumeSalaryEmployeeItemBinding;

import java.util.List;

public class SalariesEmployeeRecycleAddapter extends RecyclerView.Adapter<SalariesEmployeeRecycleAddapter.SalEmpHolder> {
    private List<SalaryEmployee> employees;
    private MyViewModel viewModel;

    public SalariesEmployeeRecycleAddapter(List<SalaryEmployee> employees,MyViewModel viewModel){
        this.employees=employees;
        this.viewModel=viewModel;
    }

    public SalaryEmployee getitem(int postion){
        return employees.get(postion);
    }

    @NonNull
    @Override
    public SalEmpHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.costume_salary_employee_item,parent,false);
        return new SalEmpHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SalEmpHolder holder, int position) {
            holder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }





    class SalEmpHolder extends RecyclerView.ViewHolder{
        CostumeSalaryEmployeeItemBinding binding;
       // Employee employeeee;
        public SalEmpHolder(@NonNull View itemView) {
            super(itemView);
            binding=CostumeSalaryEmployeeItemBinding.bind(itemView);

        }

        public void bind(SalaryEmployee employee){
//            this.employeeee=employee;
//            binding.tvName.setText(employeeee.getName());
//            myViewModel.getSalariesSum(employeeee.getId(), new DoubleValueListner() {
//                @Override
//                public void onvalueSubmmit(double value) {
//                    binding.tvSalary.setText(String.valueOf(value));
//
//                }
//            });
            binding.tvName.setText(employee._name);
            binding.tvSalary.setText(String.valueOf(employee._salary));

        }
        
    }
}
