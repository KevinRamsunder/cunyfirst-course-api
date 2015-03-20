package CunyFirstParser.containers;

/** Parent class for Class Heading */

public abstract class Heading {

   private String title; // title of class heading
   private int quantity; // number of sections within heading

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
