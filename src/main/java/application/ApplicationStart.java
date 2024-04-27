package application;

import application.singleton.Singleton;

public class ApplicationStart {
    public static void main(String[] args) {
        System.out.println("Application Started!!!");

//        singleThreadedSingleton();

        multiThreadedSingleton();
    }

    public static void singleThreadedSingleton() {
        Singleton o1 = Singleton.getInstance();
        o1.printMessage("This is the first message!!");

        Singleton o2 = Singleton.getInstance();
        o2.printMessage("This is the second message!!");
    }

    public static void multiThreadedSingleton() {
        Thread thread1 = new Thread(ApplicationStart::printStudentDetails);
        Thread thread2 = new Thread(ApplicationStart::printEmployeeDetails);
        Thread thread3 = new Thread(ApplicationStart::printStudentDetails);
        Thread thread4 = new Thread(ApplicationStart::printEmployeeDetails);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public static void printStudentDetails() {
        Singleton o1 = Singleton.getInstance();
        o1.printMessage("Student Message: This is the message!!");
    }

    public static void printEmployeeDetails() {
        Singleton o1 = Singleton.getInstance();
        o1.printMessage("Employee Message: This is the message!!");
    }
}
