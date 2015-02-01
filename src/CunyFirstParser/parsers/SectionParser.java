package CunyFirstParser.parsers;

public abstract class SectionParser {

   private int rowCount;

   public SectionParser() {
      this.rowCount = 1;
   }

   public SectionParser(int rowCount) {
      this.rowCount = rowCount;
   }

   public boolean isValid() {
      return this.rowCount == 1;
   }
}