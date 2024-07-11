//package Controller;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RTO_Challan {
    double fine;
    String vehicle_number ;
    String owner_name;
    public  String challanId() {
        int letter1 = 65 + (int) (Math.random() * (90 - 65));
        int letter2 = 65 + (int) (Math.random() * (90 - 65));
        int letter3 = 65 + (int) (Math.random() * (90 - 65));
        int letter4 = 65 + (int) (Math.random() * (90 - 65));
        int letter5 = 65 + (int) (Math.random() * (90 - 65));
        int no1 = (int) (Math.random() * 1000);
        int no2 = (int) (Math.random() * 100000);
        int no3 = (int) (Math.random() * 10);
        int no4 = (int) (Math.random() * 10);
        String challan_id = "" + ((char) (letter1)) + "" + ((char) (letter2)) + ((char) (letter3)) + "" + ((char) (letter4)) + "" + ((char) (letter5)) + "" + no1 + no2 + no3 + no4;
        return challan_id;
    }
    public  void challanDetails(String number_plate) throws Exception{

        JDBC_Connection j = new JDBC_Connection();
        String sql = "select * from registration where number_plate=?";
        PreparedStatement pst = j.Connection2().prepareStatement(sql);
        pst.setString(1, number_plate);
        ResultSet rs = pst.executeQuery();
        boolean find = false;
        while (rs.next()) {

            find = true;

            vehicle_number = rs.getString("number_plate");
            owner_name = rs.getString("owner_name");
            fine = rs.getDouble("fines");
        }
        String CI = challanId();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String violation_date = currentDate.format(formatter);

        String fineAmount = Double.toString(fine);
        String payment_status = "complete";

        System.out.println("Challan Details:");
        System.out.println("----------------------------");
        System.out.printf("%-20s : %-20s\n", "Challan Id", CI);
        System.out.printf("%-20s : %-20s\n", "Vehicle Number", vehicle_number);
        System.out.printf("%-20s : %-20s\n", "Driver Name", owner_name);
        System.out.printf("%-20s : %-20s\n", "Violation Date", violation_date);
        System.out.printf("%-20s : %-20s\n", "Fine Amount", fineAmount);
        System.out.printf("%-20s : %-20s\n", "Payment Status", payment_status);
        System.out.println("----------------------------");

    }



}