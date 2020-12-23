package com.ipl;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class BatsmenData
{
    //@CsvBindByName(column = "POS", required = true)
    @CsvBindByPosition(position = 0)
    public String pos;

    //@CsvBindByName(column = "PLAYER", required = true)
    @CsvBindByPosition(position = 1)
    public String player;

    //@CsvBindByName(column = "Mat", required = true)
    //@CsvBindByPosition(position = 2)
    //public int matches;

    //@CsvBindByName(column = "Inns", required = true)
    //@CsvBindByPosition(position = 3)
    //public int innings;

    //@CsvBindByName(column = "NO", required = true)
    //@CsvBindByPosition(position = 4)
    //public int notOuts;

    //@CsvBindByName(column = "Runs", required = true)
    //@CsvBindByPosition(position = 5)
    //public int runs;

    //@CsvBindByName(column = "HS", required = true)
    //@CsvBindByPosition(position = 6)
    //public int highestScore;

    //@CsvBindByName(column = "Avg", required = true)
    @CsvBindByPosition(position = 7)
    public double average;

    //@CsvBindByName(column = "BF", required = true)
    //@CsvBindByPosition(position = 8)
    //public int ballFaced;

    //@CsvBindByName(column = "SR", required = true)
    //@CsvBindByPosition(position = 9)
    //public double strikeRate;

    //@CsvBindByName(column = "100", required = true)
    //@CsvBindByPosition(position = 10)
    //public int hundreds;

    //@CsvBindByName(column = "50", required = true)
    //@CsvBindByPosition(position = 11)
    //public int fifties;

    //@CsvBindByName(column = "4s", required = true)
    //@CsvBindByPosition(position = 12)
    //public int fours;

    //@CsvBindByName(column = "6s", required = true)
    //@CsvBindByPosition(position = 13)
    //public int sixes;

    public String getPlayer()
    {
        return player;
    }
}
