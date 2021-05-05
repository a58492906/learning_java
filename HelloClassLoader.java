import sun.jvm.hotspot.debugger.cdbg.BaseClass;

import java.io.*;
import java.util.Base64;


/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        new HelloClassLoader().findClass("Hello").newInstance();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
       try {
           File file=new File("/Users/xuejiameng/Documents/learning/Hello.xlass");

           InputStream fileIn=new FileInputStream(file);

           // BufferedInputStream in =new BufferedInputStream(fileIn);
        byte[] bytes = toByteArray(fileIn);

            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (0xff - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);

        } catch (IOException e) {
            e.printStackTrace();
            return defineClass(name, new byte[]{}, 0, 0);

        }


    }


    private byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}


