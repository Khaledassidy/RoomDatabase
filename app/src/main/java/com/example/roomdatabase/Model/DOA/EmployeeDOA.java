package com.example.roomdatabase.Model.DOA;
//EmployeeDoa:7aykoun fe l methods le bade est5dema la 2a3ml accces 3ala l databse metl insert delete,update bas hawde le 5asoun be table l employee
//kamen doa bye3temed 3ala l anotation 3ashn yefham room database 2aw system eno heda 3ebra 3an Doa taba3 room databse lezm deef anotaions:
//2awl anotation bade 2olo eno heed l class howe DOA fa b2olo @Doa fa houn fehem eno heda l class howe doa tab3an howe ma fehem eno la jadwal mo7adad fa fe3lyn 7asab l methods le enta btktoba byet3emal ma3a fa heda 7aykoun fe methods bas ta3el l emloyee enta momken ta3mel doa wa7d bas fe methods ta3el kel l tables

//fa 2awl she bade 2a3ml method insert:
//bekl basata bt3mel method: void insertEmployee(Employee employe); method bt3ml insert la employee w bte5od paramter employee w btektob faw2a @Insert fehem system eno hay method insert bdeef object mno3 employee 3ala jadwal l employee bas hay kel l 2adeye bel room database ya3n bhay tare2a ra7yak mn ketebet l code keen l insert ta3mela b she 5 tostour cursor w 100 5areye howe heek fehem la7lo eno hay method insert 3ala l room datsbse mn 5elel l anotation
//tyeb iza jeet 2oltelo @insert employee bas 3 no2at sho ya3ne:    void insertEmployee(Employee... employee); hay 3ebra 3al array k2nak bt3mel generic number of arguments k2nak bt3mel 3adad l argument l bel method generic ya3ne sawe2 ma deft wala wa7ad 2aw wa7ad 2aw tenen 2aw 10 2aw 100 7a ydeflak yehoun keloun kamen room bete7lak heda she enak deef aktr mn object mobashara bel method hay tyeb enta mesh 7ebeb traje3 void 7ebeb traj3e long  fa bt2olo long insertEmployee(Employee... employee) l2no mn3ref method l insert btrje3 long ra2m l row le ndaf iza naja7et w iza la2 btrje3 -1


//tyeb iza bade 23mel update:
//nafs she bas bt3mel anotation @Update sawe2 ta3del wa7d eployee 2aw aktar keef bya3mel update howe: ma by3mel l 3mlye kola

//law bade 2a3mel delete nafs l update bel zabt bas anotion @delete
//kamen 7asab l primary le 3andak by3mel delete bt3te object berou7 beshof l primary key ween b2aye row fa byel8e l row le 3ando id kaza le howe l primary key

//tyeb barke badna n3mle delete bene2an 3ala shart m3yan:
//bt3mel query bt3mel method msln badak ya3mel delete bene2an 3ala l esm kaza void deleteemployee(String email) badak te7zef kel l mwazafen le 2eloun email kaza
//w btktob fo2 hay l method @Query mesh @delete
//btktob @Query("") w btktob b2lb l " " l qery le badak yeha msln delete from iza nseet esm table bt3ml controle w spave btl3lak asme2 table bt7oto fa delete from employee_table where iza nseet asme2 l column b table l employe kamen control space bl2elak yehoun fa where email= la yjblak l parameter le bel function deleyeemployee bta3ml : no2ten fo2 ba3doun ya3ne =: ba3den controle w space fa btl2e japalak l paramter le bel method delete employee btn2e l email fa howe heek 7a yo7zflak rows le mawjoud bel table l employee lama ykoun l email le mawjoud bel table equll lal emial lal bel paramter

//tyeb bade 2a3ml retrive la kel l empolyee le bel databse:
//kamen ba3mel @query("") w b3mel method esma getallemployee() w b2olo bado yrj3lek mn datbase List<Employee> ya3ne bado yrja3le lista mno3 emloyee
//ya3ne list<Employee> getallemployee(); fa 7anyrj3le kel l employee w y7tele yehoun b list howe by3mel cursor jowa w by3mel le bado yeh
//mnktob fo2 l method @Query("select * form Employee_table order by name asc") ya3ne jeble kel l employee mrataben 7asab name tasa3oude

//tyeb ana bade 2a3ml retrive la kel l employe 7asab l emil bas ya3ne le 3andoun emial kaza
//fa ba3emll nafs she kamen query w b2olo where email =:emil

//hal2 msln 7ebeb 2a3mel search 3an mwazaf bas bel esm ya3ne bel like:
//@Query("select * from employee_table where name like:'%'+name+'%'") kona na3ml heek ne7nabel sqlite bas heek 8alat lesh l2no houn mana m3rafe esharet l + fa btest3mel badela l or || heye badel lal + ya3ne || heye eshret damj badel l plus
//   hay sa7e7a @Query("select * from employee_table where name like '%'||:name||'%'")


//hala2 heek 5aslna

//bas mola7za halal2 bel query 3am terja3 data 3ala shakl list 3ashn 5ale hay data live ya3ne hay data te7tewe 3ala listner 3nde class esmo LiveData<List<Employee>> heda l class live data ana momken e7tewe l keme le rj3t bel 2aleb le esmo livedata
//keef ya3ne hay l eme le btrja3 bade e7weha b livedata ?
//alak class livedata heda fe joweta observer sho l observer l observer 3tebro metlo metl listner listner sa7e la aye ta8yer 3ala data le btseer b lista hay
//ma3na l kalem heda lama ana 5alet no3 data le bterja3 livedata ya3ne ay ta8yer 3ala l jadwal l employee table le mawjoud bel databse mobashar data 2aw l observer la7 yrou7 yjeblak listet l data l jdede w yraj3lk yeha w y2olak 5od hay data l jdede ba3d ma t8ayaret  fa hay listner 3ala ta8yer data bel databse
//data btkoun live 2awal b2awl m7dase syncrinization bte2dar t3mel aye action 3lyha
//fa aye data bade mobashra  tkoun m7dase 3ande w mote7a braje3a b obejct esmo livedata lesh?
//3ashn l method hay edman data le btrja3 mena heye e5er data tam ta3del 3lyha 3ala databse
//live data 3ebra 3an conatiner lal baynet fe observer b2lbo l observer 3ebra 3an litner sa7e la aye ta8yer 3ala table  data btem 3ala datsbse
//bedman data le btrj3le heye e5er data m7dase 3ala databse updated 2awl b 2awl
//ya3ne aye uopdate delete,insert 3ala table l employee de8re method l e btkoun btrje3 live data 7a ta3ml reflect w tjeble e5er data be table ya3ne 3atioul method le btrjae3 live data 3atoul 7a tkoun 3eyshe litner le feha w 2awl ma tshof fe ta8yer bterja3 la7ala btestd3a w bt7ades data



//LiveData<List<Employee>> vs LiveData<Employee>
// LiveData<Employee>:ya3ne observe employe wa7ad b2lb l table l employe ya3ne badak ta3mel observe la row wa7d
//LiveData<List<Employee>> :ya3ne observe la majmo3et employe be table l employe ya3ne badak ta3mel observe la kel row 2aw majmo3et row bel table l esmo employe


//heek 5asln DOA taba3 l employee hala2 balesh doa taba3 l salary

//note 3ande sha8le bel insert  w l update eno bas tnafez hay l 3malye momken enta da5el nafs l id fa houn 7a yseer conflict fa bt2olo eno onconflict eno iza sar hay l conflict ingnore ma t3mela lal 3amlye 2aw eno momekn column m3rfo unique fa enta trou7 t3dlo w t7oto eme byeshbah eme mawjoude fa enta bt2olomiza saret hay l 7ale ignore ma ta3mela
//ya3ne le sar bel zabt enta bas 3am tektob query select * from employee w t7ot return live data room databse anlyze l query w bt7alela w bt3ref eno hay l qeury 3am ya3mloha la employee table so ra2bele l employeetabele iza bseer ta8yer 3lee fa inta bas ta3mel insert 3am yet8ayr emet l employee table w ne7na 3am nra2bel l employee table so sa3eta they notify eno sar ta8yer bel employee table w 7a yeb3at e5er data mawjoude bel qury hayde
//ya3ne bas ta3mel l room anylyze lal qeury w tekteshef eno hayde l query 5asa bel employee table fa btseer bt3mel link been l function l getalllemployee bt3mel link ma3 l employee table ba3den bas tkoun return live data bt2ol la room aye ta8yer delet,update,insert bseer 3ala table l employee 2ole w b3tle e5er data sa3eta ne7na mnest2bel e5er data w mn7ota b recycel view
//bas hay tare2a enta ma feek t8ayer l livedata heye bas feek ta3mela trigger te2ra mena bas ma feek t8ayera howe internally b8ayer ya3ne bas feek ta3mel observe 3lyha

//ama 3ana livedata no3 tene b2ololo mutaable livedata hayde nafs she live data bas eno bte5telef eno feek t3del emet livedata bt5lek ta3mel set(),post() fe 2 method b2lba bt5lek t3del emeta ya3ne feek ta3mela onbserve te2ra mena w feek t8ayer emeta ama livedata keen bas fena ne2ra mena ma fena ne7na b2edna n8ayer emeta
// MutableLiveData<List<Employee>>
// MutableLiveData<List<Employee>> muable=new MutableLiveData<>();
//            muable.setValue();
//            muable.postValue();
//set value feek ta3mela bel main thread bas ya3ne feek t8yaer emet l live data bas bel main thread iza jarbt bel ta3mel b worker thread bt3mel errro w hyde iza 3mel observer 2awl ma t8ayer emet live data bt3mel observe 2ela w bteb3at e5er eme mawjoude feha bel observer method
//ama l postvalue heye iza enta kenet 3am teshte8l be worker thread w b3den badak teb3at w badak t8ayer l eme ta3et live data  l bt8ayer data le bel live data mn 5elel l worker thread ya3ne iza enta 3am tjeeb data mn api w hayde bte5od wa2t fa 7atyt l code b worker thread w badak bas teje data t7ota bl livedata fa keef btest5dema btontour data la teje mn l api 2wl ma tkoun mote7a bt3mel insert ela b2lb live data ya3ne heye bt3del data mawjoude b main thread l2no l livedata btkoun bel main fa enta badak t3del emeta la hay live data mn 5elel l worker thread




import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase.Model.Database.Employee;

import java.util.List;

@Dao
public interface EmployeeDOA {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertEmployee(Employee... employee);
    @Update(onConflict = OnConflictStrategy.IGNORE)
    void UpdateEmployee(Employee... employees);

    @Delete
    void DeleteEmployee(Employee... employees);

    @Query("delete from employee_table where name=:name")
    void DeleteEmployee(String name);

    @Query("select * from employee_table order by name asc")
    LiveData<List<Employee>> getAllEmployee();

    @Query("select * from employee_table where email=:email")
    LiveData<List<Employee>> getAllEmployeeByEmail(String email);

    @Query("select * from employee_table where name like '%'||:name||'%'")
    LiveData<List<Employee>> getEmployeeByName(String name);




}
