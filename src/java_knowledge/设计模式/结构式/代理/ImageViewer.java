package java_knowledge.设计模式.结构式.代理;

import java.net.MalformedURLException;
import java.net.URL;

public class ImageViewer {
    public static void main(String[] args) throws MalformedURLException {
        String image = "http://image.jpg";
        URL url = new URL(image);
        HighResolutionImage highResolutionImage = new HighResolutionImage(url);
        ImageProxy imageProxy = new ImageProxy(highResolutionImage);
        imageProxy.showImage();
    }
}
