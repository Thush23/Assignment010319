package com.example.assignment010319;

import java.text.SimpleDateFormat;

public class DateChecker {
        private final String year;
        private final String month;
        private final String day;

        public DateChecker(String year, String month, String day){
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public boolean isThisDateValid(String dateToValidate){

            if(dateToValidate == null){
                return false;
            }
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            return true;
        }

    }



