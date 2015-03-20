package CunyFirstParser.containers;

import org.jsoup.nodes.Element;

/** Determines if a class section is either a multi-row, or a single row */

public class RowValidator {

   private int rows;

   public RowValidator(Element time) {
      // get number of rows, use '<' as a way of counting rows in the html
      this.rows = getNumbersOfRows(time.html(), '<');
   }

   public boolean isSingleRow() {
      return this.rows == 1;
   }

   public int getRows() {
      return rows;
   }

   /** Finds the number of rows present in a class section */
   private int getNumbersOfRows(String elementHtml, char nInstancesOf) {
      int rows = 0;
      
      // Find the number of 'nInstancesOf' characters in the html
      for (int i = 0; i < elementHtml.length(); i++) {
         if (elementHtml.charAt(i) == nInstancesOf) {
            rows++;
         }
      }

      // at least one row is always found, so append
      return ++rows;
   }
}