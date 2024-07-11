import Validator.Md5Hash;

import java.sql.*;
import java.util.*;

public class RTO_Login {
    Scanner sc = new Scanner(System.in);

    public void Login() throws Exception {
        JDBC_Connection j = new JDBC_Connection();
        String sql;
        /* ----------------------------------------------------------- */
        System.out.println("\n----------------User Menu-----------------");
        System.out.print(
                "1)Login User \n2)Fill Application Form \n3)Back to main menu \n");
        System.out.println("\n----------------User Menu-----------------");
        System.out.print("Enter your choice:");
        int ch=sc.nextInt();
        switch(ch){
            case 1: {

                sc.nextLine();
                System.out.print("Enter your number plate : ");
                String number_plate = sc.nextLine();
                System.out.println("Enter password");
                String password = sc.nextLine();
                sql = "select * from registration where number_plate=? and password=?";
                PreparedStatement pst = j.Connection2().prepareStatement(sql);
                pst.setString(1, number_plate);
                String tmp= Md5Hash.getMD5Hash(password);
                pst.setString(2, tmp);
                ResultSet rs = pst.executeQuery();

                boolean found = false; // Flag to check if data is found

                while (rs.next()) {
                    found = true; // Data found
                    System.out.println("\n----------------User Details-----------------");
                    System.out.println("Owner Name :-" + rs.getString("owner_name"));
                    System.out.println("Vehicle information");
                    System.out.println("Vehicle name :-" + rs.getString("vehicle_name"));
                    System.out.println("Vehicle Type :-" + rs.getString("vehicle_type"));
                    System.out.println("Vehicle color :-" + rs.getString("vehicle_color"));
                    System.out.println("Vehicle insurance end date :-" + rs.getString("insurance"));
                    System.out.println("Vehicle PUC end date :-" + rs.getString("puc"));
                    System.out.println("Owner contact number :-" + rs.getString("owner_phone_no"));
                    System.out.println("Vehicle owner have to pay fine :-" + rs.getDouble("fines"));
                    System.out.println("\n----------------User Details-----------------");
                }

                if (!found) {
                    System.out.println("Data not found");
                } else {
                    boolean exit = true;
                    while (exit) {
                        System.out.println("\n----------------User Working Menu-----------------");
                        System.out.println(
                                "1)Update your detail \n2)Pay fine \n3)Back to main menu ");
                        System.out.println("\n----------------User Working Menu-----------------");
                        System.out.println("\nEnter your choice:");
                        String choice3 = sc.nextLine();

                        switch (choice3) {
                            case "1":
                                RTO_Update_detail d = new RTO_Update_detail();
                                d.update(number_plate);
                                break;

                            case "2": {
                                RTO_Fine f = new RTO_Fine();
                                f.payfine(number_plate);
                            }
                            break;
                            case "3": {
                                exit = false;
                            }
                            break;
                            default: {
                                System.out.println("Invalid Input");
                            }
                        }
                    }
                }
                break;
            }

            case 2:
            {
                ApplicationForm af=new ApplicationForm();
                af.apply();
                break;
            }
            case 3:
                break;


        }

    }
}