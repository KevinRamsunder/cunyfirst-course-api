package CunyFirstParser;

import java.util.ArrayList;
import java.util.List;

import CunyFirstParser.containers.ClassHeading;
import CunyFirstParser.containers.ClassSection;
import CunyFirstParser.parsers.ClassHeadingParser;

public class ClassStructure {

   private List<ClassHeading> classHeadings;

   public ClassStructure() {
      this.classHeadings = new ArrayList<ClassHeading>();
   }

   public ClassStructure(List<ClassHeading> classHeadings) {
      this.classHeadings = classHeadings;
   }

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

   public void print() {
      for (ClassHeading header : this.getClassHeaders()) {
         System.out.println(header.getTitle());

         for (ClassSection list : header.getClassList()) {
            System.out.print(list.getClassStatus() + "\t");
            System.out.println(list.sectionDisplay());
         }

         System.out.println();
      }
   }
}