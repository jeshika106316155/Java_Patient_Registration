/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p92;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class P92 {
    static int count=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here
        
        int choice=0,exist=0,inputid;
        String inputname, inputdepartment,inputtime;
        
        patient w,r[],c[],r2[]; //w=write, r=read, c=copy
        FileOutputStream fw= new FileOutputStream ("Patientlist1.dat");
        ObjectOutputStream ow=new ObjectOutputStream(fw);
        Scanner sc= new Scanner(System.in);
        FileInputStream fr=new FileInputStream("Patientlist1.dat"),fr2;
        ObjectInputStream or1=new ObjectInputStream(fr),or2;
        
        System.out.print("JJ Clinic\n\nDo you want to? 1)Registration 2)sort by department 3)sort by time 4)search by department 5)search by name 6)search by time 7)delete  data -1)exit= ");
        choice=sc.nextInt();
        while(choice!=-1)
        {
            switch(choice)
            {
                case 1:
                    w= new patient();
                    w.ask();
                    ow.writeObject(w);
                    //System.out.println(count);
                    count++;
                    break;
                case 2:
                    fr=new FileInputStream("Patientlist1.dat");
                    or1=new ObjectInputStream(fr);
                    r=new patient[100];
                    for(int i=0;i<count;i++){
                        //System.out.println(count);
                        r[i]=(patient) or1.readObject();
                    }
                    for(int i=0;i<count;i++){
                        for(int j=i+1;j<count;j++){
                            if(r[i].department>r[j].department)
                            {
                                w=r[i];
                                r[i]=r[j];
                                r[j]=w;
                            }
                        }
                    }
                    System.out.println("Name\tID\tDepartment\t\t\tTime\tWaiting number");
                    for(int i=0;i<count;i++){
                        System.out.println(r[i].name+"\t"+r[i].id+"\t"+r[i].departmentname+"\t\t\t"+r[i].timename+"\t"+(r[i].count-1));
                    }
                   fr.close();
                   or1.close();
                    break;
                case 3:
                    fr=new FileInputStream("Patientlist1.dat");
                    or1=new ObjectInputStream(fr);
                    r=new patient[count];
                    for(int i=0;i<count;i++){
                        //System.out.println(count);
                        r[i]=(patient) or1.readObject();
                    }
                    for(int i=0;i<count;i++){
                        for(int j=i+1;j<count;j++){
                            if(r[i].time>r[j].time)
                            {
                                w=r[i];
                                r[i]=r[j];
                                r[j]=w;
                            }
                        }
                    }
                    System.out.println("Name\tID\tDepartment\t\t\tTime\tWaiting number");
                    for(int i=0;i<count;i++){
                        System.out.println(r[i].name+"\t"+r[i].id+"\t"+r[i].departmentname+"\t\t\t"+r[i].timename+"\t"+(r[i].count-1));
                    }
                    fr.close();
                    or1.close();
                    
                    break;
                case 4:
                    fr=new FileInputStream("Patientlist1.dat");
                    or1=new ObjectInputStream(fr);
                    
                    System.out.print("input Department you want to search: ");
                    inputdepartment=sc.next();
                    r=new patient[100];
                    System.out.println("Name\tID\tDepartment\t\t\tTime\tWaiting number");
                    for(int i=0;i<count;i++){
                        //System.out.println(count);
                        r[i]=(patient) or1.readObject();
                        if(r[i].departmentname == null ? inputdepartment == null : r[i].departmentname.equals(inputdepartment))
                        {
                            System.out.println(r[i].name+"\t"+r[i].id+"\t"+r[i].departmentname+"\t\t\t"+r[i].timename+"\t"+(r[i].count-1));
                            exist++;
                        }
                    }
                    
                    if(exist==0)
                    {
                        System.out.println("There isn't any data with that department!");
                    }
                    exist=0;
                    fr.close();
                    or1.close();
                    break;
                case 5:
                    fr=new FileInputStream("Patientlist1.dat");
                    or1=new ObjectInputStream(fr);
                    
                    System.out.print("input Name you want to search: ");
                    inputname=sc.next();
                    r=new patient[100];
                    System.out.println("Name\tID\tDepartment\t\t\tTime\tWaiting number");
                    for(int i=0;i<count;i++){
                        //System.out.println(count);
                        r[i]=(patient) or1.readObject();
                        
                        if(r[i].name == null ? inputname == null : r[i].name.equals(inputname))
                        {
                            System.out.println(r[i].name+"\t"+r[i].id+"\t"+r[i].departmentname+"\t\t\t"+r[i].timename+"\t"+(r[i].count-1));
                            exist++;
                        }
                    }
                    if(exist==0)
                    {
                        System.out.println("There isn't any data with that name!");
                    }
                    exist=0;
                    fr.close();
                    or1.close();
                    break;
                case 6:
                    fr=new FileInputStream("Patientlist1.dat");
                    or1=new ObjectInputStream(fr);
                    
                    System.out.print("input Time you want to search: ");
                    inputtime=sc.next();
                    r=new patient[100];
                    System.out.println("Name\tID\tDepartment\t\t\tTime\tWaiting number");
                    for(int i=0;i<count;i++){
                        //System.out.println(count);
                        r[i]=(patient) or1.readObject();
                        
                        if(r[i].timename == null ? inputtime == null : r[i].timename.equals(inputtime))
                        {
                            System.out.println(r[i].name+"\t"+r[i].id+"\t"+r[i].departmentname+"\t\t\t"+r[i].timename+"\t"+(r[i].count-1));
                            exist++;
                        }
                    }
                    if(exist==0)
                    {
                        System.out.println("There isn't any data with that time!");
                    }
                    exist=0;
                    fr.close();
                    or1.close();
                    break;
                case 7:
                    fw.close();
                    ow.close();
                    fr=new FileInputStream("Patientlist1.dat");
                    or1=new ObjectInputStream(fr);
                    
                    System.out.print("input ID you want to delete: ");
                    inputid=sc.nextInt();
                    r=new patient[100];
                    c=new patient[100];
                    
                    for(int i=0;i<count;i++){
                        //System.out.println(count);
                        r[i]=(patient) or1.readObject();
                        if(r[i].id !=inputid)
                        {
                            c[exist]=r[i];
                            //System.out.println(c[exist].name);
                            exist++;
                        }
                    }
                    count--;
                    fr.close();
                    or1.close();
                    fw= new FileOutputStream ("Patientlist1.dat");
                    ow=new ObjectOutputStream(fw);
                    for(int i=0;i<count;i++){
                        //System.out.println(c[i].name);
                    ow.writeObject(c[i]);
                    }
                    fr=new FileInputStream("Patientlist1.dat");
                    or1=new ObjectInputStream(fr);
                    r2=new patient[100];
                    for(int i=0;i<count;i++){
                        r2[i]=(patient) or1.readObject();
                            System.out.println(r2[i].name+"\t"+r2[i].id+"\t"+r2[i].departmentname+"\t\t\t"+r2[i].timename+"\t"+(r2[i].count-1));
                            exist++;
                        
                    }
                    fr.close();
                    or1.close();
                    exist=0;
                    break;
            }
        System.out.print("\n\nJJ Clinic\n\nDo you want to? 1)Registration 2)sort by department 3)sort by time 4)search by department 5)search by name 6)search by time 7)delete -1)exit= ");
        choice=sc.nextInt();
        }
    }
}
