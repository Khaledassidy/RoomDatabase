package com.example.roomdatabase.Repository;
//heda l class bade jame3 fe kel data le 3ana

//bade enshe2 fe constructor bado ye5od bel constructor bado ye5od l Application l2no databse byelzama l context sa7 fa ana ba3te l content ka application ka kola
//hala2 jowet l constructor beje benshe2 databse 2aw b3ref databse MyRoomDatabse db =MyDatabse.getDatabse(application) benshe2 l databse w ba3te l context ka application kola ya3ne getapplication content k2no heeek 3am 2olo

//ba3den bade 3aref doa taba3 l employee w salary l2no heda l class l repostiray 3ebra 3an class tajme3 bejme3 fe l methods  taba3et l employee w salary fa b3ref haw 2 coa global bas declaration
// w jowa l cosntructor be7kelo eno heda l employee doa howe databse dot getemployeedoa  shoft lesh 3arfta bel databse 3ashn 2e2dar 2osala mena w kamen nafs she la slary
//3ashn 2e2dar nafez aye 3mlye bade yeha 3lee

//hala2 kel l methods le badak ta3mela bel nesbe lal insert delete..etc lal employe w slary bjame3a houn
//l calss heda la7 ykoun fe koul l methods le mwjooude be employee doa w slary doa ya3ne enta feek trou7 3ala doa tensa5 l methods koloun w t7otoun  bhyda l class tab3an bala anotations l2no hawde methods ested3a2 bas
//ya3ne btjeeb kel l methods btensa5on bala anotations w btefta7 bracket 3ala kel method bt3be feha data ya3ne fe methods insert delete ..ect
//l2no heda l class bejm3le kel data ba3d heek bseer ana bas best5dem l repository la jeeb data
//ya3ne hala2 bheda l class bade 2a3ml implemntation lal methods kola le bel doa 7a t2ole hal bade 2a3ml implemnattion metl ma kont 2a3ml databse cursor w 100 ossa la2 akeed la2
//houn bel implemnattion bade 2a3ml estd3e2a lal methods le mawjouide bel daw hala2 7a nshof bel tafasel


//hala2 implemnation taba3 l insert keef ba3mela :bkol basata bt2olo employeeDOA dot insertemployee(employee) w bt3te l employee ya3ne bas std3et l method le mawjoude bel doa
//ya3ne ne7na sho 3mlna houn 3mlna method nafs le mawjoude bel doa ok w b2lb hay l methods sorna nestd3e l methods le mawjoude bel doa ya3ne ne7na 3mlna copy past bas 3ashn ykouno nafs l paramter w w lesm 3ashn tarteb
//w bel constructor 3mlna eno nest3mel l doa ta3et l employee bas le mawjoude bel databse w nafs she la salary bas l mawjoude bel databse
//ya3ne 2olna enoml employedoa w l salry doa le bel repositry houne nafsoun l doa le mawjouden bel databse
//ya3ne ne7na mnseer mnestd3e l method bel repositry hay l method btrou7 btestd3ele method le mqjoude bel doa metl tare2et l clicklistner ya3ne ana brou7 bas 2a3ml click listner byestd3ele method le mawjoude bel click litner


//bas ne7na bel databse ne7na ma sam7na eno nafez code bel main thread fa ma fena directly b2lb l method l insert n2olo employeedoa.insert() heek mnseer 3am na3ml she8l bel main thread w ne7na by deffult databse ma by3ml l aye sho8l ela b worker thread 3ashn heeek 3mlna thread pool fa beje b2olo
//MyRoomDatabse.databsewriteexecutor.exute(()->{
//w houn jowa bestd3e l insert
//}
//l2no howe bymn3ne b2ole law enta ma sam7telo bel main thread by deffult byemnak l2no howe by deffult bado ynafezoun b thrad monfesle b2olak l insert 5ale belak badak test3mela b worker thread


//ya3ne hala2 ana e3ed ba3mel estd3e2 lal method l mawjoude bel doa bas lesh?
//alak 3ashn badel ma tektob bel main l kalem heda kolo btrtbo w bt3mlo kel wa7de b method ya3ne le byestd3e msln method l insert le mwjoude bel repositry w ya3tha employee ykoun mraye7 raso eno 7a yestd3e l insert le bel databse ya3ne raya7 7alo la aye she elo 3ela2a bel databse
//houne byosalo bel mabede2 le byosalo 3lyha bel aricuturectre eno ana abde efsel l busness logic 3an aye logic tene ya3ne ana ka programmer sho fahmne bel databse mesh m3ne eno efham databse 5als lakn byesht8el ahmad databse w beslmha la programmer tene bas hay l fekra


//method l retrive l berje3 live data houn bseer se7r eno l room la7ala btshof eno hay l method btrje3 live data fa la7la bt3mel execute lal hay l method in background

//ama be2e l method metl insert,update,delete lezm b thread monfesle

//w l method le ma btrje3 livedata btrje3 list mnest3ml thread monfsle bas ma mn3mle costume listner la tezbat w mn5ale l method void




//ya3ne hla2 ne7na jam3na l method le majoude b 2 dows w 7atynehoun b ma7al wa7ad
//tyeb momken eno bel main activity rou7 2a3ml heda l code:
//MyRoomDatabase db=MyRoomDatabase.getDatabase(application);
//        employeeDOA=db.employeeDOA();
//        salaryDOA=db.salaryDOA();
//momken wala fe aye meshkle bas heek 2artab mesh 7ebeb bt7ot heda l code bel main activity w btestd3e l code bel main activity w btnafez le badak yeh
//btestd3e kel l method bel oncreate ta3el l main activity 3ade bas heek 2artab w a7san

//hala2 bade 2a3ml bel sallary doa method baseta query btrje3 double esma getsalariesSum(log emp_id) w select sum(amount) form salary where empID=:empId) hyde btjble mawjmo3 l 3amoud le ana b7dedo fa 7a yjble majmo3 l amount taba3 l l empid le ana b7dedo w btrje3le double
//hayde btetla3 thread monfesle ma btrje3 livedata iza ma 3mlta b thread b2olak la2 hyde btetlam thread
//fa hala2 bas nestd3e l method bel execute 7a ya3ml meshkle y2olak ween l return
//tyeb hal byenfa3 b2lab l thread t2olo return salareydoa.getsumsalaries(emo_id) la2 akeeed la2
//l2no return hyde saret la method le esma run fa hyda 8alat method run void
//tyeb momken t2ole bade 3aref vaible bara double w jowa estdmo w bara 2a3ml return kamen heda 8alat lesh l2no howe lesh by3mel thread 3ashn ma yontour l method hyde la t5les la ynfez l waraha 3ashn ma y3tel ui thread l2no bte5od wa2t tawel
//fa law 3mlt return la hyde tare2a eno global w jowa equll la hy l method w ba3den bara return hyda 8alat sar l2no 7aya3mel return de8re ma 7ayontour la te5las l method

//tyeb sho l 7al:
//alak bkel basata enta t3lamt mabda2 listner lesh ma t5le l method void hyde w teje
//ta3mel interface nsameha Doublevaluelistner w jowa feha method esma onvaluesubmit(Double) bada te5od double l fekra mn hyde eno metl ma st3mlne bel adpater kouna n3rfo bel adapter 3ashn lama ned8at 3ala she yestd3a w nafez amr bara l adpter
//fa houn nafs she beje 3al method le 3ande b2olo yale bado yestd3e l method hay bado yeb3at ma3a Doublevaluelistner listner lesh
//3ashen lama hyda le jowa l thread l method t5les sho8la ma fene 2a3ml return mobashara bade bas hyda l method sum t5les sho8la ba3d ma t5les sho8la 2olo onvaluesubmit(value) l value heye kemet l function ta3et sum
//fa ana ajbrto eno ba3d ma y5les l code l sum yeb3at l keme le btetla3 lal onvaluesubmit(value)
//fa bara hala2 lama estd3e hay l method be2dar est5dem listner le 3mlto bekl sohole

//fa heek repository 5ales 3ande 3ebara 3an class bejble data mn databse aye maken btest5dmo fe bte2dar te7sal 3ala data

//w kamen heda l repository class momken t3ref  methods btjeeb data mn api mest3mel sho:
//volley
//retrofit
//firebase
//ta3mel aye tawasoul ma3 api w t3ref l method houn bhyda l class fa bseer heda class fe kol data le enta badak yeha badak tosala fa bseer ta3amoul enta kelo ma3 class wa7ad bas fe b2lbo kel she  fa aye data enta badak yeha b2aye maken btelja2 la class l repository w hyda fekret tarteb bel she8l sho8l bseer mnazam w mratab

//howe l concept mn repostory eno yjm3lak kel data mn different source mn api mn room mn cashe mn kel she w bas ykoun 3andak data mn eource wa7ad mesh darore bas ne7na 7a na3mlo


import android.app.Application;

import androidx.lifecycle.LiveData;


import com.example.roomdatabase.Model.DOA.EmployeeDOA;
import com.example.roomdatabase.Model.DOA.SalaryDOA;
import com.example.roomdatabase.Model.Database.Employee;
import com.example.roomdatabase.Model.Database.MyRoomDatabase;
import com.example.roomdatabase.Model.Database.Salary;
import com.example.roomdatabase.Model.Database.SalaryEmployee;

import java.util.Date;
import java.util.List;

public class Repository {
    EmployeeDOA employeeDOA;
    SalaryDOA salaryDOA;

    public Repository(Application application){
        MyRoomDatabase db=MyRoomDatabase.getDatabase(application);
        employeeDOA=db.employeeDOA();
        salaryDOA=db.salaryDOA();


    }


    //employee doa methods

     public void insertEmployee(Employee... employee){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDOA.insertEmployee(employee);

            }
        });
    }

    public void UpdateEmployee(Employee... employees){
        MyRoomDatabase.databaseWriteExecutor.execute(()->{
            employeeDOA.UpdateEmployee(employees);
        });
    }

    public void DeleteEmployee(Employee... employees){
        MyRoomDatabase.databaseWriteExecutor.execute(()->{
            employeeDOA.DeleteEmployee(employees);
        });

    }

    public void DeleteEmployee(String name){
        MyRoomDatabase.databaseWriteExecutor.execute(()->{
            employeeDOA.DeleteEmployee(name);
        });

    }

    public LiveData<List<Employee>> getAllEmployee(){
         return employeeDOA.getAllEmployee();


    }

    public LiveData<List<Employee>> getAllEmployeeByEmail(String email){
          return employeeDOA.getAllEmployeeByEmail(email);

    }

   public LiveData<List<Employee>> getEmployeeByName(String name){
          return employeeDOA.getEmployeeByName(name);

    }

    //salary doa methods

    public void insertSalary(Salary salary){
        MyRoomDatabase.databaseWriteExecutor.execute(()->{
            salaryDOA.insertSalary(salary);
        });
    }

    public void updateSalary(Salary salary){
        MyRoomDatabase.databaseWriteExecutor.execute(()->{
            salaryDOA.updateSalary(salary);
        });
    }

    public void deleteSalary(Salary salary){
        MyRoomDatabase.databaseWriteExecutor.execute(()->{
            salaryDOA.deleteSalary(salary);
        });
    }

    public LiveData<List<Salary>> getEmployeeSalaries(long emp_id){
        return salaryDOA.getEmployeeSalaries(emp_id);

    }

   public LiveData<List<Salary>> getEmployeeSalries(long emp_id, Date from, Date to){
        return salaryDOA.getEmployeeSalries(emp_id,from,to);

    }

    public LiveData<List<Salary>> getEmployeeSalries( Date from,Date to){
        return salaryDOA.getEmployeeSalries(from,to);

    }
    public void getSalariesSum(long emp_id,DoubleValueListner listner){
        MyRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                double value=salaryDOA.getSalariesSum(emp_id);
                listner.onvalueSubmmit(value);
            }
        });
    }
    public LiveData<List<SalaryEmployee>> getSalariesSum(){
        return salaryDOA.getSalariesSum();
    }



}
