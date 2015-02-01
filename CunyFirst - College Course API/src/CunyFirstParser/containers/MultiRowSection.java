package CunyFirstParser.containers;

import CunyFirstParser.parsers.ClassSectionParser;
import CunyFirstParser.parsers.MultiSectionParser;
import CunyFirstParser.parsers.SectionParser;

public class MultiRowSection extends ClassSection {

   private String time[];
   private String room[];
   private String instr[];

   public MultiRowSection(ClassSectionParser overhead, SectionParser handler) {
      super(overhead);
      MultiSectionParser classInfo = (MultiSectionParser) handler;
      this.time = classInfo.getTimeArray();
      this.room = classInfo.getRoomArray();
      this.instr = classInfo.getInstrArray();
   }

   @Override
   public String sectionDisplay() {
      StringBuilder display = new StringBuilder();

      for (int i = 0; i < time.length; i++) {
         display.append(this.time[i]);
         display.append(",   ");
         display.append(this.instr[i]);
         display.append("\n");
      }

      display.trimToSize();
      display.deleteCharAt(display.length() - 1);

      return display.toString();
   }

   @Override
   public String inDepthDisplay() {
      StringBuilder display = new StringBuilder();

      for (int i = 0; i < time.length; i++) {
         display.append("Days & Time:   " + this.time[i] + "\n");
         display.append("Room:   " + this.room[i] + "\n");
         display.append("Instructor:   " + this.instr[i] + "\n");
         display.append("\n");
      }

      display.append("Status:   " + this.getClassStatus() + "\n");
      display.append("\n");

      if (this.hasEnrollementInfo()) {
         display.append(this.enrollmentInfo.display(true));
      }

      return display.toString();
   }
}