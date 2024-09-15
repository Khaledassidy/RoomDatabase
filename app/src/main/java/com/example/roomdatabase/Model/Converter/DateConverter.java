package com.example.roomdatabase.Model.Converter;
//heda 3ebra 3an class baset fekrto eno ana bade 7awel bel class heda mn date la long w mn long la date tyeb lesh ba3ml heek ana ba3mel heek 3ashn databse ma bt2ebal mena she esmo date ma3nda date
//w ana me7tej et3emal ma3 date 3ashn heek bade 2a3ml convert mesh mante2 kel shway rou7 7awel date la long w et3emal ma3o ka long bel shshe  wala 2etlob mn l user yda5ele yeh long wala kel shway e5od ra2m long w karno ma3 ra2m tene la2 ana abde et3emal ma3 dates metl datapicker calnder haw keloun byet3mlo ma3 date
//date heda bade e5do w rou7 5azno bel databse ka long fa bade method t7wele mn date lal long 3ashn lama t5zen bel databse
//w bade method t7wele mn long la date 3ashn lama 2a3ml retrive mn databse yejene ka date

//fa ba3ml method public static bada te5od long w traje3 Date bade sameha fromlongtodate w b3teha Long millisecond msln w bade t7wele yeh la date bas hay l method ta3moul ma3a ka object ya3ne bte5od long mn no3 object Long w btrej3 date mn no3 long ya3ne ma t7ot long heek long la2 7oto heek Long room btet3raf 3ala object
//joweta sho bade 2a3ml la hay l method bteje bt3mel if long le jeye 3ande ma besewe null 2a3ml retun la new Date(miliisecond) fa bhya tare2a bt7wel long la date w else return null enta bas t3te la contructor l Date long be7welak yeha de8re la date
//if(milliseconds!=null){
//        return new Date(milliseconds);
//        }
//        return null;
//retun millisecond=null?null: ya3ne iza l millisend btsewe null raj3le null else raj3le new Date(millisend)

//bt3mel method tenye esma fromdatetolong bte5od date object w btrej3 long object nafs le 3mlto fo2 be2wal function 3afekra fena na3ml bsatr wa7ad:
//bade 2olo iza date equll null raje3 null else raje3 date.gettime btrje3 time bel millisec ka long
//hala2 hal heek fehmet l room databse eno heed l class l mo7awel la2
//tyeb keef lezm tfahema :
//bkel basata bteje fo2 kel funtion 3ashn room tefham eno hay mo7wel bt2olo @TypeConverters ya3ne hyde 3ebra 3an type converter eno heda 3ebra 3an mo7wel 2aw ya3ne hay l method 3ebra 3an method ta7wel
//l mohem l input w return ykouno nafs no3 taba3 ta7wel
//bteje asln l room databse btetla3 hal hay l method bte5od l 2eme le bade 7awela w btraje3 l keme le bado yeha l most5dem bel class table iza eh btest5dem hay l method 3ashn heek 3mlnehoun static 3ashn nestd3ehoun b2esm l class
//ya3ne heye btetala3 3al anwa3 7asab nou3 le mawjoud bel input ,return btrou7 btest5dmo hounek
//hal2 enta 3rft l converter 3ashn tfahem l table eno enta badak test5dem l converter brou7 bt3rfo fo2 ba3d l entitty bt2olo @TypeConverters({}) ya3ne type converts houne 3ebra 3an DateConverter.class enta heek 3arftelo eno ana 3nde type converters le howe heda l class feek deef aktr mn wa7ad fahmto eno ana bade est3mel heda l mo7wel 3ashn 7awel aye eme mesh mawjoude bel databse  le heye bel table heda l Date birthdate 7a yetla3 hal bel converter heda le 3rfto bte5od date w btrje3 eme bten2bal bel databse eh fe 3ande wa7ad converter bya3mel heek
//bel retrive nafs she beshof l converter hal fe 3ande method bte5od 2eme mn databse w btrje3 no3 mn anwa3 le mest5dema bel class taba3o eh date iza eh yes rou7 7awele yeh

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date FromLongToDate(Long milliseconds){
        return milliseconds==null?null:new Date(milliseconds);
    }
    @TypeConverter
    public static Long FromLongToDate(Date date){
        return date==null?null:date.getTime();
    }
}
