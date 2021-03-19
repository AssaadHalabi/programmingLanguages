package programmingLanguages;

/**
 * PrinterImpl
 */
public class PrinterImpl implements Printer{
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