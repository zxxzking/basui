package com.lv.basui.controller.wechatsupport;

import com.lv.basui.controller.BaseController;
import com.lv.basui.dto.DirDto;
import com.lv.basui.dto.FileType;
import com.lv.basui.dto.ResultBean;
import com.lv.basui.utils.FileTypeJudge;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "dirInfo")
public class WeChatDirController extends BaseController {


    @GetMapping(value = "getBaseDir")
    public ResultBean getBaseDir(){
        ResultBean resultBean = new ResultBean();
        File[] files = File.listRoots();
        List list = new ArrayList();
        for (int i =0; i < files.length; i++) {
            DirDto dto = new DirDto();
            dto.setIsDir("1");
            dto.setName(files[i].getPath());
            dto.setPath(files[i].getPath());
            list.add(dto);
        }
        resultBean.setData(list);

        return resultBean;
    }


    @GetMapping(value = "getDirList")
    public Object getDirList(@RequestParam(value = "path",required = true)String path, HttpServletResponse response)throws Exception{
        ResultBean resultBean = new ResultBean();

        File file = new File(path);
        if(!file.isDirectory()){
            FileType type = FileTypeJudge.getType(file.getPath());
            if(type==FileType.JPEG){
                response.setHeader("Content-Type","image/jpeg");
                FileInputStream stream = new FileInputStream(file);
                byte[] bytes = new byte[stream.available()];
                stream.read(bytes);
                response.getOutputStream().write(bytes);
                return null;

            }
        }
        List list = new ArrayList();
        if(file.exists()){
            File[] files = file.listFiles();

            for (File file1 : files) {
                DirDto dto =new DirDto();
                dto.setIsDir("0");
                dto.setName(file1.getName());
                dto.setPath(file1.getPath());
                if(file1.isDirectory()){
                    dto.setIsDir("1");
                }

                list.add(dto);
            }
        }

        resultBean.setData(list);

        return resultBean;
    }


    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Administrator\\Desktop\\微信图片_20171218094720.jpg");
        FileInputStream stream = new FileInputStream(file);
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        String i = Base64.encodeBase64String(bytes);
        System.out.println(i);
        stream.close();


    }
}
