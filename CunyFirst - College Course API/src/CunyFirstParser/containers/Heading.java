package CunyFirstParser.containers;

public abstract class Heading {

   private String title;
   private int quantity;

   public Heading(String title, int quantity) {
      this.title = title;
      this.quantity = quantity;
   }

   public String getTitle() {
      return title;
   }

   public int getQuantity() {
      return quantity;
   }
}
