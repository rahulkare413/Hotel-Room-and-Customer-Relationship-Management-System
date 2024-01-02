package Util;

import Operation.*;

import java.util.Scanner;

public class MainApp {
    private static Scanner sc = new Scanner(System.in);

    public static void operation(){
        boolean status = true;
        while (status){
            System.out.println("1.INSERT DATA ");
            System.out.println("2.UPDATE DATA ");
            System.out.println("3.DELETE DATA ");
            System.out.println("4.DISPLAY DATA BY USING HQL ");
            System.out.println("5.DISPLAY DATA BY USING HCQL ");
            System.out.println("6.EXIT ");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    InsertData data = new InsertData();
                    data.addHotelData();
                    break;
                case 2:
                    UpdateData updateData = new UpdateData();
                    updateData.updateData();
                    break;
                case 3:
                    DeleteData deleteData = new DeleteData();
                    deleteData.deleteData();
                    break;
                case 4:
                    DisplayData data1 = new DisplayData();
                    data1.displayDataByHql();
                    break;
                case 5:
                    DisplayDataByHcql byHcql = new DisplayDataByHcql();
                    byHcql.displayDataByRestrictions();
                    break;
                case 6:
                    status = false;
                    System.out.println("VISIT AGAIN ");
                    break;

            }
        }

    }
    public static void main(String[] args) {
        operation();

    }
}
