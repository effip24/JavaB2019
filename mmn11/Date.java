
/**
 * class Date creates a date..
 *
 * @author (Ephraim Phil )
 * @version (19/2/2019)
 */
public class Date
{
    private int _day;
    private int _month;
    private int _year;

    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 2000;

    /**
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000.
     * @param day the day of the month.
     * @param month the month of the year.
     * @param year the year.
     */
    public Date(int day, int month, int year)
    {
        if(checkDay(day) && checkMonth(month) && checkYear(year))
        {
            _day = day;
            _month = month;
            _year = year;
        }
        else
        {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
    }

    /**
     * copy constructor constructs a date using other date.
     * @param other the other date to copy to.
     */
    public Date(Date other)
    {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    /**
     * gets the day.
     * @retun the day.
     */
    public int getDay()
    {
        return _day;
    }

    /**
     * gets the month.
     * @return the month.
     */
    public int getMonth()
    {
        return _month;
    }

    /**
     * gets the year.
     * @retun the year.
     */
    public int getYear()
    {
        return _year;
    }

    /**
     * sets the day (only if the day is valid and between 1-31).
     * @param day the new day to be set.
     */
    public void setDay(int day)
    {
        if(checkDay(day))
        {
            _day = day;
        }
        else
        {
            _day = DEFAULT_DAY;
        }
    }

    /**
     * sets the month (only if the month is valid and between 1 - 12).
     * @param month the new month.
     */
    public void setMonth(int month)
    {
        if(checkMonth(month))
        {
            _month = month;
        }
        else
        {
            _month = DEFAULT_MONTH;
        }
    }

    /**
     * sets the year (only if the year is valid and is a 4 digits number).
     * @param year the new year.
     */
    public void setYear(int year)
    {
        if(checkYear(year))
        {
            _year = year;
        }
        else
        {
            _year = DEFAULT_YEAR;
        }
    }

    /**
     * checks if 2 dates are the same
     * @param other the other date to be compared.
     */
    public boolean equals(Date other)
    {
        boolean sameDay = false;
        boolean sameMonth = false;
        boolean sameYear = false;
        if(_day == other._day)
        {
            sameDay = true;
        }
        if(_month == other._month)
        {
            sameMonth = true;
        }
        if(_year == other._year)
        {
            sameYear = true;
        }
        if(sameDay && sameMonth && sameYear)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * checks if this date is before other date
     * @param other the other date to be checked to.
     */
    public boolean before(Date other)
    {
        if(_year < other._year )
        {
            return true;
        }
        else if(_year == other._year)
        {
            if(_month < other._month)
            {
                return true;
            }
            else if(_month == other._month && _day < other._day)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else
        {
            return false;
        }
    }

    /**
     * checks if this date is after other date.
     * @param other the other dated to be checked to.
     */
    public boolean after(Date other)
    {
        return other.before(this);
    }

    /**
     * returns a string that represents this date.
     */
    public String toString()
    {
        return _day + "/"+ _month + "/" + _year;
    }

    //checks if the day is valid
    private boolean checkDay(int day)
    {
        if(day >= 1 && day <= 31)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //checks if the month is valid
    private boolean checkMonth(int month)
    {
        if(month >= 1 && month <= 12)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //checks if the year is valid
    private boolean checkYear(int year)
    {
        if(year >= 1000 && year < 10000 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
