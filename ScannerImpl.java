package programmingLanguages;

/**
 * ScannerImpl
 */
public class ScannerImpl implements Scanner{
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