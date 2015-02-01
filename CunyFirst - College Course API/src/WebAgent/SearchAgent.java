package WebAgent;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public abstract class SearchAgent extends WebAgent {

   public SearchAgent() {
      super();
   }

   protected HtmlSelect getHtmlSelectElement(String id) {
      HtmlSelect selectElement = (HtmlSelect) page.getElementById(id);

      while (selectElement == null) {
         selectElement = (HtmlSelect) page.getElementById(id);
         waitForBackground();
      }
      return selectElement;
   }

   protected void setHtmlSelectElementValue(HtmlSelect element, String key) {
      try {
         element.setSelectedAttribute(element.getOptionByValue(key), true);
      } catch (ElementNotFoundException e) {
         e.printStackTrace();
      }
   }

   protected WebRequest getWebRequestData() {
      HtmlForm win0 = page.getFormByName("win0");
      return win0.getWebRequest(null);
   }

   protected HtmlTextInput getHtmlTextInput(String id) {
      return (HtmlTextInput) page.getElementById(id);
   }
}