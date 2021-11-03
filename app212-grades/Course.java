import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Renato Martins
 * @version 0.1 11/Sep/2020
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
     
    public Course()
    {
        this("MT1CYS1", "BSc Cyber Security");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module co452 = new Module ("CO452", "Programming Concepts");
        Module co456 = new Module ("CO456", "Web Development");
        Module co450 = new Module ("CO450", "Computer Architecture");
        Module co454 = new Module ("CO454", "Digital Tech");
        addModule(co452);
        addModule(co456);
        addModule(co450);
        addModule(co454);
    }
    
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * 
     */
    public Grades convertToGrade(int mark)
    {
        if(mark>= 0 && mark <= 39)
            return Grades.F;
        else if(mark>= 40 && mark <= 49)
            return Grades.D;
        else if(mark>= 50 && mark <= 59)
            return Grades.C;
        else if (mark>= 60 && mark <= 69)
            return Grades.B;
        else if (mark>= 70 && mark <= 100)
            return Grades.A;
        else
            return Grades.NS;
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        /** This sets the total marks to zero so that we can add them all**/
        int total = 0;
        
        int finalMark = 0;
        for(ModuleMark mark: marks)
        {
            /** Here we are = total to the total of the addition of all marks**/
            total = total + mark.getValue();
        }
        //Calculate Average for the final mark
        finalMark = total / MAXN_MODULES;
        finalGrade = convertToGrade(finalMark);
        return finalGrade;
    }
    
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        //System.out.println();
        
        printModules();
    }
    
    /**
     * Print the course's four modules
     */
    public void printModules()
    {
        for (Module module : modules)
        {
            module.print();
            module.printCredit();
        }
    }
}
