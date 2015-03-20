package CunyFirstParser.containers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import CunyFirstParser.parsers.EnrollmentInfoParser;

/**
 * Structure for holding available seats, enrollment total, and available seats
 * that belong to a class section.
 */
public class EnrollmentInfo {

   private int classCapacity;
   private int enrollmentTotal;
   private int availableSeats;

   public EnrollmentInfo(EnrollmentInfoParser enrollmentInfo) {
      classCapacity = enrollmentInfo.getCapacity();
      enrollmentTotal = enrollmentInfo.getTotal();
      availableSeats = enrollmentInfo.getAvailable();
   }

   /**
    * Determines if two enrollment informations are equal to each other. Used
    * for finding changes in class enrollment overtime.
    */
   public boolean contentEquals(EnrollmentInfo e) {
      return (e.classCapacity == this.classCapacity)
            && (e.enrollmentTotal == this.enrollmentTotal)
            && (e.availableSeats == this.availableSeats);
   }

   /**
    * Print enrollment information. appendTime parameter allows you to choose if
    * you want this information timestamped.
    */
   public String display(boolean appendTime) {
      StringBuffer display = new StringBuffer();

      if (appendTime) { // add a timestamp to data
         display.append(this.getTime() + "\n");
      }

      display.append("Class Capacity:   " + this.classCapacity + "\n");
      display.append("Enrollment Total:   " + this.enrollmentTotal + "\n");
      display.append("Available Seats:   " + this.availableSeats + "\n");
      display.append("\n");

      return display.toString();
   }

   /** Produce a timestamp */
   private String getTime() {
      Calendar c = Calendar.getInstance();
      SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
      return df.format(c.getTime());
   }

   public int getClassCapacity() {
      return classCapacity;
   }

   public int getEnrollmentTotal() {
      return enrollmentTotal;
   }

   public int getAvailableSeats() {
      return availableSeats;
   }
}
