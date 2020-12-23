package com.testcases;

import com.google.gson.Gson;
import com.ipl.BatsmenData;
import com.ipl.IPLAnalyser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLTestCase
{
    private String BATSMEN_DATA_FILE = "C:\\Users\\PUNIT BUDANIA\\IdeaProjects\\IPLAnalysis\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv";
    private String BOWLERS_DATA_FILE = "C:\\Users\\PUNIT BUDANIA\\IdeaProjects\\IPLAnalysis\\src\\test\\resources\\IPL2019FactsheetMostWkts.csv";
    IPLAnalyser iplAnalyser;

    @Test
    public void givenBatsmenData_ShouldReturnTopBattingAvg()
    {
        iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadBatsmenData(BATSMEN_DATA_FILE);
        List<BatsmenData> sortedBatsmenData = IPLAnalyser.getSortedBattingAvgs();
        //BatsmenData[] batsmenCSV = new Gson().fromJson(sortedBatsmenData, BatsmenData[].class);
        //Assert.assertEquals("MS Dhoni", batsmenCSV[0].player);
        Assert.assertEquals("MS Dhoni", sortedBatsmenData.get(0).getPlayer());
    }
}
