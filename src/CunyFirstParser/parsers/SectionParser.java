package CunyFirstParser.parsers;

/** Parent class for class sections, tells if class is single or multi-row */

public abstract class SectionParser {

   private int rowCount;

   public SectionParser() {
      this.rowCount = 1;
   }

   public SectionParser(int rowCount) {
      this.rowCount = rowCount;
   }

   public boolean isSingleRow() {
      return this.rowCount == 1;
   }
}