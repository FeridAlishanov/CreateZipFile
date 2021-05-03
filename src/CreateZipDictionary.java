import java.io.*;
import java.util.*;
import java.util.zip.*;
public class CreateZipDictionary {
    List fileList;
    String SOURCE_FOLDER ;
    CreateZipDictionary(){

        fileList = new ArrayList();
    }
   public void zipIt(String zipFile){
        byte[] buffer = new byte[1024];
        try{
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            System.out.println();
            System.out.println(" Zipfile  path : " + zipFile);

            for(Object file : this.fileList){
                ZipEntry ze= new ZipEntry((String) file);
                zos.putNextEntry(ze);
                FileInputStream in =
                        new FileInputStream(SOURCE_FOLDER + File.separator + file);
                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                in.close();
            }
            zos.closeEntry();

            zos.close();
            System.out.println();
            System.out.println("COMPLETED");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void generateFileList(File node){

        if(node.isFile()){
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }
        if(node.isDirectory()){
            String[] subNote = node.list();
            for(String filename : subNote){
                generateFileList(new File(node, filename));
            }
        }
    }

    private String generateZipEntry(String file){
        return file.substring(SOURCE_FOLDER.length()+1, file.length());
    }
}