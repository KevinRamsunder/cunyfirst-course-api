package CunyFirstParser.containers;

import CunyFirstParser.parsers.ClassSectionParser;
import CunyFirstParser.parsers.SectionParser;
import CunyFirstParser.parsers.SingleSectionParser;

public class SingleRowSection extends ClassSection {

   private String time;
   private String room;
   private String instr;

   public SingleRowSection(ClassSectionParser overhead, SectionParser handler) {
      super(overhead);
      SingleSectionParser classInfo = (SingleSectionParser) handler;
      this.time = classInfo.getTime();
      this.room = classInfo.getRoom();
      this.instr = classInfo.getInstr();
   }

   @Override
   public String sectionDisplay() {
      return this.time + ",   " + this.instr;
   }

   @Override
   public String inDepthDisplay() {
      StringBuilder display = new StringBuilder();

      display.append("Days & Time:   " + this.time + "\n");
      display.append("Room:   " + this.room + "\n");
      display.append("Instructor:   " + this.instr + "\n");
      display.append("Status:   " + this.getClassStatus() + "\n");
      display.append("\n");

      if (this.hasEnrollementInfo()) {
         display.append(this.enrollmentInfo.display(true));
      }

      return display.toString();
   }
}