package cn.wxic.mobileinternet.entiy;

import org.springframework.web.multipart.MultipartFile;

public class UploadFiles {
   private   MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
