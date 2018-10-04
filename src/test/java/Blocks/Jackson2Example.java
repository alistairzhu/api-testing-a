package Blocks;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import suites.users.TransactionsByAccount;

public class Jackson2Example {

    public static void main(String[] args) {
        Jackson2Example obj = new Jackson2Example();
        obj.run();
    //    TransactionsByAccount.printAny();



    }

    public void run() {
        ObjectMapper mapper = new ObjectMapper();

        try {

            // Convert JSON string from file to Object
           // Staff staff = mapper.readValue(new File("D:\\staff.json"), Staff.class);
           // System.out.println(staff);

            // Convert JSON string to Object
            String jsonInString = "{\"pagesTotal\":7500}";
            TransactionsByAccount staff1 = mapper.readValue(jsonInString, TransactionsByAccount.class);
            System.out.println(staff1);



            //Pretty print
     //       String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
      //      System.out.println(prettyStaff1);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}