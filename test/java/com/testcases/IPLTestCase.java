package com.testcases;

import com.google.gson.Gson;
import com.ipl.BatsmenData;
import com.ipl.BowlersData;
import com.ipl.IPLAnalyser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLTestCase
{
    private String BATSMEN_DATA_FILE = "C:\\Users\\PUNIT BUDANIA\\IdeaProjects\\IPLAnalysis\\src\\test\\resources\\WP DP Data_01 IPL2019FactsheetMostRuns.csv";
    private String BOWLERS_DATA_FILE = "C:\\Users\\PUNIT BUDANIA\\IdeaProjects\\IPLAnalysis\\src\\test\\resources\\IPL2019FactsheetMostWkts.csv";
    IPLAnalyser iplAnalyser = new IPLAnalyser();

    @Test
    public void givenBatsmenData_ShouldReturnTopBattingAvg()
    {
        //iplAnalyser = new IPLAnalyser();
        iplAnalyser.loadBatsmenData(BATSMEN_DATA_FILE);
        List<BatsmenData> sortedBatsmenData = IPLAnalyser.getSortedBattingAvgs();
        //BatsmenData[] batsmenCSV = new Gson().fromJson(sortedBatsmenData, BatsmenData[].class);
        //Assert.assertEquals("MS Dhoni", batsmenCSV[0].player);
        Assert.assertEquals("MS Dhoni", sortedBatsmenData.get(0).getPlayer());
    }

    @Test
    public void givenBatsmenData_ShouldReturnTopStrikeRate()
    {
        iplAnalyser.loadBatsmenData(BATSMEN_DATA_FILE);
        List<BatsmenData> sortedBatsmenData = IPLAnalyser.getSortedStrikingRates();
        Assert.assertEquals("Ishant Sharma", sortedBatsmenData.get(0).getPlayer());
    }

    @Test
    public void givenBatsmenData_ShouldReturnMax6sAnd4s()
    {
        iplAnalyser.loadBatsmenData(BATSMEN_DATA_FILE);
        List<BatsmenData> sortedBatsmenData = IPLAnalyser.getSorted6s();
        Assert.assertEquals("Andre Russell", sortedBatsmenData.get(0).getPlayer());
        List<BatsmenData> sortedBatsmenData1 = IPLAnalyser.getSorted4s();
        Assert.assertEquals("Shikhar Dhawan", sortedBatsmenData1.get(0).getPlayer());
    }

    @Test
    public void givenBatsmenData_ShouldReturnTopStrikeRateWithMost6s4s()
    {
        iplAnalyser.loadBatsmenData(BATSMEN_DATA_FILE);
        List<BatsmenData> sortedBatsmenData = IPLAnalyser.getSortedTopSRWithMost6s4s();
        Assert.assertEquals("Andre Russell", sortedBatsmenData.get(0).getPlayer());
    }

    @Test
    public void givenBatsmenData_ShouldReturnTopAvgWithBestSR()
    {
        iplAnalyser.loadBatsmenData(BATSMEN_DATA_FILE);
        List<BatsmenData> sortedBatsmenData = IPLAnalyser.getSortedTopAvgWithBestSR();
        Assert.assertEquals("Andre Russell", sortedBatsmenData.get(0).getPlayer());
    }

    @Test
    public void givenBatsmenData_ShouldReturnTopRunsWithBestAvg()
    {
        iplAnalyser.loadBatsmenData(BATSMEN_DATA_FILE);
        List<BatsmenData> sortedBatsmenData = IPLAnalyser.getSortedTopRunsWithBestAvg();
        Assert.assertEquals("David Warner ", sortedBatsmenData.get(0).getPlayer());
    }

    @Test
    public void givenBowlersData_ShouldReturnBestAvg()
    {
        iplAnalyser.loadBowlersData(BOWLERS_DATA_FILE);
        List<BowlersData> sortedBowlersData = IPLAnalyser.getSortedBestAvg();
        Assert.assertEquals("Prasidh Krishna", sortedBowlersData.get(0).getPlayer());
    }
}
