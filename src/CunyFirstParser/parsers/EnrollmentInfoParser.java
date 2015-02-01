package CunyFirstParser.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import CunyFirstParser.CunyFirst;

public class EnrollmentInfoParser {

   private int classCapacity;
   private int classTotal;
   private int classAvailable;

   public EnrollmentInfoParser(String htmlPage) {
      Document doc = Jsoup.parse(htmlPage);
      Element cap = doc.select(CunyFirst.findClassCapacity).first();
      Element tot = doc.select(CunyFirst.findClassTotal).first();
      Element avail = doc.select(CunyFirst.findAvailableSeats).first();
      classCapacity = Integer.parseInt(cap.ownText());
      classTotal = Integer.parseInt(tot.ownText());
      classAvailable = Integer.parseInt(avail.ownText());
   }

   public EnrollmentInfoParser(Elements cap, Elements total, Elements avail) {
      classCapacity = Integer.parseInt(cap.first().ownText());
      classTotal = Integer.parseInt(total.first().ownText());
      classAvailable = Integer.parseInt(avail.first().ownText());
   }

   public EnrollmentInfoParser(Element cap, Element total, Element avail) {
      classCapacity = Integer.parseInt(cap.ownText());
      classTotal = Integer.parseInt(total.ownText());
      classAvailable = Integer.parseInt(avail.ownText());
   }

   public int getCapacity() {
      return classCapacity;
   }

   public int getTotal() {
      return classTotal;
   }

   public int getAvailable() {
      return classAvailable;
   }
}