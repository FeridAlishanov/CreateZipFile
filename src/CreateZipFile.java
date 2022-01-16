import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
public class CreateZipFile {

    public static void zipfile(String filepath, File file) {
//path daxil edin
        Path path = Paths.get(filepath);
        String Name = file.getName();
        System.out.println("yeni setir");
        String filename = filepath;
        int pos = filename.lastIndexOf(".");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }

        byte[] buffer = new byte[1024];
        try{
            FileOutputStream fos = new FileOutputStream(filename+".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);

            ZipEntry ze= new ZipEntry(Name);
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(filepath);
            System.out.println();
            System.out.println("Zip File Path: "+filename+".zip");

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
            zos.closeEntry();

            zos.close();
            System.out.println();
            System.out.println("COMPLETED");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}