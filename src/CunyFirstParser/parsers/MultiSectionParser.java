package CunyFirstParser.parsers;

import org.jsoup.nodes.Element;

/** Parses information from multi class section HTML. */

public class MultiSectionParser extends SectionParser {

   private String[] timeArray;
   private String[] roomArray;
   private String[] instrArray;

   public MultiSectionParser(int rowCount, Element time, Element room,
         Element instr) {
      super(rowCount);
      String tTime = time.html().replace("<br /> ", "\n");
      String tRoom = room.html().replace("<br /> ", "\n");
      String tInstr = instr.html().replace("<br /> ", "\n");
      this.timeArray = tTime.split("\n");
      this.roomArray = tRoom.split("\n");
      this.instrArray = tInstr.split("\n");
   }

   public String[] getTimeArray() {
      return timeArray;
   }

   public String[] getRoomArray() {
      return roomArray;
   }

   public String[] getInstrArray() {
      return instrArray;
   }
}