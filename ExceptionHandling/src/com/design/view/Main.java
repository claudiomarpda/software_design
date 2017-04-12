package com.design.view;

import com.design.business.control.LoginException;
import com.design.business.control.PasswordException;
import com.design.business.control.UserControl;
import com.design.business.control.Validator;
import com.design.infra.InfraException;

/**
 * Makes some tests.
 */
public class Main {

    /**
     * Choose some specific test.
     * It won't work all at once due to the exceptions.
     */
    public static void main(String[] args) {
        String[] data1 = {"C++17", "Dangerous-17"}; // invalid login
        String[] data2 = {"Python", "Dynamic-3.6.2222"}; // invalid password
        String[] data3 = {"Java", "GeneralOO"}; // invalid password
        String[] data4 = {"C#", "V2isua6l"};
        String[] data5 = {"Ruby", "high"}; // invalid password
        String[] data6 = {"Assembly", "lowest50s"};

        try {
            UserControl uc = new UserControl(new Validator());

            // Use one at a time
//            System.out.println(uc.add(data1));
//            System.out.println(uc.add(data2));
//            System.out.println(uc.add(data3));
            System.out.println(uc.add(data4));
//            System.out.println(uc.add(data4));
//            System.out.println(uc.add(data5));
            System.out.println(uc.add(data6));

            System.out.println("Getting user " + data4[0] + "...");
            System.out.println(uc.get(data4[0]));
            System.out.println();

            System.out.println("Listing all...");
            uc.listAll().forEach(System.out::println);
            System.out.println();

            System.out.println(uc.remove(data4[0]));
            System.out.println(uc.remove(data4[0]));

        } catch (InfraException | LoginException | PasswordException e) {
            System.out.println(e.getMessage());
        }

    }
}
