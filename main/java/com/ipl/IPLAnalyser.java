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

public class IPLAnalyser
{
    static List<BatsmenData> batsmenDataList = null;

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

    private static List<BatsmenData> sort(Comparator batsmenDataComparator)
    {
        for (int i=0; i<batsmenDataList.size()-1; i++)
        {
            for (int j=0; j<batsmenDataList.size()-i-1; j++)
            {
                BatsmenData census1 = batsmenDataList.get(j);
                BatsmenData census2 = batsmenDataList.get(j+1);
                if(batsmenDataComparator.compare(census1, census2) > 0)
                {
                    batsmenDataList.set(j, census2);
                    batsmenDataList.set(j+1, census1);
                }
            }
        }
        return batsmenDataList;
    }
}
