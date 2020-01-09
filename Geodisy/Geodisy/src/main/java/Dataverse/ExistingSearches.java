package Dataverse;

import BaseFiles.FileWriter;
import BaseFiles.GeoLogger;
import BaseFiles.GeodisyStrings;

import java.io.IOException;
import java.util.HashMap;


public abstract class ExistingSearches extends ExisitingFile {
    GeoLogger logger;
    public abstract boolean isEmpty();

    public void saveExistingSearchs(HashMap object, String path, String className){
        saveExistingFile(object,path,className);
    }

    public HashMap<String, DataverseRecordInfo> readExistingRecords(String path){
        HashMap<String, DataverseRecordInfo> newFile = new HashMap<>();
        FileWriter fw = new FileWriter();
        try {
            return  (HashMap<String, DataverseRecordInfo>) fw.readSavedObject(GeodisyStrings.replaceSlashes(path));
        } catch (IOException e) {
            logger.error("Something went wrong reading " + path);
            return newFile;
        } catch (ClassNotFoundException e) {
            logger.error("Something went wrong parsing " + path);
            return newFile;
        } catch (NullPointerException e){
            return newFile;
        }
    }
}
