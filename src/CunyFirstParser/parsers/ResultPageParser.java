package CunyFirstParser.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import CunyFirstParser.CunyFirst;

public class ResultPageParser {

   /**
    * This class takes the result page and parses all of the data. The data then
    * needs to be stored in the MainParser class.
    */

   private int counter = 0;
   private Elements headings;
   private Elements classesPerHeading;
   private Elements nbr;
   private Elements section;
   private Elements status;
   private Elements room;
   private Elements time;
   private Elements instr;

   public ResultPageParser(Document doc) {
      headings = doc.select(CunyFirst.rPageFindHeading);
      classesPerHeading = doc.select(CunyFirst.rPagePerHeading);
      nbr = doc.select(CunyFirst.rPageFindNbr);
      section = doc.select(CunyFirst.rPageFindLecIds);
      status = doc.select(CunyFirst.rPageFindOpen);
      room = doc.select(CunyFirst.rPageFindRoom);
      time = doc.select(CunyFirst.rPageFindTime);
      instr = doc.select(CunyFirst.rPageFindInstr);
   }

   public void incrementCounter() {
      counter++;
   }

   public int headingSize() {
      return headings.size();
   }

   public Element headings(int counter) {
      return headings.get(counter);
   }

   public Element classesPerHeading(int counter) {
      return classesPerHeading.get(counter);
   }

   public Element nbr() {
      return nbr.get(counter);
   }

   public Element section() {
      return section.get(counter);
   }

   public Element status() {
      return status.get(counter);
   }

   public Element room() {
      return room.get(counter);
   }

   public Element time() {
      return time.get(counter);
   }

   public Element instr() {
      return instr.get(counter);
   }
}