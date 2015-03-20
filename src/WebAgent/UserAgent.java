package WebAgent;

import CunyFirstParser.*;
import CunyFirstParser.containers.*;
import CunyFirstParser.parsers.*;

import com.gargoylesoftware.htmlunit.html.*;

/** Agent responsible for handling user operations directly on the webpage */

public class UserAgent extends SearchAgent {

   /** Initialize all requirement to get and modify connection to CunyFirst */
   public UserAgent() {
      super();
   }

   /**
    * Submit query to webpage, parse all data, and return structured data to the
    * user. 
    */
   public ClassStructure submitAndGetResults() {
      showClosedClasses(); // get closed classes in the results
      submitQueryToWebpage(); // submit query
      
      MainParser parser = new MainParser(page.asXml()); // process results
      return parser.getClassStructure(); // return findings
   }

   /** Set the webpage with the institution you are looking for */
   public void setInstitution(String institutionKey) {
      HtmlSelect institution = getHtmlSelectElement(CunyFirst.instHtmlID);
      setHtmlSelectElementValue(institution, institutionKey);
      waitForBackground();
   }

   /** Set the webpage with the department you are looking for */
   public void setDepartment(String departmentKey) {
      HtmlSelect department = getHtmlSelectElement(CunyFirst.deptHtmlID);
      setHtmlSelectElementValue(department, departmentKey);
      waitForBackground();
   }

   /** Set the webpage with the term you are looking for */
   public void setTerm(String termKey) {
      HtmlSelect term = getHtmlSelectElement(CunyFirst.termHtmlID);
      setHtmlSelectElementValue(term, termKey);
      waitForBackground();
   }

   /** Set the webpage with the classID (NBR) you are looking for */
   public void setClassNBR(String classNumber) {
      HtmlTextInput classNumberField = getHtmlTextInput(CunyFirst.nbrHtmlID);
      classNumberField.setText(classNumber);
      waitForBackground();
   }

   /** Process a classes enrollment info, and add it to the given section */
   public void attachEnrollmentInfo(ClassSection section) {
      HtmlPage resultPage = this.clickClass(section);
      String xml = resultPage.asXml();
      EnrollmentInfoParser infoParser = new EnrollmentInfoParser(xml);
      section.attachEnrollmentInfo(new EnrollmentInfo(infoParser));
   }
   
   /** Manipulate CunyFirst into showing all classes, open or closed */
   private void showClosedClasses() {
      HtmlSelect courseNum = getHtmlSelectElement(CunyFirst.courseNumberID);
      HtmlTextInput classNumberField = getHtmlTextInput(CunyFirst.rangeID);
      setHtmlSelectElementValue(courseNum, "G");
      classNumberField.setText(Integer.toString(0));
      waitForBackground();
   }
}
