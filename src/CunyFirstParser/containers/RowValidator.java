package CunyFirstParser.containers;

import org.jsoup.nodes.Element;

public class RowValidator {

   private int rows;

   public RowValidator(Element time) {
      this.rows = getRowSelection(time.html(), '<');
   }

   public boolean isValid() {
      return this.rows == 1;
   }

   public int getRows() {
      return rows;
   }

   private int getRowSelection(String elementHtml, char nInstancesOf) {
      int n = 0;

      for (int i = 0; i < elementHtml.length(); i++) {
         if (elementHtml.charAt(i) == nInstancesOf) {
            n++;
         }
      }

      return ++n;
   }

}
