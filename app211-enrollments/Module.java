
/**
 * This class contains information about the modules for the courses
 * at BNU.
 *
 * @author Renato Martins
 * @version v1
 */
public class Module
{
    // instance variables for the module class, code is the course code and title is the course name
    private String code;
    private String title;
    private int credit;

    /**
     * Constructor for Modules
     */
    public Module(String code, String title)
    {   
        this.code = code;
        this.title = title;
        credit = 0;
    }

    public String getCode()
    {
        return code;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
    /**
     * This method will print the module name and code
     */
    public void print()
    {
        printHeading();
        
        System.out.println(" Module Code: " + code + ": " + title);
        System.out.println(" Credits for: " + title + ": " + credit);
        System.out.println();
    }
    
    /**
     * Print out the details of the Module to the terminal.
     */
    private void printHeading()
    {
        System.out.println(" --------------------------------");
        System.out.println("   App211: Module Details");
        System.out.println(" --------------------------------");
        System.out.println();
    }
}
