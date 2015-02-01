package CunyFirstParser.parsers;

import org.jsoup.nodes.Element;

public class SingleSectionParser extends SectionParser {

   private String time;
   private String room;
   private String instr;

   public SingleSectionParser(Element time, Element room, Element instr) {
      super();
      this.time = time.ownText();
      this.room = room.ownText();
      this.instr = instr.ownText();
   }

   public String getTime() {
      return time;
   }

   public String getRoom() {
      return room;
   }

   public String getInstr() {
      return instr;
   }
}