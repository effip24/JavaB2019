
/**
 * Represents a group of persons and contains an array of persons.
 *
 * @author (Ephraim Phil -)
 * @version (19/2/2019)
 */
public class Group
{
    private Person [] _persons;
    private int _numOfpersons;
    private final int MAX = 10 ;
    /**
     * Constructor for objects of class Group. 
     * Construct a new Group which contain an array of persons. 
     * 
     */
    public Group()
    {
        _persons = new Person[MAX];
        _numOfpersons = 0;
    }

    /**
     * Add a person to the array only if there is a plcae for him and he is not in the array already.  
     * @param p the person to add to the group array.
     */
    public boolean addPerson(Person p)
    {
        Person p1 = new Person(p);
        String name = p1.getName();
        String lastName = p1.getLastName();
        boolean inArray = false;

        if(MAX == _numOfpersons )
        {
            return false;
        }
        else
        {
            for (int i = 0; i < _numOfpersons; i++)
            {
                if(_persons[i].getName().equals(name) && _persons[i].getLastName().equals(lastName))
                {
                    inArray = true;
                }
            }
            if(!inArray)
            {
                _persons[_numOfpersons++] = new Person(p1);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    /**
     * Returns the number of people who were born on the given date. 
     * @param d is a class Date object, it's the given date to check the number of people who were born on the given date.
     * @return the number of people who were born on the given date.
     */
    public int bornInDate(Date d)
    {
        Date date = new Date(d);
        int counter = 0;
        if(_persons.length > 0)
        {
            for(int i = 0; i < _numOfpersons; i++)
            {
                if(_persons[i].getDateOfBirth().equals((date)))
                {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Returns the number of people who were born int the given month.  
     * @param m it's the given month to check the number of people who were born on the given month.
     * @return the number of people who were born on the given month.
     */
    public int bornInMonth(int m)
    {
        int counter= 0;
        if(m >= 1 && m <= 12 && _persons.length > 0)
        {
            for(int i = 0; i < _numOfpersons; i++)
            {
                if(_persons[i].getDateOfBirth().getMonth() == m)
                {
                    counter++;
                }
            }
            return counter;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Returns the oldest person in the array. 
     * @return the oldest person in the array.
     */
    public Person oldestPerson()
    {
        Person p1 = new Person(_persons[0]);
        Person p2 = new Person(_persons[0]);
        if(_persons.length > 0)
        {
            for(int i = 1; i < _numOfpersons; i++)
            {
                if(_persons[i].getDateOfBirth().before(p1.getDateOfBirth()))
                    p2 = _persons[i];
            }
            return p2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Returns the first name of the person whose last name comes first in the dictionary.
     * if there are a few with tha same last name the returned person will be the one whose first name come first in the dictionary.
     * @return the first name of the person whose last name comes first in the dictionary.
     */
    public String firstPerson()
    {
        Person p = new Person(_persons[0]);
        String lastName = p.getLastName();
        String fullName = p.getName();
        String name = null;
        for(int i = 1; i < _numOfpersons; i++)
        {
            if(_persons[i].getLastName().charAt(0) < lastName.charAt(0))
            {
                name = _persons[i].getName();
            }
            if(_persons[i].getLastName() ==  lastName)
            {
                if(_persons[i].getName().charAt(0) < fullName.charAt(0))
                {
                    fullName = _persons[i].getName();
                    name = _persons[i].getName();
                }
            }
        }
        if(name == null)
        {
            return fullName;
        }
        return name;
    }

    /**
     * Returns a string representation of the persons names in the Group, every person in new line.
     * @override toString in class java.lang.Object
     * @return A String representation of this person
     */
    public String toString()
    {
        String string = _persons[0].getName();
        for(int i=1; i < _numOfpersons; i++)
        {
            string += "\n"+_persons[i].getName();
        }
        return string;
    }
}

