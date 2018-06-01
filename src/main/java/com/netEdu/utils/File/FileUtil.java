package com.netEdu.utils.File;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class FileUtil {

    private static String path = "D:/test";

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
        String str1 = "";
        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);
            if(file.isEmpty()){
                return "false";
            }else{
                File dest = new File(path + "/" + fileName);
                String[] suffix = dest.toString().split("\\.");
                //所有的文件路径
                str += dest.toString() + ",";
                String fileType = "";
                if (suffix[1].equals("txt") || suffix[1].equals("doc") || suffix[1].equals("docx") || suffix[1].equals("xls")){
                    fileType = "0";
                }
                else if (suffix[1].equals("ppt")){
                    fileType = "1";
                }
                else if (suffix[1].equals("swf")){
                    fileType = "2";
                }
                //所有的文件类型
                str1 += fileType + ",";
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
        String fileTypes = str1.substring(0,str1.length() - 1);
        String savepathsAndTypes = savepaths + "?" + fileTypes;
        return savepathsAndTypes;
    }

    public static void deleteFiles(String savepath){
        File file = new File(savepath);
        file.delete();
    }

    public static void download(HttpServletResponse response,String savepath) throws IOException {
        String filename = "下载文件";
        File file = new File(savepath);
        if (file.exists()) {
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String(filename.getBytes(), "ISO-8859-1"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            OutputStream os = null;
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
