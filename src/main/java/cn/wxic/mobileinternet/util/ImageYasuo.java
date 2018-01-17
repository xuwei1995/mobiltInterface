package cn.wxic.mobileinternet.util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.io.File;
import javax.imageio.ImageIO;


public class ImageYasuo {
    /**
     * @param src
     * @param des
     * @param imgSize
     * @param quality
     */
    public  static void compress(File src,File des, int imgSize,float quality) {
        FileOutputStream out = null;
        try {
            Image image = ImageIO.read(src);

            Dimension dim = getRectangle(image.getWidth(null), image.getHeight(null),imgSize);
            BufferedImage tmpImg=new BufferedImage(dim.width,dim.height ,BufferedImage.TYPE_3BYTE_BGR);
            tmpImg.getGraphics().drawImage(image.getScaledInstance(dim.width,dim.height,Image.SCALE_SMOOTH), 0, 0, null);
            JPEGEncodeParam jep =   JPEGCodec.getDefaultJPEGEncodeParam(tmpImg);
            jep.setQuality(quality, true);

            if(des.exists()){
                des.delete();
            }
            out = new FileOutputStream(des);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tmpImg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * @param width
     * @param height
     * @return
     */
    private static Dimension getRectangle( int width, int height, int size){
        Dimension dim = new Dimension();
        double w = width+0.0;
        double h = height + 0.0;
        double rate = w/h;
        if(w > h && w > size){
            w = size;
            h = w / rate;
        }else if(h > w && h > size){
            h = size;
            w = h*rate;
        }
        width = (int)w;
        height = (int)h;
        dim.width = width;
        dim.height = height;
        return dim;
    }
    
    
    

}
