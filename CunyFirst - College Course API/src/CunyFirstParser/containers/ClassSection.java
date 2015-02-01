package CunyFirstParser.containers;

import CunyFirstParser.parsers.ClassSectionParser;

public abstract class ClassSection {

   protected EnrollmentInfo enrollmentInfo;

   private String htmlKey;
   private String nbr;
   private String section;
   private String status;

   public ClassSection(ClassSectionParser classInformation) {
      this.htmlKey = classInformation.getHtmlKey();
      this.nbr = classInformation.getNbr();
      this.section = classInformation.getSection();
      this.status = classInformation.getStatus();
   }

   public abstract String sectionDisplay();

   public abstract String inDepthDisplay();

   public void attachEnrollmentInfo(EnrollmentInfo e) {
      this.enrollmentInfo = e;
   }

   public boolean hasEnrollementInfo() {
      return this.enrollmentInfo != null;
   }

   public String getEnrollmentInfo(boolean appendTime) {
      if (this.hasEnrollementInfo()) {
         return this.enrollmentInfo.display(appendTime);
      }
      return "No enrollment information present.";
   }

   public String getHtmlKey() {
      return htmlKey;
   }

   public String getClassNbr() {
      return nbr;
   }

   public String getClassSection() {
      return section;
   }

   public String getClassStatus() {
      return status;
   }
}
