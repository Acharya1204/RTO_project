import Validator.DateValidator;
import Validator.Md5Hash;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RTO_admin {
    Scanner sc = new Scanner(System.in);
    String name;
    String password;

    public void  register() throws Exception{
        JDBC_Connection j = new JDBC_Connection();
        Statement st = j.Connection2().createStatement();
        System.out.print("Enter name of Administrator : ");
        String name=sc.nextLine();
        //System.out.print("Enter password of Administrator : ");
        //String pass=sc.nextLine();
        DateValidator.password_verify pv = new DateValidator.password_verify();
        password=pv.login();
        String sql = "Select count(*) from admin";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
           name+=rs.getString(1);
        }
        sql = "insert into admin values(?,?)";
        PreparedStatement prp = j.Connection2().prepareStatement(sql);
        prp.setString(1, name);
        String tmp= Md5Hash.getMD5Hash(password);
        prp.setString(2,tmp);
        int r = prp.executeUpdate();
        if (r >= 1) {
            System.out.println("You have successfully registered with registration no: "+name);
            //return true;
        } else {
            System.out.println("Sorry registered unsuccessfully");
            //return false;
        }

    }


    public boolean login() throws Exception {
        JDBC_Connection j = new JDBC_Connection();
        Statement st = j.Connection2().createStatement();
        System.out.print("Enter registration id of Administrator : ");
        String name = sc.nextLine();
        System.out.print("Enter password of Administrator : ");
        String pass = sc.nextLine();
        String tmp=Md5Hash.getMD5Hash(pass);
        String sql = "select * from admin where name=? and password=?";
        PreparedStatement pst = j.Connection2().prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, tmp);
        ResultSet rs = pst.executeQuery();


        boolean found = false; // Flag to check if data is found

        while (rs.next()) {
            found = true; // Data found

        }
        if(found)
            System.out.println("Admin is successfully login");
        else
            System.out.println("Admin is not successfully login");
        return found;

    }


    }
