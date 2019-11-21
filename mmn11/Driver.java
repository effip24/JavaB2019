import java.util.Scanner;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        Person p1 = new Person("Effi", "Phil", 123456, 20,4,1994);
        Person p2 = new Person("Ran", "Phil", 123456, 20,4,1994);; 
        Person p3 = new Person("Ofer", "Phil", 123456, 22,4,1979);;
        Group g = new Group();

        g.addPerson(p1);
        g.addPerson(p2);
        g.addPerson(p3);

        System.out.println("Here are the persons in the system: ");
        System.out.println("\t"+p1);
        System.out.println("\t"+p2);
        System.out.println("\t"+p3+"\n");

        System.out.println("Checking class Group methods: \n");
        //prints the oldest person
        System.out.println("\tThe oldest person in the system is:\n "+"\t\t"+g.oldestPerson()+"\n");

        //prints the persons which his first name is first in the dictionary
        System.out.println("\tThe person which his first name is first in the dictionary is: "+g.firstPerson()+"\n");

        //checks how many people were born in the date below
        int d = 20;
        int m = 4;
        int y = 1994;
        Date date = new Date(d,m,y);
        System.out.println("\tThe number of people who were born in "+d+"/"+m+"/"+y+" is: "+g.bornInDate(date)+"\n");

        //checks how many people were born in the month below
        String [] array = new String[13];
        array[1] = "January"; array[2] = "February"; array[3] = "March"; array[4] = "April"; array[5] = "May"; array[6] = "June";
        array[7] = "July"; array[8] = "August"; array[9] = "September"; array[10] = "October"; array[11] = "November"; array[12] = "December";
        int month = 4;

        System.out.println("\t The number of people who were born in "+array[month]+" is: "+g.bornInMonth(month)+"\n\n");

        //checking class Persons geters methods
        System.out.println(" Checking class Persons methods on p1 and p2 objects: ");
        System.out.println("\t p1 is: "+p1+"\n\tp2 is: "+p2+"\n");
        System.out.println("\t Checking geteres methods: \n");
        System.out.println("\t\t Checking p1.getName(): "+p1.getName()+" \n");
        System.out.println("\t\t Checking p1.getLastName(): "+p1.getLastName()+" \n");
        System.out.println("\t\t Checking p1.getId(): "+p1.getId()+" \n");
        System.out.println("\t\t Checking p1.getDateOfBirth(): "+p1.getDateOfBirth()+" \n");

        ////checking class Persons seters methods
        System.out.println("\t Checking seters methods: \n");

        System.out.println("\t\t Checking  p1.setName(test) method: "+"\t\t\t ");
        System.out.println("\t\t\t before: p1.getName(): "+p1.getName());
        p1.setName("test");
        System.out.println("\t\t\t after: p1.getName(): "+p1.getName()+"\n");

        System.out.println("\t\t Checking  p1.setLastName(LstTest) method: ");
        System.out.println("\t\t\t before: p1.getLastName(): "+p1.getLastName());
        p1.setLastName("LstTest");
        System.out.println("\t\t\t after: p1.getLastName(): "+p1.getLastName()+"\n");

        System.out.println("\t\t Checking  p1.setId(121212) method: ");
        System.out.println("\t\t\t before: p1.setId(): "+p1.getId());
        p1.setId(121212);
        System.out.println("\t\t\t after: p1.setId(): "+p1.getId()+"\n");

        System.out.println("\t\t Checking  p1.setDateOfBirth(1,1,1999) method: ");
        System.out.println("\t\t\t before: p1.getDateOfBirth(): "+p1.getDateOfBirth());
        p1.setDateOfBirth(1,1,1999);
        System.out.println("\t\t\t after: p1.getDateOfBirth(): "+p1.getDateOfBirth()+"\n");

        //checking equals method
        System.out.println("\t Checking equals methods on p1 and p2: \n");
        System.out.println("\t\t Checking equals on two different people: ");
        System.out.println("\t\t "+p1.toString()+"\n"+"\t"+"\t "+p2.toString());
        System.out.println("\t\t is p1.equals(p2)?: "+p1.equals(p2)+"\n");
        System.out.println("\t\t Checking equals on two same people: ");
        p1.setName("test");
        p2.setName("test");
        p1.setLastName("LstTest");
        p2.setLastName("LstTest");
        p1.setId(121212);
        p2.setId(121212);
        p1.setDateOfBirth(1,1,1999);
        p2.setDateOfBirth(1,1,1999);
        System.out.println("\t\t "+p1.toString()+"\n"+"\t"+"\t "+p2.toString()+"");
        System.out.println("\t\t is p1.equals(p2)?: "+p1.equals(p2)+"\n");

        //checking sameBirthday method
        System.out.println("\t Checking sameBirthday methods on p1 and p2: \n");
        System.out.println("\t\t Checking sameBirthday on two people with the same birthday: ");
        System.out.println("\t\t p1.getDateOfBirth(): "+p1.getDateOfBirth());
        System.out.println("\t\t p2.getDateOfBirth(): "+p2.getDateOfBirth());
        System.out.println("\t\t is p1.sameBirthday(p2)?: "+p1.sameBirthday(p2)+"\n");
        System.out.println("\t\tChecking sameBirthday on two people with deffirent birthday: ");
        p1.setDateOfBirth(1,5,1999);
        System.out.println("\t\t p1.getDateOfBirth(): "+p1.getDateOfBirth());
        System.out.println("\t\t p2.getDateOfBirth(): "+p2.getDateOfBirth());
        System.out.println("\t\t is p1.sameBirthday(p2)?: "+p1.sameBirthday(p2)+"\n");

        //checking older method
        System.out.println("\t Checking older method on p1 and p2: \n");
        System.out.println("\t\t Checking older method when p1 is older then p2 by year: ");
        p1.setDateOfBirth(1,1,1994);
        p2.setDateOfBirth(1,1,1999);
        System.out.println("\t\t p1.getDateOfBirth(): "+p1.getDateOfBirth());
        System.out.println("\t\t p2.getDateOfBirth(): "+p2.getDateOfBirth());
        System.out.println("\t\t is p1.older(p2)?: "+p1.older(p2)+"\n");
        System.out.println("\t\t Checking older method when p1 is older then p2 by month: ");
        p1.setDateOfBirth(1,1,1994);
        p2.setDateOfBirth(1,2,1994);
        System.out.println("\t\t p1.getDateOfBirth(): "+p1.getDateOfBirth());
        System.out.println("\t\t p2.getDateOfBirth(): "+p2.getDateOfBirth());
        System.out.println("\t\t is p1.older(p2)?: "+p1.older(p2)+"\n");
        System.out.println("\t\tChecking older method when p1 is older then p2 by day: ");
        p1.setDateOfBirth(1,1,1994);
        p2.setDateOfBirth(2,1,1999);
        System.out.println("\t\t p1.getDateOfBirth(): "+p1.getDateOfBirth());
        System.out.println("\t\t p2.getDateOfBirth(): "+p2.getDateOfBirth());
        System.out.println("\t\t is p1.older(p2)?: "+p1.older(p2)+"\n");

        //checking class Date methods
        System.out.println("Checking class Date methods: \n");
        System.out.println("\t Checking the constructor : ");
        System.out.println("\t\t a valid date is only if the day is 1-31, month 1-12 and the year is 4 digits number\n\t\totherwise a default date should be returned(1/1/2000)\n");

        System.out.println("\t\t Creating a new VALID Date object"+"(10/10/1999)");
        int dd = 10;
        int mm = 10;
        int yy = 1999;
        Date secondDate = new Date(dd,mm,yy);        
        System.out.println("\t\t\t The  returned date is: "+secondDate+"\n");

        System.out.println("\t\t Creating a new Date object with INVALID DAY"+"(0/1/1999)");
        int ddd=0;
        int mmm=1;
        int yyy = 1999;
        Date thirdDate = new Date(ddd,mmm,yyy);
        System.out.println("\t\t\t The returned date is: "+thirdDate+"\n");

        System.out.println("\t\t Creating a new Date object with INVALID MONTH"+"(1/0/1999)");
        ddd=1;
        mmm=0;
        yyy = 1999;
        Date fourthDate = new Date(ddd,mmm,yyy);
        System.out.println("\t\t\t The returned date is: "+fourthDate+"\n");

        System.out.println("\t\t Creating a new Date object with INVALID YEAR"+"(1/1/999)");
        ddd=1;
        mmm=1;
        yyy = 999;
        Date fifthDate = new Date(ddd,mmm,yyy);
        System.out.println("\t\t\t The returned date is: "+fifthDate+"\n");

        //checking geters methods
        System.out.println("\t\t Checking geters methods on secondDate object: ");
        System.out.println("\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t checking secondDate.getDay(): "+secondDate.getDay());
        System.out.println("\t\t\t checking secondDate.getMonth(): "+secondDate.getMonth());
        System.out.println("\t\t\t checking secondDate.getYear(): "+secondDate.getYear()+"\n");

        //checking seters methods on secondDate and thirdDate objects
        System.out.println("\t\t Checking seters methods on secondDate and thirdDate objects: ");
        System.out.println("\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t thirdDate object is: "+thirdDate+"\n");

        System.out.println("\t\t\t Checking setDay(2) with VALID DAY: ");
        System.out.println("\t\t\t\t before: "+secondDate);
        secondDate.setDay(2);
        System.out.println("\t\t\t\t after: "+secondDate+"\n");

        System.out.println("\t\t\t Checking setDay(0) with INVALID DAY: ");
        System.out.println("\t\t\t\t before: "+secondDate);
        secondDate.setDay(0);
        System.out.println("\t\t\t\t after: "+secondDate+"\n");

        System.out.println("\t\t\t Checking setMonth(0) with VALID DAY: ");
        System.out.println("\t\t\t\t before: "+secondDate);
        secondDate.setMonth(4);
        System.out.println("\t\t\t\t after: "+secondDate+"\n");

        System.out.println("\t\t\t Checking setMonth(0) with INVALID DAY: ");
        System.out.println("\t\t\t\t before: "+secondDate);
        secondDate.setMonth(0);
        System.out.println("\t\t\t\t after: "+secondDate+"\n");

        System.out.println("\t\t\t Checking setYear(2010) with VALID DAY: ");
        System.out.println("\t\t\t\t before: "+secondDate);
        secondDate.setYear(2010);
        System.out.println("\t\t\t\t after: "+secondDate+"\n");

        System.out.println("\t\t\t Checking setYear(900) with INVALID DAY: ");
        System.out.println("\t\t\t\t before: "+secondDate);
        secondDate.setYear(900);
        System.out.println("\t\t\t\t after: "+secondDate+"\n");

        //checking equals method on secondDate and thirdDateobjects
        System.out.println("\t\t Checking equals method on secondDate and thirdDate objects: "+"\n");

        System.out.println("\t\t\t Checking secondDate.equals(thirdDate) when both equals: ");
        System.out.println("\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t thirdDate object is: "+thirdDate);
        System.out.println("\t\t\t\t is secondDate.equals(thirdDate)?: "+secondDate.equals(thirdDate)+"\n");

        System.out.println("\t\t\t Checking secondDate.equals(thirdDate) when both are different: ");
        secondDate.setDay(3);
        secondDate.setMonth(4);
        secondDate.setYear(2010);
        System.out.println("\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t thirdDate object is: "+thirdDate);
        System.out.println("\t\t\t\t is secondDate.equals(thirdDate)?: "+secondDate.equals(thirdDate)+"\n");

        System.out.println("\t\t\t Checking secondDate.equals(thirdDate) when both has the same year: ");
        secondDate.setDay(3);
        secondDate.setMonth(4);
        secondDate.setYear(2010);
        thirdDate.setYear(2010);
        System.out.println("\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t thirdDate object is: "+thirdDate);
        System.out.println("\t\t\t\t is secondDate.equals(thirdDate)?: "+secondDate.equals(thirdDate)+"\n");

        System.out.println("\t\t\t Checking secondDate.equals(thirdDate) when both has the same year and month: ");
        secondDate.setDay(3);
        secondDate.setMonth(4);
        secondDate.setYear(2010);
        thirdDate.setMonth(4);
        thirdDate.setYear(2010);
        System.out.println("\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t thirdDate object is: "+thirdDate);
        System.out.println("\t\t\t\t is secondDate.equals(thirdDate)?: "+secondDate.equals(thirdDate)+"\n");

        //checking method before on secondDate and thirdDate objects
        System.out.println("\t\t Checking method before() on secondDate and thirdDate objects \n");
        System.out.println("\t\t\t Checking method secondDate.before(thirdDate) when secondDate is older by year: ");
        secondDate.setYear(2009);
        secondDate.setMonth(5);
        System.out.println("\t\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t\t thirdDate object is: "+thirdDate);       
        System.out.println("\t\t\t\t is secondDate.before(thirdDate)?: "+secondDate.before(thirdDate)+"\n");

        System.out.println("\t\t\t Checking method secondDate.before(thirdDate) when secondDate is older by month: ");
        secondDate.setYear(2010);
        thirdDate.setMonth(6);
        thirdDate.setYear(2010);
        System.out.println("\t\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t\t thirdDate object is: "+thirdDate);       
        System.out.println("\t\t\t\t is secondDate.before(thirdDate)?: "+secondDate.before(thirdDate)+"\n");

        System.out.println("\t\t\t Checking method secondDate.before(thirdDate) when secondDate is older by day: ");
        secondDate.setDay(1);
        secondDate.setMonth(4);
        secondDate.setYear(2010);
        thirdDate.setDay(3);
        thirdDate.setMonth(4);
        thirdDate.setYear(2010);
        System.out.println("\t\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t\t thirdDate object is: "+thirdDate);       
        System.out.println("\t\t\t\t is secondDate.before(thirdDate)?: "+secondDate.before(thirdDate)+"\n");

        //checking after method on secondDate and thirdDate objects
        System.out.println("\t\t Checking method after() on secondDate and thirdDate objects \n");
        System.out.println("\t\t\t Checking secondDate.after(thirdDate) when secondDate is older by year: ");
        secondDate.setYear(2009);
        secondDate.setMonth(5);
        System.out.println("\t\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t\t thirdDate object is: "+thirdDate);       
        System.out.println("\t\t\t\t is secondDate.after(thirdDate)?: "+secondDate.after(thirdDate)+"\n");

        System.out.println("\t\t\t Checking secondDate.after(thirdDate) when secondDate is older by month: ");
        secondDate.setYear(2010);
        thirdDate.setMonth(6);
        thirdDate.setYear(2010);
        System.out.println("\t\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t\t thirdDate object is: "+thirdDate);       
        System.out.println("\t\t\t\t is secondDate.after(thirdDate)?: "+secondDate.after(thirdDate)+"\n");

        System.out.println("\t\t\t Checking secondDate.after(thirdDate)n secondDate is older by day: ");
        secondDate.setDay(1);
        secondDate.setMonth(4);
        secondDate.setYear(2010);
        thirdDate.setDay(3);
        thirdDate.setMonth(4);
        thirdDate.setYear(2010);
        System.out.println("\t\t\t\t secondDate object is: "+secondDate);
        System.out.println("\t\t\t\t thirdDate object is: "+thirdDate);       
        System.out.println("\t\t\t\t is secondDate.after(thirdDate)?: "+secondDate.after(thirdDate)+"\n");
    }
}
