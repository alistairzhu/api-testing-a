package Blocks;

import common.ProjConstants;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import suites.users.ToolsBox;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class BlockTools {


    public static void main(String[] args){
        //new BlockTools().getBlockHashByIndex();
    }

    /**
     * This function returns an array of BlockHash by Block number range
     * @param startBlock
     * @param processNumber
     * @return
     */
    public String [] getBlockHashByIndex(int startBlock, int processNumber) throws Exception{

        String [] hashArray = new String [processNumber];

        for (int i = 0;  i < processNumber; i++ ){
            Reporter.log("Read BlockHash ByIndex", true);
            int index = startBlock + i;

            Response response = ToolsBox.getResponseWithRetry(ProjConstants.BLOCKEXPLORER_URL + "block-index/" + index);
            String jsonAsString = response.asString();
            JSONObject obj = new JSONObject(jsonAsString);
            String hash = obj.getString("blockHash");
            System.out.println("=====BlockHash are: " + hash);

            hashArray[i] = hash ;
        }
        return hashArray;
    }

    /**
     * This function return an arrayList of transactions of a block
     * @param blockHash
     * @return
     * @throws Exception
     */
    public ArrayList getTranactionsFromBlock(String blockHash ) throws Exception{
        ArrayList aList;

        Reporter.log("getTranactionsFromBlock---", true);
/*
        Response response = ToolsBox.getResponseWithRetry(ProjConstants.BLOCKEXPLORER_URL + "block/" + blockHash );
        String jsonAsString = response.asString();
        JSONObject obj = new JSONObject(jsonAsString);
        String hash = obj.getString("tx");
*/
        String hash =  given().
                when().
                get(ProjConstants.BLOCKEXPLORER_URL + "block/" + blockHash ).
                then().
                statusCode(200).
                extract().
                path("tx").toString();

        String hashTrim = hash.substring(1, hash.length()-1).replaceAll("\\s","");
        aList= new ArrayList(Arrays.asList(hashTrim.split(",")));
        System.out.println(" transactions list ...hashTrim........."+aList);

        return aList;
    }
}
