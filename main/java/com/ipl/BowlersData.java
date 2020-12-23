package com.ipl;

import com.opencsv.bean.CsvBindByPosition;

public class BowlersData
{
    //@CsvBindByPosition(position = 0)
    //public String pos;

    @CsvBindByPosition(position = 1)
    public String player;

    //@CsvBindByPosition(position = 2)
    //public int matches;

    //@CsvBindByPosition(position = 3)
    //public int innings;

    //@CsvBindByPosition(position = 4)
    //public int overs;

    //@CsvBindByPosition(position = 5)
    //public int runs;

    //@CsvBindByPosition(position = 6)
    //public int wickets;

    //@CsvBindByPosition(position = 7)
    //public int bbi;

    @CsvBindByPosition(position = 8)
    public String average;

    @CsvBindByPosition(position = 9)
    public double economy;

    @CsvBindByPosition(position = 10)
    public double strikeRate;

    //@CsvBindByPosition(position = 11)
    //public int fourW;

    //@CsvBindByPosition(position = 12)
    //public int fiveW;

    @CsvBindByPosition(position = 13)
    public int wickets;

    public String getPlayer()
    {
        return player;
    }
}
