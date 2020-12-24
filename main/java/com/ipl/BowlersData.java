package com.ipl;

import com.opencsv.bean.CsvBindByPosition;

public class BowlersData
{
    @CsvBindByPosition(position = 1)
    public String player;

    @CsvBindByPosition(position = 6)
    public int wickets;


    @CsvBindByPosition(position = 8)
    public String average;

    @CsvBindByPosition(position = 9)
    public double economy;

    @CsvBindByPosition(position = 10)
    public double strikeRate;

    @CsvBindByPosition(position = 13)
    public int bestFigure;

    public String getPlayer()
    {
        return player;
    }
}
