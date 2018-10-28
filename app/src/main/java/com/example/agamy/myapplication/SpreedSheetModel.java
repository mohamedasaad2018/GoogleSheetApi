package com.example.agamy.myapplication;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpreedSheetModel {

    @SerializedName("spreadsheetId")
    @Expose
    private String spreadsheetId;
    @SerializedName("valueRanges")
    @Expose
    private List<ValueRange> valueRanges = null;

    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public void setSpreadsheetId(String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
    }

    public List<ValueRange> getValueRanges() {
        return valueRanges;
    }

    public void setValueRanges(List<ValueRange> valueRanges) {
        this.valueRanges = valueRanges;
    }

    public class ValueRange {

        @SerializedName("range")
        @Expose
        private String range;
        @SerializedName("majorDimension")
        @Expose
        private String majorDimension;
        @SerializedName("values")
        @Expose
        private List<List<String>> values = null;

        public String getRange() {
            return range;
        }

        public void setRange(String range) {
            this.range = range;
        }

        public String getMajorDimension() {
            return majorDimension;
        }

        public void setMajorDimension(String majorDimension) {
            this.majorDimension = majorDimension;
        }

        public List<List<String>> getValues() {
            return values;
        }

        public void setValues(List<List<String>> values) {
            this.values = values;
        }

    }

    @Override
    public String toString() {
        return "SpreedSheetModel{" +
                "spreadsheetId='" + spreadsheetId + '\'' +
                ", valueRanges=" + valueRanges +
                '}';
    }
}