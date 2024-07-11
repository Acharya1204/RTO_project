import java.util.*;

public class RTO {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //String permanent_password = "12345678";
        System.out.println("----Welcome to RTO app----");
        String main_choice;
        while (true) {
            System.out.println("\n----------------Main Menu-----------------");
            System.out.print("1)Login as Administrator \n2)login as user \n3)For exit");
            System.out.println("\n----------------Main Menu-----------------");
            System.out.print("Enter your choice : ");
            main_choice = sc.nextLine();
            switch (main_choice) {
                case "1": {
//                    System.out.print("You registered as Administrator. \nPlease enter password : ");
//                    while (true) {
//                        String enter_password = sc.nextLine();
//                        if (permanent_password.equals(enter_password)) {
//                            System.out.println("registered successfully");
//                            break;
//
//                        } else {
//                            System.out.println("Wrong password! Enter again.");
//                        }
//                    }

                    boolean exit = false;
                    boolean admin_entry=true;
                    while (admin_entry==true) {
                        System.out.println("\n----------------Admin Menu-----------------");
                        System.out.print("1)Login  \n2)Register \n3)Back to main menu");
                        System.out.println("\n----------------Admin Menu-----------------");
                        System.out.print("Enter your choice : ");
                        int ch = sc.nextInt();
                        switch (ch) {
                            case 1: {
                                RTO_admin ad = new RTO_admin();
                                if(ad.login())

                                {exit = true;admin_entry=false;}
                                break;
                            }
                            case 2: {
                                RTO_admin ad = new RTO_admin();
                                ad.register();
                                break;
                            }
                            case 3: {
                                admin_entry=false;
                                break;
                            }


                        }

                    }

                    sc.nextLine();
                    while (exit == true) {
                        System.out.println("\n----------------Admin Working Menu-----------------");
                        System.out.print(
                                "1)Registration of new car \n2)Approve User Application \n3)Update car detail \n4)Search car \n5)Add fine \n6)Remove fine \n7)Back to main menu ");
                        System.out.println("\n----------------Admin Working Menu-----------------");
                        System.out.print("Enter your choice:");
                        String
                                sub_Menu_choice = sc.nextLine();
                        switch (sub_Menu_choice) {
                            case "1": {
                                RTO_Registration r = new RTO_Registration();
                                r.Registration();
                            }
                                break;

                            case "2": {
                                RTO_Registration r = new RTO_Registration();
                                r.approve();
                            }
                            break;

                            case "3": {

                                System.out.print("Enter number plate to update detail : ");
                                String update_number_plate = sc.nextLine();
                                RTO_Update_detail u = new RTO_Update_detail();
                                u.update(update_number_plate);
                            }
                                break;
                            case "4": {
                                RTO_Search_vehicle s = new RTO_Search_vehicle();
                                s.search();
                            }
                                break;
                            case "5": {
                                System.out.print("Enter the number plate to add fine : ");
                                String number_plate = sc.nextLine();
                                RTO_Fine f = new RTO_Fine();
                                f.addfine(number_plate);
                            }
                                break;
                            case "6": {
                                System.out.println("Enter the number plate to remove the fine : ");
                                String number_plate = sc.nextLine();
                                RTO_Fine f = new RTO_Fine();
                                f.remove_fine(number_plate);
                            }
                                break;
                            case "7": {
                                exit = false;
                            }
                                break;
                            default: {
                                System.out.println("Invalid input please enter a valid input");
                            }
                                break;
                        }
                    }
                }
                    break;
                case "2": {
                    System.out.println("Welcome user");

                    RTO_Login l = new RTO_Login();
                    l.Login();
                }
                    break;
                case "3": {
                    System.out.println("Thank you :)");
                    sc.close();
                    System.exit(0);
                }
                    break;
                default: {
                    System.out.println("Invalid choice");
                }
                    break;
            }
        }

    }

}