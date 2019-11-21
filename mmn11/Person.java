
/**
 * Represents information about a person.
 *
 * @author (Ephraim Phil -)
 * @version (19/2/2019)
 */
public class Person
{
    private String _first;
    private String _last;
    private long _id;
    private Date _birthDate;

    /**
     * Creates a new Person object.
     * @param first represetns the first name of a person.
     * @param last represents the last name of a person.
     * @param id represents the id of a person.
     * @param d represents the day the person was born on.
     * @param m represents the month the person was born in.
     * @param y represents the year the person was born in.
     */
    public Person(String first, String last, long id, int d, int m, int y)
    {
        _first = first;
        _last = last;
        _id = id;
        _birthDate = new Date(d,m,y);
    }

    /**
     * Constructor for objects of class Person. Copy constructor, construct a person using another person object.
     */
    public Person(Person other)
    {
        _first = other._first;
        _last = other._last;
        _id = other._id;
        _birthDate = new Date(other._birthDate);
    }

    /**
     * Returns the name of the person.
     * @return the name of the person.
     */
    public String getName()
    {
        return _first;
    }

    /**
     * Returns the Last Name of the person.
     * @return the Last Name of the person.
     */
    public String getLastName()
    {
        return _last;
    }

    /**
     * Returns the ID of the person.
     * @return the ID of the person.
     */
    public long getId()
    {
        return _id;
    }

    /**
     * Returns the birth date of the person.
     * @return the birth date of the person.
     */
    public Date getDateOfBirth()
    {
        return new Date(_birthDate);
    }

    /**
     * Sets a new name for a person.
     * @param name the new name of a person.
     */
    public void setName(String name)
    {
        _first = name;
    }

    /**
     * Sets a new Last Name for a person.
     * @param name the new Last Name of a person.
     */
    public void setLastName(String name)
    {
        _last = name;
    }

    /**
     * Sets a new ID for a person.
     * @param id the new ID of a person.
     */
    public void setId(long id)
    {
        _id = id;
    }

    /**
     * Sets a new date of birth for a person.
     * @param d the new day the person was born on.
     * @param m the new month the person was born in.
     * @param y the new year the person was born in.
     */
    public void setDateOfBirth(int d, int m, int y)
    {
        _birthDate = new Date(d,m,y);
    }

    /**
     * Check if the given person is equal to this person.
     * @param other The person to check equality with.
     * @return True if the given person is equal to this person.
     */
    public boolean equals(Person other)
    {
        boolean sameName = false;
        boolean sameLastName = false;
        boolean sameId = false;
        boolean sameBirthDate = false;
        if(_first.equals(other._first))
        {
            sameName = true;
        }
        if(_last.equals(other._last))
        {
            sameLastName = true;
        }
        if(_id == other._id)
        {
            sameId = true;
        }
        if(_birthDate.equals(other._birthDate))
        {
            sameBirthDate = true;
        }
        if(sameName && sameLastName && sameId && sameBirthDate)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Check if the given person was born on the same day this person was born.
     * @param other The person to check equality with.
     * @return True if the given person birthday equal to this person's birthday.
     */
    public boolean sameBirthday(Person other)
    {
        boolean sameBirthDay = false;
        if(_birthDate.equals(other._birthDate))
        {
            sameBirthDay = true;
        }
        return sameBirthDay;
    }

    /**
     * Check if the given person  is older then this person.
     * @param other The person to check equality with.
     * @return True if the given person is older then this person.
     */
    public boolean older(Person other)
    {
        if(_birthDate.before(other._birthDate))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns a string representation of this person in the format:
     *<p> </p>
     *<p> Last Name: Nethanyahu, First Name: binyamin, ID: 123456789, Date of birth: 14/6/2017 </p>
     * @override toString in class java.lang.Object
     * @return A String representation of this person
     */
    public String toString()
    {
        return "Last Name: "+_last+", "+"First Name: "+_first+", "+"ID: "+_id+", "+"Date Of Birth: "+_birthDate;
    }
}
