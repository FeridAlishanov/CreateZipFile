
import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Enter File Path or Folder Path:");
        Scanner scan = new Scanner(System.in);
        String  filepath= scan.nextLine();
        File file= new File(filepath);

         if (file.isFile()) {
             CreateZipFile.zipfile(filepath, file);
         }

         else if(file.isDirectory()){

             CreateZipDictionary appZip = new CreateZipDictionary();
             appZip.SOURCE_FOLDER=filepath;
           appZip.generateFileList(new File(filepath));
             appZip.zipIt(filepath+".zip");

         }


         else{
             System.out.println();
             System.out.println("Wrong File Path Format:");
         }


    }
}
