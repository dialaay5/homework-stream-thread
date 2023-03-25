package com.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customersList = new ArrayList<>();
        customersList.add(new Customer("1101", "suzi", "Jerusalem", 2, Customer.Gender.FEMALE));
        customersList.add(new Customer("1102", "tal", "Tel Aviv-Yafo", 5, Customer.Gender.MALE));
        customersList.add(new Customer("1103", "nava", "Holon", 7, Customer.Gender.FEMALE));
        customersList.add(new Customer("1104", "noya", "Petah Tikva", 8, Customer.Gender.FEMALE));
        customersList.add(new Customer("1105", "galit", "Netanya", 1, Customer.Gender.FEMALE));
        customersList.add(new Customer("1106", "hila", "Haifa", 3, Customer.Gender.FEMALE));
        customersList.add(new Customer("1107", "aya", "Bat Yam", 9, Customer.Gender.FEMALE));
        customersList.add(new Customer("1108", "dafna", "Ashkelon", 10, Customer.Gender.FEMALE));
        customersList.add( new Customer("1109", "dan", "Hadera", 6, Customer.Gender.MALE));
        customersList.add(new Customer("1110", "alon", "Ashkelon", 12, Customer.Gender.MALE));
        customersList.add(new Customer("1111", "amir", "Haifa", 4, Customer.Gender.MALE));
        customersList.add(new Customer("1112", "rami", "Haifa", 2, Customer.Gender.MALE));

        System.out.println("female customers:");
        List<Customer> femaleList = customersList.stream()
                .filter(g -> g.getGender().equals( Customer.Gender.FEMALE))
                .collect(Collectors.toList());
        femaleList.forEach(System.out::println);

        System.out.println("\nmale customers:");
        List<Customer> maleList = customersList.stream()
                .filter(g -> g.getGender().equals( Customer.Gender.MALE))
                .collect(Collectors.toList());
        maleList.forEach(System.out::println);

        System.out.println("\nnumbers of male customers:");
        System.out.println(maleList.stream().count());

        System.out.println("\nlist of cities:");
        List<String> citiesList = customersList.stream()
                .map(Customer::getCity)
                .distinct()
                .collect(Collectors.toList());
        citiesList.forEach(System.out::println);

        System.out.println("\nlist of 10 customers:");
        List<Customer> PurchasesList= customersList.stream()
                .limit(10)
                .collect(Collectors.toList());
        PurchasesList.forEach(System.out::println);
        System.out.println("max number of purchases: " + PurchasesList.stream().max(Comparator.comparing(Customer::getNumber_of_purchases)));
        System.out.println("min number of purchases: " + PurchasesList.stream().min(Comparator.comparing(Customer::getNumber_of_purchases)));
        System.out.println("\nthe customer with the max number of purchases in Ashkelon:");
        PurchasesList.stream().filter(f -> f.getCity().equals("Ashkelon")).collect(Collectors.toList());
        System.out.println(PurchasesList.stream().max(Comparator.comparing(Customer::getNumber_of_purchases)));

        System.out.println("\nhashmap between id,object:");
        Map<String,List<Customer>> customersMap = customersList.stream().collect(Collectors.groupingBy(Customer::getId));
        System.out.println(customersMap);

        System.out.println("\nparallelStream: ");
        System.out.println("היכולת לעשות פעולות במקביל, כלומר להריץ הרבה תרידים במקביל וכל אחד עושה את הפעולה שלו ומאגד בחזרה את כל התשובות ביחד לטובת השאילתה");

        System.out.println("\nA stream should be operated only once.");
        System.out.println("\nNo, because In lazy processing, the operations are performed after the action. It is processing the data only on demand.");































    }
}
