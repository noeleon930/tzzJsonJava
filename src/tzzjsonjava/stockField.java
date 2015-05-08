/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tzzjsonjava;

import java.util.HashMap;

/**
 *
 * @author Noel
 */
public class stockField
{

    //Data members
    private final String stock_id;
    private final String stock_name;
    private final String stock_dateStr;
    private final int stock_date;
    private final float point_open;
    private final float point_high;
    private final float point_low;
    private final float point_close;

    //Constructor
    public stockField(
            String stock_id,
            String stock_name,
            String stock_dateStr,
            int stock_date,
            float point_open,
            float point_high,
            float point_low,
            float point_close)
    {
        this.stock_id = stock_id;
        this.stock_name = stock_name;
        this.stock_dateStr = stock_dateStr;
        this.stock_date = stock_date;
        this.point_open = point_open;
        this.point_high = point_high;
        this.point_low = point_low;
        this.point_close = point_close;
    }

    public HashMap<String, Float> kbar()
    {
        HashMap<String, Float> tmp = new HashMap<>();

        tmp.put("open", this.point_open);
        tmp.put("high", this.point_high);
        tmp.put("low", this.point_low);
        tmp.put("close", this.point_close);

        return tmp;
    }

    public boolean equalId(String stock_id)
    {
        return (this.stock_id.equals(stock_id));
    }

    public boolean equalName(String stock_name)
    {
        return (this.stock_name.equals(stock_name));
    }

    public boolean equalDate(int stock_date)
    {
        return (this.stock_date == stock_date);
    }

    public boolean equalOpen(float point_open)
    {
        return (this.point_open == point_open);
    }

    public boolean equalHigh(float point_high)
    {
        return (this.point_high == point_high);
    }

    public boolean equalLow(float point_low)
    {
        return (this.point_low == point_low);
    }

    public boolean equalClose(float point_close)
    {
        return (this.point_close == point_close);
    }

    public String getStock_id()
    {
        return this.stock_id;
    }

    public String getStock_name()
    {
        return this.stock_name;
    }

    public int getStock_date()
    {
        return this.stock_date;
    }

    public float getPoint_open()
    {
        return this.point_open;
    }

    public float getPoint_high()
    {
        return this.point_high;
    }

    public float getPoint_low()
    {
        return this.point_low;
    }

    public float getPoint_close()
    {
        return this.point_close;
    }
}
