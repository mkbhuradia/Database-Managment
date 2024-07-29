package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import com.model.Employee;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.model.*;

public class DaoImplement {
	static Employee mainData=new Employee();
	static EmployeeRelatedName rName=new EmployeeRelatedName();
	static EmployeeAddress address=new EmployeeAddress();
	static EmployeeContact contact= new EmployeeContact();
	public String querySuccessFail(PreparedStatement pstm) throws SQLException {
		  if(pstm.executeUpdate()>0)
		    	return ("Query successfull ");
		    else
		    	return " Query fail ";
		  
	}
	public  void show(Connection con,String showDatabases) {
		
		try {
		PreparedStatement pstm=con.prepareStatement(showDatabases);
		 ResultSet rs=pstm.executeQuery();
		 while(rs.next()) {
			 System.out.println(rs.getString(1));
		 }
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
   public String[] returnTableColumn(Connection con,String showDatabases) {
	   String[] arr=null;
		try {
			PreparedStatement pst=con.prepareStatement(showDatabases);
			ResultSet rs=pst.executeQuery();
		    ResultSetMetaData rsmd=rs.getMetaData();
		    arr=new String[rsmd.getColumnCount()];
		    for(int i=0;i<arr.length;i++) {
		    	arr[i]=rsmd.getTableName(i);
		    }
		   
		  return arr;
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return arr;
	}

public  void updateQuery(Connection con,String createDatabase) {	
			try {
			PreparedStatement pstm=con.prepareStatement(createDatabase);
			 querySuccessFail (pstm);
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}
public  void createTableWithData(Connection con,String createtable,String[] columnAndDatatype) {
	        String tableName=createtable.substring(0, createtable.length());
	        System.out.println(tableName);
	        
		try {
			PreparedStatement pstm;
			Scanner sc=new Scanner(System.in);
			
           	       if(columnAndDatatype.length==1) {
           	    	String insertData="insert into "+tableName+" ("+columnAndDatatype[0]+","+")) value(?)"; 
           	    	pstm=con.prepareStatement(insertData);
           	    	pstm.executeUpdate();
           	        System.out.print("pls Enter"+columnAndDatatype[0]+" value: ");           	        
				    String EmpName=sc.nextLine();
				    querySuccessFail(pstm);
           	       }
           	    if(columnAndDatatype.length==2) { 
           	    	String insertData="insert into "+tableName+" ("+columnAndDatatype[0]+","+columnAndDatatype[1]+")) value(?,?)";
           	    	pstm=con.prepareStatement(insertData);
           	    	pstm.executeUpdate();
           	    	System.out.print("pls Enter"+columnAndDatatype[0]);
				    String EmpFisrtName=sc.nextLine();
				    System.out.print("pls Enter"+columnAndDatatype[1]);
				    String EmpMiddleName=sc.nextLine();
				    querySuccessFail(pstm);
           	    }
           	 if(columnAndDatatype.length==3) { 
        	    	String insertData="insert into "+tableName+" ("+columnAndDatatype[0]+","+columnAndDatatype[1]+","+columnAndDatatype[2]+") value(?,?,?)"; 
        	    	System.out.println(insertData);
        	    	pstm=con.prepareStatement(insertData);
        	    	
           	        System.out.print("pls Enter "+columnAndDatatype[0]+" : ");
				    String EmpFisrtName=sc.nextLine();
				    rName.setEmpFisrtName(EmpFisrtName);
				    System.out.print("pls Enter "+columnAndDatatype[1]+" : ");
				    String EmpMiddleName=sc.nextLine();
				    rName.setEmpMiddleName(EmpMiddleName);
				    System.out.print("pls Enter "+columnAndDatatype[2]+" : ");
				    String EmpLastName=sc.nextLine();
				    rName.setEmpLastName(EmpLastName);
				    for(int i=0;i<columnAndDatatype.length;i++) {
					   if(i==0) { 
						   pstm.setString(i+1, rName.getEmpFisrtName());
		           	    }
		           	 if(i==1) { 
		           		pstm.setString(i+1, rName.getEmpMiddleName());  
		           	 }     
		           	 if(i==2) { 
		           		pstm.setString(i+1, rName.getEmpLastName()); 
		           	 }
				   }
				    querySuccessFail(pstm);
           	 }     
           	 if(columnAndDatatype.length==4) { 
     	    	String insertData="insert into "+tableName+" ("+columnAndDatatype[0]+","+columnAndDatatype[1]+","+columnAndDatatype[2]+","+columnAndDatatype[3]+")) value(?,?,?,?)"; 
     	    	pstm=con.prepareStatement(insertData);
     	    	pstm.executeUpdate();
       	        System.out.println("pls Enter"+columnAndDatatype[3]);
			    String EmpName=sc.nextLine();
				rName.setEmpFisrtName(EmpName);
				querySuccessFail(pstm);
           	 }   
              
		   }	 
			
		catch(Exception e) {
			System.out.println("Pls Enter Valid Query");
		}	
	}
public  void insertDataInATable(Connection con,String insertData) {
	
	try {
		Scanner sc=new Scanner(System.in);
	PreparedStatement pstm=con.prepareStatement( insertData);
	pstm.executeUpdate();
	
	 String[] check= new String[]{mainData.getSsoId(),rName.getEmpFisrtName(),rName.getEmpMiddleName(),rName.getEmpLastName(),rName.getEmpFName(),rName.getEmpMothertName(),rName.getEmpSpouseName()};
	 System.out.println("pls Enter Column Name");
	 String columnName=sc.nextLine();
	 for(int i=0;i<check.length;i++){
	 if(check[i].equals(columnName)){
	 pstm.setString(1, mainData.getSsoId());
	 } } 
	 querySuccessFail(pstm);
	}
	catch(Exception e) {
		System.out.println("Pls Enter Valid Query");
	}	
}
public void updateTableData(Connection con,String updateTable,String updateColumn) throws SQLException {	 
	try {	
		Scanner sc=new Scanner(System.in);
		PreparedStatement pstm=con.prepareStatement(updateTable);
		System.out.println("pls Enter SsoId");
		 String ssoId=sc.nextLine();
		 System.out.println("pls Enter Employee name");
		 String EmpName=sc.nextLine();
		 System.out.println("pls Enter Employee Father name");
		 String EmpFName=sc.nextLine();
		pstm.setString(1, ssoId);
		pstm.setString(2, EmpName);
		pstm.setString(2, EmpFName);
		pstm.execute();
		querySuccessFail (pstm);
		con.close();
}
	catch(Exception e) {
		e.printStackTrace();
	}
}


}

