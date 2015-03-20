package WebAgent;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

/** Agent responsible for facilitating web page access to the user */

public abstract class SearchAgent extends WebAgent {

   public SearchAgent() {
      super();
   }

   /** Find HTML text element on webpage */
   protected HtmlTextInput getHtmlTextInput(String id) {
      return (HtmlTextInput) page.getElementById(id);
   }

   /** Find HTML drop down element on webpage */
   protected HtmlSelect getHtmlSelectElement(String id) {
      return (HtmlSelect) page.getElementById(id);
   }

   /** Select a drop down value from this SELECT element */
   protected void setHtmlSelectElementValue(HtmlSelect element, String key) {
      try {
         element.setSelectedAttribute(element.getOptionByValue(key), true);
      } catch (ElementNotFoundException e) {
         e.printStackTrace();
      }
   }
}