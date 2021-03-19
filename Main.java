package programmingLanguages;


public class Main {
    public static void main(String[] args) {
        ScannerPrinter sp = new ScannerPrinterImpl(0, 0);
        sp.changeLamp(30000);
        sp.replenishToner(10000);
        sp.scan(15);
        sp.print(30);
        sp.scanPrint(10);
        Scanner s = sp;
        s.changeLamp(30000);
        s.scan(25);
        Printer p = sp;
        p.replenishToner(10000);
        p.print(20);
    }
}

