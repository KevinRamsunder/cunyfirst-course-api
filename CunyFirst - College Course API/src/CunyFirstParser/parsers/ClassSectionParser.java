package CunyFirstParser.parsers;

import org.jsoup.nodes.Element;

public class ClassSectionParser {

   private String nbr;
   private String section;
   private String status;
   private String htmlKey;

   public ClassSectionParser(Element nbr, Element section, Element status) {
      this.nbr = nbr.ownText();
      this.section = section.ownText();
      this.htmlKey = section.id();
      this.status = status.attr("alt");
   }

   public String getHtmlKey() {
      return htmlKey;
   }

   public String getNbr() {
      return nbr;
   }

   public String getSection() {
      return section;
   }

   public String getStatus() {
      return status;
   }
}