package com.example.roomdatabase.View.UIController;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomdatabase.Model.Database.Employee;
import com.example.roomdatabase.R;
import com.example.roomdatabase.databinding.ActivityAddEmployeeBinding;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

//hala2 houn bas ekbous 3ala l floating action button byen2lne la houn 3ala activity to add employee 3ala l databse

public class AddEmployeeActivity extends AppCompatActivity {
    ActivityAddEmployeeBinding binding;
    Calendar slectedDate;
    public static final String EMPLOYEE_KEY="employee";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddEmployeeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       binding.buttonPickDate.setOnClickListener(v->{
           DatePickerDialog datePickerDialog=DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
               @Override
               public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                   binding.buttonPickDate.setText(dayOfMonth+"/"+monthOfYear+"/"+dayOfMonth);
                   slectedDate=Calendar.getInstance();
                   slectedDate.set(Calendar.YEAR,year);
                   slectedDate.set(Calendar.MONTH,monthOfYear);
                   slectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);
               }
           }, Calendar.getInstance());
           datePickerDialog.show(getSupportFragmentManager(),null);
       });


        binding.saveEmployee.setOnClickListener(v->{
            String name=binding.Fullname.getText().toString();
            String email=binding.Email.getText().toString();
            String id=binding.idNumber.getText().toString();
            long strEmpID=Long.valueOf(id);

            //date badna nda5lo keef ne7an badna nezhal lal user sha8le mnsameha datepicker 3ebra 3an view bt3mel mn 5elela pick la date m3yan enta momken test5dem data picker l efterade 2aw
            //test3mel library l2no data picker l 2efterade kteer kbeer w bado mase7a
            //fa best3mel library esma     implementation(libs.materialdatetimepicker) fa mn5elel hay bezher fragemnt w btale3 dialog b2lba heda l picker
            //fa hala2 bade 2olo lama ted8at 3ala button ta3et pickbirthdate bade esm7a lal most5dem eno ye5tar tare5 keef:
            //fa b2olo DatePickerDialog le mawjoude bel library hay
           // DatePickerDialog dialog =DatePickerDialog.newInstance() l new inatnce hay bte5od listner ya3ne ba3d ma l most5dem y7aded tare5 le bado yeh la 7 yrou7 w ynafez l code le mawjoud bel method l ondataset btb3tlk l year,monthofyear,dayofmonth le 5taroun l user
            //w l mod5al tene howe tare5 l efterade le bado ykoun m7adad law enta 7ebeb t2olo l callander taba3 l initialselection sawe2 7addt l year 2aw l month year 2aw l day 2aw 7addt l canlender
            //bt2olo ,Calander.getinstance() 3ashen y7aded l wa2t l 7ale keef ya3ne y7ded l wa2t l 7ale ya3ne 2awl ma yblesh l calander l wa2t l efterade le yest5dmo howe l wa2t l 7ale ya3ne ykoun m7ded l year,month,day l 7alayen  le enta mawjoud fehoun
            //tab3an 2awl ma te5tar tare5 7a yestd3e method l esma ondateset w 7a yeb3tlk l year ,monthofyear w dayofmonth
            //hala2 bade e5od tare5 le b7dedo l user b3ref vaible mno3 Calander
            //bade 2awl ma l user y7ded l tare5bade rou7 2olo selectedDate=Calnder.getinstance() ya3ne equll lal wa2t l 7ale
            //ba3den bade 3abe fe selecteddate.set(Calander.Year,year),setdate.set(Calnader.Month,month)....etc
            //fa houn bel zabt k2ne 3arft mot8yer global w 5aznat fe keyam l youm w shahr w year le l user 7adadoun w 3adtoun 3ala l button text
            //fa hala2 bel save btn beje bef7s l mot8yer taba3e iza keen l name empty 2aw email empty 2aw id empty 2aw l calander le howe selectedDate==null
            //best5em TextUtlis.isEmpty(name) mlsn la kel wa7de le string
            //fa hala2 houn enta bhay shshe ma3ndak viewmodel asln manal me7tejo ma fe change confiration fa enta houn btrj3o lal main activity w l mainactivity heye defo
            //Intent intent =new Intent()
            //intent.putextra(EMPLOYEE_KEY) w bt3te l employee fa heek 3ashn teb3at obejct serizalizable bas ma byemshe l 7al ela iza 3mlt emolemnt la class l employee implement serializable
            //ba3den bade sha8lo b7ot dialog.show() howe 3ebra 3an fragemnt 3adeye fa heye nafs l fragemnt dialog kont test3mela bel dialog bas houn costumize fa l getshow bte5od fragemnt fa bt2olo getsupportFragmentManager(),w tene parameter bt3te null le howe tag
            //2awl parameter bye5do le getshof howe l fragemnt manager tene paramter howe l tag bt2olo null


            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(id) ||slectedDate==null){
                Toast.makeText(this, "please enter valid data", Toast.LENGTH_SHORT).show();
                return;

            }
            else{
                Employee employee=new Employee(strEmpID,name,slectedDate.getTime(),email);
                Intent intent=new Intent();
                intent.putExtra(EMPLOYEE_KEY,employee);
                setResult(RESULT_OK,intent);
                finish();


            }
        });


    }
}