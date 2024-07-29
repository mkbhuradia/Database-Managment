package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class ConnectionClass {
	 static String tableName;
	 static String createTabl;
	 static String column;
	 static String column1;
     static String column2;
     static String column3;
     static String column4;
     static String column5;
     static String column6;
     static String column7;
     static String dataType1;
	 static String dataType2;
     static String dataType3;
     static String dataType4;
     static String dataType5;
     static String dataType6;
     static String dataType7;
     static String dataType8;
     static String insertData;
     static String[] columnAndDatatype;
     static String[] columnAndDatatype1;
     static Scanner sc =new Scanner(System.in);

public static String userName () {
		
        System.out.println("Enter UserName "); 
        return sc.nextLine();
        
}	
public static String userPassword () {
	
    System.out.println("Enter User Password "); 
    return sc.nextLine();
   
	
}
public static String enterTable() {
	System.out.print("Enter Table Name: ");   
    return sc.nextLine();
}
 public static void getConnection() {
	DaoImplement daoIm=new DaoImplement();
	
	try {	
		System.out.println("Wel-Com My DataBase(Home Page)");
		String url="jdbc:mysql://localhost:3306/";
	    Connection con=DriverManager.getConnection(url,userName(),userPassword());
		first:
		do {
		Scanner sc =new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Show databse Enter-1 \nCreate Database Enter-2 \nDelete Database Enter-3 \nUse Database Enter-4 \nExit Enter-5 ");
		int num=sc.nextInt();
		switch(num) {
		case 1: 
		        String showDatabase="show databases";
		        daoIm.show(con,showDatabase);
		        break;
		        
		case 2: 
                System.out.println("Enter Database Name for create ");
                sc.nextLine();
		        String databaseName1=sc.nextLine();
			    String createDatabase1="create database "+ databaseName1;
                daoIm.updateQuery(con,createDatabase1);
                break;
		case 3: 
                System.out.println("Enter Database Name for Delete ");
                sc.nextLine();
		        String databaseName2=sc.nextLine();		        
			    String deleteDatabase="drop database "+ databaseName2;
                daoIm.updateQuery(con,deleteDatabase);
                break;
		case 4:
			    System.out.println("Enter Database Name for Use "); 
			    sc.nextLine();
		        String databaseName=sc.nextLine();
		        String url1="jdbc:mysql://localhost:3306/"+databaseName;
		        Connection con1=DriverManager.getConnection(url1,"root","mysql@1984");
		        second:
		        do {
		        System.out.println("Change/Use Database Enter-1 \nShow tables Enter-2 \nCreate Table Without Data Enter-3 \nCreate Table With Data Enter-4\nInsert Data In Table Enter-5\nInternal Data Delete In Table Enter-6\nUpdate Table Enter-7\nshow Table Coloum Enter-8\nshow Table Data Enter-9\nDelete Table Enter-10\nBack To Main Progamme Enter-11 ");
				int num1=sc.nextInt();
				switch(num1) {
				case 1:break second;	               
				case 2:String showTables="Show Tables ";
                       daoIm.show(con1,showTables);
                       break; 
				case 3:String tableName=enterTable();
		               System.out.print("Enter Column : ");
		               int columnNum=sc.nextInt();
		               columnAndDatatype=new String[columnNum];
		               String[] DataType=new String[columnNum];
		               sc.nextLine();
		               for(int i=0;i<columnAndDatatype.length;i++) {
		               System.out.print("Enter Column Name : ");
		               String columnName=sc.nextLine();
		               columnAndDatatype[i]=columnName;
		               System.out.print("Enter Datatype : ");
		               String dataType=sc.nextLine();
		               DataType[i]=dataType;
	            	   }
		               for(int i=0;i<columnAndDatatype.length;i++) {
		            	   if(columnAndDatatype.length==1) {
			            	   String insertData1="create table "+tableName+" ("+columnAndDatatype[0]+" "+DataType[0]+" )";
					           daoIm.updateQuery(con1,insertData1);
		            		   break;
			               }
		            		   if(columnAndDatatype.length==2) {
				                   String insertData2="create table "+tableName+" ("+columnAndDatatype[0]+" "+DataType[0]+","+columnAndDatatype[1]+" "+DataType[1]+" )"; 
				            	   System.out.print(insertData);
						           daoIm.updateQuery(con1,insertData2);
						           break;}
		            		   else if(columnAndDatatype.length==3) {
	                               String insertData="create table "+tableName+" ("+columnAndDatatype[0]+" "+DataType[0]+","+columnAndDatatype[1]+" "+DataType[1]+","+columnAndDatatype[2]+" "+DataType[2]+" )";  
	                               System.out.print(insertData);
						           daoIm.updateQuery(con1,insertData);
						           break;}
		            		   else if(columnAndDatatype.length==4) {
				            	   String insertData="create table "+tableName+" ("+columnAndDatatype[0]+" "+DataType[0]+","+columnAndDatatype[1]+" "+DataType[1]+","+columnAndDatatype[2]+" "+DataType[2]+","+columnAndDatatype[3]+" "+DataType[3]+" )";                   
						           daoIm.updateQuery(con1,insertData);
						           break;}
		            		   else if(columnAndDatatype.length==5) {	   
				            	   String insertData="create table "+tableName+" ("+columnAndDatatype[0]+","+DataType[0]+","+columnAndDatatype[1]+","+DataType[1]+","+columnAndDatatype[2]+","+DataType[2]+","+columnAndDatatype[3]+","+DataType[3]+","+columnAndDatatype[4]+","+DataType[4]+" )";                   
						           daoIm.updateQuery(con1,insertData);
						           break;
			                   }
		               }
		               
				case 4:
	               String tableName1=enterTable();
	               System.out.print("Enter Column : "); 
	               int columnNum1=sc.nextInt();
	               columnAndDatatype1=new String[columnNum1];
	               String[] DataType1=new String[columnNum1];
	               sc.nextLine();
	               for(int i=0;i<columnAndDatatype1.length;i++) {
	               System.out.print("Enter Column Name : ");
	               String columnName=sc.nextLine();
	               columnAndDatatype1[i]=columnName;
	               System.out.print("Enter Datatype : ");
	               String dataType=sc.nextLine();
	               DataType1[i]=dataType;
	               }
	               for(int i=0;i<columnAndDatatype1.length;i++) {
	            	   if(columnAndDatatype1.length==1) {
	            		   column1=columnAndDatatype1[0];
	            		   dataType1=DataType1[0];
		            	   String insertData="create table "+tableName1+" ("+columnAndDatatype1[0]+" "+DataType1[0]+" ) value(?))";
				           daoIm.createTableWithData(con1,insertData,columnAndDatatype);
	            		   break;
	            	   }
		               else if(columnAndDatatype1.length==2) {
		            	   String insertData="create table "+tableName1+" ("+columnAndDatatype1[0]+" "+DataType1[0]+","+columnAndDatatype1[1]+" "+DataType1[1]+" ) values(?,?))";                   
				           daoIm.createTableWithData(con1,insertData,columnAndDatatype);
				           break;}
		               else if(columnAndDatatype1.length==3) {
	                       String insertData="create table "+tableName1+" ("+columnAndDatatype1[0]+" "+DataType1[0]+","+columnAndDatatype1[0]+" "+DataType1[1]+","+columnAndDatatype1[2]+" "+DataType1[2]+" ) values(?,?,?))";                   
				           daoIm.createTableWithData(con1,insertData,columnAndDatatype);
				           break;}
		               else if(columnAndDatatype1.length==4) {
		            	   String insertData="create table "+tableName1+" ("+columnAndDatatype1[0]+" "+DataType1[0]+","+columnAndDatatype1[1]+" "+DataType1[1]+","+columnAndDatatype1[2]+" "+DataType1[2]+","+columnAndDatatype1[3]+" "+DataType1[3]+") values(?,?,?,?))";                   
				           daoIm.createTableWithData(con1,insertData,columnAndDatatype);
				           break;}
		               else if(columnAndDatatype1.length==5) {	 
		            	   String insertData="create table "+tableName1+" ("+columnAndDatatype1[0]+","+DataType1[0]+","+columnAndDatatype1[1]+","+DataType1[1]+","+columnAndDatatype1[2]+","+DataType1[2]+","+columnAndDatatype1[3]+","+DataType1[3]+","+columnAndDatatype1[4]+""+DataType1[4]+" ) values(?,?,?,?,?))";                   
				           daoIm.createTableWithData(con1,insertData,columnAndDatatype);
				           break;  
	               }
	               }
	              
		        case 5:
	                   String tableName3=enterTable();
	                   String showData="select * from "+tableName3;                  
                       String[] columnAndDatatype=daoIm.returnTableColumn(con1,showData);   
	                   daoIm.createTableWithData(con1,tableName3,columnAndDatatype);
		               break;         
		        case 6:String tableName4=enterTable();
                       third:
           		        do {
                       System.out.println("If Delete All Record Enter-1\nIf Delete With Any Condition Enter-2\nBack "); 
	                   int Num4=sc.nextInt();
                       switch(Num4){
                       case 1: System.out.println("Enter Column Name : ");
		        	           String updateData="delete from "+sc.nextLine();
		                       daoIm.updateQuery(con1,updateData);
		                       break;  
                       case 2:System.out.println("Enter Condition : ");
                              String deleteData="delete from "+tableName4+" where "+sc.nextLine();
                              daoIm.updateQuery(con1,deleteData);
                              break;
                       case 3:System.out.println("Back ");
		                      break third;
                       default:System.out.println("Pls Enter Valid Number ");
		                      }
                       
           		        }while(true);
                       break;
		        case 7:String tableName5=enterTable();
                      fourth:
                      do {
                    	  System.out.println("If Update One Column Without Condition In Table Enter-1\nIf Update More Column With Condition In Table Enter-2\nBack Enter-3\nBack To Home Enter-4  ");
                    	  int num2=sc.nextInt();
                    	  switch(num2) {
                    	  case 1 : System.out.println("Enter Column Name : ");
                                   String columnNum5=sc.nextLine();
                                   System.out.println("Enter Value ");
                                   String columnValue=sc.nextLine();
                                   String updateData="update "+tableName5+" set"+columnNum5+"="+columnValue;
                                   break;
                    	  case 2 :break;
                    	  case 3:System.out.println("Back");
                    	         break fourth;
                    	  case 4:System.out.println("Back To Home ");
   		                         break second; 
   		                  default:System.out.println("Pls Enter Valid Number "); 		       
                    	  }
                    	  } while(true);
	                  break;
		        case 8: 
		                String tableName6=enterTable();
                       String showData1="desc "+tableName6;                  
                       daoIm.show(con1,showData1);
                       break;
		        case 9:String tableName7=enterTable();
                       String showData2="select * from "+tableName7;                  
                       daoIm.show(con1,showData2);
                       break;              
		        case 10:String tableName8=enterTable();
		        	   String deleteTable="drop table "+tableName8;
		        	   daoIm.updateQuery(con1,deleteTable);
                       break;
		        case 11:System.out.println("Back To Home");
		               break second; 
		       
		        default:System.out.println("Pls Enter Valid Number ");
				}
		        }while(true);
                
                break;
		case 5: System.out.println("Exit Programme ");
		        break first; 
		       
		default:System.out.println("Pls Enter Valid Number ");
		}
		}while(true);
	}
	catch(Exception e) {
		e.printStackTrace();
	}

 }
}
