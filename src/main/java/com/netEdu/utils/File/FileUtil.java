package com.netEdu.utils.File;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtil {

    private static String path = "F:/test";

    public static String uploadOne(MultipartFile file){
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        File dest = new File(path + "/" + fileName);
        String[] str = dest.toString().split("\\.");
        String suffix = str[1];
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            String fileType = "";
            if (suffix.equals("txt") || suffix.equals("doc") || suffix.equals("docx") || suffix.equals("xls")){
                fileType = "0";
            }
            else if (suffix.equals("ppt")){
                fileType = "1";
            }
            else if (suffix.equals("swf")){
                fileType = "2";
            }
            String result = dest.toString() + "," + fileType;
            return result;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }

    public static String uploadMany(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("files");
        if(files.isEmpty()){
            return "false";
        }
        String str = "";
        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);
            if(file.isEmpty()){
                return "false";
            }else{
                File dest = new File(path + "/" + fileName);
                str += dest.toString() + ",";
                if(!dest.getParentFile().exists()){
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                }catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return "false";
                }
            }
        }
        String savepaths = str.substring(0,str.length() - 1);
        return savepaths;
    }

}
