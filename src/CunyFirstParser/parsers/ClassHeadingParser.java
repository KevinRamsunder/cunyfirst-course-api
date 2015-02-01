package CunyFirstParser.parsers;

import org.jsoup.nodes.Element;

public class ClassHeadingParser {

   private String title;
   private int quantity;

   private final int TABLE_ROW_FACTOR = 9;

   /**
    * Note on finding the number of classes per section heading.
    * 
    * Very tricky. This section will explain how to find the total amount of
    * classes per section heading on CUNYFirst.
    * 
    * First get the amount of table rows in the first table given by the JSoup
    * query, then display the tr size of that amount. The number that appears is
    * a multiple of the amount of table rows per class in the heading.
    * 
    * Finding the specific factor:
    * 
    * Now, run the above test on a heading that contains a single class. The
    * number that appears is your dividing factor. This number will be constant
    * per CUNYFirst HTML releases. Divide the size by the number displayed and
    * this will produce the number of valid classes per heading.
    * 
    * For example at the time of writing, 9 rows were found in a heading that
    * contained one class. 9 rows represent a single class so divide by 9 to
    * find the number of classes per heading.
    */

   public ClassHeadingParser(Element title, Element quantity) {
      // read above to get dividing factor
      this.quantity = quantity.select("tr").size() / TABLE_ROW_FACTOR;

      // manual trim
      String t = title.ownText();
      this.title = t.substring(1, t.length() - 1);
   }

   public String getTitle() {
      return title;
   }

   public int getQuantity() {
      return quantity;
   }
}