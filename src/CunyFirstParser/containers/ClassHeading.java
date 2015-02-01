package CunyFirstParser.containers;

import java.util.ArrayList;
import java.util.List;

import CunyFirstParser.parsers.ClassHeadingParser;

public class ClassHeading extends Heading {

   private List<ClassSection> classes;

   public ClassHeading(ClassHeadingParser headingInformation) {
      super(headingInformation.getTitle(), headingInformation.getQuantity());
      classes = new ArrayList<ClassSection>(super.getQuantity());
   }

   public List<ClassSection> getClassList() {
      return classes;
   }

   public void addClassToHeading(ClassSection section) {
      classes.add(section);
   }

   public ClassSection getSection(int i) {
      return classes.get(i);
   }
}
