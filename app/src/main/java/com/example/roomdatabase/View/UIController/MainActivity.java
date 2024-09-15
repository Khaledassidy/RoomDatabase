package com.example.roomdatabase.View.UIController;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.View.Addapter.SalariesEmployeeRecycleAddapter;
import com.example.roomdatabase.Model.Database.Employee;
import com.example.roomdatabase.R;
import com.example.roomdatabase.Model.Database.SalaryEmployee;
import com.example.roomdatabase.ViewModel.MyViewModel;
import com.example.roomdatabase.databinding.ActivityMainBinding;

import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;
/*

l youm la7 ne7ke 3an library mashhoura w moheme esma Room Databse

sho l fekra mn room databse? sho le 5alena nelja2 la hay library?

iza mnzkour 2awl ma balshna net3amal ma3 database kona database le mnet3emal ma3a esma sqlite database
l sqlite databse keen feha shwayet limitation b mawdo3 ta3amoul ma3 l boolean,b mawdo3 ta3amoul ma3 date,w ba3d sha8let kenet 3meel limitation be ta3amoul ma3 datsbase
w iza mnzkour keen shakl database eno lezm ta3ml class extend sqliteopenhelper  w t3ref verion w tables w lcolumn w ta3mel create la databse w ta3mel exequte qeury select.... w ta3mel jomal create table,delete,update w enta testd3ehoun kelo keen from scratch kenet tet3mel ma3 l crud operartion yadaweyan  keen wa2t ta3mel insert tektob code kbeer w jomlet retrive tektob code kamen kbeer w while loop w cursor w 100 5abreye w t3yet la kel 3amoud b esmo w tenshe2 l object b2edak w t3be w terja3 teb3ato ya3ne iza mnetzkar katbna aktr mn 1000 satr databse 3ashn kam sha8le bas

l fekra  eno la2o eno est3mel l sql mesh kteer mokne3a bel she8l lesh l2no enta mohemtak ka developer android eno enta tet3emal ma3 logic taba3 l application ya3ne mane metar efham l query taba3 databse  ana mafroud et3emal ma3 methods l mthods hay btjble data mn database ana mesh motalab efham l queries le 5asa bel databse wala moutalab 2a3mel l koyoud l mot3l2a bel database heda mesh she8le ana she8le jeeb data bas la heek 7ewlo yle2eo taba2a fo2 library l sql  bshkl eno tsahel 3lyna ta3amoul ma3 databse fa la2o 3edet librarys  metl library l active anroid le kenet mn zamen kteer keno yest3mloha abl ma 3mlo librar room databse
library hay l active android kenet btsahel 3lyna  ta3amoul ma3 databse w kenet betmasel waset been l code le enta btktbo w been databse fa kenet btsahel 3lyna kteer she8l

ba3den la2o library mn l android nafsa  esma room databse heye demn selselet l jetpack ya3ne mawjoude demn library ta3et jetpack library l room databse heye mawjoude fo2 ka taba2a faw2 l sqlitedatabse
ya3ne l room databse sho8la bas eno btshel 3lyna ta3amoul ma3 databse mn ne7ye l wa2t w she8l bas heda 2sesa w feha eshya kteer momken nest5dema

bel room database bestdem she esmo architecture components
sho l architure component:heye 3ebra 3an majmo3a mn l 3anser l btshelak ta3amoul bel application taba3ak lama enta ta3ml application btshel 3leek sho8lak mn demn l architure commponnet:
1-livedata
2-viewmodel
3-room databse
hawde sha8let 7a tfedak bas ta3mel application keef kel wa7de ela tafasela w ela shar7 la7la l7a neshr7a kola

b2olak t5ayal l senario heda:eno enta fe 3andak she esmo ui controller(Activity or Fragmnet) sho l usi controller ya activity ya fragment aye 3onsour l most5dem byet3emal ma3o mosharatan ya bado ydefle data 2aw bade 2o3roud fe data
bye7lek eno l mante2 bel ta3amoul ma3 l ui controller 3ashn yosal la databse le mawjoude 3ande ya3ne 3ande databse fa 3ashn 2osal mn l ui controller la databse mn zamen ana kont mosbashratan mn l acctivity 2aw fragemnt benshe2 object mn database w rou7 2elo hatle l baynet mobashratan alak hay l 7arake mesh 7elwe lesh l2no fe tricks enta momken to2a3 feha  metl sho :
alak l ui controller heda lama badak t3ref fe code databse mobashrtan momken enta yseer 3andak ta8yer bel configuration taba3 l activity metl rotation la shshe lama ta3mel rotate la shshe bya3mel re create lal activity fa bel tele 7a ya3mel recreate lal object taba3e le howe database w l data le b2lbo fa enta bhay l 7ale rje3t mn no2tet sefr ya3e saret k2no l activity balashet mn jdeed
bel mo2bel l mante2 b2olak lama 8ayer configuration fa l user lisa mawjud bel shshe fa l mafroud 5ale l data metl ma heye 7ata law 8aar l configuration hay sha8le mn sha8let
sha8le tenye l data le kenet teje la 3andak mn databse ma keen fe syncronization byna w been databse ya3ne ma keen fe listner 3ala ta8yer l data le bel databse fa enta fe3lyan lama deef object 3ala databse msln bade zeed food 3ala databse keen lezm ana 3ashn 7ades l data le bel recycle view erja3 ba3d fatra 2aw ba3d action mo3yan jeeb data b2ede mn databse msln bel onactivityresult trou7 t2olo hatle l data mara tenye mn databse fa ma keen fe listner 3ala edafet data 2aw 3ala ta3del data bel databse
w kamen keen sha8let ela 3el2a b tajme3 l data 2aw takwenha b maken wa7ad room databse heye mn demn l architucture coomponent le heye wafaret elna eno ne7na nektob l methods tab3tna 3ala shakl abstract methods w na3mel shwayet anotations w howe la7alo ya3mel implemntation elha ya3ne la7 nosal la mar7ale eno ana bas bektob anotations ya3n @... w howe la7alo byefham eno l system eno hyde 3ebra 3an method ana bade 7ot l implemntation 2aw bade deef l implemntation taba3a mn 3ende mn system ya3ne fa system matlob ya3mel l code tba3 2aw library ya3ne bshkl ada2 howe l matlob ya3mel l cursor w l content value w l insert w l update,delete w kel l eshya howe le 7a ya3mela ana bas b3te eshra eno ana bade 2a3ml l 3amlye hay w howe la7alo bya3ml implemntation lal 3amlye w byektob code mn doun ma ana ektob fa hay 3ebra 3an 3anaser sahlet ta3moul ma3 codes 5sousan bel mashare3 da5me ya3ne mesh mashro3 fe table 2aw tnen la2 fe kteer tables w fe cashing la tables kteer houn enta lezm test5dem fe 3anser mn l arichetuture commponent

fa senario le mawjoud amemna eno 3ande ui controller shshe tab3te mafroud tetwasal ma3 class esmo viewmodel sho heda l view model heda 3ebra 3an 3osnour waset bynak enta ka shshe bt3roud 3anaser lal user w been l data le m5zane bel repositry sho l repositry heda 3ebra 3an mostwda3 lal data class mnjame3 fe ne7na l data tyeb hal class heda mawjoud bel arichitetcture commponent la2 hal heda l calss mawjoud bel android la2 heda 3ebra 3an class ana ba3mlo b2ede w bjame3 fe l methods le lezme tet3emal ma3a shshet le mawjoude bel application ya3ne masln ana 3ande shshet 3ard feha food w shshet 3ard feha price shshet 3ard food b2lb cart bjme3 kel l methods le btjeble l data hay w b7ota b class esmo remositry hal momken est8ne 3ano eh momken est8ne 3ano momken heda l class yejam3 data mn l api w mn database mn esmo mostwde3 lal data beloum kel l data le mawjoude bel application w b5azena b maken wa7ad la soholet ta3amoul ma3ha b ameken tenye
fa ana ka shshe hala2  activity 2aw fragment bade etwasal ma3 repositry mesh bshkl mobesher 3an tare2 l viewmodel lesh l2no alak l viewmodel heda mn esmo viewmodel ya3ne wasel been l view w l model 2aw data ya3ne tyeb lesh howe 3mlo alak l2no mn demn l 7ajet l by3mela metl ma 7kena abl shway byet3emal ma3 l configration bshkl sa7e7 metl eno ta3mel rotate lal shshe lama teje ta3mel rotate houn l viewmodel bedal sha8al 3ala l configration hay fa ma byedmar bedal sha8al toul ma l activity sha8ale 2aw l fragemnt sha8ale ma btefre2 ma3o 3emel rotate wala ma 3emel rotate l view model bedal mote7 elo
fa enta btestd3e l fe lal viewmodel l methods l mawjoude bel repositry w mn l activity 2aw l fragemnt btestd3e l methods l mawjoude bel viewmodel 3ashn l data  dal persisance mote7a 3ala ta8your l configration w l 2e3dadet 2aw ta2lobet le btseer lal activity 2aw lal fragemnt

repositry byet5azan feha metl ma 7kena kel l methods taba3 data mn demna l method api w mndemna methods l room databse

w l viewmodel b2lbo she esmo livedata heda 3ebra 3an object fe observer 2aw fe method b masebet listner btem estd3e2a 3end ta8yer l data ya3ne aye ta8yer bel data mobshar byestd3e l method le majoud bel listner le bde5lo w b7ades l data bshakl  mobesher  fe l object heda live daata feek te7ke eno data btkoun fe live ya3ne kneak bel zabt 3emel listner 3ala aye ta8yer bseer bel database byt8ayr 3andak bel class l mawjoud la7 neshra7 tafasel aktar

room databse:b2laba she esmo:
entity:entity ya3ne table 2aw model zamen kouna na3ml lal databse model class msln employee 2aw food l model howe 3ebra 3an l entity l entitity hay btmsel table jadwal bel databse bas n2ol 3ana 4 entity ya3ne 4 table bel databse
DAO:e5tesar lal Data Acces Object heda 3ebra 3an object mn 5elelo ba3mel acces 3ala l data
SQLite:le heye databse le btkoun b2lb l room databse  le byet5azan feha l data

ya3ne 3ande entity table bade ektob method bel DAO tosal la data le bel jadwal heda w yofadal eno na3mel la kel entitiy kel table file doa 5as fe
fe nes bt3mel file wa7d doa la kel l tables ma fe meshkle bas l afdal na3mel file doa la kel entitiy kel table w tjame3oun bel repositry le mawjoud 3ande



l hykaleye 7a tseer heek:
eno fe 3ande mainactivity:feha observer,w feha adapter l observer   le 7kena 3ano taba3 l live data eno aye ta8eyr 3alal data fa byet8ayr houn bel observer fa benfez l code le bade yeh
w 3ande activity jdede 3ashn deef feha data jdede
w 3ande viewmodel le bad ykoun fe lista bel data
w ba3den 3ande repositry
w ba3den 3ande l room databse l fe table esmo word w DOA interface DOA 3ebra 3an interface esmo worddoa w 3ande l databse

heda shar7 nazare

la nblesh b2olak badak ta3mel project jdeed w ba3den badak deef librarys l maktabet l room databse le houne:
implementation(libs.lifecycle.viewmodel)
implementation(libs.lifecycle.livedata)
implementation(libs.lifecycle.common.java8)
ba3den bade fa3el l viewbinding

ba3den b2olak badak ta3mel jadwal entity lal databse fe basata ya3ne bya3ml class esmo word fe string kelme esma mword w contructor w getter la hay l kelme ba3den 3ashn t5le heda l class table bel databse btktob notiation fo2 l clas @Entity() mola7za moheme room databse mo3tmde e3temed kemel 3ala l anotation le heye @... fa @entity ya3ne heda jadwal  ,@primarykey ya3ne ya3ne hyde primary key @nonnull ya3ne hyde manno3 tkon null  @columninfo ya3ne ma3lomet lal 3amoud lal column le enta sha8l 3lee ya3ne hawde btktoubon fo2 l varible le bt3ttbro column
fa kel class  @entity 3ebra 3an table kel 5aseye jowa l class howe 3amoud bel jadwal
bel doa bt3mel method insert,delete,query ya3ne method l insert kteer baseta kena bel sqlite nektob cursor w alf sha8le bel room bt2olo void insert bt3te l data w bt2olo anotation @inset
2aw iza bdna na3ml retrive query ya3ne kona n3mel balewe code kbera ama hon btktob @qeuery()  w btktob l select b2lba
ama iza delete bt2olo void detele w faw2a anotation query mesaln eno dlete from ...
howe berou7 bya3mel nafs code le bel sqlite cursor do while bas meen befhmo eno rou7 msln 3meel get kaza msln getfood l anotation befhmo eno rou7 3meel maping lal query hay msln 3ala method w b7wela la code fe b2lbo 3mlyete bsln la jeeb l fodd by3mel cursor de5lo w kel she de5lo

bel nesbe lal live data enta btktob l query w bt2olo ta7ta livedata fa hay l method badak yeha tkoun live byefham la7alo howe object esmo live data fa bhay l 7ale 7a dal data live aye ta8yer 3ala datbase mobashrtan mobsahar byestd3e listner b el class live data w b7des data live data 3ebra 3an class fe litnser lama e7ke eno hay data live m3net l kalem aye she bseer insert,delete,update, retrive aye 3mlye btseer 3ala databse mobahsratn byestd3e litner le mawjoud bel livedata fa ana b2olo lama tseer 3mlye hay l m3yane rou7 std3e livedata ya3ne 7ades l data bel sqlite keen fe so3obe 2a3ml heek keen law bade 2a3ml insert bade ebkous button lama ed8at 3ala l button b2olo deef bel databse w ba3den 2olo retrive mn databse tyeb yemken method l edafe mn databse 3mla b thread monfesle fa law jeet 2o3roud abl ma t5les l edafe kenet ma7a ye3redle yemken l data m7dase 2no yemken l insert ma5alset she8la ya3ne yemken y3roud abl ma t5les l 3mlyet l insert bas houn bel livedata b2olo bshkl wade7 w sare7 eno ba3d ma tet8ayr l bayent bel databse rou7 std3e litner w hatle aye bayent jdede t8ayaret bel databse fa ana heek damen eno litner mesh 7a yestd3a ela ba3d ma l data tet7ads 2aw tet8ayr bel databse

repostry b2olak data yemken tejek mn doa,2aw mn network ya3ne api
w doa howe ma fe anotation howe ne7na mn3mlo
w b2oalk feret l viewmodel eno 7ata law 3mlt rotate bedal sha8al viewmodel w mote7 l rotation le bseer

hala2 heda kolo 7aky nazare bas ma3lomet hala2 la7 nblesh na3ml application bye3temed 3ala l room databse w neshra7 kel tafasel
7a ykoun 3ande database lal mwazafen
3ande table lal employee esmo employee 7a ykoun fe {id primary key,name,birthdate,email}
w 3ande table tene esmo sallary l ma3shet ta3el l mwazafen ya3n3 bade mwazaf esmo ahmad retbo shahr 10 msln 600 shhr 12 800 bel 2e5er kel mwazaf elo majmo3et raweteb one to many {id,amount,data,empId foregn key)

hala2 bade eje et3emal ma3 2awemer databse fa hala2 hawde l 2 tables bade enshe2oun
bade 2a3ml package bade sameha databse:
keef bade 2a3ml table bel databse table 3ande 3ebra 3an class 3ade bsame Empoyee w class tene lal salry l2no 2 tables

hala2 sho data lezme lal employee id,name,birthdate,email fa beje b3ref varibles 2awl she la hawde
hala2 ba3mel table tene esmo salry fe data heye {id,amount,data,empId}
hala2 heek 5alsna l 2 tables w rabtnehoun ba3d dal enak t3refoun 3ala database
//dal fe sha8le baseta bas date le ana 3rfto bel sallary w l employee hawde l tnen hawde l tenen mante2yan mesh mawjouden bel databse ya3ne ma fe bel databse sqlite databse she esmo mno3 date tyeb keef btseer ta3moul ma3 date mn 5elel long ya3ne enta sa7 m3ref houn Date bas bel sqlite  byest5dmo ka long lama yet5azan beyt5azan long lama btjebo btjebo long bas hala2 keef 3mlyet ta7wel bada tseer Date w long lezm enta ta3mela b2edak l2no iza dalet heek la7 ya3mlak exeption la7 y2olak mn ween jeyeb datatype esma Date ma3nde heek she ana 3ande long  fa lezm 2a3ml mo7wel mn long la data w mn date la long
//fa ba3ml class esmo DateConverter heda l klem byetebe2 3ala kel l converter le badak ta3meloun
//hala2 heek sar l tables jehzen 3ande w byet7awal emetoun metl ma bade w kelshe rawa2


//hala2 ba3d ma 5alst kel haw bade eje hala2 2a3mel DOA data acces object acces la 2 tables le 3mltoun w bade eje 2a3ml repository w l viewmodel ,livedata ,databse w est5demun 3nade


hala2 badna na3mel DOA:howe data access object sho ya3ne 3ebra 3an object mn 5elelo enta btosal lal bayanet l mawjoude bel databse ya3ne badak t7ot fe kel l method le 2ela 3ela2a bel wosol lal bayent bel table taba3e l 2afdal ta3mel doa la kel table mawjoud 3andak
fa bade eje 2a3ml employeedoa,salarydoa doa 3ebra 3an interface l2no ma btektob fe codes implemnt la methods le mawjoude bel doa wazef room databse heye le ta3mel implemnation 7asab l query 2aw l anotations le enta bt7ota
ba3ml class EmployeeDOA: b7et fe kel l methods le bade yeha insert delete,update ,query
ba3mel class SalaryDOA:b7ot feh kel l methods le bade yeha insert delete,update,qureies

fa la7ed hala2 ansha2na ne7na:
Entitys:tables lal employe,salary
Converterdate:convert date to long w long to date
DOA:3mlna interface doa lal employee w salry w feha kel l methods le momken 3oza

//hala2 l 5otwe jeye bade enseh2 l repositry l mostwda3 baynet taba3 data btjame3 fe l data  le bade 5azen fee koul l methods le enta badak tet3emal ma3a  bas ana abl ma enshe2 l repositry mafroud enshe2 databse le bade 2orbout feha l tables l mawjoude 3ande ne7na lesh 2a5rna 5etwet databse lal 2e5er la ba3d ma enshe2 l entitys w l doa  l2no ana databse lama enshe2a lezm 3aref feha l jadawel l tables fa iza ma kent menshe2 l tables ma fene 3aref databse  fa hala2 bade 2a3ml class esmo MYroomDatabse:


///hala2 5alsna databse enshe2neha

sorna m5lsen:
Entity
converter
DOA
Database
5alsna sando2 le mawjou ta7t ta7t 3enween room bel documntation

hala2 badna nblesh bel repositry

repositary:howe mostwde3 la data howe class java 3ade bejme3 kel data b2lbo mostwde3 momken nest8ne 3ano ma fe meshkle
5alsna l repository jam3an fe kel data w tmm hala2 she8l

sorna m5lsen:
Entity
converter
DOA
Database
Repository

hala2 badna nblesh bel viewmodel l viewmodel feek ma test3mlo 3ade bas howe elo mayzet mne7a bten3az


hala2 neje ne7ke 3an e5er sha8le heye l viewmodel:
mn3mel class bade same MyViewModel w b2lbo kel data le mawjoude bel repository
fa hala2 sorna 3mleen:
Entity
converter
DOA
Database
Repository
ViewModel

fa hala2 dalele eno est5dem bel mainactivity le mawjoude 3ana hala2 ma mnest3mel 8eer l viewmodel ya3en ta3amoule bel mainactivty bas ma3 l andoid viewmodel 2aw ma3 l myviwmodel bas ma3nde aye 3ela2a ma3 classes tenye ta3amoule bas ma3 l viewmodel
tyeb be2dar et3emal ma3 l repository fena bas ne7na l a7san net3emal ma3 l viewmodel 3ashn l configuration iza ma badak configration fa t3mela ma3 l repostory


//la et3emal ma3 l viewmodel bade 2a3mlo 2a3mlo create be heda l class keef?
b3ref vaible mn l Myveiwmodel myviewmodel equll new hala2 ana ma ba3mel new Myviewmodel lesh 3ashn l viewmodel howe n3qmal 3ashn l configuration sa7 sa7
fa iza 3mlna =new Myviewmodel() 7a ne5sar 5aseyet eno howe survivor la configuration fa ana bade yeha tkoun heda l viewmodel marbout bel activity 2aw fragemnt fa iza 3mlna new Myviewmodel heek mala7 yenrebet ma3 l activity
fa 3ande provided howe l moder ya3ne bade 7ada yrbout l viewmodel l 3mlto bel activity fa fe 3ande
she esmo  ViewModelProvider(); heda bye5od context w b2lbo method esma get() bte5od l veiwmodel taba3e fa hyda bhay tare2a 3am troubout heda l viewmodel taba3e bhay l activity

new ViewModelProvider(this):Here, you're creating a new ViewModelProvider object. The this you pass as an argument is likely referring to your Activity or Fragment. ya3ne hyda l hyde bt3mlk object mn viewmodel w btsjaela 3ala hayde l activity
.get(MyViewModel.class):ya3ne houn bt2olo lala manger 3atene heda l viewmodel ya3ne baee type ta3et l viewmodel ykoun heda l class
hyade l method 2awl 2awl mara bseer ta8yer bel configuration bt3mlk object ba3den bas teje la ta3ml mara chnage lal configuration by3ml check hal hyde l viwmodel Myviwwmodel exest bel activity 2aw fragemnt yes l2no abl b mara st3mlneha fa bas 7a yjeba ya3ne siglton design

ya3ne ne7na 3mlna kel hyde l 2ossa ma 3mnla =new Myviwmodel() 3ashn mesh kelmara yseer ta8yer bel configuration yerja3 ya3mel object mn mn 2awl w jdeed la2 lezm bas yseer configration 2awl mara ta3ml object ba3den bseer bya3ml check if exist l viewmodel ta3le byestd3e
l2no iza kel mara bado ya3mel object ma7aya3ref eno sar fe change
ya3ne l viwmodelprovider howe responsible 3ashn l retrive intnce 2aw create
ya3ne howe 2awl ma nsha8el l activity by3ml intance mn viewmodel ba3den iza l activity destory 2aw rotate l viwmodel ma btmout bedala 3eyhse fa basyeje la yen3aml mara tenye create heda str 7a yen2ra fa ma 7ata3ml create bas hal mara 7at2olak eno ana 3ande viewmodel 3mlto abl b mara fa bas 7atjebo t3mlo retrive return bhayda tare2a l viewmodel bedala 3eyshe w bt3ml survive lal
ya3ne bas la yerja3 yraje3 l intsatnce l viewmodel fa howe heek ya3ne 7tafaz be 7alto le ekenet fa aye data stored inide it 7adal still present same bedal metl ma heye



hala2 ne7na 5alsna neshe2 kel l hykleye taba3 l classes w databse w kel she
hala2 badna neje la sho8l ta2le2e le howe sho8l l 3anser l yser interface w l 3anaser l mawjoude feha

3ana shshet main activity 7a ykoun feha recycle view feha data tab3et salary 7a yen3ered feha data tab3et l employee w kel mowazaf elo slary taba3o w 3ande floating action button heda 3ashn y7wlak 3ala activity la ndeef employee

w l activity le bdeef employee esma addsalaryActivity hay feha spinner l mowazfen w ba3den bado yda5el kemet salry b edit text ba3den 3adne button be7ded l tare5 ba3den fe 3ande button save 3ashn ysayev l sallary la heda l mowazaf bel databse

w 3ande activity telte AddEmployeeActivity feha 3 edit text full name,id number,email w button pick birthdate w button save

ba3den bade 2a3ml costumeitem lal salry employe le bade 7oto bel recycle view 3ebra 3an card view b2lbo linear layout 2 textviw wa7de lal esm l employee w majmo3 l rawteb tab3to

w 3ande costume spinner item hayda le bado yen3ered fa howe 3ebra 3an textview bas b2lb cotume layout

hala2 badna na3ml l addapter l 5as bel bel spinnerhala2 l adapter l spinner 5alasneh

hala2 adapter l mainactivity le heye bade 2o3roud feha data ta3et l mwazafen w raweteb ya3ne 3ande jadwal fe 3amouden l 3amoud l 2awl fe asme2 l mwazafen w l 3amoud tene majmo3 l slaries taba3 kel mwazaf fa l method le heye l sum le mawjoude bel doa bade estd3eha 3end kel mwazaf bel recycle view
hala2 enta momken ta3mel 3ard data b2aktr mn tare2a enta momken ta3eml dmaj la 2 tables bel databse w ta3mel jalb la data  mn jadwalen ma3 ba3d ta3mel join la jadwalen ma3 ba3d momken ta3mel aktr mn tare2a la jalb data mn jadwalen ma3 ba3d madmojen
bas tare2a le bade 2a3mela tare2a ashal best5dem l addpter le 3am 2a3mlo de5el kel adapter 3ande 3end kel mwazaf mn l wazafen bade estd3e l method le esma getsum bas tare2a l aktr proffesional eno ta3mel join mn 5elel databse w ta3mel return la data b views w t3be data b recycle view

fa ne7na hala2 b recyel view class ro7na 3mlna list mn object l employee
ba3den 3mlna object mn viewmodel la njeeb meno data
w 3mlna constructor bye5od lista w bye5od viewmodel

w 3mlna class viewholder
w b2lbo 3mlna method esma bind la nestd3eha bel onbind mn3be data feha hay l method bte5od Emoloyee object w bte5od view model w b2alb l method 3mlna eno heda l employee le badna nd5lo equll la object eployee le bel viewholder
w b3den 7atyna la name.settext esmp l employee
w b3den sta3yna method l getsaleries le bel viewmodel 3atneha id l employee w feha click listner 7atyne w 3mlna li click listner berj3le value double ta3et sum la kel mwfaz b7eta b tene textview ta3el l slary lesh 3mlna employee object w rj3na 3mlna itile b2lb l function l2no ba3d shway bas na3ml click listner badna neb3tlo object mn employee bel click listner

hal2 ne7na 5alsna l addpter ba3den ne7na 3ana button hay btn2ol 3ala activity bt3mel add la employee w keef bade 2a3ml add la salary 3mlta mn 5elel menue button esma add slary

hala2 bel main activity 2awl sha8le lezm 3aref l viewmodel global Myviewmodel myviewmodel;
ba3den ba3mel intilize la viewmodel:myviewmodel=new ViewModelProvider(this).get(MyViewmodel.class);
heda l inatnce le 3arfto 7a ykoun mote7 3ala mostawa ta8yer l configration lal activity hay ya3ne 7ata law sar fe rotation  heda l object 7a ydal mawjoud w ra7 yet3emal ma3o b nafs l data le bede5lo

tyeb keef bade 2e3red l baynet  b recycle view 5alene rateb sha8le 2a3ml method baseta esma populateDataIntoRv() bte5od mene hay l method listet l baynet of employe w bt3be b recycle view hala2 hay l method saret jehze bte5od list w w bt3mela populate la data le b2lba b recycleview


hala2 bel oncreate bt2olo myviewmodel.getAllEmployees().observe() houn l fekra mn livedata fe method esma observe bte5od first parameter l owner taba3 l observer heda le howe hay l activity w l paramter tene howe new ....
btefta7 3andak method listner esma
onchange(List<Employee> employee)
sho ma3net l kalem heda alak listner le bel paramter tene fe method esma oncahnge aye ta8yer 3ala l baynet le btrja3 mn method l getallemployee  bel databse mobasharatan la7 yestd3e l method l onchange w yeb3tlk List<Employee> employees le heye feha data 2e5er wa7de hayde l 7alekola bas iza keen return type livedata
fa 2awl ma yseer ta8yer 3ala data bade 2a3ml populate lal data le byeb3tole yah ka list le heye l jdede bel recyeleview
fa heek damna eno 3atoul 7a ykoun b2lb l recycleview 2e5er data m3dale mn wara l observer le bewferle yeha livedata
houn enta btsajela bhay l activity lal owner ya3ne ba t3teha l context fa saret l onserver mortebta bhay l activity fa hay btra2eb life cycle ta3et l activity fa iza sar update 3ala data w l activity mana activite mana 7a ta3mel aye update bas tsser l activity active sa3eta 7a test3de l method w trj3lk l update data w t3del data 3ala l recycle view

ya3ne howe 2awl paramter l owner howe l activity le enta feha lesh 3ashn bao yorbot l observer feha fa litner onchange bado ykoun sha8al ma3 lifecycle ta3et l activity le enta feha law l activity sar pause ela fa litner 7a yo2af l2no mesh mante2 eno l activity tafet w enta trou7 ta3mel litner w tjeeb l baynet w tnafez l code le b2lb l onchange 7a tkoun l activity tafye fa ya3tek execption bas terja3 mn l onpause 7a yshof eno fee ta8yer sa3eta 7a yestd3e l onchange w ynfez l code b2lb l oncahnge

w heeek mnkoun 5aslna kel she w kel she jehez 3ande
w 3ande bas 2a3ml run byetl3le bel cosole she esmo databse inspector bt5lene shof kel she 3am yseer bel databse ya3ne bas ta3ml insert bebyn 3andak row delete de8re bebyn 3andak

b2rejek kel tables w bzeyede 3lyhoun table malster b2lbo id w hash text la heda l id heda table 3ebra 3an l currecnt schema ta3et databse le 3andak ya3ne iza badak tzeed column m3yan badak test3mel hay l info le b2lb hyda table la t8ayer l schema
ya3ne iza enta ro7t 3mlt add column fa heda she bado y8ayer l schema ta3et table fa sho badak ta3ml 2awl she badak t8ayer l version w 3ashn ma terja3 tel8e l app w terja3 tnazlo w yemshe l 7al ya3ne data le fe table bedala metl ma heye bas byenzed column
badak ta3me class migration from version 1 2 esmo migration1_2 extedn class migration byetl3 3andak function hay l function btektob feha query eno alter table add column w ba3d ma t5les btro7 3ala tag databse bt2olo fe attrinute esma migration bt3e l class ta3elak fa byemshe l a7l
bas badna nentebh eno l class badoun ykouno l parametr public w nafs le esm le 3am na3ml query ya3ne l as kaza heda bado ykoun nafs she bel class


hala2 le 3am yseer:
2awl ma mnblesh bekoun 3ana databse feha kel tables fadye mn 5elel l class databse le 3mlne w fe b2lbo column w kel she
hala2 ne7na bas 3am yen3ard data bel main activity ne7na 3am notlob mn view model data fa l view model btou7 btb3at la repostory bade hay data w l repository betrou7 bteb3at la doa bade hay data w doa berou7 bejeeb data mn databse w berj3a 3ala l repotory w l view model w l viewmodel t2rsela lal activity w bt3rouda
w nafs she bensbe lal insert 2aw delete ne7na 3am neb3at request mn l main 3ala l viwmodel l viewmode bteb3ata lal repostory l repostory bteb3at lal doa w doa bye3mel insert la hyde data bel databse
w bel nesbe lal live data betshof iza aye data t8ayret bhay table le m3ayne de8re bt3mel notify lala viws eno update hayde data le t8yaret


livedata heye mutable live data ya3ne ma feek t8ayer emeta feek bas te2ra l eme ta3eta ya3ne houn bas kona 3am na3ml return livedata fa houn heye 7a ta3mel observe 3ala ta8your l livedata ya3ne kel ma t8ayr emet livedata btestd3a method l observe w bteb3tlk e5er eme lal livedata bas houn mesh enta 3am t8ayera la emet livedata la2 howe internally 3am yshof eno ana 3am ra2ebl emet livedata le heye table fa enta bas 3am ta3mel insert la data 3al table hay l livedata 3am tet8ayr internally bas mesh ne7na 3am n8ayera fa l observe 3am yshof fe ta8yer 3a2emet l livedata 3am testd3e l observe w teb3at e5er data b2lb live data w hounek 3am n3del l ui

l youm la7 nblesh shar7 b she esmo architecture pattern:
exmple:t5ayal eno ne7na badna nebne madene kemle sho l motatlebet le b7aje ela:
2awl sha8le b7aje eno n7aded l maken eno ween bade ebne hay l madene
tene she badna n7aded eno adesh la7 tkoun mase7et hay l madene
telet she la7 n7ded l ameken l ra2seye tab3et hay l madene msln ween 7a tkoun l mostashfeyet,weeen l ameken tarfehye ,weeen l maderes ,ween 7a tkoun l jaweme3,ween 7a tkoun ameken sakan ,ween 7a tkoun l bona ta7teye taba3et l madene
hawde koloun mnetlek 3lyhoun esm architetcture pattern ya3ne l anmat l hykaleye hala2 ne7na heek 7addna haykaleyt l madene bas ne7na ma balsna bel bene2 hawde ta7dedet k2no ne7na 7adadna l arichetuture pattern l anmat l hykaleye ta3et l madene ba3d ma 7dadna l amekn l ra2seye w mase7et l madene w een bada tkoun hay l madene mn balesh nfout bel tasafasel msln
mne5od kel 2ot3a mn l 2ot3a le 7addneha msln mne5od l 2ot3a le heye l mase7a le 7addneha lal mostshfeyet mnblesh n7ded eno adesh 7atkoun mase7et l mostashfa adesh 7akoun 3adad tawabe2  bekl tabe2 kam 8orfe la7koun feha ya3ne mnblesh nebne l ajze2 le 7addenha mn abl hyde l ajze2 l baseta le 3am nebneha mtl 8oraf lal ameken le 7a teskoun feha nees adesh 7akoun mase7ta adesh 7akoun 3adad l abneye lal soken hyde tajze2et l baseta le 3am njaze2a mnetle2 3lyha esm design pattern

mn hawde l amsel:
l arichetucture pattern:byeshra7 l mokwenet w tafe3loha keef ya3ne ya3ne msln ya3ne ne7na 7addna l mase7a w 7addna l amken l mostshfa w amaken tarfeh w l abneye ya3ne hala2 enta bas te5roj mn baytak w badak trou7 3ala amken la tarfeh bt3ref keef badak tetfe3al mn ma7al ma enta seken la ma7al ma enta raye7 la ameken tarfeh  hyde arichetucture pattern byeshra7 l mokwenet w tafe3ola ma3 ba3d
design pattern:byeshra7 l bene2 ya3ne enta 7addt maken l mostshfa bas eno keef 7aykoun lawna kam tabe2 feha  ya3ne heye mokwenet l bene2 hyde mokwenet l bene2 heye design pattern
w momken ne5tesera b 3ebra tenye eno l archetucture pattern  howe 3ebra 3an mo5tat tajrede ama design pattern howe 3ebra 3an bene2 lal mo5tat l tajrede

hala2 lesh btest5dam l arichetecture pattern w design pattern:
-2awln 3ashn ne7sal 3ala code wade7 w mafhoum keef ya3ne ya3ne enta hala2 btbne mashro3 m3yan application w heda l mashro3 byeshte8l ma3ak team mkawan mn 4 asha5as bas enta tektob code yemken yeje wa7ad tene ykamel heda l code  bas yeje heda sha5s lezm ykoun by3ref  lezm ykoun ykoun fe arichtucture pattern w design pattern bshakl eno bas yeje la ykamel yefham sho ana keteb 3ala sho 3am eshte8l yaref eno enta sho 3am t7ewel tebne ya3ne bas tkoun 3am tebne jez2 m3yan mn l application l programmer tene yefhamak eno enta sho 3am t7wel tebne fa heda she kteer mohem eno ykoun l code understandable
-tene sha8le eno ykoun l code reusability ya3ne hala2 3am ebne she m3yan bel application w mmken ba3den 3oz ebne b application tene fa badal ma erja3 ektbo mn 2awl w jdeede berja3 bas bjeeeb l code metl ma howe le ketbo b 8eeer application w 7oto bhay l appplication w hyde sha8le btseer bas tkoun fasel l eshya 3an ba3da ya3ne manak m5le en hyde m3l2a bhyde bshakl eza emto lal code la test3mlo ykoun fe restriction eno ma feek test5dmo lal code ela ma ykoun mawjoud hay sha8le
-telet sha8le eno by3mlk she esmo cleaner code ykoun l code ndeef w 5ale mn aye mashekl w ebel lal maintance ya3ne bas la eje a3mel update lal code ykoun sahl 3lye w maintance ma ye5od wa2t tawel w ykoun l code 5ele mn l exeption hyde no2ta moheme lesh best3mel l design pattern w l arichetecture pattern

arechetecture pattern w anwe3a:
-model view controller(MVC)
-model view presenter(MVP)
-model view view model(MVVM)
-MVI heda arichetecture jdede


design pattern byen2esem la 3 anwa3:
-creational pattern(Builder,singleton,dependency injection,factory)
-structure pattern(Adapter,Facade,Decerator)
-behavoral pattern(Observer,State,Command)

tab3an kel mostla7 mn haw keloun elo dars 5as

hala hawde keloun best5dmo b mahro3 wa7ad la2 mesh darore:
enta momken test5dem arichetecure wa7ad msln MVC w te5od mn design pattern msln Bulider,Facade,Stet,observer w tebne mashro3 mesh darore tkoun btest5dem kel she b mashro3 wa7ad bas enta lezm ta3refoun koloun eno aymta test5dem hal she w weeen test5dema


hala2 l archetecture patter:
howe be2om b ta2sem l mahem l mo5telefe bel application la mokwenet most2elel b7ad zeta w heda she beshel 3mlyet ta3del w l update lal appliction
w b5le l maintibility ashal mn 5ell tanzem l code l2no kel ma keen l code aktr mnazam kenet l maintibility ashal
w btshel l archetectue pattern 2e3edet este5dem l mokwenet b maken tene 2aw b application tene ya3ne reusibility

hala2 l MVVM:
mvvm howe arichetucture pattern aktr she mashhour be2om b fasl l mokwenet l appliction la 3 mokwenet ra2seye sho houne l mokwenet:

Model:ma3neto namozaj hay 3ebra 3an taba2a mas2ole 3an edaret l data w l mante2 l 5as bel application heda jez2 bte3emal ma3 data ema iza keen mn api 2aw mn databse local room 2aw sql bekoun b2lbo kel she 5aso bel databse w enshe2a w columns ya3ne howe byhtam bel data tab3 l application ya3ne kel l data taba3et l application mawjoude bel model
view: ma3neto l 3ard 3ebra 3an wejha lal user ya3ne activity 2aw fragemnt b2lba kel she beshofo l most5dem le heye bt3rod feha l data howe heda byehtam bel 3anaser le btshofa ya3ne bel user interface howe activity 2aw fragmnet ya3ne howe 7ala2et wasl been l baynet w been l user interface keef bseer heda tafe3oul l user by3mel event m3yan mn l view 3ala l viewmodel insert msln fa hy l event btenrasal mn l view lal view model l viewmodel byersel heda l event lal model la databse  bhay tare2a bseer ta8yer bel databse w byerja3 heda ta8yer lal viewmodel telk2eyan mesh b2ede bas hala2 ma fe sehm mn l view model lal view ya3ne ma fe tawasoul mobesher been l viewmodel w l view l2no houn lama yseer ta8yer b databse 2aw b data ta3et l app  w yseer e3det heda ta8yer lal viewmodel l view mala7 yrou7 yetlbo la heda ta8yer ela eza keen jowet l viewmodel she esmo live data 3an tare2 live data la7 ytem est3lem l view 3an kel ta8yer 3am yseer de5el l baynet  ya3ne l view mesh 7a yotlob request mn viewmodel la yredelo data laken by3mel l view observe lal viewmodel ya3ne l view la7 yra2eb l viewmodel w be mojarad ma yseer ta8yer de5el l  viewmodel la7 ytem 2e3a2o lal view by deffult mndoun ma yetlbo l view hay no2ta jawhreye bemyez l vewmodel 3an be2e l eshya metl l preseneter l far2 tene eno la7 ykoun 3ana taba2 tenye been l viewmodel w l model esma repository  ya3ne l viewmodel ma be5teb mobeshratan l model laken be5teb l model 3an tare2 taba2 tenye esma repository l repository howe le 7aykoun 7ala2et wasl been l model w l viewmodel ya3ne taba2at ra2seye heye 3 l view ,viewmodel w model laken btem wad3 taba2a senweye been l model w l viewmodel btetsama repository
viewmodel:ma3neto 3ard l namozaj howe 3ebra 3an waset been l view w l model byorbout l data mn l model le b2lbo data w bejheza la y2om brda bel view w bekoun mas2l 3an l cofigration change le momken tseer

le bseer eno l view btetlob data mn l view model l viewmodel btotlob data mn l model fa l model btjeeb data bteb3ta lal viewmodel w l view model bteb3ta lal view w l viewmodel heye bt5zen data b2lb livedata fa bas yseer ta8yer 3al liuve data te8re btrje3 data lal view mn 5elel l observer l2no btkoun l activity 3am ta3mel observe 3ala l livedata
bas fe 2 senario bel nsebe lal livedata:
eza kenet 3am tet3mal ma3 data takledeye mesh databse fa houn le b5zen data bel live data howe l viewmodel mn 5elel l set() w bas l activity 3am tra2eb ta8yer live data houn l acivity 3am tr2eb l method le mawjoud bel viewmodel le btrje3 live data fa fe method std3neyha b2lba set() 8ayret livedata fa de8re btrja3 vimodel btb3ta data lal activity
ama houn l activity 3am tr2eb method le brje3 live data bel viewmodel fa enta bas ro7t 3mlt insert std3et method mn l view model la ta3mel insert fa ra7et hay l method std3et method le bel repostory w method le bel respository std3e method le doa w 3mlet insert la data fa hala2 room shef eno fe ta8yer la data fa ra7 8ayar live data internally ya3ne k2no 3mel set() fa ta8yer hay livedata 3mlet reflect 3ala live data le bel repsotory w ta8yer l live data bel repository 3melet ta8yer 3ala live data bel viewmodel fa l activity 3am ta3mel observe 3a hay l viewmodel fa ra7 viewmodel 3emel notify lal activiy w 2ala live data t8ayret le 3am ta3mela observe fa 5ode hay live data l jdede w 3adle l ui taba3ek fa houn kolo sar by deffult 2ama fo2 sar yadaweyn ne7na 3mlna ta8yer lal live data mn 5elel method set()


ma3neto l 3ard 3ebra 3an wejha lal user ya3ne activity 2aw fragemnt b2lba kel she beshofo l most5dem le heye bt3rod feha l data howe heda byehtam bel 3anaser le btshofa ya3ne bel user interface howe activity 2aw fragmnet ya3ne howe 7ala2et wasl been l baynet w been l user interface keef bseer heda tafe3oul l user by3mel event m3yan mn l view 3ala l viewmodel insert msln fa hy l event btenrasal mn l view lal view model l viewmodel byersel heda l event lal model la databse  bhay tare2a bseer ta8yer bel databse w byerja3 heda ta8yer lal viewmodel telk2eyan mesh b2ede bas hala2 ma fe sehm mn l view model lal view ya3ne ma fe tawasoul mobesher been l viewmodel w l view l2no houn lama yseer ta8yer b databse 2aw b data ta3et l app  w yseer e3det heda ta8yer lal viewmodel l view mala7 yrou7 yetlbo la heda ta8yer ela eza keen jowet l viewmodel she esmo live data 3an tare2 live data la7 ytem est3lem l view 3an kel ta8yer 3am yseer de5el l baynet  ya3ne l view mesh 7a yotlob request mn viewmodel la yredelo data laken by3mel l view observe lal viewmodel ya3ne l view la7 yra2eb l viewmodel w be mojarad ma yseer ta8yer de5el l  viewmodel la7 ytem 2e3a2o lal view by deffult mndoun ma yetlbo l view hay no2ta jawhreye bemyez l vewmodel 3an be2e l eshya metl l preseneter l far2 tene eno la7 ykoun 3ana taba2 tenye been l viewmodel w l model esma repository  ya3ne l viewmodel ma be5teb mobeshratan l model laken be5teb l model 3an tare2 taba2 tenye esma repository l repository howe le 7aykoun 7ala2et wasl been l model w l viewmodel ya3ne taba2at ra2seye heye 3 l view ,viewmodel w model laken btem wad3 taba2a senweye been l model w l viewmodel btetsama repository:

l mvvm fena ne3ber 3lee mn 5elel heda l exmple:
3teber badna na3mel robot byet7arak byemshe by3mel 7araket ok
model howe 3ebra 3an l brain taba3 l robot le b2lbo mawjoud m3raf kel task metl eno yesmhe yor2os ya3mel kel she 7araket bas hawde ma byetaba2o law7do hawde byetba2o mn 5elel instruction ya3ne l model 3ande howe list of tasks bye2dar ya3meloun l robot
view howe 3ebra 3an remote controle menst3mlo la na3ml interact ma3 robot 3ana b2lbo button for walk button for dance button for wave  bas tekbous 3ala button mn haw msln l wave button tell the robot what to do bhay l exmple howe wave
viewmodel howe 3ebra 3an translator been rorbot bran and remote controle ya3ne bas tekbous 3ala button m3yan mn remote controle hayde byen3mal tranlsate w btente2l lal model 3ashn ynafez 7arake mo3ayne ya3ne howe bas nekbous 3ala buttton bel remote hayde l action btetrjm la she m3yan command byefhama l robot w btenresel lal 3a2lo lala robot w bt2olo nafzle hyde l action
exmple iza kabsana 3ala wave button bel remote controle l viewmodel btrjem hay l kabse lal rebote controle w b2olo bafez hay l 7arake le heye wave make wave
ya3ne kabsana 3ala remote controle wave button bte5oda l viewmodel w btersel l viewmodel message lal model le howe 3a2l l robot w bt2olo please wave

ya3ne l mvvvm btes3dna controle 3ala l application mn 5elel seprate l brain le howe l model le howe data w by3mel seprate lal remote controle le howe l activity w kamen seprate l translater le howe l viewmodel hay separation btsd3na to manage l application

l mvvm heye template lal client application archetecture bt3mel serate lala application le3na l 3 part kel part mas2ol 3ala she m3yan model,view,viewmodel
howe byefsel l data presentation ya3ne l l user interface le btreoud data 3ana data nafsa btefsouloun 3an ba3d kel wa7de ma 5asa b tene

ya3ne l model b2lba kel she data kel she 5aso bel databse sawe2 keeen m api 2aw local databse by3mel encapsulate la data ta3et l application mtl l user information,data retrive from web service ma bekoun fe b2lba wala code 5aso bel user interface 2aw keef data badna ten3ered 3ebra 3an database class w entity mn 5elela bt3mel structure lal data
l view hyde mn 5elela mnetwasal ma3 l viewmodel lal action le momken ya3mela l user hyde l layer observe viewmodel w ma bekoun b2lba aye code 5aso bel logic taba3 l appliction heye 3bra 3ana activity bya3mel action l user mn 5ela w mn 5elel hayde l action mnetwasal ma3 l viewmodel w mne2dar mn 5elela na3ml observe lal viewmodel w heye mas2ole bas 3an l presentation data to user w trigger l action le momken ya3mela l user heye mas2ole 3an kel she beshofo l user w by3mel ma3o interact heye l user interafce b2lba button recycle view ...etc
l viewmodel  heye 3ebra 3an link 2aw wasel been l view w l model b2lab kel logic  manage data le bada ten3arad w bteb3at data le bada ten3arad lal view la7ala mndoun aye requst mn l view ya3ne heye l viewmodel ma btetwasal ma3 l view ya3ne b2lb l view ne7na ma mneb3at requst lal viewmodel eno badna hay data la2 l view observe ber2eb l viewmodel w beshof data le 3am tet8ayr feha mn 5elel live data le mawjoude b2lb l viewmodel w mn5elel l viewmodel ne7na mnetwasal ma3 l model la na3ml aye action 3ala l model bas mesh bshakl mobesher mn 5elel kamen waset baynon le howe l repostory w heda l class kamen bya3mel manage la aye confiration momken l view yseer 3lyha metl l rotation


MVVM:
View-->viewmodel-->repository->model
       livedata


mo5atat lal view viewmodel:

mn blesh bel activity 2aw frgemnt le bemsel l view ba3den mn activity 2aw fragemnt byetlob mn l viewmodel w l viewmodel byotlob mn repository repository momken ykoun naw3en 5eyaren ya ema bekoun  ya ema btkoun data mawjoude be server bel remote metl firebase ,api ya3ne databse 5arejeye ,2aw btkoun l viewmodel de5leye metl l room btkoun databse de5leye
heda l aktr este5dem arichetecture pattern lesh l2no by3tek tarteb akatr lal application l2no houn ne7na 3am nefsel been l userinterface w l databse w heda she be2lel l taklefet l maintainbility w beshel eno neshte8l ka team metl msln wa7ad yestelm l model wa7ad yestelm l viewmodel wala yesteml view ya3ne howe heek faale l data 3an l user interface ya3ne mesh metl ma kona na3mel eno na3mel query la data base mn l activity 3ala l databse la2 houn enta btestd3e method w heye la7ala btjeblak databse w bt7otlak yeha enta 3leek bas ta3mel populate la data ya3ne btjeek data mn bara 3leek tbeha bas 2aw iza badak ta3mel insert bas btst3mel method bel viewmodel w howe la7alo berou7 by3mel insert bas houn eno enta mesh kel mara badak teje 3al activity badak ta3mel objet mn l databse w ta3mlinsert 2aw mesh kel mara enta bas t2olob shshe badak terja3 ta3mel objet mn databse w yerja3 yejblak data 2aw mesh kel mara badak ta3mel requst la mn databse la yejblak data la2 houn howe la7alo bas yshof ta8yer bjeeb data w enta 3leek bas t7ota b view ya3ne enta b2lb l view ya3ne houn kolo mafsoul 3an tene ya3ne keen law badak data terja3 3ashn t7ota b receycle view keeen tsstd3e Databse.getintance,getallemployee() hala2 batalt ta3mel heek sar 3andak observer heye la7al btjblk data bala ma enta testd3eha w bel nesbe lal insert enta 3am testd3e method bas 3am ta3teha paramter bas heye la7ala 3am trou7 ta3mel insert b worker thread ya3ne enta law ma fasltoun keeen kel mara badak ta3mel insert badak trou7 yta3mel thread jdeed ma belak iza keen badak ta3mel 5 insert ma3 ba3d badak ta3mel 5 thread heda she 8alat bhay tare2a enta fasel kel she 3an ba3do

Activity|fragemnt
       |
       |
    View model
    livedata
        |
        |
    Respoitory
        |
        |
 _______|__________________
 |                         |
 |                         |
 |                         |
 Model(Room)         Remote data source(Retrofit)api
 |                          |
 |                          |
 |                          |
 SQLIte                  webservice

exmple badna ne7sob 3omr sha5s ntab2o mn 5elel l mvvvm
bade 2a3ml 4 packages:
package model
package repostory
package viewmodel
package howe l view

fa houn le sar eno 3mlt model fe b2lbo name w l age w 3mlt interface bel reposotry package bye5od name w age  w berje3 muable livedata
ba3den bel repostory 3mlt implemnt la heda l imferface w 7asbt  age w jebt name w jebt data mn l model w 3tyto l age w name w rj3t hay data b mutable live data ok fa houn l repository heye le 3am tetwasal ma3 l model
w ba3den 3mlt viewmodel b2lbo function btrkje3 mutable live data w btstd3e method l repsotory w bel main activity 7atet observe 3alal funtion le brje3 live data
fa hala2 ana bas ekbous 3ala l button btrou7 bestd3e method l bel viewmodel w viewmodel btrou7 btsd3e l method le bel repsotory w l repsotory bteytwasal ma3 ma3 l model b sayev data w be3del 3ala l live data fa bas hayde live data tet3dal heda ta3del kmen byetba2a 3ala livedata le mawjoude bel viewmodel fa l activity 3am ta3ml observe 3ala hyde live data btshof eno sar fe ta3del 3alyha fa l viewmodel bt3ml notify lala activity w bt2ola eno sar fe ta3del 3ala live data w btb3tla e5er live data 3anda fa heek tab2na mafhoun l mvvvm faslna l logic w l data 3an l user interface


l mvvvm btest5dam akatr bel project l m32ade w b7aje la ta7deset kteer bel application mnest5deml mvvm










 */











public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MyViewModel viewModel;
    SalariesEmployeeRecycleAddapter addapter;
    ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if(o.getResultCode()==RESULT_OK && o.getData()!=null){
                Employee employee= (Employee) o.getData().getSerializableExtra(AddEmployeeActivity.EMPLOYEE_KEY);
                viewModel.insertEmployee(employee);

            }

        }
    });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel=new ViewModelProvider(this).get(MyViewModel.class);

//        viewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
//            @Override
//            public void onChanged(List<Employee> employees) {
//                populateDataIntoRV(employees);
//            }
//        });

        viewModel.getSalariesSum().observe(this, new Observer<List<SalaryEmployee>>() {
            @Override
            public void onChanged(List<SalaryEmployee> salaryEmployees) {
                populateDataIntoRV(salaryEmployees);
            }
        });

        binding.addBtn.setOnClickListener(v->{
            Intent intent=new Intent(this, AddEmployeeActivity.class);
            activityResultLauncher.launch(intent);
        });

    }

    void populateDataIntoRV(List<SalaryEmployee> employees){
         addapter=new SalariesEmployeeRecycleAddapter(employees,viewModel);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        binding.recyleview.setLayoutManager(layoutManager);
        binding.recyleview.setAdapter(addapter);
        //delete
        //new item toush helper by3mel isnatnce mn class esmo itemtoachhelper heda 3ebra 3an utility class bel android mn 5elelo befrlna handling touch geatures specially from swipe 2aw drag 2aw drop actions in recycel view
        //new itemtoxhepler.simple call back 3ebra 3an call back bye5od 2 paramter the first argument 0 in this case hyde mn 5elela mn3mel specify lala drag and drop direction 0 ya3ne eno mabdna drag ana drop
        //tene paramter ItemTochhelper.Left hyde specify the swipe direction fa houn 3am n2olo eno bas na3ml swipe badna na3ml swipe 3al left

        //b2lb heda l class fe 2 method la na3mleoun overide:
        //2awl method heye onmove btestd3a wa2t bas l item bel recycle view btet7arak btre2et drage and drop in this case maman3oza
        //tene method esma onswiped hayde byen3mala call bas na3ml swipe lal item bel recyle view bt2rslna 2 paramter l viewholder w l integer direction
        //drag ya3ne enta bemkenak ta3mel hold 3alal item w t7areka tlo3 nzoul..etc ya3ne drag eno tetd8at da8ta tawele w t7rek l 3onsour
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //houn badna na3ml l action bas l item yen3mla swipe
                //fa houn bas 2a3ml swipe lal item lal left bade 2a3ml delete la hay l item
                SalaryEmployee employee=addapter.getitem(viewHolder.getBindingAdapterPosition());
                viewModel.DeleteEmployee(employee.getName());

            }
            //e5er she mn3mel attash la recycel view mn 5elel hayde l method mawjoude bel item toash helper to attash to recycle view  hyde bt5le l itemtoash helper yseer mawjoud bel recyele view w y3melo enable w yf3lo w bt5lene a3mel swipe 2aw drag and drop la item bel recyele view

            //hala2 la na3mel background ta7t l item ybyen souret delete back ground bas na3mel swipe badna na3mel overide la ba3d method esma on

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                //houn badna nestd3e library heye la7la b2alba l icon ta3el delete 3ashn ma na3mela from scratsh
                //ba3den mn3ml object mn recycleviewswipeecrator 3ebra 3an class b2lb hay librar hay library bt5lene 7ot aye background 3ala l swipe
                //hyde bt5elene 7ot background w background color w corener redius w padding w image kel hawde lal item le bas 2a3mela swipe
                new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        .addSwipeLeftActionIcon(R.drawable.baseline_auto_delete_24)
                        .addSwipeLeftBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.back))
                        .create()
                        .decorate();
            }
            //e5er she mn3mel attash la recycel view mn 5elel hayde l method mawjoude bel item toash helper to attash to recycle view  hyde bt5le l itemtoash helper yseer mawjoud bel recyele view w y3melo enable w yf3lo w bt5lene a3mel swipe 2aw drag and drop la item bel recyele view

        }).attachToRecyclerView(binding.recyleview);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.add_salary){
            Intent intent=new Intent(this,AddSalaryActivity.class);
            startActivity(intent);
            return true;

        }
        return false;
    }
}