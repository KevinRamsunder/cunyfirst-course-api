package CunyFirstParser.containers;

import java.util.ArrayList;
import java.util.List;
import CunyFirstParser.parsers.ClassHeadingParser;

/**
 * Structure for containing class headings. Each class heading holds some number of
 * class sections which are stored within this structure.
 */

public class ClassHeading extends Heading {

   // List of class sections within this heading
   private List<ClassSection> classes;

   /** Initialize heading information, and create storage room for each section */
   public ClassHeading(ClassHeadingParser headingInformation) {
      super(headingInformation.getTitle(), headingInformation.getQuantity());
      classes = new ArrayList<ClassSection>(super.getQuantity());
   }

   /** Return all of the sections within this heading */
   public List<ClassSection> getClassList() {
      return classes;
   }

   /** Add a class section to this heading */
   public void addClassToHeading(ClassSection section) {
      classes.add(section);
   }

   /** Get a specific section from this heading */
   public ClassSection getSection(int i) {
      // Check for out of bounds exceptions
      ClassSection returnSection = null;
      
      try {
         returnSection = classes.get(i);
      } catch (Exception e) {
         System.err.println(e.getLocalizedMessage());
      }
      
      return returnSection;
   }
}