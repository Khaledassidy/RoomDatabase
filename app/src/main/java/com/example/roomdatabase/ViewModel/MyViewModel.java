package com.example.roomdatabase.ViewModel;
/*
l view model heda 3ebra 3an sha8le mawjoude bel aricheturecture commponent
fa 2awl she ba3ml heda l class ykoun extend mn class esmo AndroidViewModel
w b2olak heda l class eno lezm ykoun fe constructor b2lbo Application 3ashn yeb3at hyda l application la super() lal ab


lviewmodel:heda elo meze sho heye meze ?:
alak enta fete7 application taba3ak l application taba3ak fe search b2lbo fa fat7t hal search w enta sha8al bel telephone poratriat 3ade w ro7t enta bhal search 3mlt search la kelmet pizza msln tala3le lista feha kel item l pizza hala2 law 2alabet l device 3ala l landscape hal mante2 yerja3 yenshe2 databse mara tenye w ya3ml l 3amlye mara tenye  la2 5als data beala mote7a lista ta3et l pizza bedal 3andak dtabase object mawjoud 3adak
absta sha8le lesh lama yo2loub shshe yrou7 yenshe2 object mn databse,lesh lama t8ayer l configuration taba3 l screen 2aw taba3 l activity yrou7 ya3mel reacreate la database bkel basata mesh lezmetne l 3amleye hay
fa eja alak l android viewmodel heda lama enta t3ref kel  l methods le 3araftoun bel repossitory bde5lo enta btstafed mn meze sho l meze hay ?
eno data bedal mote7a 7ata law l activity 8ayret l oriantion taba3ha 2aw 2lab l user shshe 2aw 8ayar configuration l activity ma fe meshkle 3ande ya3mel le bado yeh 7adala l data mote7a 3nade
3ashn heek bel documnation btl2e 3mlk eno activity insatnce 3andak sar feha rotation event reacreated activity instnce data 7adala mote7a mesh 7ayrou7 ya3mel ma3 l activity object mara tenye
zamen kona mesh fahmanen kona nrou7 na3ml databse w n3refa bel activity lesh kona biggners w keen kol ma ya3mel rotate lal activity yrou7 ya3mel intance jdede la databse fa keen nees 3ashn yohrbo mn l meshkle hay keno yrou7o ysabto shshe eno mamno3 ta3ml rotate ma y5le l user ye2dar ya3ml rotation
heek hala2 saret l 2omour wad7a w sar l eshya m3rafe bel viewmodel fa enta bt3ref kel data le bada l ui tetwasal ma3a bde5el viewmodel hala2 meen wasetak lal activity 2aw l fragemnt l viewmodel ma elak 3ela2a b 2aye 7ada enta elak 3el2a bas bel viewmodel heye le bada ta3ml populate la activity b data
tyeb repository? ma ele ba3d feha she bas l viewmodel
tyeb l doa? ma ele feha she ba3d bas l viewmodel
tyeb databse ?ma ele feha l class bas  l view model

ana bas mn l activity bet3emal ma3 l viewmodel ya3ne law ma3e partner lama salmo mashro3ak 7a yet3emal bas ma3 l viewmodel


fa bel 7ale hayde lezm 3aref kel l methods le bel repository b2alb l viewmodel sa7 wala la2 sa7

fa 5alene 3aref l Repository houn global Repository repostory
w b3lb l constructor ba3ml intilize la 2elo w b3te b2lb l constrictor l apllication
7a t2ole bade 2a3ml databse la2 ma howe enta bas 3am ta3ml obejct repository b2lbo 3am ta3ml databse

hala2 bensa5 kel l methods l mawjoude bel repository nafsa tyeb 3am karera eh 3ade bkarera mesh meshkle

hala2 bestd3e l methods l repository ya3ne repository dot msln getallemployee()
fa brou7 bestd3e l method mn repository w hay l method bel repository b2lba l thread fa 7a testd3a w bas tsd3a 7a testd3a l method le mawjoude bel doa le howe fe l method kola le m3araf bel databse fa 7a ynafez l code yjeblak kel l employee
ya3ne l 2ossa hala2 rj3a rjou3 mn repository la callass l doa
heek 5alst l viewmodel kolo

viewmodel bdala sha8ale tool l wa2t btwa2ef b7ale mo3ane:
In the case of an activity, when it finishes.
In the case of a fragment, when it detaches.
In the case of a Navigation entry, when it's removed from the back stack.

ya3ne viewmodel bdala 3eyshe bel oncreate onstart on resume ba3den bas na3mel rotate l system by3ref eno ma 7ayseer destroy 3al 2e5er fa be7fez l state ta3et l viewmodel bel cashe w bseer pause stop create start rsume fa houn byerja3 bjeeb state l viewmodel l2no houn howe ma 7a yerja3 ya3mel instance jdede 7a yshf eno 3ando isntance fa 7adal data metl ma heye ma 7ayen3mal reset ama bas 2a3ml close lal app system by3ref eno houn how 7a ydamer kel l app  ma 7a yerja3 ya3mel create so houn byems7e kel she resource w mnhay resource byem7e l viemodel sa3eta bas nefta7 nerj3 l app mnerja3 mn3mel isnatnce jdede mn l viwmodel
bas fe tare2a eno ta3mel viewmodel dala 3eyshe been l activity w fragemnt toul ma l application 3eyshe w mn3mla close she esmo shared viewmodel

viwmodelprovider(this) hyde ms2ole 3ala l lifecycle ta3et l viwmodel w btbt l viwmodel bel owner taba3a ya3ne bas n7ot this rabtna hay l viwmodel bhay l activity 3ashn ta3ref aymta 3am yseer configration jdede 2aymta 3am tetdmar l viewmodel
.get(myvidemodel.class):hyde btrje3 insatnce men l viewmodel heda iza kenet mawjoude iza la2 bt3mel new isnatnce 2awl ma tefta7 l app bt3mel new isnatnce ba3de bas tseer ta3mel rotate btbtel t3mel intance btjeeb l inatnce l3nda btkoun m7fza l state taaba3 l ui b2lb l cashe bas yseer configration change









 */


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdatabase.Model.Database.Employee;
import com.example.roomdatabase.Model.Database.Salary;
import com.example.roomdatabase.Repository.DoubleValueListner;
import com.example.roomdatabase.Repository.Repository;
import com.example.roomdatabase.Model.Database.SalaryEmployee;

import java.util.Date;
import java.util.List;

public class MyViewModel extends AndroidViewModel {
    Repository repository;
    public MyViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);

    }

    public void insertEmployee(Employee... employee){
        repository.insertEmployee(employee);



    }

    public void UpdateEmployee(Employee... employees){
            repository.UpdateEmployee(employees);
    }

    public void DeleteEmployee(Employee... employees){
            repository.DeleteEmployee(employees);

    }

    public void DeleteEmployee(String name){
            repository.DeleteEmployee(name);

    }

    public LiveData<List<Employee>> getAllEmployee(){
        return repository.getAllEmployee();


    }

    public LiveData<List<Employee>> getAllEmployeeByEmail(String email){
        return repository.getAllEmployeeByEmail(email);

    }

    LiveData<List<Employee>> getEmployeeByName(String name){
        return repository.getEmployeeByName(name);

    }

    //salary doa methods

    public void insertSalary(Salary salary){
            repository.insertSalary(salary);
    }

    void updateSalary(Salary salary){
            repository.updateSalary(salary);

    }

    void deleteSalary(Salary salary){
        repository.deleteSalary(salary);
    }

    public LiveData<List<Salary>> getEmployeeSalaries(long emp_id){
        return repository.getEmployeeSalaries(emp_id);

    }

    public LiveData<List<Salary>> getEmployeeSalries(long emp_id, Date from, Date to){
        return repository.getEmployeeSalries(emp_id,from,to);

    }

    public LiveData<List<Salary>> getEmployeeSalries( Date from,Date to){
        return repository.getEmployeeSalries(from,to);

    }

    public void getSalariesSum(long emp_id, DoubleValueListner listner){

        repository.getSalariesSum(emp_id,listner);

    }

    public LiveData<List<SalaryEmployee>> getSalariesSum(){
        return repository.getSalariesSum();
    }



}
