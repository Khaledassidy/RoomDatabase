package com.example.roomdatabase.Model.Database;
//hala2 class database code ta3elo sebet howe nafs l code bkel mashro3 2aw kel application b8ayer fe sha8let baseta jedan
//sho class l roomdatabse:badna nefham sho heda l class w lesh 3mlo? w sho by3mel w bshof mnestfed meno?
/*
2awl she anotation databse:@Databse:3ashn yefham l system eno heda l class 3ebra 3an databse fa lezm ektoblo anotation Database 2awl ma yshofa anotation databse berou7 byenshe2 l databse w be3del 3lyha law kenet mawjoude
@Databse() feha 3 paramter:
2awl paramter bte5do:enities:ya3ne sho houne l jadewel le badak tensh2oun 2aw badak t3refoun bel databse fa btefta7 praces masfoufe {} w bt7ot feha seme2 databse le houne salary w employee btestd3e l employee ,salary class aye jadwal ma byet3araf bel enities ma bekoun mote7 bel database
tene paramter howe l verison:version =1 nafs l kalem le 7kene bel sqllite eno kel databse ela version law badak t3del mafroud enak tzeed l version
telet paramter:exportSchema: hay 3ebra iza badak testma7 tsader databse ka jason file fa hala2 5aleha false mana 3eyzena iza bade yeha b7ota true


ba3d ma 5alsn l anotation databse
fa 3nade l class l myroomdatabse bado ykoun extend RoomDatabase metl ma koun na3ml mn l sqlite extend lal sqliteopen helper houn b room mna3ml extend la Roomdatabse heye l class l 2asese le bybne databse w mn5elelo fe method btet3emal ma3 database


haala2 ana best3mel databse ba3mel mo2sher 3ala kel doa le mawjoude 3ande lesh tyeb?
alak l2no kamen shway enta 7a ta3mel object mn databse hay fa enta 3ashn tosal lal bayent enta lezm ykoun 3andak jowa databse mo2sher 3ala doa l2no l baynet ta3wletak mawjoude jowa doa fa enta bas badak ta3ml mydatabse db =new  mydatabse() keef badak tosal lal baynet bt2olo sa3eta db.employedoa.getemployee() msln 3ashn tosal lal data law ma fe doa ma feek tosal lal data
b3rf doa ka abstarct lesh l2no howe l doa interface fa ma feek ta3ml object meno ma 3ndo constructor howe abstarct class ya3ne mesh method 3adeye wala class 3ade fa howe abstract class fe methods b2lbo

hala2 3 varible mot8ayer b3ref mo2sher 3ala databse ya3ne b3ref mo2sher 3ala l class ta3ele l myroomdatabse w bsameh insatnce heda 3ebra 3an mo2sher 3ala databse  lesh l2no iza mnetzakar zamen bel sqlite kenet 2a3ml varible mn l databse w sameh insatnce w l varible heda kont 2a3mlo intilze b method 3arefo mno3 l class w 3ref fe l object lesh 3ashn estd3e l oebjct mn bara w 2olna kamen eno keef nensh2 object wa7ad mn databse siglton design l2no mesh mante2 kel mara bade 2a3ml she bel databse rou7 3aref inatnce object mn databse fa lesh ma ba3mel object wa7ad mn databse w seer estd3e b2esm l class
l2no mafroud hala2 databse l mawjoude 3ande mesh mante2 kel ma bade deef 2aw 23roud 2aw 2a3mel update rou7 2a3ml obeject mn databse lesh l2no bseer 3andak kel mara 3am tenshe2 databse jdede fa lesh ma bt3ml singlton design bt3mel object wa7ad w btseer bt3yetlo b esm l class  kel ma badak ta3ml operation w ma bt3ml new object sa3eta
fa b2olo law l object heda mwjoud b5le ya3ml retrun la heda l object b5le yrj3le yeh metl ma howe iza mano mawjoud anshe2le yeh w raj3le yeh heda mabda2 singleton design pattern
eno l fekra eno ana bekoun 3ande object wa7ad 2aw mot8ayer esmo insatnce heda l instance fe b2lbo object mn databse l instnace heda ana b5zen fe keme le kemet l objet taba3 l class w bseer best5dmo w b2ol wala law fe keme b2lbo 3atene yeh law ma fe keme b2lbo ya3ne null nshe2le wa7d  fa heek ana be7res eno ykoun 3ande object wa7ad 3ala mostawa l application kolo  mesh darore enshe2 10 object object wa7ad bas bekfe lesh la male ram object object wa7ad bekfe
tyeo bas 2al heda l intnce le badna n3rfo bado ykoun volatile sho ya3ne volatile?
l volatile heye 3ebra 3an 5aseye l 5aseye hayde lama enta badak t3ref mot8ayer varible w l varible heda ykoun  l user l most5dem bado yosalo mn aktr mn thread b nafs l wa2t ya3ne ana heda l object bade est3mlo b akatr mn thread b nafs l wa2t sho ya3ne?
ya3ne law enta 3andak vaible int x=15 heda l variable enta lama tsha8el l application by deffult enta btest5dmo bel ui thread ya3ne law 8ayrt 2emto 5alyto ba3d heek x=16 ma7ada 7ay2olak she sa7 tyeb alak law enta keeen 3andak bel application aktr mn thread bt7ewel t8ayer mn kemet l mot8ayer b nafs l wa2t keef ya3ne ya3ne?
3ande thread 1  ,  2 , 3  ,  4 ,  5  3ande 5amse thread 3teber enta bt3mel nezam banck w l bernemej taba3ak 3ala server w fe 3andak 5 thread sha8alen b nafs l wa2t 3teber senario mn seriohat 7asal ele howe enta  we2ef 3ala saraf w fete7 application l banck 3ala telephone w bnafs l la7za enta sa7bt masare mn application l mobile mabla8 mo3ayan w sa7bt mn l saraf mabla8 mo3ayn tab3an l 3mlyet bten3mal b threads lesh l2no bte5od wa2t tawel w rom databse 7a nshof jez2 kbeer mn 3amlyet btetnafs b worker threads ma btetnafaz bel main thread enta momken t8ayer b 2e3dadet databse w tejbro yetnafs l 3mlyet bel main thread bas by deffult l room databse btnafez l 3mlyet le bte5od wa2t b worker thread 2aw b thread monfesle 3ashn tetjanab y3le2 system ma3ak l application
fa efred eno  l  thread l 2ola enta sa7bt mena masare mena mn l application w thread tenye enta sa7bt l masare mena mn l atm b nafs l wa2t l threade shta8alo w sa7abolak l masare  law l thread l 2ola 7ewalt tosal la x 7a tle2e emto 15 l2no 7a te5od nos5a meno w 7a teshte8l jowa lisa ra2mo 15  w thread tenye a5det kemet l varibe w b2lbo keen fe 15
fa l thread l 2ola 7a tn2es meno msln 15 w thread tenye 7a tn2es meno 15 b nafs la7za  fa enta mn2es sort mn thread l 2ola 15 w thread tenye 15 ya3ne 30 w enta l 2eme le ma3ak bas 15 sabab l meshkel houn eno l thread l 2ola a5det nes5a mn l varible le 3anda w sht8alet 3lee w l thread tenye kamen a5det nos5a mn l vaible w shta8let 3lee w kel threa saret bteshte8l  3ala nos5et l vaieble heda le mawjoud  ma3a le 2emto 15  fa lama rj3et ktashafet eno l 2eme le 3am tna2esa ma btkfe fa sar fe meshkle bel program w 3mel crush tyeb sho 7al l meshkle houn?
t3ref l variable volatile volatile ma3neta eno heda l varable lezm 3ala kel thread bada test5dmo 7a tosalao bshakl mobesher ma te5od nos5a 3ano ya3ne te5od 2e5er keme t5azanet fe mamno3 ta3mel cashe lal 2me l threads bt3mel cashe lal keme  bte5od l keme le bel cashe w bt3del l keme le bel cashe w bas t5les bt5zena fe l application taba3e
bas eja l voaltile byemna3 heda yseer  mamno3  iza l thread l 2ola bada tosal lal vaible heda lezm mobashara trou7 la 2e5er keme t3adalet 3ala heda l varable heda kamn nafs she lal thread 2 lezm lama tosal lal vaible tosal la 2e5er keme t5zanet fe
fa bel senario tab3na 7a teje l thread l 2ola le howe taba3 l atm 7a yeje yes7ab aye ta8yer 3ala l vaible 7a yet8ayer mobashrtn 3ala l orginal vaible l thread tenye mesh 7a tosal la 2eme le 2a5deta l nos5a le 3anda 7a tosal lal keme le 2e5er she 3adleta l thread 1
fa law l thread l 2ola  sabet mena 15 7a teje l thread tenye tetla3 tle2e 0 fa mesh 7a tn2es she  bel 7ale hay enta damnt 2omorak tmm
 fa l volatile b2e5tesar heda 3ebra 3an varible mojahezz eno aktr mn thread tet3emal ma3o eno heda l mot8ayer 7ases mamno3 l thread ta3mel meno cashe lezm tosal lal keme l 2asaseye tab3to 3end ste5demo

 ba3d heek 3arfna public static final  int NUMBER_OF_THREAD=4 varible integer final 5azna fe kemet 4

ba3d heek 3arfna variable ExecutorSevice sho howe l executorservice?
executorservice:fe 3ande she esmo thread pool sho howe l thread pool pool ma3neta msba7 l thread pool howe 3ebra 3an object wajado eno est5demak bel threads kteer fa wajado eno enta badal ma t3od tenshe2 thread kel shway te5od wa2t b enshe2 thread w wa2t best5dema wa2t be tadmer l thread alak lesh ma ana wafer l wa2t w rou7 2a3ml thread pool 2a3melm object mn thread pool 3ebra 3an sando2 b2lbo majmo3a mn l thread la nefroud eno 4 threads bade 2a3mel 4 threads l threads hawde aye wa7ad bado ya3mel amr task m3yan 3ala l dabase bado yest5demha
tyeb keef bado yest5dema alak eja wa7ad bado ya3mel insert 3ala databse berou7 3ala sare3 3ala l box 3ala pool beshof fe thread mn haw l 4 mote7a 2awl she bekoun bel 2awl menshe2 4 threads w 7atetoun bel box bte5od thread menon btest5dema ma btmaweta brje3a mara tenye bt5leha bel object heda 3ashn twafer wa2t destroy taba3a
law eja ba3den wa7ad tene    task tene mesh 7a yetar yenshe2 thread jdede 7a ye5od wa7de mn l mote7a mana mash8ole 3andak bel box  w yrou7 yest5dema w yraje3a mara tenye bas y5les
fa le sar badal ma kent enta kol mara ta3mel thread w test5dema w ta3mela destroy bas t5les enta wafrt 3ala 7alk wa2t l create wa2t destroy sar fe 3andak thread jehez test5dema mobahsratan w bas t5les terja3 trjae3a la sando2 3ashn iza fe 8ayrak bado yest5dema  yest5dema hyda esmo thread pool
fa ana ba3ml thread pool 3ashn raye7 7ale w est5dem l 3mlye hay momken test5dem thread 3adye ma fe moshkle bas heek afdal w asra3 la system wla2ele
fa b3ref Executorserveice databsewriteexecutor =Executor.newfixedthreadpool() fa 3mlna executor service samnyne bel esm heda databsewriteexecutor equll executor dot newfixedthreadpool w 3atne bel constriuctor 3ada l thread le bado yenshe2 le heye l eme ta3et vaible number of thread le heye 4
fa heda howe 3ebra 3an l object le fe 4 threads le enta mo ken test5dem aye thread menon mote7a la aye task
tyeb hal ana le b2olo st5dem l thread le esma kaza la2 howe la7alo bas yeje task beshof aye thread mana mash8le iza la2a wa7de by3teha heda task lal thread le mote7a mana mash8ole w bas y5les l 3mlye berje3 l thread 3ala l box 2aw l pool 3ashn iza fe she task tenye bado ynafez yest3mel naf l thread
ya3ne k2no bel zabt fe sando2 fe 4 sha8let l 4 sha8let hawde hawde btest5dema w btrje3a 3ashn 8ayrak yest5dema bas la tawfer l wa2t bel enshe2 w bel tadmer
7a t2ole bye5od mase7a bel ram ma fe meshkle bel ram bel device sar 2a8laboun fe ram kbera w ma fe meshkle bye5od bhskl 2alele ma b2ser 3lee

hala2 ba3ml method esma getdatabase() bte5od parameter contect wazefeta:
tef7as iza object l databse nafso le 3mlto equll null  trou7 tenshe2 object iza mesh null trjae3 l object mn databse singleton design pattern ,  metl l getinsatnce method

beje 2awl she befhas iza l intance kenet equll null fa ana l moftard been praces l if enshe2 object mn databse w raj3o 3ashn aye wa7d bado ya3mel aye ested3a2 mn doa 3ala databse ye2dar yestd3e bkel sohole
fa b2lb l if sho bade 2a3ml:
fe 3ande tag esmo syncronized l code le bekoun jowa tag l syncronized men esmo motazemen alak law enta ,enta l mafroud databse tab3tak howe mhay2lak yeha eno enta testd3eha mn aktr mn thread fa bel tele metwa2a3 l method hay l getdatabse ytem estd3e2a msln mn 4 threads msln  b nafs l wa2t fa momken tosdof eno aktr mn thread b nafs la7za testd3e hay l method b nafs la7za zeta
fa eja l 7al eno tag syncronized byemna3 mana3an beten eno aye wa7ad ynafez l code  le b2lbo mn aktr mn thread
b mostala7 tene law fe enta 3andak 2 threads l thread l 2ola std3e l method hay w l thread tenye stad3et l method tenye nafsa zeta law bel 7ale tabe3eye ma fe syncronize thread l 2ola 7a tenshe2 object w tenye 7a tenshe2 object lesh
l2no l thread l 2ola fa7set l instance null fa ra7et ansha2et object l thread tenye fa7set eno null fa ansha2et object sar 3andak 2 object mazbout
bas alak tag syncronize   btemna3ak 2awl sha8le law ejet l thread l 2ola tnafez l code fetet la jowa w thread tenye ejet we2fet 3ala tag syncrinize 3anda moder hay syncronize 2altlo la thread tene mamno3 tfoute 3al code taba3e ya thread 2 aletlo lesh l2no fe thread sha8le hala2 bheda l code w l pogramer 3mel syncronize ya3ne mamno3 ente ya thread 2 tfoute  tnafze codek ela lama l 2ola t5les l code taba3a
nafazet l 2ola l code   w l thread 2 ba3da we2fe 3ala l syncrinize 3al beb we2fe natra l thread l 2ola amr eno t5les 3ashn tfout tnafez l code taba3a fa l thread l 2ola fete 5alaset nafazet l code le jowa ba3den 5alaset l code tele3t mn tag l syncrinize fa madel tel3et fa l l syncronize btefta7la l bebe lal thread tenye w bt2ola sar feke tfoute 5alaset l thread l 2ola fa l thread tenye 7a tfout w tnafez l code 7a tshof hal l intance btsewe null fa houn akeed la2 ma btsewe null l2no l intance 3arafet dtabse w 5asaneto b kemet l instnce fa 7a ta3ml return lal intance de8re mesh 7a t3mel new inatnce mn databse

hal code le jowa syncrinized howe code  enshe2 intance mn room database:
bt2olo INTANCE equll ro7 3meel bulder la room databse  3ate l contenct w 3ate esm  l class taba3 l databse w 3aref esm databse w 2e5r she 3meel buld  howe heek 3arflak insatnce mn databse
fa hala2 law jeet la tfout b code le syncronized l thread l 2ola 5alaset build la databse w sayveto b vaible l inatnce fa 7a tfout l thread 2 7a tef7as hal l inatnce equll null la2 so ma equll null 7a yetla3 w ya3mel return lal inatnce hay l fekra mn syncrinize 3ashn heek fe 2 if statement bt3mel check iza l intance equll null lesh?
l2no l if l2ola kel mara 7a y3ade 3lyah w yo2af 3end syncronized law law ma fe if tenye lal intance bel syncronize 7a y5les l thread l 2ola w bas terja3 tfout l thread tenye fa 7a ta3ml inatnce ana ma bade heek bade yeha terja3 tef7as mara tenye ta7asouban 3ashn kemet l instance t8ayaret jowa l thread l 2awl
fa 3ashn heek fekret l syncronized mamno3 aktr mn thread   ena tfout w tnafez l code le joweha w heda l mante2 eno mamno3 aktr mn thread tfout ta3mel instance 3ashn ma yseer fe 3ande multiple intance of this object databse object

est5demna l syncronize ma3 l volatile eno sar est5demna thread safe ya3ne est5dem emen 3end est5dem aktr mn thread


note:2alak 3end momken ta3mel callback w defa houn bel database sho ya3ne callback:
t3ref mot8ayer mno3 RoomDatabse.Callback vaible mno3 roomdatabse callback w same aye esm =new RoomDatabse.callback
heda 3bra 3an call back sho ya3ne call back heda l class back 3ebra 3an litner la databse l class heda 2aw l method le mawjoude jowa l class heda
btem ested3e2a ka call back   sho ya3ne ya3ne 3end enshe2 databse la 2awl mara berou7 byestd3e l code heda :
fa 3andak bel oncreate method ta3et databse badak ta3mel 7adas mo3yan msln aye 7adas badak ta3mlo bel create ta3et database btnafzo joweta fa bel oncreate btktob l code le badak ta3mlo
lama yeje yenshe2 databse  la 2awl mara 7a yeje 7a yrou7 ynafez l code heda
l code le badak tnafzo bel oncreate bt3mlo bel exector l pool thread bt3mel databasewrite.execute(()->{
w houn btktob l code le badak yeh
}
msln feek ta3mel msln te7zef kel databse w ya3mel insert la 3onsouren msln
bas ta3mel execute databse.writeexecute(()->{
} bt3te l code le badak yeh bel execute w btetrko howe la7alo benfazo b worker thread  ma elna 3el2a ya3ne ya3ne 5tar howe l thread l 2ola wala tenye wala telte wala rab3a mesh she8le heda howe she8lo ye5tar l thread l mote7a ana ma7sane howe benfez l code bel thread l mote7a byerja3 berje3a 3al pool la yterka iza fe task tene bado yetnafaz

hala2 5als 3arft l code w l call back w kel she tmm fa heda l call back bt3etha bel method l getdatabse bt2olo
dot addCallback() w bt3etha l call back le 3mlto enta fa heek bseer l databse 2awl mara 5ale belak eno heda l kalem bas 2awl mara 2awal mara btem enshe2a berou7 b nafez l code le mawjoud bel oncreate



fe methods tenye fena nest5dema kamen bel create taba3 databse le be method l getdatabse :
metl allowmainthreadqueries() hay momken test5dema 3ashn tesma7 lal queries eno deymn tejbro eno deymn  ynafez l queries bel main thread hala2 law hay l method mesh mawjoude btetar ta3mel thread w tnafez codak b thread bas law badak tektoba mesh darore ta3mel thread mobashara tnafez codak bel main thread
ne7na ma badna nektoba 3ashn nshof keef momken testa5dem l thread pool executor 3ashn  tnafez l 2awmer taba3ak metl l insert delete update..etc


w note feek kamen ta3mel databse bel sqlite w t3be data feha w b3den teje 3al app ta3ml folder asset w t7ot file databse feha
w bel method ta3et l bulid btest3mel method esma  .createFromAsset() w bt3te la hay l method l path taba3 l folder databse le howe msln R.raw.mydb msln

w sha8le teneye ana bas ro7t la 2a3mel add salary w rje3t 3ala l main activity mala7 tet8ayr salary lesh l2no ana 3melel observe lal employee table mesh lal salary table fa mala7 tet3dal 8eer yadweyan heye 7a tbyen 3ala databse inspector bas mesh 7a tbyen bel view:
-2awl tare2a fena na3ml notifydata set change bas y5les add la sallary
-tare2a tenye w l aktr proffesional eno 2a3ml class esmo employeesalry fe b2lbo name lal employee w double slalary w getter w setter w constructor bas heda mesh tbale heda class ne7na badna na3ml sum method le 3mlnheha bas best5dem l union bas na3mel union badna yetla3 ma3na table jdede heda table badna yeh yrja3 live data bas mno3 heda l class ba3d heek nafs l addpter le 3m;lto bas bt5le naw3o mn nafs no3 l class w heek btkun wafrt 3a 7alak kel mara bel adpter ta3ml query


fe 3ana method esma .fallbacktodesrctiveMigartion() hyde byen3mala call bas nenshe2 databse ma3neta eno iza 8ayrna l version taba3et databse due la ta8yer bel schema ta3et databse msln zedna column 2aw table hyde l method byt2olo la room eno 3meel drop la databse kolo rja3 3emel create la 2elo mn 2awl w jdeed discard exesting data ya3ne btetjehl l data le kenet mawjoude hyde no3 mn l rpivace fene 7ota

 */


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdatabase.Model.DOA.EmployeeDOA;
import com.example.roomdatabase.Model.DOA.SalaryDOA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Employee.class, Salary.class},version = 1,exportSchema = true)
public  abstract  class MyRoomDatabase extends RoomDatabase {
    public abstract EmployeeDOA employeeDOA();
    public abstract SalaryDOA salaryDOA();
    private static volatile MyRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS=4;
    //eza badna na3ml migration:
//    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            // Add the new column
//            database.execSQL("ALTER TABLE Employee ADD COLUMN MiddleName TEXT");
//        }
//    };
    //mn3del databse version la 2
    //w bas nenshe2 databse b7ot     .addMigrations(MyRoomDatabase.MIGRATION_1_2)
    public static final ExecutorService databaseWriteExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MyRoomDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (MyRoomDatabase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(), MyRoomDatabase.class
                    ,"employees_db")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.

                //msln btjeeb doa houn w ta3et l employee w bt3mel delete all w ba3den msln bt3mel insert la kam employee
                //EmployeeDOA doa= INSTANCE.employeeDOA();


            });
        }
    };
}
