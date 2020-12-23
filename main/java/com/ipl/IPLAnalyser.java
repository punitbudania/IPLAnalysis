package com.ipl;

import com.google.gson.Gson;
import com.jarfile.CSVBuilderException;
import com.jarfile.CSVBuilderFactory;
import com.jarfile.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyser
{
    static List<BatsmenData> batsmenDataList = null;
    static List<BatsmenData> sortedList = null;

    public void loadBatsmenData(String csvFilePath)
    {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath)))
        {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            batsmenDataList = icsvBuilder.getCSVFileList(reader, BatsmenData.class);
        }
        catch (IOException | CSVBuilderException e)
        {
            e.printStackTrace();
        }
    }

    public static List<BatsmenData> getSortedBattingAvgs()
    {
        Comparator<BatsmenData> batsmenDataComparator = Comparator.comparing(batsmenData -> batsmenData.average);
        //System.out.println(sort(batsmenDataComparator));
        //String sortedBattingAvgs = new Gson().toJson(batsmenDataList);
        return sort(batsmenDataComparator.reversed());
    }

    public static List<BatsmenData> getSortedStrikingRates()
    {
        Comparator<BatsmenData> batsmenDataComparator = Comparator.comparing(batsmenData -> batsmenData.strikeRate);
        return sort(batsmenDataComparator.reversed());
    }

    public static List<BatsmenData> getSorted6s()
    {
        Comparator<BatsmenData> batsmenDataComparator = Comparator.comparing(batsmenData -> batsmenData.sixes);
        return sort(batsmenDataComparator.reversed());
    }

    public static List<BatsmenData> getSorted4s()
    {
        Comparator<BatsmenData> batsmenDataComparator = Comparator.comparing(batsmenData -> batsmenData.fours);
        return sort(batsmenDataComparator.reversed());
    }

    public static List<BatsmenData> getSortedTopSRWithMost6s4s()
    {
        Comparator<BatsmenData> batsmenDataComparator = Comparator.comparing(batsmenData -> batsmenData.strikeRate);
        List<BatsmenData> sortedTopSR = sort(batsmenDataComparator.reversed());
        sortedList = sortedTopSR.stream().limit(10).collect(Collectors.toList());
        System.out.println(sortedList);
        Comparator<BatsmenData> batsmenDataComparator1 = Comparator.comparing(batsmenData -> batsmenData.boundaries);
        return sortFurther(batsmenDataComparator1.reversed());
    }

    private static List<BatsmenData> sort(Comparator comparator)
    {
        for (int i=0; i<batsmenDataList.size()-1; i++)
        {
            for (int j=0; j<batsmenDataList.size()-i-1; j++)
            {
                BatsmenData census1 = batsmenDataList.get(j);
                BatsmenData census2 = batsmenDataList.get(j+1);
                if(comparator.compare(census1, census2) > 0)
                {
                    batsmenDataList.set(j, census2);
                    batsmenDataList.set(j+1, census1);
                }
            }
        }
        return batsmenDataList;
    }

    private static List<BatsmenData> sortFurther(Comparator comparator)
    {
        for (int i=0; i<sortedList.size()-1; i++)
        {
            for (int j=0; j<sortedList.size()-i-1; j++)
            {
                BatsmenData census1 = sortedList.get(j);
                BatsmenData census2 = sortedList.get(j+1);
                if(comparator.compare(census1, census2) > 0)
                {
                    sortedList.set(j, census2);
                    sortedList.set(j+1, census1);
                }
            }
        }
        return sortedList;
    }
}
