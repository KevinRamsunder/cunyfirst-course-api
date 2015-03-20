package CunyFirstParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import CunyFirstParser.parsers.*;
import CunyFirstParser.containers.*;

/**
 * Main Parser for result page. Constructs the storage and retrieval of all
 * parsed data obtained from CunyFirst
 */

public class MainParser {

   // Structure for holding all parsed data
   private ClassStructure classStructure;

   public MainParser(String html) {
      // parse data and create class structure
      classStructure = new ClassStructure();
      Document doc = Jsoup.parse(html);
      createClassStructure(doc);
   }

   public ClassStructure getClassStructure() {
      return classStructure;
   }

   /**
    * Create the overall parsed data structure based on the given result page
    * 
    * @param doc
    *           the given result page
    */
   private void createClassStructure(Document doc) {
      // Parse and the store the results
      ResultPageParser parser = new ResultPageParser(doc);

      // Add all class headings
      for (int i = 0; i < parser.headingSize(); i++) {
         ClassHeading heading = getHeadingInfo(parser, i);
         classStructure.createSectionHeader(heading);

         // Add classes per each heading
         addClassesPerHeading(parser, i);
      }
   }

   /**
    * Add every class that belongs to heading 'headingNumber'
    * 
    * @param parser
    *           parsed results
    * @param headingNumber
    *           class heading index
    */
   private void addClassesPerHeading(ResultPageParser parser, int headingNumber) {
      // get the amount of classes per this heading
      int size = classStructure.getClassHeader(headingNumber).getQuantity();

      // add all the classes that belong to this heading
      for (int i = 0; i < size; i++) {
         // find of if this class is comprised of multiple rows
         RowValidator validator = getValidator(parser);

         // construct class information
         ClassSection classSection = getClassSection(validator, parser);

         // add this class to the overall structure, move the parser to the next
         // class
         classStructure.addClassToHeader(headingNumber, classSection);
         parser.incrementCounter();
      }
   }

   /**
    * Construct the class section based on the number of rows the section
    * contains
    * 
    * @param rows
    *           denotes the number of rows each section has
    * @param pars
    *           parsed results
    * @return the constructed Class Section
    */
   private ClassSection getClassSection(RowValidator rows, ResultPageParser pars) {
      ClassSectionParser overhead = getOverhead(pars);

      // Choose between class type based on the amount of rows
      if (rows.isSingleRow()) {
         // denotes a single row per section
         SingleSectionParser handler = getParser(pars);
         return getSection(overhead, handler);
      } else {
         // denotes multiple rows per section
         MultiSectionParser handler = getParser(rows, pars);
         return getSection(overhead, handler);
      }
   }

   /*
    * Below are utility methods that help construct the structure that stores
    * the parsed data.
    */

   private SingleSectionParser getParser(ResultPageParser parser) {
      return new SingleSectionParser(parser.time(), parser.room(),
            parser.instr());
   }

   private MultiSectionParser getParser(RowValidator row, ResultPageParser par) {
      return new MultiSectionParser(row.getRows(), par.time(), par.room(),
            par.instr());
   }

   private ClassSection getSection(ClassSectionParser ov, SingleSectionParser in) {
      return new SingleRowSection(ov, in);
   }

   private ClassSection getSection(ClassSectionParser ov, MultiSectionParser in) {
      return new MultiRowSection(ov, in);
   }

   private ClassHeading getHeadingInfo(ResultPageParser parser, int i) {
      return new ClassHeading(new ClassHeadingParser(parser.headings(i),
            parser.classesPerHeading(i)));
   }

   private RowValidator getValidator(ResultPageParser parser) {
      return new RowValidator(parser.time());
   }

   private ClassSectionParser getOverhead(ResultPageParser par) {
      return new ClassSectionParser(par.nbr(), par.section(), par.status());
   }
}