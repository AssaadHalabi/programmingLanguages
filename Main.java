package programmingLanguages;
// TODO: Implement your classes here

/**
 * Scanner
 */
interface Scanner {
    boolean scan(int numPages);
    void changeLamp(int l);
}

/**
 * ScannerImpl
 */
class ScannerImpl implements Scanner{
    int lampLife;
    public ScannerImpl(int l) {
        this.lampLife = l;
    }

    @Override
    public boolean scan(int numPages) {
        if(numPages > this.lampLife) {
            System.out.println("Please change the lamp\n");
            return false;
        } else {
            System.out.println("Scanning successful\n");
            this.lampLife -= numPages;
            return true;
        }
    }

    @Override
    public void changeLamp(int l) {
        this.lampLife = l;
        
    }

    
}


/**
 * Printer
 */
interface Printer {
    boolean print(int numPages);
    void replenishToner(int t);
}
/**
 * PrinterImpl
 */
class PrinterImpl implements Printer{
    int tonerLevel;
    public PrinterImpl(int t) {
        this.tonerLevel = t;
    }

    @Override
    public boolean print(int numPages) {
        if(numPages > this.tonerLevel) {
            System.out.println("Not enough toner\n");
            return false;
        } else {
            System.out.println("Printing successful\n");
            this.tonerLevel -= numPages;
            return true;
        }
    }

    @Override
    public void replenishToner(int t) {
        this.tonerLevel = t;
    }
    
}
/**
 * ScannerPrinter
 */
interface ScannerPrinter extends Scanner, Printer{
    public boolean scanPrint(int numPages);
    
}
/**
 * ScannerPrinterImpl
 */
class ScannerPrinterImpl implements ScannerPrinter{
    private ScannerImpl scanner;
    private PrinterImpl printer;
    public ScannerPrinterImpl(int l, int t) {
        this.scanner = new ScannerImpl(l);
        this.printer = new PrinterImpl(t);
    }

    @Override
    public boolean scanPrint(int numPages) {
        return this.scanner.scan(numPages) && this.printer.print(numPages);
    }


    @Override
    public boolean scan(int numPages) {
        return this.scanner.scan(numPages);
    }


    @Override
    public void changeLamp(int l) {
        this.scanner.changeLamp(l);
    }


    @Override
    public boolean print(int numPages) {
        return this.printer.print(numPages);
        
    }


    @Override
    public void replenishToner(int t) {
        this.printer.replenishToner(t);
    }

    
}



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

