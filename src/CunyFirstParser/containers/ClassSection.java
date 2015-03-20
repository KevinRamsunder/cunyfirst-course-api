package CunyFirstParser.containers;

import CunyFirstParser.parsers.ClassSectionParser;

/**
 * Structure for containing individual class sections. This is a parent class
 * for multi-row and single row class sections.
 */
public abstract class ClassSection {

   // Enrollment information for this section
   protected EnrollmentInfo enrollmentInfo;

   // Relevant information for this section
   private String htmlKey;
   private String nbr;
   private String section;
   private String status;

   /** Initialize key attributes for this section */
   public ClassSection(ClassSectionParser classInformation) {
      this.htmlKey = classInformation.getHtmlKey();
      this.nbr = classInformation.getNbr();
      this.section = classInformation.getSection();
      this.status = classInformation.getStatus();
   }

   // Short overview of this section's data
   public abstract String sectionDisplay();

   // In depth information of this section's data
   public abstract String inDepthDisplay();

   /**
    * Add enrollment info to this section since this information is not required
    * for construction
    */
   public void attachEnrollmentInfo(EnrollmentInfo e) {
      this.enrollmentInfo = e;
   }

   /**
    * Print enrollment information with timestamp data IFF enrollment data is
    * found.
    */
   public String getEnrollmentInfo(boolean appendTime) {
      if (this.hasEnrollementInfo()) {
         return this.enrollmentInfo.display(appendTime);
      }
      return "No enrollment information present.";
   }

   public boolean hasEnrollementInfo() {
      return this.enrollmentInfo != null;
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