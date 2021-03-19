package programmingLanguages;

/**
 * ScannerPrinterImpl
 */
public class ScannerPrinterImpl implements ScannerPrinter{
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