package com.example;

import org.apache.hadoop.hive.ql.exec.UDF;

import org.apache.hadoop.io.Text;

/**
 * UDF to convert a month name to a month number
 */

public class MonthNumbertoNameUDF extends UDF {

  public Text evaluate(Integer monthNum) {
    try {
      if (monthNum < 1 || monthNum > 12) {

        return new Text("Invalid month");

      }

      switch (monthNum) {

        case 1:
          return new Text("January");
        case 2:
          return new Text("February");
        case 3:
          return new Text("March");
        case 4:
          return new Text("April");
        case 5:
          return new Text("May");
        case 6:
          return new Text("June");
        case 7:
          return new Text("July");
        case 8:
          return new Text("August");
        case 9:
          return new Text("September");
        case 10:
          return new Text("October");
        case 11:
          return new Text("November");
        case 12:
          return new Text("December");

      }

      return null;

    } catch (IllegalArgumentException e) {
      return new Text("Invalid input");
    }
  }

}