package com.example.roomdatabase.Model.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.roomdatabase.Model.Converter.DateConverter;

import java.io.Serializable;
import java.util.Date;
//hala2 2awl she b3ref varibles id,name,birthdate,emil w iza mnetzkar bel sqlite ma keen fene 3aref date keen bade 2a3ml ya double,string,long ama hala2 be2dar et3mela ma3 data bas b7ale 5asa ya3ne lezm ya3ne lezm 2a3mel 7arake trick 3ashn yefham room databse eno heda date laken howe room databse fe3lyan law ana katbt date Date birthdate varible date howe la7 yr3efa 3ando long laken fe 3amlyet ta7wel btseer
//fa hala2 2awl she 3arft sho houne l varoble le 3ande ya3ne sho houne l column le 3ande:
//private long id;
//private String name;
//private Date birthdate;
//private String email;
//fa hala2 sort m3ref table lal database w heda table fe 4 2a3mede id,name,birthdate,email
//bas hala2 heda jadwal ma elo 2eme ya3ne howe w heek l2no room databse lesa ma fhmt eno heda table ybe keef bade fahema eno howe table:
//best3mel anotation esma @Entity 3al sare3 btefham eno heda table heda class l employee heda table tyeb @Entity ya3ne table tyeb b2ye databse ya3ne heda jadwal b2aye databse mawjoud ma enta lisa ma anh2t databse sa7e7 heda l 7aky ana lisa b3ref be  haykleye databse btem enshe2a bel run time bel tash8el  ama hala2 enta bt3ref bel haykaleye bas fa @Entity ya3ne aye wa7d 7a yest5dem heda l class 7a yefham eno howe table room databse  tyeb sho esm l jadwal heda esmo employee tyeb ana mesh m3jebne eno same bel table employee bade 5ale bel java esmo employee ya3ne bade yeh bel java esmo employee bas bel databse bade esm tene fa la ta3mel heed btefta7 pracet hed @Entity() w b2lb heda l praces bt7ot tableName='khaled' msln fa heek enta samet l table khaled bel databse w samyto bel java Employee ya3ne ba3d shway bt2olo select * from khaled,insert into khaled ,update khaled,delete khaled khaled sar esm l table bas law enta 5ayto bdoun l praces 7a ye5od l esm l eftarade le howe esm l class Employee law deft l 5aseye hay la7 ye5od l esm le enta btktbo tyeb heda l class sar table tyeb w hawde le 3arftoun id,name,email,birthdate saro 2a3mede bel databse sa7 saro 2a3mede bel databse
//bas enta momken t7ot eloun 5asa2es metl primary key w 8yra bas abl fe mol7za eno l anotation bshkl 3am btetba2 3ala awal code barmaje mawjoud waraha ya3ne l anotation l @entity teb3a la meen sho feha waraha fe waraha class employee fa btetba2 3ala heda l class btetb2 3ala satr le waraha bas law fe 3ande 50 anotation @entitty  hawde keloun teb3en la 2awl satr code mawjoud warahoun
//fa hala2 iza bade 3aref 5asa2es lal column le 3andemetl sho:
//fa hal2 law bade 3aref 5aseye lal id msln b3ref faw2a mobshrtan anotation l2no l anotation teb3a bas la 2awl satr barmaje
//fa hala2 msln bade 3aref eno l id primary key:b2olo @PrimaryKey badak yeh mano num kamen bt7ot faw2a l id @nonnull fa sar hawde l tenen l anotation teb3en bas lal id
//hala2 badak she 5aseye lal name fa btktob fo2 name l anotation msln @nonull
//fe 3aande bas 5aseye esma @ColumnInfo() hyde ma3lomet la hyda l 3amoud msln feek t2olo name="_id" ma3neha metl ma 7kena fo2 bel zabt sar heda l column bel databse esmo _id keen esmo id l2no howe bye5od by deffult esm l varible hala2 ana 5lyt esmo _id bel room databse ama bel java esmo id tab3an b2lb hay l columninfo feek t7ot deffultvalue

//hala2 bta3mel generate la constructor bye5od l 4 varible w constructor fade kamen
//w generate la setter w getter
//w heek enta 5alst 2awl table

//fe she 3ana esmo indexes hayde btest3mal la na3ml quury asra3 keef ya3ne
//ya3ne 3ana table l employee w 7atna select * from eployee where email="khaled@hotmail.com" houn l la7 yrou7 ya3mel sacn la table row by row la yl2e l email matching heda l email w yjebo ama best3mel l idexes k2no 3ande kteeb mesh w b2awl saf7a 7atet eno bhyde l page mawjouden haw l eshay bhwde l page mawjoude hay l eshya tene fa heek bas dawer 3ala she m3yan 7a ykiun asra3 ma dawer 3lee saf7a sa77a
//fa eza 3mlt indexes 3ala emial bhay tare2a mesh 7a ya3mel sacan row by row 7a yrou7 de8re yl2e row le ne7na talbeno

@Entity(tableName = "employee_table")
@TypeConverters({DateConverter.class})
public class Employee implements Serializable {
    //Employee table {id,name,birthdate,email}
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "emp_id")
    private long id;

    @NonNull
    private String name;

    @NonNull
    private Date birthdate;

    @NonNull
    private String email;

    public Employee(long id, @NonNull String name, @NonNull Date birthdate,@NonNull String email) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
    }

    public Employee(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
