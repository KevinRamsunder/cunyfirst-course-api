package CunyFirstParser;

import java.util.ArrayList;
import java.util.List;

import CunyFirstParser.containers.ClassHeading;
import CunyFirstParser.containers.ClassSection;
import CunyFirstParser.parsers.ClassHeadingParser;

/** Structure for holding all parsed data from HTML */

public class ClassStructure {

   // List of class headings
   private List<ClassHeading> classHeadings;

   public ClassStructure() {
      this.classHeadings = new ArrayList<ClassHeading>();
   }

   public ClassStructure(List<ClassHeading> classHeadings) {
      this.classHeadings = classHeadings;
   }

   /** Format and print the data that is currently in the structure */
   public void print() {
      // Indices for labeling and organizing data
      int classIndex = 0; 
      int headerIndex = 0;
      
      // Get data from each heading
      for (ClassHeading header : this.getClassHeaders()) {
         System.out.print(headerIndex++ + ". ");
         System.out.println(header.getTitle());
         
         // Get data from each section within the heading
         for (ClassSection list : header.getClassList()) {
            System.out.print("   " + classIndex++ + ". ");
            System.out.print(list.getClassStatus() + "   ");
            System.out.println(list.sectionDisplay());
         }

         classIndex = 0;
         System.out.println();
      }
   }
   
   /** Methods to create the structure */
   
   public List<ClassHeading> getClassHeaders() {
      return classHeadings;
   }

   public void createSectionHeader(ClassHeadingParser e) {
      classHeadings.add(new ClassHeading(e));
   }

   public void createSectionHeader(ClassHeading e) {
      classHeadings.add(e);
   }

   public void addClassToHeader(int positionOfHeader, ClassSection section) {
      this.classHeadings.get(positionOfHeader).addClassToHeading(section);
   }

   public int getSectionHeaderCount() {
      return this.classHeadings.size();
   }

   public ClassHeading getClassHeader(int headerIndex) {
      return this.classHeadings.get(headerIndex);
   }

   public ClassSection getClassSection(int headerIndex, int classIndex) {
      return this.getClassHeader(headerIndex).getSection(classIndex);
   }
}