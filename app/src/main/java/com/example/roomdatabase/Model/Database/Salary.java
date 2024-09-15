package com.example.roomdatabase.Model.Database;
//hala2 bkarer nafs l 3amlye b table l salary 3ande 4 varible id,amount,data emId
//bade l id primary key w badak yeh ykoun auto increament fa b2lb l primary key anotation() bt2olo autogenerate=true
//mn3mel constructor fe l varible,w constructor fade w getter w setter

//hala2 5alsna bas ba3d fe 3mlyet rabt been 2 tables keef :
//3l2et l l employe ma3 salary 1 to many kel majmo3a mn salary teb3a la employee wa7ad
//keef bade 2a3mela ma feek mobashrtn t2olo eno heda foregn key badak teje 3ala jadwal le fe l foregn key le howe salary meen l foregn key le howe l empID le bedoul 3ala primary key le bel table l employee
//fa beje 3ala l salary table b2lb tag l entity befta7 bracet w b2olo Entity(foregnkey={}) w bt3ref b2lb l praces kel l foregn key le 3andak 3andak 2 2aw 3 2ad ma badak bt7ota bel praces
//houn 3ande foregn key wa7de le howe l emp_id
//fa b2lb hay l praces bt2olo @Foregn key() iza 3andak foregn keye teney bt2olo false @foregnkey

//fa @foregnkey() bte5od majmo3a mn l 5asa2e2 2awl sha8le esm l class taba3 l ab  le howe class l employee ya3ne l class le 3am ne5od mena l foregn key howe class l employee le howe le fe l id
//fa b2olo @Foregnkey(entity=Employee.clas,)
//ba3den bt7ded l parentColumn{} sho l 2a3mede taba3et l parent le howe l employee badak test5dema bel ebn le howe l salary ya3ne sho l 3amoud le howe primary key bel parent l id mnfta7 kamen {} mn7ota l2no momken ykoun 3ande akatr mn foregn key la nafs jadwal ya3ne yemken l employee 3ando kaza primary key w bade yehoun ykouno foregn key b heda table fa hala2 3ande pas wa7ad fa esmo emp_id

//hala2 falsle l childcolumn esm l column le howe foregn key empId

//fasle fe 3ande ba3d l awemer bel update w delete eno onupdate cascade on delete cascade fa bt2olo onupdate=Foregnkey.CASCADE
//hala2 heek enta rabatoun w law fe ba3d foregn key bt3mel fasle w bt3mel @Foregnkey() w bt3ml nafs le 3mlto

//dal fe sha8le baseta bas date le ana 3rfto bel sallary w l employee hawde l tnen hawde l tenen mante2yan mesh mawjouden bel databse ya3ne ma fe bel databse sqlite databse she esmo mno3 date tyeb keef btseer ta3moul ma3 date mn 5elel long ya3ne enta sa7 m3ref houn Date bas bel sqlite  byest5dmo ka long lama yet5azan beyt5azan long lama btjebo btjebo long bas hala2 keef 3mlyet ta7wel bada tseer Date w long lezm enta ta3mela b2edak l2no iza dalet heek la7 ya3mlak exeption la7 y2olak mn ween jeyeb datatype esma Date ma3nde heek she ana 3ande long  fa lezm 2a3ml mo7wel mn long la data w mn date la long
//fa ba3ml class esmo DateConverter

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.roomdatabase.Model.Converter.DateConverter;

import java.util.Date;
@TypeConverters({DateConverter.class})
@Entity(foreignKeys = {@ForeignKey(entity = Employee.class,parentColumns = {"emp_id"},childColumns ={"empId"},onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.CASCADE)},indices = @Index(value = {"empId"}))
public class Salary {
//   Salary {id,amount,data,empId}
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private double amount;

    @NonNull
    private Date date;

    @NonNull
    private long empId;

    public Salary(int id,  @NonNull double amount, @NonNull Date date,@NonNull long empId) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.empId = empId;
    }

    public Salary( @NonNull double amount, @NonNull Date date,@NonNull long empId) {
        this.amount = amount;
        this.date = date;
        this.empId = empId;
    }

    public Salary(){

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long emp_id) {
        this.empId = emp_id;
    }
}
