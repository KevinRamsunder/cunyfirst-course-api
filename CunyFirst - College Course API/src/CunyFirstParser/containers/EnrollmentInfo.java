package CunyFirstParser.containers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import CunyFirstParser.parsers.EnrollmentInfoParser;

public class EnrollmentInfo {

   private int classCapacity;
   private int enrollmentTotal;
   private int availableSeats;

   public EnrollmentInfo(EnrollmentInfoParser enrollmentInfo) {
      classCapacity = enrollmentInfo.getCapacity();
      enrollmentTotal = enrollmentInfo.getTotal();
      availableSeats = enrollmentInfo.getAvailable();
   }

   public boolean contentEquals(EnrollmentInfo e) {
      return (e.classCapacity == this.classCapacity)
            && (e.enrollmentTotal == this.enrollmentTotal)
            && (e.availableSeats == this.availableSeats);
   }

   public String display(boolean appendTime) {
      StringBuffer display = new StringBuffer();

      if (appendTime) {
         display.append(this.getTime() + "\n");
      }

      display.append("Class Capacity:   " + this.classCapacity + "\n");
      display.append("Enrollment Total:   " + this.enrollmentTotal + "\n");
      display.append("Available Seats:   " + this.availableSeats + "\n");
      display.append("\n");

      return display.toString();
   }

   private String getTime() {
      Calendar c = Calendar.getInstance();
      SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");

      return df.format(c.getTime());
   }
}
