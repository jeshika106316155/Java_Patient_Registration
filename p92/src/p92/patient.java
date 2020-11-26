/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p92;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class patient implements Serializable{
    String name, departmentname, timename;
    static int countdent[]={1,1,1}, countcar[]={1,1,1}, countski[]={1,1,1};
    int id, count,department, time, systolic, diastolic,bmi;
    void ask(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Please input name & ID= ");
        name=sc.next();
        id=sc.nextInt();
        System.out.print("Department? 1)dentist 2)cardio 3)skin= ");
        department=sc.nextInt();
        switch(department)
        {
            case 1:
                departmentname="dentist";
                break;
            case 2:
                departmentname="cardio";
                break;
            case 3:
                departmentname="skin";
                break;
        }
        System.out.print("Time? 1)morning 2)aftrenoon 3)night= ");
        time=sc.nextInt();
        switch(time)
        {
            case 1:
                timename="morning";
                break;
            case 2:
                timename="afternoon";
                break;
            case 3:
                timename="night";
                break;
        }
        
        if(department==1 && time==1)
        {
            count=countdent[0];
            countdent[0]++;
        }
        else if(department==1 && time==2)
        {
            count=countdent[1];
            countdent[1]++;
        }
        else if(department==1 && time==3)
        {
            count=countdent[2];
            countdent[2]++;
        }
        if(department==2 && time==1)
        {
            count=countcar[0];
            countcar[0]++;
        }
        else if(department==2 && time==2)
        {
            count=countcar[1];
            countcar[1]++;
        }
        else if(department==2 && time==3)
        {
            count=countcar[2];
            countcar[2]++;
        }
        if(department==3 && time==1)
        {
            count=countski[0];
            countski[0]++;
        }
        else if(department==3 && time==2)
        {
            count=countski[1];
            countski[1]++;
        }
        else if(department==3 && time==3)
        {
            count=countski[2];
            countski[2]++;
        }
        System.out.println("Your registration for "+departmentname+" in "+timename);
        System.out.println("your waiting number: "+ count+"\n\n");
        count++;
   }
    
}
