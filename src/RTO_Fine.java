//import Controller.RTO_Challan;

import java.util.*;
import java.sql.*;

public class RTO_Fine {
    double fine;
    Scanner sc = new Scanner(System.in);
    public void payfine(String number_plate) throws Exception {
        JDBC_Connection j = new JDBC_Connection();
        String sql = "select fines from registration where number_plate=?";
        PreparedStatement pst = j.Connection2().prepareStatement(sql);
        pst.setString(1, number_plate);
        ResultSet rs = pst.executeQuery();
        boolean find = false;
        while (rs.next()) {
            find = true;
            fine = rs.getDouble(1);
        }
        if (find == false) {
            System.out.println("invalid number plate");
        }
        if (fine > 0) {
            boolean exit = true;
            while (exit) {
                System.out.println("\n----------------Submit Fine-----------------");
                System.out.println("You want pay your fine ? \nEnter 1 for YES \nEnter 2 for NO ");
                System.out.println("\n----------------Submit Fine-----------------");
                String choice_fine = sc.nextLine();
                switch (choice_fine) {
                    case "1": {
                        System.out.println("Enter your debit card 3-digit CVV number");
                        String cvv = sc.nextLine();
                        sql="select * from card where cvv=?";
                        PreparedStatement pst1=j.Connection2().prepareStatement(sql);
                        pst1.setString(1,cvv);
                        ResultSet rs1=pst1.executeQuery();
                        boolean found=false;
                        while (rs1.next()){
                            found=true;
                        }
                        if (found) {


                            System.out.println("You successfully paid the  " + fine + " fine.");
                            RTO_Challan ch=new RTO_Challan();
                            ch.challanDetails(number_plate);

                            sql = "Update registration set fines=? where number_plate=?";
                            pst = j.Connection2().prepareStatement(sql);
                            pst.setDouble(1, 0);
                            pst.setString(2, number_plate);
                            pst.execute();

                            exit = false;
                        } else {
                            System.out.println("Inalid card detail");
                            System.out.println("Try again");
                        }
                    }
                        break;
                    case "2": {
                        exit = false;
                    }
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } else {
            System.out.println("You don't have any fines.");
        }

    }

    public void addfine(String number_plate) throws Exception {
        JDBC_Connection j = new JDBC_Connection();
        System.out.print("Enter fine to add : ");
        try {   
            fine = sc.nextDouble();
        } catch (Exception e) {
            System.out.println(e);
        }
        String sql = "update registration set fines=fines+? where number_plate=?";
        PreparedStatement pst = j.Connection2().prepareStatement(sql);
        pst.setDouble(1, fine);
        pst.setString(2, number_plate);
        int r = pst.executeUpdate();
        if (r>0) {
            System.out.println("successfully update fine");
        } else {
            System.out.println("invalid number plate");
        }

    }

    public void remove_fine(String number_plate) throws Exception {
        JDBC_Connection j = new JDBC_Connection();
        Statement st = j.Connection2().createStatement();
        String sql = "update registration set fines=0 where number_plate='"+number_plate+"'";

        int r = st.executeUpdate(sql);
        if (r > 0) {
            System.out.println("successfully remove fine");
        } else {
            System.out.println("invalid number plate");
        }

    }
}