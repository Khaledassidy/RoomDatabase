package com.example.roomdatabase.View.UIController;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.roomdatabase.View.Addapter.EmployeeSpinnerAdapter;
import com.example.roomdatabase.Model.Database.Employee;
import com.example.roomdatabase.Model.Database.Salary;
import com.example.roomdatabase.ViewModel.MyViewModel;
import com.example.roomdatabase.databinding.ActivityAddSalaryBinding;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//bade bas ekbous 3al menue le bel main actvity yen2elne 3ala hyde l activity
//houn kamne 3ande button bte5tar mena tare5 kamen bade 2a3ml clander dialog w nfs le 3mlto hounek
//hala2 bade 3abe l spinner keef mn5elel viewmodel fa b3ref viewmodel

public class AddSalaryActivity extends AppCompatActivity {
    ActivityAddSalaryBinding binding;
    Calendar slectedDate=Calendar.getInstance();
    MyViewModel viewModel;
    EmployeeSpinnerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddSalaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel=new ViewModelProvider(this).get(MyViewModel.class);
        adapter=new EmployeeSpinnerAdapter(new ArrayList<>());
        binding.spinnerEmployee.setAdapter(adapter);
        viewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                adapter.setEmployees(employees);
            }
        });

        binding.pickSlaryDate.setOnClickListener(v->{
            DatePickerDialog datePickerDialog=DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                    binding.pickSlaryDate.setText(dayOfMonth+"/"+monthOfYear+"/"+dayOfMonth);
                    slectedDate.set(Calendar.YEAR,year);
                    slectedDate.set(Calendar.MONTH,monthOfYear);
                    slectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                }
            }, Calendar.getInstance());
            datePickerDialog.show(getSupportFragmentManager(),null);
        });

        binding.saveSalry.setOnClickListener(v->{
            String stramount=binding.amount.getText().toString();
            long empid=binding.spinnerEmployee.getSelectedItemId();
            if(TextUtils.isEmpty(stramount) || empid==-1 || slectedDate==null){
                Toast.makeText(this, "please enter a valid data", Toast.LENGTH_SHORT).show();
                return;
            }
            double amount =Double.parseDouble(stramount);
            Salary salary=new Salary(amount,slectedDate.getTime(),empid);
            viewModel.insertSalary(salary);


            });
    }
}