package CunyFirstParser;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import CunyFirstParser.containers.ClassHeading;
import CunyFirstParser.containers.ClassSection;
import CunyFirstParser.containers.MultiRowSection;
import CunyFirstParser.containers.RowValidator;
import CunyFirstParser.containers.SingleRowSection;
import CunyFirstParser.parsers.ClassHeadingParser;
import CunyFirstParser.parsers.ClassSectionParser;
import CunyFirstParser.parsers.MultiSectionParser;
import CunyFirstParser.parsers.SectionParser;
import CunyFirstParser.parsers.SingleSectionParser;

public class MainParser {

   private ClassStructure classStructure;

   public MainParser(String html) {
      Document doc = Jsoup.parse(html);
      Elements headings = doc.select(CunyFirst.rPageFindHeading);
      Elements classesPerHeading = doc.select(CunyFirst.rPagePerHeading);
      Elements nbr = doc.select(CunyFirst.rPageFindNbr);
      Elements section = doc.select(CunyFirst.rPageFindLecIds);
      Elements time = doc.select(CunyFirst.rPageFindTime);
      Elements room = doc.select(CunyFirst.rPageFindRoom);
      Elements instr = doc.select(CunyFirst.rPageFindInstr);
      Elements status = doc.select(CunyFirst.rPageFindOpen);

      ClassSection classSection;
      ClassSectionParser overhead;
      RowValidator validator;
      SectionParser handler;
      List<ClassHeading> classHeadings = new ArrayList<ClassHeading>();
      int c = 0;

      for (int i = 0; i < headings.size(); i++) {
         ClassHeadingParser headingInfo = new ClassHeadingParser(
               headings.get(i), classesPerHeading.get(i));
         classHeadings.add(new ClassHeading(headingInfo));

         for (int j = 0; j < classHeadings.get(i).getQuantity(); j++) {
            validator = new RowValidator(time.get(c));
            overhead = new ClassSectionParser(nbr.get(c), section.get(c),
                  status.get(c));

            if (validator.isValid()) {
               handler = new SingleSectionParser(time.get(c), room.get(c),
                     instr.get(c));
               classSection = new SingleRowSection(overhead, handler);
            } else {
               handler = new MultiSectionParser(validator.getRows(),
                     time.get(c), room.get(c), instr.get(c));
               classSection = new MultiRowSection(overhead, handler);
            }

            c++;
            classHeadings.get(i).addClassToHeading(classSection);
         }
      }

      classStructure = new ClassStructure(classHeadings);
   }

   public ClassStructure getClassStructure() {
      return classStructure;
   }

   private boolean verify(Elements... params) {
      int n = params[0].size();
      for (int i = 1; i < params.length; i++) {
         if (n != params[i].size()) {
            return false;
         }
      }
      return true;
   }
}