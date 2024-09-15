package com.example.roomdatabase.View.Addapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.roomdatabase.Model.Database.Employee;
import com.example.roomdatabase.R;

import java.util.List;

public class EmployeeSpinnerAdapter extends BaseAdapter {
    private List<Employee> employees;

    public EmployeeSpinnerAdapter(List<Employee> employees){
        this.employees=employees;

    }
    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Employee getItem(int position) {
        return employees.get(position);
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return employees.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(view==null){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.costume_spinner_item,parent,false);

        }
        TextView textView=view.findViewById(R.id.emp_name);
        Employee employee=getItem(position);
        textView.setText(employee.getName());

        return view;
    }
}
