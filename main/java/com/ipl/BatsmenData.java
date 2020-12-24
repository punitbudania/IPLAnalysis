package com.ipl;

import com.opencsv.bean.CsvBindByPosition;

public class BatsmenData
{
    @CsvBindByPosition(position = 0)
    public String pos;

    @CsvBindByPosition(position = 1)
    public String player;

    @CsvBindByPosition(position = 5)
    public int runs;

    @CsvBindByPosition(position = 7)
    public double average;

    @CsvBindByPosition(position = 9)
    public double strikeRate;

    @CsvBindByPosition(position = 10)
    public int hundreds;

    @CsvBindByPosition(position = 12)
    public int fours;

    @CsvBindByPosition(position = 13)
    public int sixes;

    @CsvBindByPosition(position = 14)
    public int boundaries;

    @CsvBindByPosition(position = 15)
    public int bestFigures;

    public String getPlayer()
    {
        return player;
    }
}
