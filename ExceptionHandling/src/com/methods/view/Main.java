package com.methods.view;

import com.methods.business.control.UserControl;
import com.methods.infra.InfraException;

/**
 * Makes some tests.
 */
public class Main {

    public static void main(String[] args) {
        String[] data1 = {"C++17", "Dangerous-17"}; // not acceptable
        String[] data2 = {"Python", "Dynamic-3.6.2222"}; // not acceptable
        String[] data3 = {"Java", "GeneralOO"}; // not acceptable
        String[] data4 = {"C#", "V2isua6l"};
        String[] data5 = {"Ruby", "high"}; // not acceptable
        String[] data6 = {"Assembly", "lowest50s"}; // not acceptable

        try {
            UserControl uc = new UserControl();
            System.out.println(uc.add(data1));
            System.out.println(uc.add(data2));
            System.out.println(uc.add(data3));
            System.out.println(uc.add(data4));
            System.out.println(uc.add(data4));
            System.out.println(uc.add(data5));
            System.out.println(uc.add(data6));

            System.out.println("Getting user " + data4[0] + "...");
            System.out.println(uc.get(data4[0]));

            System.out.println("Listing all...");
            uc.listAll().forEach(System.out::println);

            System.out.println(uc.remove(data4[0]));
            System.out.println(uc.remove(data4[0]));

        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }

    }
}
